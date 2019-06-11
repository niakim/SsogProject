package project.semi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import project.semi.nk.PayLayout;

public class LayOut extends JFrame implements ActionListener {
	SetStyle s = new SetStyle();

	ProductModel pm;
	CartBean cBean;
	CheckList checkList;
	int mainW = 400;

//	private String imgPATH = "C:\\Users\\sist\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\"; // 이미지
	private String imgPATH = "C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\"; // 이미지

	private JTabbedPane jtbp;
	private JPanel[] jp = new JPanel[2];
	private String[] tabStr = { "냉동", "정육", "수산", "과일", "과자", "가구", "욕실", "주방" };
	private JPanel[] tabJp = new JPanel[tabStr.length];
	private JScrollPane[] tapJscrl = new JScrollPane[tabStr.length];
	private JScrollPane[] tapJscrlSub = new JScrollPane[tabStr.length];
	private String[] jbtnStr = { "MY SSOG", "배송 중", "할인 쿠폰", null, null, null };
	private JButton[] jbtn = new JButton[jbtnStr.length];

	private String mainStr[] = { null, "환영합니다!" };
	private JLabel mainlb[] = new JLabel[mainStr.length];
	private JPanel westSouth, wsPanel1, wsPanel2, wsPanel3;

	private JPanel[] center = new JPanel[tabStr.length];
	private ProductLayout[][] productLayout = new ProductLayout[tabStr.length][12];
	private ImageIcon backImg;

	private ImageIcon[] tabImg = new ImageIcon[tabStr.length];
	private ImageIcon[] tabImg2 = new ImageIcon[tabStr.length];
	private String tabImgStr = "C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\tab\\";
	private String[] tabImgStrSub = { "ND", "JY", "SS", "FR", "SN", "FU", "BA", "KI" };

