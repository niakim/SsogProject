package project.semi.nk;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PayLayout extends JFrame implements ActionListener {

	private JButton jbtnShop, test;
	private JPanel jp1, jp2, jp3, /* jp3_1,jp3_2, */jp4, jp4_1;
	private JScrollPane jsp;
	private Font gothic1 = new Font("맑은 고딕", Font.PLAIN, 15); // 라벨에 쓰일 글씨체
	private Font gothic2 = new Font("맑은 고딕", Font.BOLD, 15); // 라벨에 쓰일 글씨체
	private Font gothic3 = new Font("맑은 고딕", Font.BOLD, 25); // 라벨에 쓰일 글씨체
	private Font gothic4 = new Font("맑은 고딕", Font.BOLD, 40); // 라벨에 쓰일 글씨체
	private String[] jlbMainStr = { "결제하기" };
	private JLabel[] jlbMain = new JLabel[jlbMainStr.length];

	private String[] jlb3_1FixedStr = { " 받는 분 정보", "배송지 정보", "[16933]경기 용인시 수지구 123동 456호", "쏙 배송메시지",
			"※ 업체에서 직접 배송되는 상품은 품절 발생 시 대체배송 없이 결제 시 선택하신 방법으로 환불 처리됩니다.", "이메일", "ssogmember1@ssog.com", "품절시 환불방법",
			"※ 결제완료 문자/메일 및 환불처리는 주문자(회원)에게 안내됩니다." };
	private JLabel[] jlb3_1Fixed = new JLabel[jlb3_1FixedStr.length];

	private String[] deliveryMessage = { " 배송기사에게 전달되는 메시지 입니다. 선택하여 주세요.　　　", " 부재시, 경비(관리)실에 맡겨주세요.",
			" 부재시, 문 앞에 놓아주세요.", " 직접 받겠습니다.", " 배송 전에 연락주세요." };
	private JComboBox<String> jComboBox;
	private JRadioButton refund1, refund2;
	private ButtonGroup refundGroup;
	private JPanel jp3_sub1, jp3_sub2, jp3_sub3, jp3_sub4, jp3_sub5, jp3_sub6, jp3_sub7, jp3_sub8, jp3_sub9, jp3_sub10,
			jp3_sub11;
	//
	private String[] jlb3_2FixedStr = { " 주문 상품 : " };
	private JLabel[] jlb3_2Fixed = new JLabel[jlb3_2FixedStr.length];
	private JPanel jp3_sub20;
	//
	private String[] jlb3_3FixedStr = { " 결제 수단 " };
	private JLabel[] jlb3_3Fixed = new JLabel[jlb3_3FixedStr.length];
	private JPanel jp3_sub30, jp3_sub31, jp3_sub32, jp3_sub33, jp3_sub34, jp3_sub35, jp3_sub36, jp3_sub37, jp3_sub38;// 33-37//38:chkBox
	private JButton jbtnPay1, jbtnPay2, jbtnPay3, jbtnPay4, jbtnPay5;
	//
	//
	private JPanel jpPaySSog1, jpPaySSog1_blank, jpPaySSog2, jpPaySSog3, jpPaySSog4;
	private JPanel jpPayCardBlank, jpPayCard1, jpPayCard2, jpPayCard3, jpPayCard4, jpPayCard5;
	private JPanel jpPayBank1, jpPayBank2, jpPayBank3, jpPayBank4;
	private JPanel jpPayCp1, jpPayCp2, jpPayCp3, jpPayCp4, jpPayCp5, jpPayCp6;
	//
	private String[] jcbPayCpStr = { "통신사 선택", "SKT", "KT", "LGU+", "KCT(알뜰폰)", "헬로모바일" };
	private JComboBox<String> jcbPayCp;
	//
	private String[] jcbPayCard1Str = { " 카드를 선택해주세요.　　　　 　　　　　　　　　　　　　　", " SSOG마트 카드", " 현대카드", " KB국민카드", " 비씨카드",
			" 씨티카드", " 하나카드", " 롯데카드", " SSOGPAY카드", " NH카드", " 우리카드", " IBK기업은행카드", " SC은행카드", " 광주카드", " 전북카드",
			" 수협카드", " 제주카드" };
	private JComboBox<String> jcbPayCard1;
	private String[] jcbPayCard2Str = { " 일시불　　　　　　　　　", " 무이자", " 일반 할부" };
	private JComboBox<String> jcbPayCard2;
	private String[] jcbPayCard3Str = { " 선택　　　　　　　　 　　　", " 2", " 3", " 4", " 5" };
	private JComboBox<String> jcbPayCard3;
	//
	private String[] jlb4FixedStr = { "배송지 : ", "주문금액", "할인금액　　　　　　　　　　　　-", "포인트 사용", "SSOG포인트", "SSOG쿠폰", "결제예정금액" };
	//
	private String[] jlb4NonFixedStr = { "[16933]경기 용인시 수지구 123동 456호", "원", "원", "원", "원" };
	//
	private JLabel[] jlb4Fixed = new JLabel[jlb4FixedStr.length];
	private JLabel[] jlb4NonFixed = new JLabel[jlb4NonFixedStr.length];

	private JPanel[] jp3_ = new JPanel[5]; // 왼쪽 메인에 (jp3) 안에 들어가는 애들
	// private JPanel[] jp3_sub = new JPanel[20]; //왼쪽 메인에 (jp3) 안에 들어가는 애들
	private JPanel[] jpLine = new JPanel[8];
	private String[] jbtnStr4 = { "변경>", "전환/조회", "사용", "주문 상품 결제하기" };
	private JButton[] jbtn4 = new JButton[jbtnStr4.length];
	private JCheckBox chk1, chk2;

	private CardLayout card = new CardLayout(0, 0);

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public JLabel[] getJlb4NonFixed() {
		return jlb4NonFixed;
	}

	public void setJlb4NonFixed(JLabel[] jlb4NonFixed) {
		this.jlb4NonFixed = jlb4NonFixed;
	}

	// ?
	public JButton[] getJbtn4() {
		return jbtn4;
	}

	public void setJbtn4(JButton[] jbtn4) {
		this.jbtn4 = jbtn4;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		// String str = e.getActionCommand();

		if (source == jbtnShop) {
			PayLayout.this.dispose();
		}
		// if (str.equals("신용카드")) {card.show(PayLayout.this, "p1");}

		if (source == jbtnPay1) {
			jp3_[3].setVisible(false);
		}
		if (source == jbtnPay2) {
			jp3_[3].setVisible(true);
			card.show(jp3_[3], "p2");
		}
		if (source == jbtnPay3) {
			jp3_[3].setVisible(true);
			card.show(jp3_[3], "p3");
		}
		if (source == jbtnPay4) {
			jp3_[3].setVisible(true);
			card.show(jp3_[3], "p4");
		}
		if (source == jbtnPay5) {
			jp3_[3].setVisible(true);
			card.show(jp3_[3], "p5");
		}

		// 결제방법 - 신용카드 - 선택 해야만 다음 콤보박스 선택 가능하도록.
		if (jcbPayCard1.getSelectedIndex() == 0) {
			jcbPayCard2.setEnabled(false);
		} else {
			jcbPayCard2.setEnabled(true);
		}

		if (jcbPayCard2.getSelectedIndex() == 0) {
			jcbPayCard3.setEnabled(false);
		} else {
			jcbPayCard3.setEnabled(true);
			if (jcbPayCard1.getSelectedIndex() == 0) {
				jcbPayCard3.setEnabled(false);

			}

		}

		// 팝업창 뜨는 것들 모음집
		// 쿠폰 사용
		if (jbtn4[0] == source) {
//			new AddrSearchBox();
		}

		else if (jbtn4[2] == source) {
			new CouponSearchBox(this);
		} else if (jbtn4[3] == source) {
			if (chk1.isSelected()) {
				if (JOptionPane.showConfirmDialog(this, jlb4NonFixed[4].getText() + "을 결제하시겠SSOG?", "결제확인이쏙",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null) == JOptionPane.OK_OPTION) {
					new PayLayoutSuccess();
					PayLayout.this.dispose();
				}
			} else {
				JOptionPane.showMessageDialog(null, "<html><div color=red>약관에 동의해주세요!", "결제",
						JOptionPane.ERROR_MESSAGE);
				// JOptionPane.showConfirmDialog(this, "약관에 동의해주세요!");
			} // else

		}

	}

	public void iniLayout() {

		int panelsize = ((d.width - d.width / 4) / 3) * 2; // 수식 넘 길어서 인자로 줌.

		jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBackground(new Color(240, 240, 240));

		for (int i = 0; i < jpLine.length; i++) {
			jpLine[i] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					// TODO Auto-generated method stub
					Graphics2D g2d = (Graphics2D) g;
					g2d.setStroke(new BasicStroke(4));
					g2d.drawLine(20, 10, 880, 10);// ((d.width - d.width / 4)/3)*2+30
				}

			};
		}

		//////////////////////////////////////////////////////////////////////////////////////////////////

		jp2 = new JPanel();
		jp2.setLayout(null);
		jp2.setBackground(Color.white);
		jp2.setBounds(30, 120, panelsize, d.height - 150);// (d.height / 3 * 2) + d.height / 3 * 2

		GridBagLayout gbl = new GridBagLayout();
		jsp = new JScrollPane(jp3 = new JPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// new GridLayout(5, 1)
		jp3.setLayout(new BoxLayout(jp3, BoxLayout.Y_AXIS));
		jsp.setBounds(20, 20, panelsize - 40, d.height - 190);
		jsp.getVerticalScrollBar().setUnitIncrement(20); // 스크롤바 스피드
		jp3.setBackground(Color.white);

		LineBorder whiteBorder = new LineBorder(Color.white);// jsp 테두리가 생겨서 그거 없애려고 화이트로 하나 만들어줌.
		jsp.setBorder(whiteBorder);

		// JLabel background=new JLabel(new ImageIcon("d:\\crudimg7\\test.png"));

		// Dimension xs= new Dimension(900, 200);
		// Dimension xl= new Dimension(900, 500);

		for (int i = 0; i < 4; i++) {
			jp3_[i] = new JPanel();
			jp3_[i].setBackground(Color.white);
			// jp3_[i].setBorder(whiteBorder);
			jp3_[i].setPreferredSize(new Dimension(900, 470));
			// jp3_[i].setMinimumSize(xs);

			if (i == 1 || i == 2) {
				jp3_[i].setPreferredSize(new Dimension(900, 250));
			} else if (i == 3) {
				jp3_[i].setLayout(card); // 카드 레이아웃
				jp3_[i].setPreferredSize(new Dimension(900, 320));
				jp3_[i].setBackground(Color.pink);
			}

			jp3.add(jp3_[i]);

		}

		/*
		 * for (int i = 0; i < 20; i++) { //i<20에서 바꿈 jp3_sub[i] = new JPanel();
		 * jp3_sub[i].setPreferredSize(new Dimension(900, 50)); //이거 먹음 ㅠㅠ
		 * jp3_sub[i].setOpaque(false); if(i==0||i==1||i==2||i==3||i==4) {
		 * jp3_[0].add(jp3_sub[i]); }else { jp3_[2].add(jp3_sub[i]); } }
		 */

		jp3_sub1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub11 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		jp3_sub20 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		jp3_sub30 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3_sub31 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jp3_sub32 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 결제 버튼 패널

		jp3_sub33 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 결제 상세 내용 패널
		jp3_sub34 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jp3_sub35 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jp3_sub36 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jp3_sub37 = new JPanel(new FlowLayout(FlowLayout.CENTER));

		jp3_sub38 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 체크박스용
		jp3_sub38.add(chk2 = new JCheckBox("선택한 결제수단을 다음에도 사용"));
		chk2.setFont(gothic1);
		chk2.setBackground(Color.white);

		///// 임시 카드 색상
		jp3_sub33.setBackground(Color.white);
		jp3_sub34.setBackground(Color.white); // SSOG PAY
		jp3_sub35.setBackground(Color.white); // 신용카드
		jp3_sub36.setBackground(Color.white); // 실시간 계좌이체
		jp3_sub37.setBackground(Color.white); // 휴대폰 결제

		jp3_sub2.setOpaque(false);
		jp3_sub3.setOpaque(false);
		jp3_sub4.setOpaque(false);
		jp3_sub5.setOpaque(false);
		jp3_sub6.setOpaque(false);
		jp3_sub7.setOpaque(false);
		jp3_sub8.setOpaque(false);
		jp3_sub9.setOpaque(false);
		jp3_sub10.setOpaque(false);
		jp3_sub11.setOpaque(false);

		jp3_sub31.setOpaque(false);
		jp3_sub32.setOpaque(false);
		jp3_sub38.setOpaque(false);
		/*
		 * LineBorder grayBorderThick = new LineBorder(new Color(100, 100, 100),3);
		 * jp3_sub1.setBorder(grayBorderThick); jp3_sub20.setBorder(grayBorderThick);
		 * jp3_sub30.setBorder(grayBorderThick);
		 */
		/*
		 * jp3_sub1.setBackground(new Color(242, 208, 144)); jp3_sub20.setBackground(new
		 * Color(242, 208, 144)); jp3_sub30.setBackground(new Color(242, 208, 144));
		 */
		jp3_sub1.setBackground(new Color(10, 10, 10, 130));
		jp3_sub20.setBackground(Color.DARK_GRAY);
		jp3_sub30.setBackground(new Color(242, 208, 144));

		jp3_sub1.setPreferredSize(new Dimension(850, 50)); // 1번째 패널 title
		jp3_sub2.setPreferredSize(new Dimension(200, 100)); // 배송지정보
		jp3_sub3.setPreferredSize(new Dimension(650, 100));
		jp3_sub4.setPreferredSize(new Dimension(200, 70));
		jp3_sub5.setPreferredSize(new Dimension(650, 70));
		jp3_sub6.setPreferredSize(new Dimension(850, 50)); // Warning
		jp3_sub7.setPreferredSize(new Dimension(200, 50));
		jp3_sub8.setPreferredSize(new Dimension(650, 50));
		jp3_sub9.setPreferredSize(new Dimension(200, 50));
		jp3_sub10.setPreferredSize(new Dimension(650, 50));
		jp3_sub11.setPreferredSize(new Dimension(850, 30)); // Warning

		jp3_sub20.setPreferredSize(new Dimension(850, 50)); // 2번째 패널 제목 - 주문 상품

		jp3_sub30.setPreferredSize(new Dimension(850, 50)); // 3번째 패널 제목 - 결제
		jp3_sub31.setPreferredSize(new Dimension(850, 70));
		jp3_sub32.setPreferredSize(new Dimension(850, 70));
		// 카드 임시
		/*
		 * jp3_sub33.setPreferredSize(new Dimension(850, 70));
		 * jp3_sub34.setPreferredSize(new Dimension(850, 70));
		 * jp3_sub35.setPreferredSize(new Dimension(850, 70));
		 * jp3_sub36.setPreferredSize(new Dimension(850, 100));
		 * jp3_sub37.setPreferredSize(new Dimension(850, 70));
		 */

		jp3_sub38.setPreferredSize(new Dimension(860, 30));

		jComboBox = new JComboBox<String>(deliveryMessage); // 배송메세지 콤보박스
		jComboBox.setFont(gothic1);
		jComboBox.setBackground(Color.white);
		jp3_sub5.add(jComboBox);

		refundGroup = new ButtonGroup();
		refundGroup.add(refund1 = new JRadioButton("주문시 결제수단으로 환불받기"));
		refundGroup.add(refund2 = new JRadioButton("예치금으로 자동환불 받기"));
		refund1.setFont(gothic1);
		refund2.setFont(gothic1);
		refund1.setOpaque(false);
		refund2.setOpaque(false);
		jp3_sub10.add(refund1);
		jp3_sub10.add(refund2);

		/*
		 * ButtonGroup testbg= new ButtonGroup(); testbg.add(jbtnPay2 = new
		 * JButton("SSOG PAY")); testbg.add(jbtnPay3 = new JButton("신용카드"));
		 * testbg.add(jbtnPay4 = new JButton("실시간 계좌이체")); testbg.add(jbtnPay5 = new
		 * JButton("휴대폰 소액결제"));
		 */
		String replace = "결제 수단을 선택해주세요.";
		jbtnPay1 = new JButton(replace);
		jbtnPay2 = new JButton("SSOG PAY");
		jbtnPay3 = new JButton("신용카드");
		jbtnPay4 = new JButton("실시간 계좌이체");
		jbtnPay5 = new JButton("휴대폰 소액결제");
		jbtnPay1.setFont(gothic3);
		jbtnPay2.setFont(gothic2);
		jbtnPay3.setFont(gothic2);
		jbtnPay4.setFont(gothic2);
		jbtnPay5.setFont(gothic2);
		jbtnPay1.addActionListener(this);
		jbtnPay2.addActionListener(this);
		jbtnPay3.addActionListener(this);
		jbtnPay4.addActionListener(this);
		jbtnPay5.addActionListener(this);
		jbtnPay2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnPay3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnPay4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnPay5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnPay1.setPreferredSize(new Dimension(850, 65));
		jbtnPay2.setPreferredSize(new Dimension(208, 65));
		jbtnPay3.setPreferredSize(new Dimension(207, 65));
		jbtnPay4.setPreferredSize(new Dimension(207, 65));
		jbtnPay5.setPreferredSize(new Dimension(208, 65));

		LineBorder redBorderThick = new LineBorder(new Color(168, 39, 53), 5); // 쏙의 붉은색~
		LineBorder blackBorderThick = new LineBorder(new Color(30, 30, 30), 2); //
		LineBorder grayBorderThick = new LineBorder(new Color(220, 220, 220), 1); //
		jbtnPay1.setBorder(blackBorderThick);
		jbtnPay2.setBorder(grayBorderThick);
		jbtnPay3.setBorder(grayBorderThick);
		jbtnPay4.setBorder(grayBorderThick);
		jbtnPay5.setBorder(grayBorderThick);
		jbtnPay1.setBackground(Color.white);
		jbtnPay2.setBackground(Color.white);
		jbtnPay3.setBackground(Color.white);
		jbtnPay4.setBackground(Color.white);
		jbtnPay5.setBackground(Color.white);
		jbtnPay1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnPay1.setBorder(blackBorderThick);
				jbtnPay1.setText("결제 수단을 선택해주세요.");
				jbtnPay2.setBorder(grayBorderThick);
				jbtnPay3.setBorder(grayBorderThick);
				jbtnPay4.setBorder(grayBorderThick);
				jbtnPay5.setBorder(grayBorderThick);

			}
		});
		jbtnPay2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnPay2.setBorder(redBorderThick);
				jbtnPay1.setBorder(redBorderThick);
				jbtnPay3.setBorder(grayBorderThick);
				jbtnPay4.setBorder(grayBorderThick);
				jbtnPay5.setBorder(grayBorderThick);

				jbtnPay1.setText("SSOG PAY");

			}
		});
		jbtnPay3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnPay3.setBorder(redBorderThick);
				jbtnPay1.setBorder(redBorderThick);
				jbtnPay2.setBorder(grayBorderThick);
				jbtnPay4.setBorder(grayBorderThick);
				jbtnPay5.setBorder(grayBorderThick);

				jbtnPay1.setText("신용카드");
			}
		});
		jbtnPay4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnPay4.setBorder(redBorderThick);
				jbtnPay1.setBorder(redBorderThick);
				jbtnPay2.setBorder(grayBorderThick);
				jbtnPay3.setBorder(grayBorderThick);
				jbtnPay5.setBorder(grayBorderThick);

				jbtnPay1.setText("실시간 계좌이체");
			}
		});
		jbtnPay5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnPay5.setBorder(redBorderThick);
				jbtnPay1.setBorder(redBorderThick);
				jbtnPay2.setBorder(grayBorderThick);
				jbtnPay3.setBorder(grayBorderThick);
				jbtnPay4.setBorder(grayBorderThick);

				jbtnPay1.setText("휴대폰 소액결제");
			}
		});

		// 34.결제 세부내역(SSOG PAY)jpPaySSog
		jpPaySSog1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPaySSog1.setPreferredSize(new Dimension(850, 3));

		jpPaySSog1_blank = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPaySSog1_blank.setPreferredSize(new Dimension(850, 10));
		jpPaySSog1_blank.setOpaque(false);

		jpPaySSog2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPaySSog2.setPreferredSize(new Dimension(200, 50));
		jpPaySSog2.setOpaque(false);
		JLabel jlbPaySSog1 = new JLabel("휴대폰");
		jlbPaySSog1.setFont(gothic2);
		jpPaySSog3 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 결제 - 휴대폰 기입
		jpPaySSog3.setPreferredSize(new Dimension(650, 80));
		jpPaySSog3.setOpaque(false);
		jcbPayCp = new JComboBox<String>(jcbPayCpStr); // 휴대폰 번호 콤보박스
		jcbPayCp.setFont(gothic1);
		jcbPayCp.setBackground(Color.white);
		JTextField jtfPaySSog1 = new JTextField(); // 010
		jtfPaySSog1.setPreferredSize(new Dimension(120, 30));
		jtfPaySSog1.setFont(gothic1);
		jtfPaySSog1.addKeyListener(new KeyAdapter() { // 숫자 세개로 제한
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 2)
					ke.consume();
			}
		});
		JLabel jlbPaySSog2 = new JLabel(" - ");
		JTextField jtfPaySSog2 = new JTextField(); // 1234
		jtfPaySSog2.setPreferredSize(new Dimension(120, 30));
		jtfPaySSog2.setFont(gothic1);
		jtfPaySSog2.addKeyListener(new KeyAdapter() { // 숫자 4개로 제한
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 3)
					ke.consume();
			}
		});
		JLabel jlbPaySSog3 = new JLabel(" - ");
		JTextField jtfPaySSog3 = new JTextField(); // 5678
		jtfPaySSog3.setPreferredSize(new Dimension(120, 30));
		jtfPaySSog3.setFont(gothic1);
		jtfPaySSog3.addKeyListener(new KeyAdapter() { // 숫자 4개로 제한
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 3)
					ke.consume();
			}
		});
		JLabel jlbPaySSog4 = new JLabel("입력하신 휴대폰 번호로 결제 요청이 전송됩니다.");
		jlbPaySSog4.setFont(gothic1);
		jlbPaySSog4.setForeground(Color.gray);
		jpPaySSog4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPaySSog4.setPreferredSize(new Dimension(850, 110));
		jpPaySSog4.setOpaque(false);
		JLabel jlbPaySSog5 = new JLabel("· 청구할인 적용 대상 시 결제금액이 청구할인 가능금액보다 적은 경우, 청구할인 혜택을 받으실 수 없습니다.");
		JLabel jlbPaySSog6 = new JLabel("· 청구할인 예상금액은 일 최대 청구할인 한도에 따라 달라질 수 있습니다.");
		JLabel jlbPaySSog7 = new JLabel("· SSOGPAY를 통한 결제시, 청구할인예상금액은 SSOGPAY앱에서 확인 가능합니다.");
		JLabel jlbPaySSog8 = new JLabel("· SSOGPAY카드 청구할인은 SSOGPAY로 결제하셔야 가능합니다.");
		jlbPaySSog5.setFont(gothic1);
		jlbPaySSog5.setForeground(Color.red);
		jlbPaySSog6.setFont(gothic1);
		jlbPaySSog6.setForeground(Color.red);
		jlbPaySSog7.setFont(gothic1);
		jlbPaySSog8.setFont(gothic1);

		jpPaySSog2.add(jlbPaySSog1);
		jpPaySSog3.add(jcbPayCp);
		jpPaySSog3.add(jtfPaySSog1);
		jpPaySSog3.add(jlbPaySSog2);
		jpPaySSog3.add(jtfPaySSog2);
		jpPaySSog3.add(jlbPaySSog3);
		jpPaySSog3.add(jtfPaySSog3);
		jpPaySSog3.add(jlbPaySSog4);
		jpPaySSog4.add(jlbPaySSog5);
		jpPaySSog4.add(jlbPaySSog6);
		jpPaySSog4.add(jlbPaySSog7);
		jpPaySSog4.add(jlbPaySSog8);

		jp3_sub34.add(jpPaySSog1);
		jp3_sub34.add(jpPaySSog1_blank);
		jp3_sub34.add(jpPaySSog2);
		jp3_sub34.add(jpPaySSog3);
		jp3_sub34.add(jpPaySSog4);
		// 35.결제 세부내역(신용카드)jpPayCard
		jpPayCard1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayCard1.setPreferredSize(new Dimension(850, 3));

		jpPayCardBlank = new JPanel();
		jpPayCardBlank.setPreferredSize(new Dimension(850, 20));
		jpPayCardBlank.setOpaque(false);

		jpPayCard2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayCard2.setPreferredSize(new Dimension(200, 50));
		jpPayCard2.setOpaque(false);
		JLabel jlbPayCard1 = new JLabel("카드종류");
		jlbPayCard1.setFont(gothic2);

		jpPayCard3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jpPayCard3.setPreferredSize(new Dimension(650, 40));
		jpPayCard3.setOpaque(false);
		jcbPayCard1 = new JComboBox<String>(jcbPayCard1Str);
		jcbPayCard1.addActionListener(this);
		jcbPayCard1.setFont(gothic1);
		jcbPayCard1.setBackground(Color.white);

		jpPayCard4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayCard4.setPreferredSize(new Dimension(200, 50));
		jpPayCard4.setOpaque(false);
		JLabel jlbPayCard2 = new JLabel("할부선택");
		jlbPayCard2.setFont(gothic2);

		jpPayCard5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jpPayCard5.setPreferredSize(new Dimension(650, 40));
		jpPayCard5.setOpaque(false);
		jcbPayCard2 = new JComboBox<String>(jcbPayCard2Str);
		jcbPayCard2.setFont(gothic1);
		jcbPayCard2.addActionListener(this);
		jcbPayCard2.setBackground(Color.white);
		jcbPayCard3 = new JComboBox<String>(jcbPayCard3Str);
		jcbPayCard3.addActionListener(this);
		jcbPayCard3.setFont(gothic1);
		jcbPayCard3.setBackground(Color.white);

		/*
		 * JLabel jljljl = new JLabel("선택하신 결제방법은"+ jcbPayCard1.getSelectedIndex()
		 * +"입니당");
		 */

		/* jpPayCardBlank.add(jljljl); */

		jpPayCard2.add(jlbPayCard1);
		jpPayCard3.add(jcbPayCard1);
		jpPayCard4.add(jlbPayCard2);
		jpPayCard5.add(jcbPayCard2);
		jpPayCard5.add(jcbPayCard3);

		jp3_sub35.add(jpPayCard1);
		jp3_sub35.add(jpPayCardBlank);
		jp3_sub35.add(jpPayCard2);
		jp3_sub35.add(jpPayCard3);
		jp3_sub35.add(jpPayCard4);
		jp3_sub35.add(jpPayCard5);

		// 36.결제 세부내역(계좌이체)
		jpPayBank1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayBank1.setPreferredSize(new Dimension(850, 3));

		jpPayBank2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayBank2.setPreferredSize(new Dimension(850, 120));
		jpPayBank2.setOpaque(false);
		JLabel jlbPayBank1 = new JLabel("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		JLabel jlbPayBank2 = new JLabel("· 결제와 동시에 즉시이체되며, 전체 주문 취소 시 당일입금되며, 부분취소 시 익일 입금됩니다.");
		JLabel jlbPayBank3 = new JLabel("· KB국민, IBK기업, SC제일, NH농협의 경우 해당 은행 규정상 150만원 이상 금액은 계좌이체가 불가합니다.");
		JLabel jlbPayBank4 = new JLabel("· 안전한 거래를 위해 5만원 이상 현금결제 시 구매안전서비스(보증보험)에 가입신청 하실 수 있습니다.");
		jlbPayBank2.setFont(gothic1);
		jlbPayBank3.setFont(gothic1);
		jlbPayBank4.setFont(gothic1);
		jpPayBank2.add(jlbPayBank1);
		jpPayBank2.add(jlbPayBank2);
		jpPayBank2.add(jlbPayBank3);
		jpPayBank2.add(jlbPayBank4);

		jpPayBank3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayBank3.setPreferredSize(new Dimension(850, 3));

		jpPayBank4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayBank4.setPreferredSize(new Dimension(850, 130));
		jpPayBank4.setOpaque(false);
		JLabel jlbPayBank5 = new JLabel("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		JLabel jlbPayBank6 = new JLabel("· 해외법인업체 상품은 소득세법에 따라 소득공제가 불가하여 현금영수증 발급이 불가합니다.");
		JLabel jlbPayBank7 = new JLabel("· 국내와 해외법인업체 상품 동시구매 시 현금영수증 발급은 가능하나, 해외법인업체 상품 결제금액은 제외됩니다.");
		JLabel jlbPayBank8 = new JLabel("· 해외법인업체 : YOOX ASIA LIMITED, JRK TRADE, SHOE EXPRESS");
		jlbPayBank6.setFont(gothic1);
		jlbPayBank7.setFont(gothic1);
		jlbPayBank8.setFont(gothic1);
		jpPayBank4.add(jlbPayBank5);
		jpPayBank4.add(jlbPayBank6);
		jpPayBank4.add(jlbPayBank7);
		jpPayBank4.add(jlbPayBank8);

		jp3_sub36.add(jpPayBank1);
		jp3_sub36.add(jpPayBank2);
		jp3_sub36.add(jpPayBank3);
		jp3_sub36.add(jpPayBank4);

		// 37. 결제 세부내역(휴대폰)
		jpPayCp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayCp1.setPreferredSize(new Dimension(850, 3));

		jpPayCp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayCp2.setPreferredSize(new Dimension(850, 40));
		jpPayCp2.setOpaque(false);
		JLabel jlbPayCp1 = new JLabel("결제하실 휴대폰 번호를 확인하시기 바랍니다. 휴대폰 가입자와 신용카드 가입자(계좌일 경우 예금주)는 동일인이어야 합니다.");
		jlbPayCp1.setFont(gothic2);
		jpPayCp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayCp3.setPreferredSize(new Dimension(200, 50));
		jpPayCp3.setOpaque(false);
		JLabel jlbPayCp2 = new JLabel("휴대폰");
		jlbPayCp2.setFont(gothic2);
		jpPayCp4 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 결제 - 휴대폰 기입
		jpPayCp4.setPreferredSize(new Dimension(650, 60));
		jpPayCp4.setOpaque(false);
		jcbPayCp = new JComboBox<String>(jcbPayCpStr); // 휴대폰 번호 콤보박스
		jcbPayCp.setFont(gothic1);
		jcbPayCp.setBackground(Color.white);
		JTextField jtfPayCp1 = new JTextField(); // 010
		jtfPayCp1.setPreferredSize(new Dimension(120, 30));
		jtfPayCp1.setFont(gothic1);
		jtfPayCp1.addKeyListener(new KeyAdapter() { // 숫자 세개로 제한
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 2)
					ke.consume();
			}
		});
		JLabel jlbPayCp3 = new JLabel(" - ");
		JTextField jtfPayCp2 = new JTextField(); // 1234
		jtfPayCp2.setPreferredSize(new Dimension(120, 30));
		jtfPayCp2.setFont(gothic1);
		jtfPayCp2.addKeyListener(new KeyAdapter() { // 숫자 4개로 제한
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 3)
					ke.consume();
			}
		});
		JLabel jlbPayCp4 = new JLabel(" - ");
		JTextField jtfPayCp3 = new JTextField(); // 5678
		jtfPayCp3.setPreferredSize(new Dimension(120, 30));
		jtfPayCp3.setFont(gothic1);
		jtfPayCp3.addKeyListener(new KeyAdapter() { // 숫자 4개로 제한
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() > 3)
					ke.consume();
			}
		});

		jpPayCp5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayCp5.setPreferredSize(new Dimension(850, 3));

		jpPayCp6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jpPayCp6.setPreferredSize(new Dimension(850, 110));
		jpPayCp6.setOpaque(false);
		JLabel jlbPayCp5 = new JLabel("· [결제하기] 버튼을 클릭하시면, 휴대폰 결제 화면으로 연결되어 결제정보를 입력하실 수 있습니다.");
		JLabel jlbPayCp6 = new JLabel("· 월 누적 결제금액이 SKT/KT/LG U+ 최대 50만원까지 결제가 가능합니다.");
		JLabel jlbPayCp7 = new JLabel("   (단, 회원 별 결제한도는 각 통신사별 이용제한에 따라 적용됩니다.)");
		JLabel jlbPayCp8 = new JLabel("· 한도문의는 모빌리언스(1600-0523), 다날(1566-3355)로 해 주시기 바랍니다.");
		jlbPayCp5.setFont(gothic1);
		jlbPayCp6.setFont(gothic1);
		jlbPayCp7.setFont(gothic1);
		jlbPayCp8.setFont(gothic1);

		jpPayCp2.add(jlbPayCp1);
		jpPayCp3.add(jlbPayCp2);

		jpPayCp4.add(jcbPayCp);
		jpPayCp4.add(jtfPayCp1);
		jpPayCp4.add(jlbPayCp3);
		jpPayCp4.add(jtfPayCp2);
		jpPayCp4.add(jlbPayCp4);
		jpPayCp4.add(jtfPayCp3);

		jpPayCp6.add(jlbPayCp5);
		jpPayCp6.add(jlbPayCp6);
		jpPayCp6.add(jlbPayCp7);
		jpPayCp6.add(jlbPayCp8);

		jp3_sub37.add(jpPayCp1);
		jp3_sub37.add(jpPayCp2);
		jp3_sub37.add(jpPayCp3);
		jp3_sub37.add(jpPayCp4);
		jp3_sub37.add(jpPayCp5);
		jp3_sub37.add(jpPayCp6);

		//

		jp3_sub31.add(jbtnPay1);
		jp3_sub32.add(jbtnPay2);
		jp3_sub32.add(jbtnPay3);
		jp3_sub32.add(jbtnPay4);
		jp3_sub32.add(jbtnPay5);

		jp3_[0].add(jp3_sub1);
		jp3_[0].add(jp3_sub2);
		jp3_[0].add(jp3_sub3);
		jp3_[0].add(jp3_sub4);
		jp3_[0].add(jp3_sub5);
		jp3_[0].add(jp3_sub6);
		jp3_[0].add(jp3_sub7);
		jp3_[0].add(jp3_sub8);
		jp3_[0].add(jp3_sub9);
		jp3_[0].add(jp3_sub10);
		jp3_[0].add(jp3_sub11);

		jp3_[1].add(jp3_sub20);

		jp3_[2].add(jp3_sub30);
		jp3_[2].add(jp3_sub31);
		jp3_[2].add(jp3_sub32);
		jp3_[2].add(jp3_sub38);

		jp3_[3].add("p1", jp3_sub33); // 카드 임시
		jp3_[3].add("p2", jp3_sub34); // 카드 임시
		jp3_[3].add("p3", jp3_sub35); // 카드 임시
		jp3_[3].add("p4", jp3_sub36); // 카드 임시
		jp3_[3].add("p5", jp3_sub37); // 카드 임시

		/*
		 * jp3_sub37.add("p1",jp3_sub33); //카드 임시 jp3_sub37.add("p2",jp3_sub34); //카드 임시
		 * jp3_sub37.add("p3",jp3_sub35); //카드 임시 jp3_sub37.add("p4",jp3_sub36); //카드 임시
		 */

		/***************************************************************/
		// {"받는 분 정보","배송지 정보","배송메시지","이메일","품절시 환불방법"}
		for (int i = 0; i < jlb3_1Fixed.length; i++) {
			/*
			 * if(i==0) { jlb3_1Fixed[i] = new JLabel(jlb3_1FixedStr[i],
			 * SwingConstants.LEFT);
			 * jlb3_1Fixed[i].setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 60)); }
			 */
			jlb3_1Fixed[i] = new JLabel(jlb3_1FixedStr[i]);
			// jlb3_1Fixed[i].setHorizontalAlignment(SwingConstants.LEFT);
			if (i == 0) {
				jlb3_1Fixed[i].setFont(gothic3);
				jlb3_1Fixed[i].setForeground(Color.white);//
			} else if (i == 1 || i == 3 || i == 5 || i == 7) {
				jlb3_1Fixed[i].setFont(gothic2);
			} else if (i == 2 || i == 6) {
				jlb3_1Fixed[i].setFont(gothic1);
			} else if (i == 4 || i == 8) {
				jlb3_1Fixed[i].setFont(gothic2);
				jlb3_1Fixed[i].setForeground(Color.GRAY);
			}
		}

		jp3_sub1.add(jlb3_1Fixed[0]);
		jp3_sub2.add(jlb3_1Fixed[1]);
		jp3_sub3.add(jlb3_1Fixed[2]);
		jp3_sub4.add(jlb3_1Fixed[3]);
		jp3_sub6.add(jlb3_1Fixed[4]);
		jp3_sub7.add(jlb3_1Fixed[5]);
		jp3_sub8.add(jlb3_1Fixed[6]);
		jp3_sub9.add(jlb3_1Fixed[7]);
		jp3_sub11.add(jlb3_1Fixed[8]);

		/***************************************************************/
		for (int i = 0; i < jlb3_2Fixed.length; i++) {
			jlb3_2Fixed[i] = new JLabel(jlb3_2FixedStr[i]);
			jlb3_2Fixed[i].setFont(gothic3);
			jlb3_2Fixed[i].setForeground(Color.white);
		}

		jp3_sub20.add(jlb3_2Fixed[0]);

		/***************************************************************/
		for (int i = 0; i < jlb3_3Fixed.length; i++) {
			jlb3_3Fixed[i] = new JLabel(jlb3_3FixedStr[i]);
			jlb3_3Fixed[i].setFont(gothic3);
			jlb3_3Fixed[i].setForeground(Color.BLACK);
		}

		jp3_sub30.add(jlb3_3Fixed[0]);

		////////////////////////////////////////////////////////////////////////////////////////////////// 오른쪽
		////////////////////////////////////////////////////////////////////////////////////////////////// 결제창
		jp4 = new JPanel();
		jp4.setLayout(null);
		jp4.setBackground(Color.white);
		jp4.setBounds((((d.width - d.width / 4) / 3) * 2) + 60, 170, ((d.width - d.width / 4) / 3) - 100, 650);
		LineBorder grayBorder = new LineBorder(new Color(215, 215, 215)); // TitledBorder
		jp4.setBorder(grayBorder);

		jp4.add(jpLine[5]);
		jpLine[5].setForeground(new Color(230, 230, 230));
		jpLine[5].setBounds(20, 390, 330, 10);

		jp4.add(chk1 = new JCheckBox());
		chk1.setBounds(20, 480, 25, 25);
		chk1.addActionListener(this);
		chk1.setOpaque(false);
		JLabel jlbplz = new JLabel("<html>" + "주문 상품정보 및 결제대행 서비스 이용약관에 <br> 모두 동의하십니까?" + "</html>");
		jlbplz.setFont(gothic1);
		jlbplz.setForeground(new Color(105, 105, 105));
		jlbplz.setBounds(50, 465, ((d.width - d.width / 4) / 3) - 140, 70);
		jp4.add(jlbplz);

		jp4_1 = new JPanel();
		jp4_1.setLayout(null);
		jp4_1.setBackground(new Color(215, 215, 215));
		jp4_1.setBounds(0, 0, ((d.width - d.width / 4) / 3) - 100, 150);

		for (int i = 0; i < jlbMain.length; i++) {
			jlbMain[i] = new JLabel(jlbMainStr[i]);
			if (i == 0) {
				jlbMain[i].setFont(gothic4);
				jp1.add(jlbMain[i]);
			} else {
				jp3.add(jlbMain[i]);
			}
		}

		jlbMain[0].setBounds(40, 60, 400, 50); // 결제하기

		for (int i = 0; i < jbtn4.length; i++) {
			jbtn4[i] = new JButton(jbtnStr4[i]);
			jbtn4[i].addActionListener(this);
			jbtn4[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jp4.add(jbtn4[i]);

			if (i == 1 || i == 2) {
				jbtn4[i].setFont(gothic1);
				jbtn4[i].setBackground(new Color(240, 240, 240));
				jbtn4[i].setBorder(grayBorder);
			} else if (i == 3) {
				jbtn4[i].setFont(gothic3);
				jbtn4[i].setForeground(Color.white);
				jbtn4[i].setBackground(new Color(168, 39, 53));// 결제하기 red color
			} else {
				jbtn4[i].setFont(gothic2);
				jbtn4[i].setForeground(new Color(105, 105, 105));
				jbtn4[i].setBorderPainted(false);
				jbtn4[i].setContentAreaFilled(false);
				// jbtn4[i].setFocusPainted(false);
			}

		}
		// {"변경>","전환/조회","사용","10,000원 결제하기"};
		jbtn4[0].setBounds(panelsize / 2 - 200, 20, 80, 20);
		jbtn4[1].setBounds(panelsize / 2 - 240, 280, 100, 40);
		jbtn4[2].setBounds(panelsize / 2 - 240, 330, 100, 40);
		jbtn4[3].setBounds(20, 560, panelsize / 2 - 140, 70);
		jbtn4[3].addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtn4[3].setBackground(Color.black);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtn4[3].setBackground(new Color(168, 39, 53));
			}

		});

		// jp4에 붙는 고정값들의 라벨들.
		// private String[] jlb4FixedStr = {"배송지","주문금액","할인금액","포인트
		// 사용","SSOG포인트","SSOG쿠폰","결제예정금액"};
		for (int i = 0; i < jlb4Fixed.length; i++) {
			jlb4Fixed[i] = new JLabel(jlb4FixedStr[i]);
			jp4.add(jlb4Fixed[i]);
			jlb4Fixed[i].setFont(gothic2);
			if (i == 6) {
				jlb4Fixed[i].setForeground(new Color(252, 61, 114));
			} else {
				jlb4Fixed[i].setForeground(Color.black);

			}
		}

		jlb4Fixed[0].setBounds(30, 20, 60, 20); // 배송지//
		jlb4Fixed[1].setBounds(30, 170, 60, 20); // 주문금액
		jlb4Fixed[2].setBounds(30, 200, 400, 20); // 할인금액
		jlb4Fixed[3].setBounds(30, 230, 100, 20); // 포인트 사용//
		jlb4Fixed[4].setBounds(30, 287, 100, 20); // SSOG포인트
		jlb4Fixed[5].setBounds(30, 337, 100, 20); // SSOG쿠폰//
		jlb4Fixed[6].setBounds(30, 420, 100, 20); // 결제예정금액

		// jp4에 붙는 고정값이 아닌 라벨들.(db연결용)
		// private String[] jlb4NonFixedStr = {"[16933]경기 용인시 수지구 123동
		// 456호","원","원","원","원"};
		for (int i = 0; i < jlb4NonFixed.length; i++) {
			jlb4NonFixed[i] = new JLabel(jlb4NonFixedStr[i]);
			jp4.add(jlb4NonFixed[i]);

			if (i == 0) {
				jlb4NonFixed[i].setFont(gothic1);
				jlb4NonFixed[i].setForeground(Color.black);

			} else if (i == 4) {
				jlb4NonFixed[i].setForeground(new Color(252, 61, 114));
				jlb4NonFixed[i].setFont(gothic3);
				jlb4NonFixed[i].setHorizontalAlignment(SwingConstants.RIGHT);
			} else {
				jlb4NonFixed[i].setForeground(Color.black);
				jlb4NonFixed[i].setFont(gothic2);
				jlb4NonFixed[i].setHorizontalAlignment(SwingConstants.RIGHT);
			}

		}

		jlb4NonFixed[0].setBounds(30, 65, ((d.width - d.width / 4) / 3) - 130, 20); // 주소//
		jlb4NonFixed[1].setBounds(250, 170, 100, 20); // 주문금액 가격
		jlb4NonFixed[2].setBounds(250, 200, 100, 20); // 할인금액 가격
		jlb4NonFixed[3].setBounds(250, 230, 100, 20); // 포인트 사용 가격//
		jlb4NonFixed[4].setBounds(250, 415, 100, 30); // 포인트 사용 가격//red

		//////////////////////////////////////////////////////////////////////////////////////////////////
		jp1.add(jbtnShop = new JButton(new ImageIcon("d:\\crudimg7\\infobutton1.png")));
		jbtnShop.setBorderPainted(false);
		jbtnShop.setContentAreaFilled(false);
		jbtnShop.setFocusPainted(false);
		jbtnShop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnShop.addActionListener(this);
		jbtnShop.setBounds(d.width - 700, 80, 180, 40);
		jbtnShop.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnShop.setIcon(new ImageIcon("d:\\crudimg7\\infobutton1.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnShop.setIcon(new ImageIcon("d:\\crudimg7\\infobutton2.png"));

			}

		});
		////////////////////////////////////////////////////////////////////////////////////////////////// AddList
		jp2.add(jsp);
		jp4.add(jp4_1);

		jp1.add(jp2);
		jp1.add(jp4);
		jp1.add(jbtnShop);

		this.add(jp1);
	}

	public PayLayout() {
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
				PayLayout.this.dispose();
			}
		});

		this.setUndecorated(true);
		this.setBounds((d.width / 4)-78, 0, (d.width - (d.width / 4))+78, d.height);// (d.height / 3 * 2) + d.height / 3 * 2
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {

		new PayLayout();

	}
}
