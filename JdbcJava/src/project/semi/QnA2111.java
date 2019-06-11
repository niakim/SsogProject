package project.semi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;






public class QnA2111 extends JPanel implements ActionListener{
private JPanel []jp =new JPanel[4];
private JPanel grid;
private JPanel flow;
private JButton jbtn12,jbtnok;
private JPanel boder[]=new JPanel[5];
private JPanel boder1[]=new JPanel[4];
private String []jlstr= {"문의유형","문의/답변","       작성자             ","                      작성일                          "}; 
private JLabel []jl=new JLabel[jlstr.length];
private JLabel []aa=new JLabel[3];
private JPanel []boder2=new JPanel[3];
private JLabel []bb= new JLabel[3];
private JButton []jbtn=new JButton[3];
private JLabel[]cc=new JLabel[3];
private JLabel[]dd=new JLabel[3];
private String a,b,c;
private CardLayout card=new CardLayout();
private JPanel jp11;
private ArrayList<JButton> list=new ArrayList<JButton>();
private ArrayList<JPanel>list1=new ArrayList<JPanel>();
private JPanel jpmain=new JPanel(card);
private JPanel jppp;
private int ee[]=new int[3];
private String id;
private List<proModel>Alist;
	@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	//if(e.getSource()==jbtnok) {
		
	//	new QnA(a,b,c,id);
		
//	}
	
	
	
	//JOptionPane == Alist[유저가선택한인덱스]
	int idx=0;
	
