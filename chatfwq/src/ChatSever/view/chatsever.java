package ChatSever.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Serverwod.view.Server;

public class chatsever extends JFrame implements ActionListener{
	JPanel jp1;
	JButton jb1,jb2;
	public chatsever(){
		jp1=new JPanel();
		jb1=new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2=new JButton("停用服务器");
		jb2.addActionListener(this);
		jp1.add(jb1);jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(240,240);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		chatsever chatsever=new chatsever();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1)
			new Server();
	}

}
