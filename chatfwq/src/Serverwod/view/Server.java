package Serverwod.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import caht.model.Massage;
import caht.model.Massageserver;
import caht.model.User;

public class Server implements Massageserver{
	
	ServerSocket ss;
	Socket s;
	public Server(){
		
	try {
		
		ss=new ServerSocket(3456);
		System.out.println("服务器已启动，正在监听3456端口......");
		while(true){//设置死循环，方便服务器可以无限验证
		s=ss.accept();//等待连接
		System.out.println(s);
		
		ObjectInputStream ois;
		
		ois=new ObjectInputStream(s.getInputStream());
		User user=(User)ois.readObject();
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		Massage massage=new Massage();
		massage.setSender("server");
		massage.setReceiver(user.getUserName());
//		服务器验证密码并且生成验证结果
		if(user.getPassword().equals("123456")){
			massage.setMassageTap(massage_success);
		}else{
			massage.setMassageTap(massage_failure);
		}
//		将验证结果发给客户端
		ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(massage);
			
//		如何接收客户端的聊天信息？另建一个线程来接收
		new ServerThread(s).start();
		
		}
		
	}catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	}
	public static void main(String[] args) {
		
	}

}
