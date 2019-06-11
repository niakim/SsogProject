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



public class SearchID extends JFrame {

	protected static final Component SearchID = null;
	private String PATH = "C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\";
	private String imgStr = "back2.jpg";
	private ImageIcon backImg;

	private JPanel idPanel;

	private String lbStr[] = { "아이디 찾기", "로그인을 하시면 SSOG MALL의 다양한 정보와 혜택을 누리실 수 있습니다.", "이름", "휴대전화" };
	private JLabel idLabel[] = new JLabel[lbStr.length];

	private JTextField idTf[] = new JTextField[3];

	private String btStr[] = { "인증 번호 받기", "아이디 찾기", "인증 번호 확인" };
	private JButton idBt[] = new JButton[btStr.length];

	private String numStr[] = { "대한민국 +82", "덴마크 +45" };
//	private String numStr [] = {"+82","+45"};

	private JComboBox<String> idCombo = new JComboBox<String>();

	SsgBean bean;

	int random;
	String number;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

		backImg = new ImageIcon(PATH + imgStr);

		idPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stubx

				if (backImg != null) {
					g.drawImage(backImg.getImage(), 0, 0, this);
				}
			}
		};

		idPanel.setLayout(null);

		for (int i = 0; i < idTf.length; i++) {
			idTf[i] = new JTextField();
		}

		for (int i = 0; i < lbStr.length; i++) {
			idLabel[i] = new JLabel(lbStr[i]);
			idPanel.add(idLabel[i]);
		}

		idLabel[0].setFont(new Font("맑은 고딕", Font.BOLD, 30));
		idLabel[0].setBounds(165, 5, 200, 60);
		idLabel[0].setForeground(Color.darkGray);

		idLabel[1].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		idLabel[1].setForeground(Color.darkGray);
		idLabel[1].setBounds(45, 55, 600, 30);

		for (int i = 2; i < idLabel.length; i++) {
			idLabel[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			idLabel[i].setBounds(40, 50 + (90 * (i - 1)), 600, 30);
		}

		for (int i = 0; i < idTf.length; i++) {
			idTf[i] = new JTextField();
			idPanel.add(idTf[i]);
			idTf[0].setBounds(40, 170, 405, 50);
			idTf[1].setBounds(170, 260, 275, 50);
			idTf[2].setBounds(40, 320, 405, 50);
			idTf[i].setOpaque(false);
			idTf[i].setBorder(null);
			idTf[2].setEnabled(false);
			idTf[2].setOpaque(true);
			idTf[2].setBackground(new Color(250, 250, 250));
		}

		idPanel.add(idCombo = new JComboBox<>(numStr));
		idCombo.setBounds(40, 260, 120, 50);
		idCombo.setBackground(Color.WHITE);
		idCombo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		idCombo.setOpaque(false);

		for (int i = 0; i < btStr.length; i++) {
			idBt[i] = new JButton(btStr[i]);
			idBt[i].setForeground(Color.WHITE);
			idBt[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			idBt[i].setBounds(40, 380 + (80 * i), 403, 50);
			idPanel.add(idBt[i]);
		}

		idBt[0].setBackground(new Color(232, 232, 232));
		idBt[0].setForeground(Color.gray);
		idBt[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				idTf[2].setEnabled(true);

				if (idBt[0].getText().equals("인증 번호 받기")) {
				random = (int) (Math.random() * 9999) + 100;
				setNumber(String.valueOf(random));
				idTf[2].setEnabled(true);
				if (!idTf[1].getText().equals("")) {
					idTf[2].setOpaque(false);
					idTf[2].setText(null);
					idTf[2].setForeground(Color.black);
					idBt[0].setText("인증 번호 확인");

					if (random >= 1000 && random < 10000) {
						JOptionPane.showMessageDialog(SearchID, getNumber(), "인증 번호", JOptionPane.INFORMATION_MESSAGE);
					} else {
						setNumber(getNumber() + (int) (Math.random() * 9));
						JOptionPane.showMessageDialog(SearchID, getNumber(), "인증 번호", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(SearchID, "번호를 입력하세요.", "번호 미입력", JOptionPane.INFORMATION_MESSAGE);
				}			
			 } else if (idBt[0].getText().equals("인증 번호 확인")) {
				System.out.println("인증 번호 확인 넘어옴");

				if (idTf[2].getText().equals(getNumber())) {
					JOptionPane.showMessageDialog(SearchID, "인증 번호가 확인되었습니다.", "인증 번호 확인", JOptionPane.INFORMATION_MESSAGE);
					idTf[2].setEnabled(false);
				} else {
					idBt[0].setText("인증 번호 받기");
					JOptionPane.showMessageDialog(SearchID, "인증 번호를 확인해 주세요.", "인증 번호 오류", JOptionPane.INFORMATION_MESSAGE);
					idTf[2].setText(" * " + idTf[2].getText());
					idTf[2].setForeground(Color.RED);
				}

			}
			}
			
		});

		idBt[1].setBackground(new Color(125, 28, 48));
		idBt[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				String name = idTf[0].getText().trim();
				String phone = idTf[1].getText().trim();

				if (SsgDao.getInstance().mateName(name)) {
					System.out.println("이름 일치");
					if (SsgDao.getInstance().matePhone(name, phone)) {
						System.out.println("이름 번호 일치");
						if (idTf[2].getText().equals(getNumber())) {
							System.out.println("인증번호 일치");
							SsgDao.getInstance().searchId(name, phone);
							setId(SsgDao.getInstance().searchId(name, phone).getId());
							new SearchIDOk(getId());
							dispose();
						}
					} else {
						System.out.println("번호 없음");
						JOptionPane.showMessageDialog(SearchID, "가입 정보가 없습니다.", "가입 정보 없음", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					System.out.println("이름 없음");
					JOptionPane.showMessageDialog(SearchID, "가입 정보가 없습니다.", "가입 정보 없음", JOptionPane.INFORMATION_MESSAGE);
				}				
				
				
				for (int i = 0; i < idTf.length; i++) {
					idTf[i].setText("");					
				}
				idBt[0].setText("인증 번호 받기");
			}
		});
		idBt[0].setBorderPainted(false);

		this.add(idPanel);

	}

	public SearchID() {
		super("아이디 찾기");
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

	public static void main(String[] args) {
		new SearchID();
	}
}
