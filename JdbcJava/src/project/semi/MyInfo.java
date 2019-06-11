package project.semi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyInfo extends JFrame implements ActionListener {
	private Image myInfoImg = Toolkit.getDefaultToolkit().createImage("C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\코드\\NK\\crudimg7\\newmyinfo2.jpg");
	private JPanel jp1,jp2;
	private JButton jbtnShop;
	private String[] jbtnStr= {" "," "," "," "," "," "," "," "," "}; //9개[0~8]
	private JButton[] jbtn = new JButton[jbtnStr.length];
	private Font gothic = new Font("맑은 고딕", Font.BOLD, 15); //라벨에 쓰일 글씨체
	private Font gothicR = new Font("맑은 고딕", Font.BOLD, 30); //라벨에 쓰일 글씨체
	private String[] jlbStr= {"박진영","0","0","0","2월 17일 주문","코듀 와플번아웃 극세사토퍼Q 외 1건","1","0","0","333","hellossog@ssog.com"};
	private JLabel[] jlb = new JLabel[jlbStr.length];
	private String id;
	private String name;
	private String pw;
	private String a,b,c;
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	
	private JButton jbtnBye;
	
	private QnA2111 qnA2111;
	

	
	public QnA2111 getQnA2111() {
		return qnA2111;
	}
	public void setQnA2111(QnA2111 qnA2111) {
		this.qnA2111 = qnA2111;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == jbtnShop) {
		//	MyInfo.this.dispose();
		}
		
		if(source==jbtn[1]) {
			new QnA(a, b, c, id,this);
		}
		if(source==jbtnBye) {
			new Withdrawal(id, pw, name);
		}
			
					
		
	}
	
	

	public void iniLayout() {
		
		//jp1 = new JPanel();
		//jp1.setLayout(null);
		//jp1.setBackground(Color.white);
		this.setBackground(Color.WHITE);
		jp2 = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				if(myInfoImg!=null) {
					g.drawImage(myInfoImg, 0, 0, this);
			
				}
				
			}
			
		};
		jp2.setLayout(null);
		jp2.setBounds(d.width / 8, 60, d.width - d.width / 4, (d.height / 3 * 2) + d.height / 3 * 2);
		

		jp2.add(jbtnShop = new JButton(new ImageIcon("C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\코드\\NK\\crudimg7\\infobutton1.png")));
		jbtnShop.setBorderPainted(false);
		jbtnShop.setContentAreaFilled(false);
		jbtnShop.setFocusPainted(false);
		jbtnShop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnShop.addActionListener(this);
		jbtnShop.setBounds(d.width-800, 5, 180, 40);
		jbtnShop.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnShop.setIcon(new ImageIcon("C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\코드\\NK\\crudimg7\\infobutton1.png"));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnShop.setIcon(new ImageIcon("C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\코드\\NK\\crudimg7\\infobutton2.png"));
				
			}

		});
		
		
		for (int i = 0; i < jbtn.length-1; i++) { //메인에 들어가는 판에 붙을 버튼들(Invisible Buttons)
			jbtn[i] = new JButton(jbtnStr[i]);
			jbtn[i].addActionListener(this);
			jbtn[i].setBorderPainted(false);
			jbtn[i].setContentAreaFilled(false);
			jbtn[i].setFocusPainted(false);
			jbtn[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jp2.add(jbtn[i]);
		}
		
		jbtnBye = new JButton("회원 탈퇴");
		jbtnBye.setBackground(new Color(168, 39, 53));
		jbtnBye.setFont(gothic);
		jbtnBye.addActionListener(this);
		jbtnBye.setBounds(820,473,100,40);
		jp2.add(jbtnBye);
		
		int location = 700;
		
		jbtn[0].setBounds(location, 10, 70, 80);//1
		jbtn[1].setBounds(location+80, 10, 70, 80);//2
		jbtn[2].setBounds(location+160, 10, 70, 80);//3
		jbtn[3].setBounds(location+240, 10, 70, 80);//4
		jbtn[4].setBounds(85, 390, 80, 30);//1
		jbtn[5].setBounds(320, 390, 140, 30);//2
		jbtn[6].setBounds(575, 390, 140, 30);//3
		jbtn[7].setBounds(695, 540, 160, 30);//1
		//jbtn[8].setBounds(320, 590, 380, 30);//1

		
		for (int i = 0; i < jlb.length; i++) { //메인에 붙을 글씨들
			jlb[i] = new JLabel(jlbStr[i]);
			jp2.add(jlb[i]);
			if(i==6||i==9) {
				jlb[i].setFont(gothicR);
				jlb[i].setForeground(new Color(252, 61, 114));
				jlb[i].setHorizontalAlignment(SwingConstants.RIGHT);
			}else {
				jlb[i].setFont(gothic);
				
			}
			
		}
		

		jlb[0].setBounds(50,11,50,20); //회원 이름
		jlb[1].setBounds(940,130,50,20);//취소num
		jlb[2].setBounds(940,175,50,20);//교환수num
		jlb[3].setBounds(940,220,50,20);//반품수num
		jlb[4].setBounds(70,313,100,20); //~월~일 주문
		jlb[5].setBounds(220,313,400,20); //주문 상품 이름..(~외 ~건)
		jlb[6].setBounds(70,418,40,40); //쿠폰갯수
		jlb[7].setBounds(180,468,20,20); //쿠폰갯수1
		jlb[8].setBounds(180,488,20,20); //쿠폰갯수2
		jlb[9].setBounds(220,418,150,40); //포인트
		jlb[10].setBounds(570,460,150,40); //회원탈퇴
		
		//
		jlb[1].setForeground(new Color(86, 164, 223));
		jlb[2].setForeground(new Color(86, 164, 223));
		jlb[3].setForeground(new Color(86, 164, 223));
		
		
		//jp1.add(jp2);
		//jp1.add(jbtnShop);
		this.add(jp2);
		this.add(jbtnShop);
		jp2.setBackground(Color.white);
		jbtnShop.setBackground(Color.WHITE);
		//this.add(jp1);
		if(proDao.listBoard(id).size()!=0) {
			
			qnA2111=new QnA2111(id);
			jp2.add(qnA2111);	
		qnA2111.setBounds(10,601,990,322);
		qnA2111.setVisible(true);
	
		}
	}

	public MyInfo(String id,String pw,String name) {
		
		this.id=id;
		this.pw=pw;
		this.name=name;
		iniLayout();

		this.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowClosing(WindowEvent e) {
				MyInfo.this.dispose();
			}
		});

		this.setUndecorated(true);
		this.setBounds((d.width / 4)-78, 0, (d.width - (d.width / 4))+78, d.height);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}

	/*public static void main(String[] args) {
		new MyInfo("");

	}*/
}
