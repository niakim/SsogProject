package project.semi;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// https://mainia.tistory.com/4673	// 탈퇴참고화면

public class Withdrawal extends JFrame implements ActionListener {
	private SetStyle s = new SetStyle();
	private ImageIcon loginimg = new ImageIcon(
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\코드\\NK\\crudimg7\\SSOGLOGO.png");
//	private ImageIcon loginimg = new ImageIcon(
//			"/Users/y/Dropbox/나경 JAVA/조별 Project/2.CRUD(19.03.08)/코드/NK/crudimg7/SSOGLOGO.png");

	private JPanel[][] jp = new JPanel[3][];
	private JLabel[][] jlb = new JLabel[3][];
	private JPasswordField jpf;
	private JButton[][] jbtn = new JButton[3][];
	private TitledBorder tb;
	private String[] jcbStr = { "상품 다양성/가격품질 불만", "교환/환불/품질불만", "배송지연", "이용빈도 낮음", "개인정보유출", "회원득혜/쇼핑혜택 부족", "A/S 불만",
			"쇼핑몰 속도 불만", "기타" };
	private JCheckBox[] jcb = new JCheckBox[jcbStr.length];
	private JScrollPane jscp;
	private JTextArea jta;
	private String[] jbtnStr = { "회원 탈퇴 신청", "취소" };
	private int[] jcbInt = new int[jcb.length];
	private String complain = "";

	private String[] logInfo = new String[3];

	private CardLayout card = new CardLayout();

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == jbtn[0][0] || e.getActionCommand().equals("next")) { // 다음 버튼
			if (jpf.getText().equals(logInfo[1])) {
				card.show(this.getContentPane(), "1");
			} else {
				jpf.setText("");
				tb = new TitledBorder(new LineBorder(s.ssogRed, 3), "비밀번호 입력");
				tb.setTitleColor(s.ssogRed);
				jp[0][1].setBorder(tb);
				jbtn[0][0].setBackground(Color.DARK_GRAY);
			}
		}
		if (source == jbtn[1][0]) { // 회원 탈퇴 신청 버튼
			if (jcbInt[0] == -1 && jcbInt[1] == -1 && jcbInt[2] == -1 && jcbInt[3] == -1 && jcbInt[4] == -1
					&& jcbInt[5] == -1 && jcbInt[6] == -1 && jcbInt[7] == -1 && jcbInt[8] == -1) {
				JOptionPane.showMessageDialog(this, "최소 하나의 사유를 선택해주세요.");
			} else {
				String tmp = "#";
				WithdrawalBean w = new WithdrawalBean();
				Member m = IdDao.searchSnumber(logInfo[0]);
				for (int i = 0; i < jcbInt.length; i++) {
					if (jcbInt[i] == 1) {
						complain += (tmp.concat(jcb[i].getText()));
					}
				}
				w.setSnumber(m.getSnumber());
				w.setAddr(m.getAddr());
				w.setComplain(complain);
				w.setOpinion(jta.getText());
				IdDao.insertWithdrawal(w);
				IdDao.deleteId(logInfo[0]);
				card.show(this.getContentPane(), "2");
			}
		}
		if (source == jbtn[1][1]) { // 취소 버튼
			Withdrawal.this.dispose();
		}
		if (source == jbtn[2][0]) { // 닫기 버튼
			dispose();
		}

