package project.semi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignUpLayout extends JFrame implements ActionListener, FocusListener {
	SetStyle s = new SetStyle();
	private Image signImg = Toolkit.getDefaultToolkit()
			.createImage("C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\joinback.jpg"); // 경로재지정
	private JPanel jp;
	private JTextField[] jtf = new JTextField[13];
	private JPasswordField[] jpf = new JPasswordField[2];
	private JLabel[] jlb = new JLabel[4];
	private JButton[] jbt = new JButton[6];
	private String passWord = "";
	private int idCheck = -1;
	private int pCheck = -1;
	private String code = "";
	private String rCode = "";
	Calendar calendar = Calendar.getInstance();
	private String sysdate = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
			+ calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.HOUR_OF_DAY) + "/"
			+ calendar.get(Calendar.MINUTE) + "/" + calendar.get(Calendar.SECOND);

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public JTextField[] getJtf() {
		return jtf;
	}

	public void setJtf(JTextField[] jtf) {
		this.jtf = jtf;
	}

	public JLabel[] getJlb() {
		return jlb;
	}

	public void setJlb(JLabel[] jlb) {
		this.jlb = jlb;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		Object source = arg0.getSource();

		for (int i = 0; i < jtf.length; i++) {
			if (source == jtf[i]) {
				if (jtf[i].getText().equals("아이디") || jtf[i].getText().equals("성 ") || jtf[i].getText().equals("이름")
						|| jtf[i].getText().equals("주민등록번호") || jtf[i].getText().equals("휴대전화번호")
						|| jtf[i].getText().equals("인증번호") || jtf[i].getText().equals("우편번호")
						|| jtf[i].getText().equals("상세주소") || jtf[i].getText().equals("추천인코드")) {
					jtf[i].setText("");
				} else if (jtf[i].getText().equals("비밀번호(8~20자 이내)") || jtf[i].getText().equals("비밀번호 다시 입력")) {
					jtf[i].setBounds(10, 10 + (i + 3) * 50, 0, 0);
					jpf[i - 1].setBounds(10, 10 + (i + 3) * 50, 330, 30);
					jpf[i - 1].requestFocus(true);
				}
			}
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		for (int i = 0; i < jtf.length; i++) {
			if (jtf[i].getText().equals("")) {
				jtfSetText(i);
			}
		}
		for (int i = 0; i < jpf.length; i++) { // 비밀번호 비밀번호 확인 다시 뜨게
			if (arg0.getSource() == jpf[i] && jpf[i].getText().equals("")) {
				jpf[i].setBounds(10, 10 + (i + 4) * 50, 0, 0);
				jtf[i + 1].setBounds(10, 10 + (i + 4) * 50, 330, 30);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == jbt[0]) { // id check
			idCheck *= -1;
			if (jtf[0].getText().trim().equals("") || jtf[0].getText().trim().equals("아이디")) {
				JOptionPane.showMessageDialog(this, "ID를 입력하세요.");
			} else if (IdDao.searchId(jtf[0].getText().trim()) == false) {
				JOptionPane.showMessageDialog(this, "사용 가능한 ID입니다.");
			} else {
				JOptionPane.showMessageDialog(this, "이미 존재하는 ID입니다.");
				jtf[0].setText("");
			}
		}
		if (source == jbt[1]) { // get verified code
			pCheck *= -1;
			if (jtf[7].getText().equals("휴대전화번호") || jtf[7].getText().equals("")) {
				JOptionPane.showMessageDialog(this, "휴대전화번호를 입력해주세요.");
			} else {
				code = "";
				JOptionPane.showMessageDialog(this, set5dCode());
				System.out.println(code);
			}
		}
		if (source == jbt[2]) { // check verified code
			if (jtf[8].getText().equals(code)) {
				JOptionPane.showMessageDialog(this, "인증되었습니다.");
			} else {
				JOptionPane.showMessageDialog(this, "인증번호를 다시 입력해주세요.");
				jtf[8].setText("");
			}
		}
		if (source == jbt[3]) { // zipcode
			new ZipCodeLayout(this);
		}
		if (source == jbt[4]) { // referral code
			findRefferralCode();
		}
		if (source == jbt[5]) { // sign up
			if (idCheck == -1) {
				JOptionPane.showMessageDialog(this, "ID 중복 검사 버튼을 눌러주세요.");
			} else if (pCheck == -1) {
				JOptionPane.showMessageDialog(this, "휴대폰 인증을 실시해주세요.");
			} else if (jlb[1].getText().equals("비밀번호를 다시 설정해주세요.")) {
				JOptionPane.showMessageDialog(this, "비밀번호를 다시 설정해주세요.");
			} else if (jtf[0].getText().equals("") || jpf[0].getText().equals("") || jpf[1].getText().equals("")
					|| jtf[3].getText().equals("") || jtf[4].getText().equals("") || jtf[5].getText().equals("")
					|| jtf[6].getText().equals("") || jtf[7].getText().equals("") || jtf[8].getText().equals("")
					|| jtf[9].getText().equals("") || jtf[10].getText().equals("") || jtf[11].getText().equals("")
					|| jtf[12].getText().equals("") || jtf[0].getText().equals("아이디") || jtf[3].getText().equals("성 ")
					|| jtf[4].getText().equals("이름") || jtf[5].getText().equals("주민등록번호")
					|| jtf[7].getText().equals("휴대전화번호") || jtf[8].getText().equals("인증번호")
					|| jtf[9].getText().equals("우편번호") || jtf[10].getText().equals("상세주소")) {
				JOptionPane.showMessageDialog(this, "입력되지 않은 정보가 있습니다.");
			} else {
				Member m = new Member();
				m.setId(jtf[0].getText().trim());
				m.setPw(jpf[0].getText().trim());
				m.setName(jtf[3].getText().trim() + jtf[4].getText().trim());
				m.setSnumber(jtf[5].getText().trim() + "-" + jtf[6].getText().trim());
				m.setAddr("(" + jtf[9].getText().trim() + ") " + jtf[10].getText().trim() + " "
						+ jtf[11].getText().trim());
				m.setCnumber(jtf[7].getText().trim());
				m.setReferralCode(rCode);
				m.setCode(findCode()); // 수정 꼭 해야함
				m.setGrade("일반 회원");
				m.setState("가입");
				m.setPoint(1000);
				m.setRegdate(sysdate);
				System.out.println(m);
				IdDao.insertMember(m);
				JOptionPane.showMessageDialog(this, "회원 가입을 축하합니다!");
				this.dispose();
				// 로그인 창으로 이동
			}
		}
	}

	public void findRefferralCode() {
		if (jtf[12].getText().trim().equals("추천인코드") || jtf[12].getText().trim().equals("")
				|| IdDao.searchCode(jtf[12].getText().trim()) == false) {
			JOptionPane.showMessageDialog(this, "코드를 다시 확인해주세요.");
			jtf[12].setText("");
		} else {
			JOptionPane.showMessageDialog(this, "확인되었습니다.");
			IdDao.updatePoint(jtf[12].getText().trim());
			rCode = jtf[12].getText().trim();
		}
	}

	public String findCode() {
		code = "";
		set5dCode();
		if (IdDao.searchCode(code) == false) {
			return code;
		} else {
			code = "";
			findCode();
		}
		return code;
	}

	public String set5dCode() {
		for (int i = 0; i < 5; i++) {
			int count = (int) (Math.random() * 2);
			if (count == 0) {
				char n = (char) ((Math.random() * 10) + 48);
				code += n;
			} else {
				char a = (char) ((Math.random() * 26) + 65);
				code += a;
			}
		}
		return code;
	}

	public void jtfSetText(int i) {
		jtf[i].setForeground(Color.gray);
		switch (i) {
		case 0:
			jtf[i].setText("아이디");
			break;
		case 1:
			jtf[i].setText("비밀번호(8~20자 이내)");
			break;
		case 2:
			jtf[i].setText("비밀번호 다시 입력");
			break;
		case 3:
			jtf[i].setText("성 ");
			break;
		case 4:
			jtf[i].setText("이름");
			break;
		case 5:
			jtf[i].setText("주민등록번호");
			break;
		case 7:
			jtf[i].setText("휴대전화번호");
			break;
		case 8:
			jtf[i].setText("인증번호");
			break;
		case 9:
			jtf[i].setText("우편번호");
			jtf[i].setEditable(false);
			jtf[i].setFocusable(false);
			break;
		case 10:
			jtf[i].setText("상세주소");
			jtf[i].setEditable(false);
			jtf[i].setFocusable(false);
			break;
		case 12:
			jtf[i].setText("추천인코드");
			break;
		}
	}

	public String pwCheck(char pw) {
		if (pw == '\b') {
			passWord += "";
		} else {
			passWord += pw;
		}
		return passWord;
	}

	public void layOut() {
		jp = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				if (signImg != null) {
					g.drawImage(signImg, 0, 0, this);
				}
			}
		};
		jp.setLayout(null);

		for (int i = 0; i < jpf.length; i++) {
			jpf[i] = new JPasswordField();
			jpf[i].setBorder(null);
			jpf[i].addFocusListener(this);
			jpf[i].addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					if (e.getSource() == jpf[0]) {
						if (jpf[0].getText().length() < 7 || jpf[0].getText().length() > 19) {
							jlb[1].setForeground(Color.RED);
							jlb[1].setText("비밀번호를 다시 설정해주세요.");
						} else {
							jlb[1].setText("");
						}
					}

					if (e.getSource() == jpf[1]) {
						pwCheck(e.getKeyChar());
						if (e.getKeyChar() == '\b') {
							passWord = passWord.substring(0, passWord.length() - 1);
						}
						if (passWord.equals(jpf[0].getText())) {
							jlb[2].setForeground(Color.DARK_GRAY);
							jlb[2].setText("사용 가능한 비밀번호입니다.");
						} else {
							jlb[2].setForeground(Color.RED);
							jlb[2].setText("일치하지 않습니다.");
						}
					}
				}

			});
			jp.add(jpf[i]);
		}

		for (int i = 0; i < jtf.length; i++) {
			jtf[i] = new JTextField();
			jtf[i].setBorder(null);
			jtfSetText(i);
			jtf[i].addFocusListener(this);
			jp.add(jtf[i]);

			switch (i) {
			case 0: // id
				jtf[i].setBounds(10, 10 + (i + 3) * 50, 200, 30);
				break;
			case 1:
			case 2: // pw
				jtf[i].setBounds(10, 10 + (i + 3) * 50, 330, 30);
				break;
			case 3:
			case 4: // name
				jtf[i].setBounds(10 + (i - 3) * 170, 10 + (3 + 3) * 50, 330 / 2 - 5, 30);
				break;
			case 5:
			case 6: // snumber
				jtf[i].setBounds(10 + (i - 5) * 175, 10 + (5 + 2) * 50, 330 / 2 - 10, 30);
				break;
			case 7: // pnumber
				jtf[i].setBounds(10 + (i - 7) * 115, 10 + (i + 1) * 50, 200, 30);
				break;
			case 8: // pnumber verified code
				jtf[i].setBounds(10, 10 + (i + 1) * 50, 200, 30);
				break;
			case 9: // zipcode
				jtf[i].setBounds(10, 10 + (i + 1) * 50, 200, 30);
				break;
			case 10:
			case 11: // address
				jtf[10].setEditable(false);
				jtf[i].setBounds(10, 10 + (i + 1) * 50, 330, 30);
				break;
			case 12: // referral code
				jtf[i].setBounds(10, 10 + (i + 1) * 50, 200, 30);
				break;
			}
		}

		for (int i = 0; i < jlb.length; i++) {
			jlb[i] = new JLabel("");
			jp.add(jlb[i]);
			jlb[i].setHorizontalAlignment(SwingConstants.CENTER);

			if (i == 0) {
				jlb[i].setBounds(0, -10, 370, 140); // logo
				jlb[i].setText(
						"<html><p style = \"font-size: 30; font-family: 나눔고딕; text-align: center\">회원가입</p><br><p style = \"font-size: 12; font-family: 나눔고딕; color: gray; text-align: center\">회원으로 가입하신 후<br>SSOG.COM의 다양한 서비스를 이용해보세요.</p></html>");
			} else if (i == 1 || i == 2) { // id, pw check
				jlb[i].setBounds(10, 90 + (i + 2) * 50, 330, 20);
				jlb[i].setHorizontalAlignment(SwingConstants.LEFT);
			} else if (i == 3) { // snumber
				jlb[i].setBounds(165, 10 + (7) * 50, 20, 30);
				jlb[i].setText("-");
			}
		}

		for (int i = 0; i < jbt.length; i++) {
			jbt[i] = new JButton("");
			s.setStyle(jbt[i], s.lightGray, Color.DARK_GRAY, s.nanum, Font.PLAIN, 12);
			jbt[i].addActionListener(this);
			jp.add(jbt[i]);

			switch (i) {
			case 0: // id check
				jbt[i].setBounds(220, 10 + (i + 3) * 50, 120, 30);
				jbt[i].setText("중복 검사");
				break;
			case 1:
				jbt[i].setBounds(220, 10 + (i + 7) * 50, 120, 30);
				jbt[i].setText("인증번호 받기");
				break;
			case 2:
				jbt[i].setBounds(220, 10 + (i + 7) * 50, 120, 30);
				jbt[i].setText("인증번호 확인");
				break;
			case 3: // zipcode
				jbt[i].setBounds(220, 10 + (i + 7) * 50, 120, 30);
				jbt[i].setText("우편번호");
				break;
			case 4:
				jbt[i].setBounds(220, 10 + (i + 9) * 50, 120, 30);
				jbt[i].setText("코드 확인");
				break;
			case 5: // sign up
				jbt[i].setBounds(10, 10 + (i + 9) * 50, 330, 30);
				jbt[i].setText("등록");
				s.setStyle(jbt[i], s.ssogRed, Color.WHITE);
				break;
			}
		}
		this.add(jp);
	}

	public SignUpLayout() {
		layOut();
		System.out.println(sysdate);
		this.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				jtf[0].setFocusable(true);
				jpf[0].setFocusable(true);
			}
		});

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				jtf[0].setFocusable(false);
				jpf[0].setFocusable(false);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				SignUpLayout.this.dispose();
			}
		});

		this.setBounds(0, 0, 370, 800);
		this.setLocation(((d.width - this.getWidth()) / 2), ((d.height - this.getHeight()) / 2));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

//	public static void main(String[] args) {
//
//		new SignUpLayout();
//
//	}
}