package yychat.com.chatview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.*;

import chat.model.Message;
import yychat.connect.ConnectPort;

public class ChatInterface extends JFrame implements ActionListener{
	
	JPanel jp1;
	JButton jb1;
	//JTextPane jtp;
	JTextArea jta;
	JTextField jtf;
	JScrollPane jsc;
	
	String friendName;
	String userName;
	
	String Sender;
	String Receiver;
	
	public ChatInterface(String friendName,String userName){
		this.friendName=friendName;
		this.userName=userName;
		this.Sender=userName;
		this.Receiver=friendName;
		
		jp1=new JPanel();
		jb1=new JButton("发送");
		jb1.addActionListener(this);
		/*jtp=new JTextPane();
		jtp.setEditable(false);*/
		jta=new JTextArea();
		jta.setEditable(false);
		jtf=new JTextField(20);
		jsc=new JScrollPane(jta);
		jp1.add(jtf);jp1.add(jb1);
		
		this.add(jsc,JLabel.CENTER);
		this.add(jp1,"South");
		
		this.setTitle(userName+"正在和"+friendName+"聊天");
		this.setSize(550,340);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		//new  ChatInterface();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			String content=jtf.getText();
			jta.append(content+"\r\n");
			
			Message mess=new Message();
			mess.setSender(Sender);
			mess.setReceiver(Receiver);
			mess.setContent(content);
			mess.setMessageType(Message.message_comment);
			
			Socket s=(Socket)ConnectPort.hashmap.get(Sender);
			ObjectOutputStream oos;
			try {
				oos=new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(mess);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void messappend(Message mess){
		jta.append(mess.getSender()+"对你说："+mess.getContent()+"\r\n");
	
	}

}