		for (int i = 0; i < jcbInt.length; i++) {
			if (source == jcb[i]) {
				jcbInt[i] *= -1;
			}
		}
	}

	public void setInt() {
		for (int i = 0; i < jcbInt.length; i++) {
			jcbInt[i] = -1;
		}
	}

	public void layOut() {
		for (int i = 0; i < jp.length; i++) {
			switch (i) {
			case 0: // 본인확인
				jp[i] = new JPanel[2];

				jp[i][0] = new JPanel(null);
				jp[i][0].setBackground(Color.WHITE);

				jlb[i] = new JLabel[4];

				jlb[i][0] = new JLabel();
				jlb[i][0].setIcon(loginimg);
				jlb[i][0].setBounds((600 - 150) / 2, 100, 150, 150);

				jlb[i][1] = new JLabel();
				jlb[i][1].setText(logInfo[2]);

				jlb[i][2] = new JLabel("계속하려면 먼저 본인임을 인증하세요.");
				s.setStyle(jlb[i][2], false, Color.DARK_GRAY);
				jlb[i][2].setBounds((600 - 320) / 2, 350, 320, 30);

				jp[i][1] = new JPanel(null);
				jp[i][1].setBackground(Color.WHITE);
				tb = new TitledBorder(new LineBorder(Color.BLACK, 3), "비밀번호 입력");
				tb.setTitleColor(Color.DARK_GRAY);
				jp[i][1].setBorder(tb);
				jp[i][1].setBounds((600 - 320) / 2, 390, 320, 60);

				jlb[i][3] = new JLabel("비밀번호를 잊으셨나요?");
				s.setStyle(jlb[i][3], false, Color.GRAY);
				jlb[i][3].setBounds((600 - 320) / 2, 550, 250, 30);
				jlb[i][3].addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						// 비밀번호 찾기 페이지로 이동
						System.out.println("..");
					}
				});

				jpf = new JPasswordField(15);
				jpf.setBorder(null);
				jp[i][1].add(jpf);
				jpf.setBounds(10, 20, 300, 30);
				jpf.registerKeyboardAction(this, "next", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
						JComponent.WHEN_FOCUSED);

				jbtn[i] = new JButton[1];
				jbtn[i][0] = new JButton("다음");
				s.setStyle(jbtn[i][0], s.ssogRed, Color.WHITE);
				jbtn[i][0].setBounds((600 - 320) / 2, 460, 320, 40);
				jbtn[i][0].setActionCommand("next");
				jbtn[i][0].addActionListener(this);

				for (int j = 0; j < jlb[i].length; j++) {
					jp[i][0].add(jlb[i][j]);
				}
				jp[i][0].add(jp[i][1]);
				jp[i][0].add(jbtn[i][0]);
				break;
			case 1: // 탈퇴 확인
				jp[i] = new JPanel[3];

				jp[i][0] = new JPanel(null);
				jp[i][0].setBackground(Color.WHITE);

				jlb[i] = new JLabel[10];

				jlb[i][0] = new JLabel("회원");
				s.setStyle(jlb[i][0], false, s.ssogRed, "나눔고딕", Font.BOLD, 20);
				jlb[i][0].setBounds(10, 0, 40, 50);

				jlb[i][1] = new JLabel("탈퇴");
				s.setStyle(jlb[i][1], false, Color.BLACK, "나눔고딕", Font.BOLD, 20);
				jlb[i][1].setFont(new Font("나눔고딕", Font.BOLD, 20));
				jlb[i][1].setBounds(55, 0, 40, 50);

				jlb[i][2] = new JLabel("|   회원탈퇴 전 다음 사항을 꼭 숙지하시기 바랍니다.");
				s.setStyle(jlb[i][2], false, Color.GRAY, "나눔고딕", Font.PLAIN, 12);
				jlb[i][2].setBounds(105, 0, 300, 50);

				jlb[i][3] = new JLabel(); // 선
				s.setStyle(jlb[i][3], true);
				jlb[i][3].setBackground(Color.DARK_GRAY);
				jlb[i][3].setBounds(10, 50, 565, 3);

				jlb[i][4] = new JLabel("· 저희 쏙배송은 고객센터(127-127)를 365일 24시간 운영하고 있습니다.");
				s.setStyle(jlb[i][4], false, Color.BLACK, "나눔고딕", Font.PLAIN, 12);
				jlb[i][4].setBounds(10, 60, 565, 20);

				jlb[i][5] = new JLabel("· 서비스 이용 중 불편사항은 언제든지 연락 주시면, 최선을 다해 해결 되도록 노력하겠습니다.");
				s.setStyle(jlb[i][5], false, Color.BLACK, "나눔고딕", Font.PLAIN, 12);
				jlb[i][5].setBounds(10, 80, 565, 20);

				jp[i][1] = new JPanel(null);
				jp[i][1].setBackground(Color.WHITE);
				jp[i][1].setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				jp[i][1].setBounds(10, 110, 565, 160);

				jlb[i][6] = new JLabel("회원탈퇴 안내");
				s.setStyle(jlb[i][6], false, Color.BLACK, "나눔고딕", Font.BOLD, 12);
				jlb[i][6].setBounds(10, 10, 545, 20);

				jlb[i][7] = new JLabel(
						"<html>· 회원 탈퇴 시 회원님께서 보유하셨던 비현금성 포인트와 쿠폰, 회원정보, 거래정보 등은 모두 삭제 됩니다.<br>· 회원 탈퇴 후 해지 및 재가입 방지를 목적으로 1개월간 회원의 성명, 주민등록번호, 아이디, 비밀번호, 이메일, 로그기록, 접속IP를 보관 합니다. 거래 정보가 있는 경우, 판매 거래 정보관리를 위하여 구매와 관련된 상품정보, 아이디, 거래 내역 등에 대한 기본정보는 탈퇴 후 5년간 보관합니다.<br>· 회원 탈퇴 후 재가입 시에는 신규 회원 가입으로 처리되며, 탈퇴 전의 회원정보와 거래정보 및 포인트, 쿠폰 정보 등은 복구되지 않습니다.<br>· 구매를 주 목적으로 재가입하는 경우 유예기간은 탈퇴 후 30일입니다.<br>· 판매를 주 목적으로 재가입하는 경우 유예기간은 탈퇴 후 60일입니다.</html>");
				s.setStyle(jlb[i][7], false, Color.BLACK, "나눔고딕", Font.PLAIN, 12);
				jlb[i][7].setBounds(10, 30, 545, 120);

				jlb[i][8] = new JLabel("쏙배송 서비스 이용 중 불편사항을 선택해주세요.(복수선택가능)");
				s.setStyle(jlb[i][8], false, Color.BLACK, "나눔고딕", Font.BOLD, 14);
				jlb[i][8].setBounds(10, 300, 545, 20);

				jp[i][2] = new JPanel(new GridLayout(3, 3));
