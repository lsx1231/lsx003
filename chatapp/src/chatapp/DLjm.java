package chatapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import caht.model.Massage;
import caht.model.Massageserver;
import caht.model.User;
import chat.contrl.Lianjie;

public class DLjm extends JFrame implements ActionListener,Massageserver{
//	北部组件
	JLabel jl1;
//	中部组件
	//密码登录组件
	JTabbedPane jt1;
	JPanel jp1,jp2,jp3;
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	JTextField te1;
	JPasswordField pa1;
	JCheckBox jc1,jc2;
	//手机验证登录
	JLabel label1,label2,label3;
	JTextField sjhm,yzm;
	JButton getyzm;
	//电子邮箱登录组件
	JLabel jla1,jla2,jla3,jla4;
	JTextField jtext1;
	JPasswordField yxmm;
//	南部组件
	JButton jb1,jb2,jb3;
	JPanel jp4;
//	构造方法
	public DLjm(){
//		创建北部
		jl1=new JLabel(new ImageIcon("images/tou.gif"));
		this.add(jl1,"North");
//		创建中部
		//账户密码登录
		l1=new JLabel("YY号码",JLabel.CENTER);te1=new JTextField();
		b2=new JButton(new ImageIcon("images/clear.gif"));
		l2=new JLabel("YY密码",JLabel.CENTER);pa1=new JPasswordField();
		l3=new JLabel("忘记密码",JLabel.CENTER);
		l3.setForeground(Color.BLUE);
		jp1=new JPanel(new GridLayout(3,3));
		jc1=new JCheckBox("隐身登录");jc2=new JCheckBox("记住密码");
		l4=new JLabel("申请密码保护",JLabel.CENTER);
		//手机验证登录
		jp2=new JPanel(new GridLayout(2,3));
		label1=new JLabel("手机号码",JLabel.CENTER);label2=new JLabel("",JLabel.CENTER);
		label3=new JLabel("输入验证码",JLabel.CENTER);
		sjhm=new JTextField();yzm=new JTextField();
		getyzm=new JButton("获取验证码");
		jp2.add(label1);jp2.add(sjhm);jp2.add(label2);
		jp2.add(label3);jp2.add(yzm);jp2.add(getyzm);
		//电子邮箱登录
		jp3=new JPanel(new GridLayout(2,3));
		jla1=new JLabel("邮箱账户",JLabel.CENTER);jla2=new JLabel("邮箱密码",JLabel.CENTER);
		jla3=new JLabel("",JLabel.RIGHT);jla4=new JLabel("",JLabel.RIGHT);
		jtext1=new JTextField();
		yxmm=new JPasswordField();
		jp3.add(jla1);jp3.add(jtext1);jp3.add(jla3);
		jp3.add(jla2);jp3.add(yxmm);jp3.add(jla4);
		
//		添加中部组件
		jp1.add(l1);jp1.add(te1);jp1.add(b2);
		jp1.add(l2);jp1.add(pa1);jp1.add(l3);
		jp1.add(jc1);jp1.add(jc2);jp1.add(l4);
		jt1=new JTabbedPane();
		jt1.add(jp1,"YY密码");jt1.add(jp2,"手机号码");jt1.add(jp3,"电子邮箱");
		this.add(jt1);
//      创建南部
		jb1=new JButton(new ImageIcon("images/denglu.gif"));
		jb1.addActionListener(this);//添加监听器
		jb2=new JButton(new ImageIcon("images/zhuce.gif"));
		jb3=new JButton(new ImageIcon("images/quxiao.gif"));
		jb3.addActionListener(this);
		jp4=new JPanel();
		jp4.add(jb1);jp4.add(jb2);jp4.add(jb3);
		this.add(jp4,"South");
//		编辑窗口显示参数
		this.setSize(350,240);
		this.setTitle("CHAT登录");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		DLjm DLjm=new DLjm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			String userName=te1.getText();
			String password=new String(pa1.getPassword());
			User user=new User();
			user.setUserName(userName);
			user.setPassword(password);
			
//			密码验证
			Massage massage=new Lianjie().loginValidate(user);//要把密码和账号传送到连接端的loginValidate
			
			if(massage.getMassageTap().equals(massage_success)){
				new FLjm(userName);
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this,"密码或者账号错误");
			}
		}
		if(e.getSource()==jb3)
			this.dispose();
	}


}
