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
//	�������
	JLabel jl1;
//	�в����
	//�����¼���
	JTabbedPane jt1;
	JPanel jp1,jp2,jp3;
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	JTextField te1;
	JPasswordField pa1;
	JCheckBox jc1,jc2;
	//�ֻ���֤��¼
	JLabel label1,label2,label3;
	JTextField sjhm,yzm;
	JButton getyzm;
	//���������¼���
	JLabel jla1,jla2,jla3,jla4;
	JTextField jtext1;
	JPasswordField yxmm;
//	�ϲ����
	JButton jb1,jb2,jb3;
	JPanel jp4;
//	���췽��
	public DLjm(){
//		��������
		jl1=new JLabel(new ImageIcon("images/tou.gif"));
		this.add(jl1,"North");
//		�����в�
		//�˻������¼
		l1=new JLabel("YY����",JLabel.CENTER);te1=new JTextField();
		b2=new JButton(new ImageIcon("images/clear.gif"));
		l2=new JLabel("YY����",JLabel.CENTER);pa1=new JPasswordField();
		l3=new JLabel("��������",JLabel.CENTER);
		l3.setForeground(Color.BLUE);
		jp1=new JPanel(new GridLayout(3,3));
		jc1=new JCheckBox("�����¼");jc2=new JCheckBox("��ס����");
		l4=new JLabel("�������뱣��",JLabel.CENTER);
		//�ֻ���֤��¼
		jp2=new JPanel(new GridLayout(2,3));
		label1=new JLabel("�ֻ�����",JLabel.CENTER);label2=new JLabel("",JLabel.CENTER);
		label3=new JLabel("������֤��",JLabel.CENTER);
		sjhm=new JTextField();yzm=new JTextField();
		getyzm=new JButton("��ȡ��֤��");
		jp2.add(label1);jp2.add(sjhm);jp2.add(label2);
		jp2.add(label3);jp2.add(yzm);jp2.add(getyzm);
		//���������¼
		jp3=new JPanel(new GridLayout(2,3));
		jla1=new JLabel("�����˻�",JLabel.CENTER);jla2=new JLabel("��������",JLabel.CENTER);
		jla3=new JLabel("",JLabel.RIGHT);jla4=new JLabel("",JLabel.RIGHT);
		jtext1=new JTextField();
		yxmm=new JPasswordField();
		jp3.add(jla1);jp3.add(jtext1);jp3.add(jla3);
		jp3.add(jla2);jp3.add(yxmm);jp3.add(jla4);
		
//		����в����
		jp1.add(l1);jp1.add(te1);jp1.add(b2);
		jp1.add(l2);jp1.add(pa1);jp1.add(l3);
		jp1.add(jc1);jp1.add(jc2);jp1.add(l4);
		jt1=new JTabbedPane();
		jt1.add(jp1,"YY����");jt1.add(jp2,"�ֻ�����");jt1.add(jp3,"��������");
		this.add(jt1);
//      �����ϲ�
		jb1=new JButton(new ImageIcon("images/denglu.gif"));
		jb1.addActionListener(this);//��Ӽ�����
		jb2=new JButton(new ImageIcon("images/zhuce.gif"));
		jb3=new JButton(new ImageIcon("images/quxiao.gif"));
		jb3.addActionListener(this);
		jp4=new JPanel();
		jp4.add(jb1);jp4.add(jb2);jp4.add(jb3);
		this.add(jp4,"South");
//		�༭������ʾ����
		this.setSize(350,240);
		this.setTitle("CHAT��¼");
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
			
//			������֤
			Massage massage=new Lianjie().loginValidate(user);//Ҫ��������˺Ŵ��͵����Ӷ˵�loginValidate
			
			if(massage.getMassageTap().equals(massage_success)){
				new FLjm(userName);
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this,"��������˺Ŵ���");
			}
		}
		if(e.getSource()==jb3)
			this.dispose();
	}


}
