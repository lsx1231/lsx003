package yychat.connect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.HashMap;

import chat.model.Message;
import yychat.com.chatview.ChatInterface;
import yychat.com.chatview.FriendList;
import yychat.com.chatview.LoginInterface;

public class ClientReceiver extends Thread{
	
	HashMap hashmap;
	Socket s;
	
	public ClientReceiver(HashMap hashamap,Socket s){
		this.hashmap=hashmap;
		this.s=s;
	}
	
	public void run(){
		ObjectInputStream ois;
		try {
			while(true){
			ois=new ObjectInputStream(s.getInputStream());
			Message mess=(Message)ois.readObject();
			if(mess.getMessageType().equals(Message.message_comment)){
			ChatInterface chatinterface=(ChatInterface)FriendList.hashmap.get(mess.getSender());
			chatinterface.messappend(mess);
			}
			if(mess.getMessageType().equals(Message.message_onlinefriendname)){
				FriendList friendlist=(FriendList)LoginInterface.hashmap.get(mess.getReceiver());
				friendlist.setEnabel(mess);
			}
			if(mess.getMessageType().equals(Message.message_onlinefriendupdate)){
				FriendList friendlist=(FriendList)LoginInterface.hashmap.get(mess.getReceiver());
				System.out.println(mess.getContent());
				friendlist.updateEnabel(mess);
			}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