	private ImageIcon iconHeart = new ImageIcon(
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\clip1.png");
	private ImageIcon iconHeart2 = new ImageIcon(
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\clip2.png");
	private int intHeart = -1;

	private String[] logInfo = new String[3];

	private CardLayout card = new CardLayout();

	// 민아 장바구니
	private JPanel southCenterJp;
	private JPanel cart[] = new JPanel[2];

	private JLabel mLabel;
	private JScrollPane cartJscrl; // 장바구니 리스트 스크롤바
//	private ImageIcon btimg;

	private ImageIcon nocartImg;
	private JLabel nocartLabel;

	ArrayList<CartBean> cartL = new ArrayList<CartBean>();

	int not;

//	private UIManager ui = new UIManager();
	int click = 1;
	// --장바구니 거쳐가는 곳
	private JPanel cartList;
	private JButton cartButton[];
	private JLabel cartLabel[];
	private JLabel powonLabel[];

	private ImageIcon img;
	private Image img2;

	// --장바구니 저장되는 곳
	ArrayList<JPanel> cartSaveList = new ArrayList<JPanel>();
	ArrayList<JLabel[]> labelSaveList = new ArrayList<JLabel[]>();
	ArrayList<JButton[]> buttonSaveList = new ArrayList<JButton[]>();
	ArrayList<JCheckBox[]> checkSaveList = new ArrayList<JCheckBox[]>();

	// 민아 결제버튼
	private JPanel buyPanel[] = new JPanel[4];
	private String buyLstr[] = { "총 상품 금액", null, "배송비", null, "적립 포인트", null, "합계 금액", null };
	private JLabel buyLabel[] = new JLabel[buyLstr.length];
	private String buyBstr = "전체 상품 주문";
	private JButton buyButton;
	
	private JPanel[] tabJpCenter = new JPanel[tabStr.length];// ★

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == jbtn[0]) { // 내 정보 보기
			new MyInfo(logInfo[0],logInfo[1],logInfo[2]);
		}
		if (source == jbtn[1]) { // 배송 중 버튼 // 수정하기
		}
		if (source == jbtn[2]) { // 할인쿠폰 버튼 // 수정하기
		}
		for (int k = 0; k < tabStr.length; k++) {
			for (int i = 0; i < productLayout[k].length; i++) {
				if (source == productLayout[k][i].getJbtnPro()) {// 상세페이지 이동
					card.show(tabJp[k], Integer.toString(k) + Integer.toString(i));// ★
				} else if (source == productLayout[k][i].getTmpJbtn()[0]) { // 수량조절 -
					if (productLayout[k][i].getCount() > 1) {
						productLayout[k][i].setCount(productLayout[k][i].getCount() - 1);
						productLayout[k][i].getTmpT().setText(Integer.toString(productLayout[k][i].getCount()));
					}
				} else if (source == productLayout[k][i].getTmpJbtn()[1]) { // 수량조절 +
					productLayout[k][i].setCount(productLayout[k][i].getCount() + 1);
					productLayout[k][i].getTmpT().setText(Integer.toString(productLayout[k][i].getCount()));
				} else if (source == productLayout[k][i].getJbtnCart()) { // 카트버튼 //k탭 i탭 안의 순서
					System.out.println("[카트 버튼 액션 리스너]");

					cart[1].remove(nocartLabel);

					// 카트 눌렀을 때 해당 상품의 정보 저장
					String name = null;
					int count = 0;
					int danga = 0;
					String iimg = null;
					int sum = 0;

					name = productLayout[k][i].getcName();
					count = productLayout[k][i].getCount();
					danga = Integer.parseInt(productLayout[k][i].getcPrice());
					iimg = productLayout[k][i].getcImg();
					sum = count * danga;

					int check = 0;

					int j = click - 1;

					listCart(iimg, name, count, danga, sum); // 비교

					// BUY 구역
					lastBuy(iimg, name, count, danga, sum);
				}
//				else if (source == productLayout[k][i].getPutInCart()) { // 장바구니에 담기
//					System.out.println("장바구니에 담기");
//					// 수정하기
//				}
				else if (source == productLayout[k][i].getSpecificJbtn()[0]) { // 수량조절 -
					if (productLayout[k][i].getCountSpecific() > 1) {
						productLayout[k][i].setCountSpecific(productLayout[k][i].getCountSpecific() - 1);
						productLayout[k][i].getSpecificTf()
								.setText(Integer.toString(productLayout[k][i].getCountSpecific()));
					}
				} else if (source == productLayout[k][i].getSpecificJbtn()[1]) { // 수량조절 +
					productLayout[k][i].setCountSpecific(productLayout[k][i].getCountSpecific() + 1);
					productLayout[k][i].getSpecificTf()
							.setText(Integer.toString(productLayout[k][i].getCountSpecific()));
				} else if (source == productLayout[k][i].getKeepShopping()) { // 계속 쇼핑하기
					card.show(tabJp[k], Integer.toString(k));// ★
				} else if (source == productLayout[k][i].getJbtnHeart()) {
					intHeart *= -1;
					if (intHeart == 1) {
						productLayout[k][i].getJbtnHeart().setIcon(iconHeart2);
					} else {
						productLayout[k][i].getJbtnHeart().setIcon(iconHeart);
					}
				}
			}
		}
	}

	public void iniLayout() {
		backImg = new ImageIcon(imgPATH + "SSOGMAIN3.gif");

		jp[0] = new JPanel(new BorderLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				if (backImg != null) {
					g.drawImage(backImg.getImage(), 0, -80, this);
				}

			}
		}; // Westf
		jp[0].setPreferredSize(new Dimension(mainW, 0));

		westSouth = new JPanel(new BorderLayout());
		westSouth.setPreferredSize(new Dimension(mainW, 680));// 메인의 로고 아랫부분 높이
		westSouth.setOpaque(false);

		wsPanel1 = new JPanel(new GridLayout(2, 1));
		wsPanel1.setBorder(BorderFactory.createEmptyBorder(10, 0, 75, 0));

		for (int i = 0; i < mainlb.length; i++) {
			mainStr[0] = "<html><strong>" + logInfo[2] + "</strong>님</html>";
			mainlb[i] = new JLabel(mainStr[i]);
			s.setStyle(mainlb[i], false, Color.white, "나눔스퀘어", Font.PLAIN, 20);
			mainlb[i].setHorizontalAlignment(SwingConstants.CENTER);
			wsPanel1.setOpaque(false);
			wsPanel1.add(mainlb[i]);
		}

		westSouth.add(wsPanel1, "North");

		wsPanel2 = new JPanel(new GridLayout(2, 3));
		wsPanel2.setOpaque(false);

