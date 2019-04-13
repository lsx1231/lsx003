package Serverwod.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import caht.model.Massage;
import caht.model.Massageserver;

public class ServerThread extends Thread implements Massageserver{//�߳�Ҫ��run����
	
	Socket s;
	HashMap hashmap;
	public ServerThread(Socket s,HashMap hashmap) {
		this.s=s;
		this.hashmap=hashmap;
	}

	public void run(){
		ObjectInputStream ois;
		try {
			while(true){
			ois=new ObjectInputStream(s.getInputStream());
		    Massage massage=(Massage)ois.readObject();
			System.out.println(massage.getSender()+"��"+massage.getReceiver()+"���ͣ�"+massage.getCenter());
			
//			����ת����Ϣ
			if(massage.getMassageTap().equals(Massageserver.massage_common)){
				Socket s1=(Socket)hashmap.get(massage.getReceiver());
				ObjectOutputStream oos;
				oos=new ObjectOutputStream(s1.getOutputStream());
				oos.writeObject(massage);
				System.out.println("��ת��"+massage.getSender()+"��"+massage.getReceiver()+"���͵���Ϣ");
			}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
