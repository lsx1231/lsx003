package chat.contrl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import caht.model.User;

public class Lianjie {
	
	Socket s;
//	建立和服务器的连接
	public Lianjie(){
		try {
			s=new Socket("127.0.0.1",3456);//建立连接
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
//	接受登录端的信息
	public void loginValidate(User user){
		ObjectOutputStream oos;
		
		try {
			oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