		for (int i = 0; i < jbtn.length; i++) { // 모든 버튼 생성하고 액션리스너 달기
			jbtn[i] = new JButton(jbtnStr[i]);
			jbtn[i].setContentAreaFilled(false);
			jbtn[i].setBorderPainted(false);
			jbtn[i].addActionListener(this);
			jbtn[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			if (i <= 2) {
				s.setStyle(jbtn[i], s.ssogYellow, "나눔스퀘어", Font.PLAIN, 13);
				jbtn[i].setOpaque(false);
				wsPanel2.add(jbtn[i]);
			} else {
				s.setStyle(jbtn[i], Color.white, "나눔스퀘어", Font.PLAIN, 15);
				jbtn[i].setOpaque(false);
				jbtn[i].setText("<html><a style='font-size:20px' ><b>0</b> </a> 건</html>");
				wsPanel2.add(jbtn[i]);
			}
		}
		westSouth.add(wsPanel2, "Center");

		wsPanel3 = new JPanel();
		wsPanel3.setOpaque(false);
		wsPanel3.setPreferredSize(new Dimension(mainW, 420));

		westSouth.add(wsPanel3, "South");
		westSouth.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

		jp[0].add("South", westSouth);

		JPanel root = new JPanel(new BorderLayout());
		jtbp = new JTabbedPane();
		jtbp.setUI(new TabbedPaneUI());
		jtbp.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < tabStr.length; i++) {
					jtbp.setIconAt(i, tabImg[i]);
					if (jtbp.getSelectedIndex() == i) {
						jtbp.setIconAt(i, tabImg2[i]);
					} else {
						card.show(tabJp[i], Integer.toString(i));
					}
				}
			}

		});

		for (int i = 0; i < tabJp.length; i++) {// 수정하기 민아 코드랑 제일 많이 다른 부분임
			center[i] = new JPanel(new BorderLayout());
			tabJp[i] = new JPanel(card);// ★
			tabJp[i].setBackground(Color.WHITE);
			center[i].add("Center", tabJp[i]);// ★

			tabJpCenter[i] = new JPanel(new GridLayout(3, 4));// ★
			tabJpCenter[i].setBackground(Color.WHITE);
			tabJp[i].add(tapJscrl[i] = new JScrollPane(tabJpCenter[i]), Integer.toString(i));
			tapJscrl[i].setBorder(null);
			tapJscrl[i].getVerticalScrollBar().setUI(new ScrollUI());
			tapJscrl[i].getHorizontalScrollBar().setUI(new ScrollUI());
			tapJscrl[i].getVerticalScrollBar().setUnitIncrement(16); // 속도제어

			tabImg[i] = new ImageIcon(tabImgStr.concat(tabImgStrSub[i]).concat("1.jpg"));
			tabImg2[i] = new ImageIcon(tabImgStr.concat(tabImgStrSub[i]).concat("2.jpg"));

			jtbp.addTab("<html><table width='0' cellpadding = '0' cellspacing = '0'></table></html>", tabImg[i],
					center[i]);
			jtbp.getComponent(i).setName(Integer.toString(i));
		}

		for (int k = 0; k < tabStr.length; k++) { // 제품 12개 한번에 보이는 페이지
			for (int i = 0; i < productLayout[k].length; i++) {// 수정하기 여기도 다름
				System.out.println(k + " " + i);
				productLayout[k][i] = new ProductLayout(k, logInfo[0]);
				tabJpCenter[k].setBorder(new EmptyBorder(50, 50, 50, 50)); // ★ 내부 공백

				tabJpCenter[k].add(productLayout[k][i].productLayout(i));// ★
			}
		}

		for (int k = 0; k < tabStr.length; k++) { // 상세페이지
			for (int i = 0; i < productLayout[k].length; i++) {// 수정하기 여기도 다름
				System.out.println(k + " " + i);
				tabJp[k].add(tapJscrlSub[k] = new JScrollPane(productLayout[k][i].specificLayout(i)),
						Integer.toString(k) + Integer.toString(i));
				tapJscrlSub[k].getVerticalScrollBar().setUI(new ScrollUI());
				tapJscrlSub[k].setBorder(null);
				tapJscrlSub[k].getHorizontalScrollBar().setUI(new ScrollUI());
				tapJscrlSub[k].getVerticalScrollBar().setUnitIncrement(16);
			}
		}

		for (int k = 0; k < tabStr.length; k++) { // 액션리스너 달기
			for (int i = 0; i < productLayout[k].length; i++) {
				productLayout[k][i].getJbtnPro().addActionListener(this);
				productLayout[k][i].getTmpJbtn()[0].addActionListener(this);
				productLayout[k][i].getTmpJbtn()[1].addActionListener(this);
				productLayout[k][i].getJcb().addActionListener(this);
				productLayout[k][i].getJbtnCart().addActionListener(this);
				productLayout[k][i].getPutInCart().addActionListener(this);
				productLayout[k][i].getSpecificJbtn()[0].addActionListener(this);
				productLayout[k][i].getSpecificJbtn()[1].addActionListener(this);
				productLayout[k][i].getKeepShopping().addActionListener(this);
				productLayout[k][i].getJbtnHeart().addActionListener(this);
			}
		}
		root.add("Center", jtbp);

		jp[1] = new JPanel(new BorderLayout());// root - South
		southCenterJp = new JPanel(new BorderLayout()); // 장바구니 패널

		JPanel southEastJp = new JPanel(new BorderLayout()); // 구매정보 + 구매버튼 패널
		southEastJp.setBackground(Color.white);

		// --- buy

		// buyPanel[0]: 겉패널 안에 테두리 주고 들어갈 패널, 전체
		// buyPanel[1]: 왼쪽정렬(라벨), 오른쪽 정렬(유동라벨) / grid(5,2)
		// butPanel[2]: 버튼 2개 / grid(2,1)

		for (int j = buyPanel.length - 1; j >= 0; j--) {
			buyPanel[j] = new JPanel();

			if (j == 2) {// 구매버튼 2개
				buyPanel[j].setLayout(new GridLayout(1, 1, 10, 10));
				buyButton = new JButton(buyBstr);
				buyButton.setFont(new Font("나눔스퀘어", Font.BOLD, 20));
				buyButton.setPreferredSize(new Dimension(0, 70));

				buyButton.setBackground(s.ssogRed);
				buyButton.setBorderPainted(false);
				buyButton.setForeground(Color.white);
				buyButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
//								System.out.println("최종 결제갈 목록"); 
						Object source = e.getSource();
						if(source==buyButton) {
							new PayLayout();
						}
						

					}
				});
				buyPanel[j].setBackground(Color.white);
				buyPanel[j].add(buyButton);
			} else if (j == 1) { // 총 상품 금액..
				buyPanel[j].setLayout(new GridLayout(5, 2));
				for (int i = 0; i < buyLabel.length; i++) {
					buyLabel[i] = new JLabel(buyLstr[i]);
					if (i >= buyLabel.length - 2 && i <= buyLabel.length - 1) {
						buyLabel[i].setFont(new Font("나눔스퀘어", Font.BOLD, 20));
						buyLabel[i].setForeground(s.ssogRed);
					} else {
						buyLabel[i].setFont(new Font("나눔스퀘어", Font.BOLD, 15));
						buyLabel[i].setForeground(Color.darkGray);
					}

					if (i == 1) {
						buyLabel[i].setText("0 원");
						buyLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);
					}
					if (i == 3) {
						buyLabel[i].setText("0 원");
						buyLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);

					}
					if (i == 5) {
						buyLabel[i].setText("0 P");
						buyLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);

					}
					if (i == 7) {
						buyLabel[i].setText("0 원");
						buyLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);
					}

					buyPanel[j].setBackground(Color.white);
					buyPanel[j].add(buyLabel[i]);
				}
			} else if (j == 0) { // 구매버튼창 속 전체 패널
				buyPanel[j].setLayout(new BorderLayout());
				buyPanel[j].add(buyPanel[j + 1]);
				buyPanel[j].add(buyPanel[j + 2], "South");
				southEastJp.setPreferredSize(new Dimension(400, 350));
				southEastJp.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
				southEastJp.add(buyPanel[j], "Center");
			}
		}
		// --- buy
		cart[0] = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cart[0].setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));

		cart[0].add(mLabel = new JLabel("장바구니"));
		mLabel.setFont(new Font("나눔스퀘어", Font.BOLD, 20));
		mLabel.setPreferredSize(new Dimension(80, 70));
		cart[0].setPreferredSize(new Dimension(100, 70));
		cart[0].setBackground(Color.white);

		southCenterJp.add(cart[0], "North");

		cartJscrl = new JScrollPane(cart[1] = new JPanel(new GridLayout(1, 1)),
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		cartJscrl.setBorder(null);
		cartJscrl.getVerticalScrollBar().setUI(new ScrollUI());
		cartJscrl.getHorizontalScrollBar().setUI(new ScrollUI());
		cartJscrl.getVerticalScrollBar().setUnitIncrement(16); // 속도제어

		nocartImg = new ImageIcon(imgPATH + "nocart.jpg");
		nocartLabel = new JLabel(nocartImg);
		cart[1].add(nocartLabel);
		cart[1].setBackground(Color.white);

		southCenterJp.add(cartJscrl, "Center");

		jp[1].add("Center", southCenterJp);
		jp[1].doLayout();
		jp[1].add("East", southEastJp);
		root.add("South", jp[1]);

		this.add("West", jp[0]);
		this.add("Center", root);
	}

	public void addCart(String cimg, String cname, int ccount, int cdanga, int csum, int order) {
		System.out.println("addCart");

		CartBean bean = new CartBean(cname, ccount, csum);
		bean.setCimg(cimg);
		bean.setCname(cname);
		bean.setCcount(ccount);
		bean.setCdanga(cdanga);
		bean.setCsum(csum);
		System.out.println(bean.toString());
		CartDao.getInstance().addCart(bean);

		selectCart(cname);
	}

	// 집
	public void modifyCart(String cimg, String cname, int ccount, int cdanga, int csum) {
		System.out.println("modifyCart");

		CartBean bean = new CartBean(cimg, cname, ccount, cdanga);
		bean.setCimg(bean.getCimg());
		bean.setCname(bean.getCname());
		bean.setCcount(ccount);
		bean.setCdanga(cdanga);
		bean.setCsum(csum);
		CartDao.modifyCart(bean);

		for (int i = 0; i < labelSaveList.size(); i++) {
			if (buttonSaveList.get(i)[1].getText().equals(String.valueOf(bean.getCname()))) {
				labelSaveList.get(i)[0].setText(String.valueOf(bean.getCcount()));
				labelSaveList.get(i)[1].setText(String.valueOf((bean.getCdanga() * bean.getCcount()) / 100));
				labelSaveList.get(i)[2].setText(String.valueOf((bean.getCdanga() * bean.getCcount())));
				break;
			} else {
			}
		}
	}

	public void selectCart(String cname) {
		System.out.println("selectCart");

		CartBean bean = CartDao.getInstance().selectCart(cname);

		// ---패널에 추가
		int listH = 130;
		int listW = d.width - mainW - 400;
		cartLabel = new JLabel[3];
		cartButton = new JButton[3];

		cartJscrl.setPreferredSize(new Dimension(0, 210));

		cartList = new JPanel(new FlowLayout(FlowLayout.LEFT));

		for (int i = 0; i < cartLabel.length; i++) {
			cartLabel[i] = new JLabel();
			cartButton[i] = new JButton();
			if (i == 0) {
				// 이미지
				img = new ImageIcon(bean.getCimg());
				img2 = img.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
				img = new ImageIcon(img2);
				cartButton[i].setIcon(img);
				cartButton[i].setPreferredSize(new Dimension(150, listH));
				// 수량
				cartLabel[i].setText(String.valueOf(bean.getCcount()));
				cartLabel[i].setPreferredSize(new Dimension(listW / 9, listH));
			}
			if (i == 1) {
				// 제품명
				cartButton[i].setText(bean.getCname());
				cartButton[i].setHorizontalAlignment(SwingConstants.LEFT);
				cartButton[i].setPreferredSize(new Dimension(listW / 3, listH));
				// 포인트
				cartLabel[i].setText(String.valueOf(bean.getCpoint() + " P"));
				cartLabel[i].setPreferredSize(new Dimension(listW / 8, listH));
				cartLabel[i].setForeground(s.ssogRed);
			}
			if (i == 2) {
				// 가격
				cartLabel[i].setText(String.valueOf(bean.getCsum() + " 원"));
				cartLabel[i].setPreferredSize(new Dimension(listW / 6, listH));
				// 삭제
				img2 = img2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				cartButton[i].setText(cname);
				cartButton[i].setForeground(Color.white);
				/* 버튼 투명하게 */
				cartButton[i].setPreferredSize(new Dimension(listW / 9, listH));
				cartButton[i].setHorizontalAlignment(SwingConstants.RIGHT);
			} // 라벨, 버튼 if문 끝 (0~2)
			cartButton[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			/* 버튼 투명하게 */
			cartButton[i].setContentAreaFilled(false);
			cartButton[i].setBorderPainted(false);

			cartLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);
			cartLabel[i].setFont(new Font("나눔고딕", Font.BOLD, 15));
			cartButton[i].setFont(new Font("나눔고딕", Font.BOLD, 15));
		}
		cartList.add(cartButton[0]);
		cartList.add(cartButton[1]);
		cartList.add(cartLabel[0]);
		cartList.add(cartLabel[1]);
		cartList.add(cartLabel[2]);
		cartList.add(cartButton[2]);
		cartList.setBackground(Color.white);

		cartSaveList.add(cartList);
		cart[1].add(cartSaveList.get(cartSaveList.size() - 1));
		labelSaveList.add(cartLabel);// 0수량, 1포인트, 2가격
		// #
		buttonSaveList.add(cartButton);// 0 이미지,1 제품명,2 삭제

		click++; // 클릭하면 리스트 추가, 현재 들어가 있는 상품 수이기도 함.

		cart[1].setLayout(new GridLayout(cartSaveList.size(), 1));

		this.doLayout();
		this.setVisible(true);
	}

	public void listCart(String cimg, String cname, int ccount, int cdanga, int csum) {
		System.out.println("[listCart]");

		int over = 0;

		for (CartBean c : CartDao.getInstance().listMember()) {
			if (c.getCname().equals(cname)) { // 기존에 상품이 있음
				over++;
			} else { // 새로 추가
			}
		}
		decision(over, cimg, cname, ccount, cdanga, csum, CartDao.getInstance().listMember().size());
	}

	public void decision(int over, String cimg, String cname, int ccount, int cdanga, int csum, int order) {
		System.out.println("decision");
		if (over == 0) {
//			System.out.println("새로 추가");
			addCart(cimg, cname, ccount, cdanga, csum, order);
		} else {
//			System.out.println("[수량 수정]" + cname);
			modifyCart(cimg, cname, ccount, cdanga, csum);
		}
	}

	public void lastBuy(String cimg, String cname, int ccount, int cdanga, int csum) {
		System.out.println("lastBuy");

		int buyProductPrice = 0;
		int buycharge = 0;

		// 상품 합, 배송비, 포인트, 상품+배송비 (총 결제 금액)

		for (CartBean c : CartDao.getInstance().listMember()) {
			System.out.println(
					"[최종 리스트 확인] " + c.getCname() + " " + c.getCcount() + " " + c.getCdanga() + " " + c.getCsum());
			buyProductPrice += c.getCsum();
		}

		if (buyProductPrice < 30000) {
			buycharge = 2500;
		}

		int buyPoint = buyProductPrice / 100;
		int buySum = buyProductPrice + buycharge;

		buyLabel[1].setText(buyProductPrice + " 원");
		buyLabel[1].setHorizontalAlignment(SwingConstants.RIGHT);
		buyLabel[3].setText(buycharge + " 원");
		buyLabel[3].setHorizontalAlignment(SwingConstants.RIGHT);
		buyLabel[5].setText(buyPoint + " P");
		buyLabel[5].setHorizontalAlignment(SwingConstants.RIGHT);
		buyLabel[7].setText(buySum + " 원");
		buyLabel[7].setHorizontalAlignment(SwingConstants.RIGHT);
	}

	public LayOut(String id, String pw, String name) {
		super(name + "님의 ㅆㅆㅗㄱ");

		this.logInfo[0] = id;
		this.logInfo[1] = pw;
		this.logInfo[2] = name;

		iniLayout();

		this.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtn[0].setFocusable(true);
			}
		});

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				jbtn[0].setFocusable(false);
				CartDao.getInstance().deleteCart();
				CartDao.getInstance().insertCart();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setUndecorated(true);
		this.setBounds(0, 0, d.width, d.height);
		this.setLocation(((d.width - this.getWidth()) / 2), (d.height - this.getHeight()) / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

//	public static void main(String[] args) {
//
//		new LayOut("nana0813", "yodream123", "나재민");
//
//	}
}
