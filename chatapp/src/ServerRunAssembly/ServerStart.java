package ServerRunAssembly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ServerStart extends JFrame implements ActionListener{
	JPanel jp1;
	JButton jb1,jb2;

	public ServerStart(){
		
		jp1=new JPanel();
		jb1=new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2=new JButton("关闭服务器");
		jp1.add(jb1);jp1.add(jb2);
		
		this.add(jp1);
		this.setTitle("服务器控制台");
		this.setSize(350,150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ServerStart();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1) new ServerRun();
		
	}

}
