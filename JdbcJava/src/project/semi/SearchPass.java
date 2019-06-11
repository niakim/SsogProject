package project.semi;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPass extends JFrame {

	protected static final Component SearchPass = null;
	private String PATH="C:\\Users\\sist\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\";
	private String imgStr="passback.jpg";
	private ImageIcon backImg;
	
	private JPanel passPanel;
	
	private String lbStr [] ={"비밀번호 찾기", "비밀번호를 찾고자 하는 아이디를 입력해 주세요.","이름", "휴대전화"};
	private JLabel passLabel [] = new JLabel[lbStr.length];
	
	private JButton nextBt, idBt;
	private JLabel oneLabel;
	private JTextField oneTf;

	public void initLayout() {
		
		backImg = new ImageIcon(PATH+imgStr);
		
		passPanel = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				if(backImg!=null) {
					g.drawImage(backImg.getImage(), 0, 0, this);
				}
			}
		};
		
		passPanel.setLayout(null);
		
		
		for (int i = 0; i < 2; i++) {
			passLabel[i] = new JLabel(lbStr[i]);			
			passPanel.add(passLabel[i]);
		}
		
		passLabel[0].setFont(new Font("맑은 고딕", Font.BOLD, 30));
		passLabel[0].setBounds(160, 5, 200, 60);
		passLabel[0].setForeground(Color.darkGray);
		
		passLabel[1].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		passLabel[1].setForeground(Color.darkGray);
		passLabel[1].setBounds(120, 55, 600, 30);
		
		oneLabel = new JLabel("아이디");
		passPanel.add(oneLabel);
		oneLabel.setBounds(40, 140, 600, 30);
		oneLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		oneTf = new JTextField();
		oneTf.setBorder(null);
		passPanel.add(oneTf);
		oneTf.setBounds(40, 170, 405, 50);

		nextBt = new JButton("다음");
		passPanel.add(nextBt);
		nextBt.setBounds(40, 250, 403, 50);
		nextBt.setBackground(new Color(125, 28, 48));
		nextBt.setForeground(Color.WHITE);
		nextBt.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		nextBt.setBorderPainted(false);
		nextBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				//--if (아이디가 맞다면)
				if(SsgDao.getInstance().mateID(oneTf.getText())) {
					new SearchPass2(oneTf.getText());
					dispose();					
				} else {
					JOptionPane.showMessageDialog(SearchPass, "아이디가 없습니다.", "아이디 없음", JOptionPane.INFORMATION_MESSAGE);;
				}
				
			}
		});
		
		
		idBt = new JButton("아이디가 기억나지 않는다면? 아이디 찾기 >");
		passPanel.add(idBt);
		idBt.setBounds(10, 310, 300, 30);
		idBt.setBackground(Color.white);
		idBt.setForeground(Color.GRAY);
		idBt.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		idBt.setBorderPainted(false);
		idBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SearchID();
				dispose();
				
			}
		});
			
		this.add(passPanel);
		
	}
	
	public SearchPass() {
		super("비밀번호 찾기");
		initLayout();

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setBounds(0, 0, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SearchPass();
	}
}