	for(int i=0;i<3;i++) {
		
		if(e.getSource()==jbtn[i]) {
			
			idx = ee[i]-1;
			
			
			
			Alist=proDao.listBoard(id);System.out.println("Dd");
			
			System.out.println(Alist.get(idx).getPw());
			if(Alist.get(idx).getPw().equals(JOptionPane.showInputDialog(this, "비밀번호 입력하세요" ))) {
			new QnA(Alist.get(idx).getPw(),
					Alist.get(idx).getText(),
					Alist.get(idx).getTitle().trim(),"",null);
			}else {
				JOptionPane.showMessageDialog(this,"비밀번호를 확인하세요","",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
	}
	for(int i = 0; i < flow.getComponentCount(); i++) {
		if( e.getSource() == (Object)flow.getComponent(i) ) {			
			
			hi(Integer.parseInt(e.getActionCommand()),0);
			
			break;
		}
	}
	



	
}


	public void init() {
		this.setLayout(new BorderLayout());
		Alist=proDao.listBoard(id);
		jppp=new JPanel(new BorderLayout());
		jp11=new JPanel(new BorderLayout());
		//this.setLayout(card);
		grid=new JPanel(new GridLayout(5, 1));
		jp11.add(grid);
		
		
		for (int i = 0; i < boder.length; i++) {
			boder[i]=new JPanel(new BorderLayout());
			boder[i].setBackground(Color.WHITE);
			grid.add(boder[i]);			
			
			
		}
		for (int i = 0; i < jp.length; i++) {
			jp[i]=new JPanel(new BorderLayout());
			boder1[i]=new JPanel(new BorderLayout());
			boder1[i].setBackground(Color.WHITE);
			boder[i].add("East",jp[i]);
			boder[i].add(boder1[i]);
			
		}
		for (int i = 0; i < jl.length; i++) {
			jl[i]=new JLabel(jlstr[i]);
			jl[i].setBackground(Color.white);
			jl[i].setOpaque(true);
		}
				
		boder1[0].add("West",jl[0]);
		boder1[0].add(jl[1]);		
		boder1[0].add("East",jl[2]);
		jl[0].setHorizontalAlignment(SwingConstants.CENTER);
		jl[1].setHorizontalAlignment(SwingConstants.CENTER);
		jl[2].setHorizontalAlignment(SwingConstants.LEFT);
		
		jp[0].add(jl[3]);
		jbtn12=new JButton("1");
		this.add("South",flow=new JPanel());
		flow.setBackground(Color.WHITE);
		jbtn12.addActionListener(this);
		flow.add(jbtn12);
		//jbtnok=new JButton("문의글 작성");//여기나중에주석
		//jbtnok.addActionListener(this);
		//boder[4].add("East",jbtnok);
		
		this.add("Center",jpmain);
		
		
		
		jpmain.add(jp11,"1");
		
		
		   for (int i = 0; i < 3; i++) {		
			aa[i]=new JLabel();
			aa[i].setBackground(Color.WHITE);
			aa[i].setOpaque(true);
			aa[i].setFont(new Font("나눔고딕",Font.PLAIN, 17));
			cc[i]=new JLabel();
			cc[i].setBackground(Color.WHITE);
			cc[i].setOpaque(true);
			cc[i].setFont(new Font("나눔고딕",Font.PLAIN, 17));
			dd[i]=new JLabel();
			dd[i].setBackground(Color.WHITE);
			dd[i].setOpaque(true);
			dd[i].setFont(new Font("나눔고딕",Font.PLAIN, 17));
			boder2[i]=new JPanel(new BorderLayout());
			boder2[i].setBackground(Color.white);
			bb[i]=new JLabel();	
			bb[i].setBackground(Color.WHITE);
			bb[i].setOpaque(true);
			bb[i].setFont(new Font("나눔고딕",Font.PLAIN, 17));
			
			boder1[i+1].add("West",aa[i]);			
			boder1[i+1].add(boder2[i]);
			boder1[i+1].add("East",dd[i] );
			boder2[i].add("West",bb[i]);
			bb[i].setHorizontalTextPosition(SwingConstants.RIGHT);			
			boder2[i].add(jbtn[i]=new JButton());
			
			jbtn[i].setBackground(Color.white);
			jbtn[i].setFont(new Font("나눔고딕",Font.PLAIN, 17));
			
			jbtn[i].addActionListener(this);
			jbtn[i].setBorderPainted(false);
			jbtn[i].setContentAreaFilled(false);
			jbtn[i].setFocusPainted(false);
			jbtn[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			boder2[i].add("East",cc[i]);
			
			
		}
	
		hi(1,1);
	
	}
	public void push() {
		int j=2;			
		for (int i = 0; i < Alist.size(); i++) {
			if(i%3==0&&i!=0) {
				
				list.add(new JButton(Integer.toString(flow.getComponentCount()+1)));
				list1.add(new JPanel(new BorderLayout()));				
				//jpmain.add(list1.get(j-2),Integer.toString(j));
				
				flow.add(list.get(j-2));
				
				//list1.get(j-2).add(grid);				
				list.get(j-2).addActionListener(this);
				j++;
			
			}
		}
	}
	
public void hi(int p,int a) {
Alist=proDao.listBoard(id);
if(a!=0) {
push();
}
	int staP = ((p*3)-(3));
	int endP = p*3-1;
	for (int i = 0; i < 3; i++) {
		aa[i].setText("");
		bb[i].setText("");
		cc[i].setText("");
		dd[i].setText("");
		jbtn[i].setText("");
	}
	
	
		
	
	for (int i = 0; i < 3; i++) {
		
		if ( staP == (endP+1) ) return;
		if ( staP == Alist.size() ) return;
		aa[i].setText(Alist.get(staP).getTitle());
		bb[i].setText("          질문대기");
		cc[i].setText(Alist.get(staP).getId());
		dd[i].setText(Alist.get(staP).getDate1());
		jbtn[i].setText(Alist.get(staP).getText());
		ee[i]=Alist.get(staP).getNo();
		staP++;
	}
	
	
	
}
	
	public QnA2111(String id) {
		this.id=id;
		//this.setLayout(new BorderLayout());
		//this.setBounds(-500,-500, 900, 250);
		init();
		this.setVisible(false);
		
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	/*public static void main(String[] args) {
		new QnA2111();
	}*/
}
