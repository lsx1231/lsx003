package Serverwod.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import caht.model.Massage;

public class ServerThread extends Thread{
	
	public ServerThread(Socket s){
		
		ObjectInputStream ois;
		try {
			ois=new ObjectInputStream(s.getInputStream());
		    Massage massage=(Massage)ois.readObject();
			System.out.println(massage.getSender()+"¶Ô"+massage.getReceiver()+"·¢ËÍ£º"+massage.getCenter());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