//				jp[i][2].setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));
				jp[i][2].setBackground(Color.WHITE);
				jp[i][2].setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				jp[i][2].setBounds(10, 325, 565, 100);

				jlb[i][8] = new JLabel("쏙배송 서비스 이용 중 불편사항을 선택해주세요.(복수선택가능)");
				s.setStyle(jlb[i][8], false, Color.BLACK, "나눔고딕", Font.BOLD, 14);
				jlb[i][8].setBounds(10, 300, 545, 20);
				setInt();

				for (int j = 0; j < jcb.length; j++) {
					jp[i][2].add(jcb[j] = new JCheckBox(jcbStr[j]));
					jcb[j].addActionListener(this);
					s.setStyle(jcb[j], Color.WHITE, "나눔고딕", Font.PLAIN, 12);
				}

				jlb[i][9] = new JLabel("그 이외에 쏙배송에 남기고 싶으신 의견이 있으시면 기재해주세요.");
				s.setStyle(jlb[i][9], false, Color.BLACK, "나눔고딕", Font.BOLD, 14);
				jlb[i][9].setBounds(10, 455, 545, 20);

				jscp = new JScrollPane(jta = new JTextArea(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				jscp.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				jta.setLineWrap(true);
				jscp.setBounds(10, 480, 565, 200);

				jbtn[i] = new JButton[jbtnStr.length];
				for (int j = 0; j < jbtn[i].length; j++) {
					jbtn[i][j] = new JButton(jbtnStr[j]);
					jbtn[i][j].addActionListener(this);
					jbtn[i][j].setBounds(150 + j * 160, 710, 150, 40);
					jp[i][0].add(jbtn[i][j]);
				}
				s.setStyle(jbtn[1][0], Color.WHITE, s.ssogRed, "나눔고딕", Font.BOLD, 14, s.ssogRed, 1);
				s.setStyle(jbtn[1][1], Color.WHITE, Color.GRAY, "나눔고딕", Font.BOLD, 14, Color.GRAY, 1);

				for (int j = 6; j < 8; j++) {
					jp[i][1].add(jlb[i][j]);
				}
				jp[i][0].add(jscp);
				for (int j = 0; j < 6; j++) {
					jp[i][0].add(jlb[i][j]);
				}
				for (int j = 8; j < jlb[i].length; j++) {
					jp[i][0].add(jlb[i][j]);
				}
				for (int j = 1; j < jp[i].length; j++) {
					jp[i][0].add(jp[i][j]);
				}
				break;
			case 2: // 탈퇴 완료
				jp[i] = new JPanel[1];

				jp[i][0] = new JPanel(null);
				jp[i][0].setBackground(Color.WHITE);

				jlb[i] = new JLabel[3];

				jlb[i][0] = new JLabel("쏙배송 회원 탈퇴가 완료되었습니다.");
				s.setStyle(jlb[i][0], false, s.ssogRed, "나눔고딕", Font.BOLD, 20, SwingConstants.CENTER);
				jlb[i][0].setBounds(10, 250, 565, 25);

				jlb[i][1] = new JLabel("<html>그동안 쏙배송 서비스를 이용해주신 <b>" + logInfo[2] + "</b> 고객님께 감사드립니다.</html>");
				s.setStyle(jlb[i][1], false, Color.BLACK, "나눔고딕", Font.PLAIN, 16, SwingConstants.CENTER);
				jlb[i][1].setBounds(10, 300, 565, 25);

				jlb[i][2] = new JLabel("고객님의 소중한 충고로 더욱 발전하는 쏙배송 되겠습니다.");
				s.setStyle(jlb[i][2], false, Color.GRAY, "나눔고딕", Font.PLAIN, 14, SwingConstants.CENTER);
				jlb[i][2].setBounds(10, 325, 565, 25);

				jbtn[i] = new JButton[1];

				jbtn[i][0] = new JButton("닫기");
				s.setStyle(jbtn[i][0], s.ssogRed, Color.WHITE, "나눔고딕", Font.BOLD, 16);
				jbtn[i][0].setBounds((600 - 320) / 2, 460, 320, 40);
				jbtn[i][0].addActionListener(this);

				jp[i][0].add(jbtn[i][0]);
				for (int j = 0; j < jlb[i].length; j++) {
					jp[i][0].add(jlb[i][j]);
				}
				break;
			}
			this.add(jp[i][0]);
		}

		this.setLayout(card);

		for (int i = 0; i < jp.length; i++) {
			this.add(jp[i][0], Integer.toString(i));
		}
	}

	public Withdrawal(String id, String pw, String name) {
		super(name + "님 정말 탈퇴하시려구요?...");

		this.logInfo[0] = id;
		this.logInfo[1] = pw;
		this.logInfo[2] = name;

		layOut();

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				Withdrawal.this.dispose();
			}
		});

		this.setBounds(0, 0, 600, 800);
		this.setLocation(((d.width - this.getWidth()) / 2), ((d.height - this.getHeight()) / 2));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

//	public static void main(String[] args) {
//
//		Withdrawal w = new Withdrawal("nana0813", "yodream123", "나재민");
//
//	}
}
