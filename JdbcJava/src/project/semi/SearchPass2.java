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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class SearchPass2 extends JFrame {

	protected static final Component SearchPass2 = null;
	private String PATH="C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\";
	private String imgStr="back2.jpg";
	private ImageIcon backImg;
	
	private JPanel passPanel;
	
	private String lbStr [] ={"비밀번호 찾기", "비밀번호를 찾고자 하는 아이디를 입력해 주세요.","이름", "휴대전화"};
	private JLabel passLabel [] = new JLabel[lbStr.length];

	private JTextField passTf [] = new JTextField[3];
	
	private String btStr [] = {"인증 번호 받기","비밀 번호 찾기"};
	private JButton passBt [] = new JButton[btStr.length];
	
	private String numStr [] = {"대한민국 +82","덴마크 +45"};
//	private String numStr [] = {"+82","+45"};

	private JComboBox<String> idCombo = new JComboBox<String>();
	
	int random;
	String number;
	
	private String pass;
	private String id;
	
	
	
	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public int getRandom() {
		return random;
	}



	public void setRandom(int random) {
		this.random = random;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



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

		for (int i = 0; i < passTf.length; i++) {
			passTf[i] = new JTextField();
		}
		
		for (int i = 0; i < lbStr.length; i++) {
			passLabel[i] = new JLabel(lbStr[i]);			
			passPanel.add(passLabel[i]);
		}
		
		passLabel[0].setFont(new Font("맑은 고딕", Font.BOLD, 30));
		passLabel[0].setBounds(160, 5, 200, 60);
		passLabel[0].setForeground(Color.darkGray);
		
		passLabel[1].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		passLabel[1].setForeground(Color.darkGray);
		passLabel[1].setBounds(120, 55, 600, 30);
		
		for (int i = 2; i < passLabel.length; i++) {
			passLabel[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			passLabel[i].setBounds(40, 50+(90*(i-1)), 600, 30);
		}
		
		for (int i = 0; i < passTf.length; i++) {
			passTf[i] = new JTextField();
			passPanel.add(passTf[i]);
			passTf[0].setBounds(40, 170, 405, 50);
			passTf[1].setBounds(170, 260, 275, 50);
			passTf[2].setBounds(40, 320, 405, 50);
			passTf[i].setOpaque(false);
			passTf[i].setBorder(null);
			passTf[2].setEnabled(false);
			passTf[2].setOpaque(true);
			passTf[2].setBackground(new Color(250, 250, 250));
		}
		
		passPanel.add(idCombo = new JComboBox<>(numStr));
		idCombo.setBounds(40, 260, 120, 50);
		idCombo.setBackground(Color.WHITE);
		idCombo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		idCombo.setOpaque(false);
		
		for (int i = 0; i < btStr.length; i++) {
			passBt[i] = new JButton(btStr[i]);
			
			passBt[i].setForeground(Color.WHITE);
			passBt[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			passBt[i].setBounds(40, 380+(80*i), 403, 50);
			passPanel.add(passBt[i]);			
		}
		
		passBt[0].setBackground(new Color(232, 232, 232));
		passBt[0].setForeground(Color.gray);
		passBt[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
				if (passBt[0].getText().equals("인증 번호 받기")) {
				random = (int) (Math.random() * 9999) + 100;
				setNumber(String.valueOf(random));
				passTf[2].setEnabled(true);
				if (!passTf[1].getText().equals("")) {
					passTf[2].setOpaque(false);
					passTf[2].setText(null);
					passTf[2].setForeground(Color.black);
					passBt[0].setText("인증 번호 확인");

					if (random >= 1000 && random < 10000) {
						JOptionPane.showMessageDialog(SearchPass2, getNumber(), "인증 번호", JOptionPane.INFORMATION_MESSAGE);
					} else {
						setNumber(getNumber() + (int) (Math.random() * 9));
						JOptionPane.showMessageDialog(SearchPass2, getNumber(), "인증 번호", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(SearchPass2, "번호를 입력하세요.", "번호 미입력", JOptionPane.INFORMATION_MESSAGE);
				}			
			 } else if (passBt[0].getText().equals("인증 번호 확인")) {
				if (passTf[2].getText().equals(getNumber())) {
					JOptionPane.showMessageDialog(SearchPass2, "인증 번호가 확인되었습니다.", "인증 번호 확인", JOptionPane.INFORMATION_MESSAGE);
					passTf[2].setEnabled(false);
				} else {
					passBt[0].setText("인증 번호 받기");
					JOptionPane.showMessageDialog(SearchPass2, "인증 번호를 확인해 주세요.", "인증 번호 오류", JOptionPane.INFORMATION_MESSAGE);
					passTf[2].setText(" * " + passTf[2].getText());
					passTf[2].setForeground(Color.RED);
				}

			}
			}
		});
		
		passBt[1].setBackground(new Color(125, 28, 48));
		passBt[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String name = passTf[0].getText().trim();
				String phone = passTf[1].getText().trim();

				if (SsgDao.getInstance().mateName(name)) {
					System.out.println("이름 일치");
					if (SsgDao.getInstance().matePhone(name, phone)) {
						System.out.println("이름 번호 일치");
						if (passTf[2].getText().equals(getNumber())) {
							System.out.println("인증번호 일치");
							SsgDao.getInstance().searchId(name, phone);
							setPass(SsgDao.getInstance().searchId(name, phone).getPass());
							new SearchPassOk(getPass(),id);
							dispose();
						}
					} else {
						System.out.println("번호 없음");
						JOptionPane.showMessageDialog(SearchPass2, "가입 정보가 없습니다.", "가입 정보 없음", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					System.out.println("이름 없음");
					JOptionPane.showMessageDialog(SearchPass2, "가입 정보가 없습니다.", "가입 정보 없음", JOptionPane.INFORMATION_MESSAGE);
				}				
				
				
				for (int i = 0; i < passTf.length; i++) {
					passTf[i].setText("");					
				}
				passBt[0].setText("인증 번호 받기");
			}
		});
		passBt[0].setBorderPainted(false);

		
		this.add(passPanel);
		
	}
	
	
	
	public SearchPass2(String id) {
		super("비밀번호 찾기");
		this.id=id;
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

		this.setBounds(0, 0, 500, 570);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
/*	public static void main(String[] args) {
		new SearchPass2();
	}*/
}
