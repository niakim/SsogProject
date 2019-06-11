package sist.com.jdbc;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MemberView extends JFrame implements ActionListener{
	
	Panel gridP,postPan,idPan;
	TextField[]tf = new TextField[4];
	JButton jbtn,jbtnCheckId;
	TextField tfLogin;
	JLabel jlId;

	
	
	
	
	public TextField getTfLogin() {
		return tfLogin;
	}


	public void setTfLogin(TextField tfLogin) {
		this.tfLogin = tfLogin;
	}


	public TextField[] getTf() {
		return tf;
	}


	public void setTf(TextField[] tf) {
		this.tf = tf;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(jbtn==e.getSource()) {
			new PostSearchBox(this);
		}
		else if(jbtnCheckId==e.getSource()) {
			new IdCheckBox(this);
		}
	}


	public void initLay() {
		gridP=new Panel(new GridLayout(12,1)); //패널 기본 flow
		
		idPan = new Panel();
		idPan.add(jlId = new JLabel("ID"));
		idPan.add(tfLogin = new TextField(37));
		idPan.add(jbtnCheckId = new JButton("중복 검사"));
		jbtnCheckId.addActionListener(this);
		gridP.add(idPan);
		
		
		postPan = new Panel();
		for (int i = 0; i < tf.length; i++) {
			tf[i]=i==0||i==1?new TextField(15):new TextField(50);
		}
		postPan.add(tf[0]);
		tf[0].setEditable(false);
		postPan.add(new Label("-"));
		postPan.add(tf[1]);
		tf[1].setEditable(false);
		postPan.add(jbtn = new JButton("우편번호"));
		jbtn.addActionListener(this);
		gridP.add(postPan);
		
		//gridP.add(new JLabel(""));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.add(tf[2]);
		jp2.add(tf[3]);
				
		
		
		gridP.add(jp1);
		gridP.add(jp2);
		
		this.add(gridP);
	}
	
	
	public MemberView() {
		super("Jdbc회원가입");
		initLay();
		this.setBounds(100,100,500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new MemberView();
	}
	
}



