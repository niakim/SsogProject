package project.semi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ProductLayout extends JFrame {
	SetStyle s = new SetStyle();

	private JPanel jpPro;
	private JButton jbtnPro;
	private String[] jlbProStr = { "제품명", "판매가" };
	private JLabel[] jlbPro = new JLabel[jlbProStr.length];
	private ImageIcon[] iconPro = new ImageIcon[12];
	private String[] iconStr = { "C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\민아\\ND\\ND",
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\민아\\JY\\JY",
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\현중\\SS\\SS",
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\나경\\FR\\FR",
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\현중\\SN\\SN",
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\나경\\FU\\FU",
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\다정\\BA\\BA",
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\다정\\KI\\KI" };
//	private String[] iconStr = { "/Users/y/Dropbox/나경 JAVA/조별 Project/2.CRUD(19.03.08)/IMG/민아/ND/ND",
//			"/Users/y/Dropbox/나경 JAVA/조별 Project/2.CRUD(19.03.08)/IMG/민아/JY/JY",
//			"/Users/y/Dropbox/나경 JAVA/조별 Project/2.CRUD(19.03.08)/IMG/현중/SS/SS",
//			"/Users/y/Dropbox/나경 JAVA/조별 Project/2.CRUD(19.03.08)/IMG/나경/FR/FR",
//			"/Users/y/Dropbox/나경 JAVA/조별 Project/2.CRUD(19.03.08)/IMG/현중/SN/SN",
//			"/Users/y/Dropbox/나경 JAVA/조별 Project/2.CRUD(19.03.08)/IMG/나경/FU/FU",
//			"/Users/y/Dropbox/나경 JAVA/조별 Project/2.CRUD(19.03.08)/IMG/다정/BA/BA",
//			"/Users/y/Dropbox/나경 JAVA/조별 Project/2.CRUD(19.03.08)/IMG/다정/KI/KI" };

	private JPanel tmp[] = new JPanel[2];
	private String[] tmpJbtnStr = { "-", "+" };
	private JButton[] tmpJbtn = new JButton[tmpJbtnStr.length];
	private JTextField tmpT;
	private JCheckBox jcb;
	private JButton jbtnCart;
	private ImageIcon iconCart = new ImageIcon(
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\코드\\DJ\\img\\cart.png");

	private JPanel jpSpecific;
	private JLabel jlbSpecific;
	private JPanel[] jpBorder = new JPanel[3]; // 민아꺼는 4개임 수정하기
	private JButton putInCart;
	private JLabel[] jlbInfo = new JLabel[3];
	private JButton[] specificJbtn = new JButton[tmpJbtnStr.length];
	private JTextField specificTf;
	private JLabel stock;
	private JLabel[] proInfo = new JLabel[2];
	private JButton keepShopping;
	private JButton jbtnHeart;
	private ImageIcon iconHeart = new ImageIcon(
			"C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\clip1.png");

	private String[] namestr = { "ND", "JY", "SS", "FR", "SN", "FU", "BA", "KI" };

	private String id = "";

	private int count = 1;
	int m;
	private int countSpecific = 1;

	// 민아
	private String cName;
	private String cPrice;
	private int cCount;
	private String cImg;

	public JButton getJbtnPro() {
		return jbtnPro;
	}

	public void setJbtnPro(JButton jbtnPro) {
		this.jbtnPro = jbtnPro;
	}

	public JButton[] getTmpJbtn() {
		return tmpJbtn;
	}

	public void setTmpJbtn(JButton[] tmpJbtn) {
		this.tmpJbtn = tmpJbtn;
	}

	public JTextField getTmpT() {
		return tmpT;
	}

	public void setTmpT(JTextField tmpT) {
		this.tmpT = tmpT;
	}

	public JCheckBox getJcb() {
		return jcb;
	}

	public void setJcb(JCheckBox jcb) {
		this.jcb = jcb;
	}

	public JButton getJbtnCart() {
		return jbtnCart;
	}

	public void setJbtnCart(JButton jbtnCart) {
		this.jbtnCart = jbtnCart;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public JButton getPutInCart() {
		return putInCart;
	}

	public void setPutInCart(JButton putInCart) {
		this.putInCart = putInCart;
	}

	public JButton[] getSpecificJbtn() {
		return specificJbtn;
	}

	public void setSpecificJbtn(JButton[] specificJbtn) {
		this.specificJbtn = specificJbtn;
	}

	public JTextField getSpecificTf() {
		return specificTf;
	}

	public void setSpecificTf(JTextField specificTf) {
		this.specificTf = specificTf;
	}

	public int getCountSpecific() {
		return countSpecific;
	}

	public void setCountSpecific(int countSpecific) {
		this.countSpecific = countSpecific;
	}

	public JButton getKeepShopping() {
		return keepShopping;
	}

	public void setKeepShopping(JButton keepShopping) {
		this.keepShopping = keepShopping;
	}

	public JButton getJbtnHeart() {
		return jbtnHeart;
	}

	public void setJbtnHeart(JButton jbtnHeart) {
		this.jbtnHeart = jbtnHeart;
	}

	public String getcImg() {
		return cImg;
	}

	public void setcImg(String cImg) {
		this.cImg = cImg;
	}

	public int getcCount() {
		return cCount;
	}

	public void setcCount(int cCount) {
		this.cCount = cCount;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPrice() {
		return cPrice;
	}

	public void setcPrice(String cPrice) {
		this.cPrice = cPrice;
	}

	public JPanel productLayout(int n) {
		jpPro = new JPanel(new BorderLayout());

		iconPro[n] = new ImageIcon(iconStr[m].concat(Integer.toString(n + 1)).concat("-1").concat(".jpg"));
		setcImg(iconStr[m].concat(Integer.toString(n + 1)).concat("-1").concat(".jpg"));
		Image origin = iconPro[n].getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		iconPro[n] = new ImageIcon(origin);

		jbtnPro = new JButton(iconPro[n]);
		s.setStyle(jbtnPro, Color.WHITE, Color.WHITE);
		jpPro.add("Center", jbtnPro);

		tmp[0] = new JPanel(new GridLayout(3, 1));
		String[] info = { ProductDao.Prolist(namestr[m]).get(n).getNAME(),
				ProductDao.Prolist(namestr[m]).get(n).getPRICE() };

		for (int j = 0; j < jlbProStr.length; j++) {
			jlbPro[j] = new JLabel("<html>" + jlbProStr[j].concat(": ").concat(info[j]) + "</html>");
			jlbPro[j].setBorder(new EmptyBorder(0, 50, 0, 0));
			s.setStyle(jlbPro[j], Color.WHITE);
			if (j % 2 == 0) {
				setcName(info[j]);
//			System.out.println(info[j] + "제품명 확인");
			} else {
				setcPrice(info[j]);
//				System.out.println(info[j] + "가격 확인");				
			}
			tmp[0].add(jlbPro[j]);
		}

		tmp[1] = new JPanel();
		tmp[1].setBackground(Color.WHITE);

		for (int j = 0; j < tmpJbtn.length; j++) {
			tmpJbtn[j] = new JButton(tmpJbtnStr[j]);
			s.setStyle(tmpJbtn[j], Color.WHITE, Color.BLACK, "나눔고딕", Font.BOLD, 15);
		}

		tmpT = new JTextField(5);
		tmpT.setHorizontalAlignment(SwingConstants.CENTER);
		tmpT.setFont(new Font("나눔고딕", Font.BOLD, 15));
		tmpT.setText(Integer.toString(count));

		jcb = new JCheckBox();
		jcb.setBackground(Color.WHITE);

		Image tmpCart = iconCart.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		iconCart = new ImageIcon(tmpCart);
		jbtnCart = new JButton(iconCart);
		s.setStyle(jbtnCart, Color.WHITE, Color.WHITE);

		tmp[1].add(tmpJbtn[0]);
		tmp[1].add(tmpT);
		tmp[1].add(tmpJbtn[1]);
		tmp[1].add(jbtnCart);

		tmp[0].add(tmp[1]);

		jpPro.add("South", tmp[0]);
		return jpPro;
	}

	public JPanel specificLayout(int n) {
		jpSpecific = new JPanel(new BorderLayout());
		jpSpecific.setBackground(Color.WHITE);

		jpBorder[0] = new JPanel(new BorderLayout()); // west 제품 상세 사진
		jpBorder[0].setBorder(new EmptyBorder(50, 50, 0, 0));
		jpBorder[0].setBackground(Color.WHITE);
		iconPro[n] = new ImageIcon(iconStr[m].concat(Integer.toString(n + 1)).concat("-1").concat(".jpg"));
		Image origin = iconPro[n].getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH);
		iconPro[n] = new ImageIcon(origin);
		jlbSpecific = new JLabel(iconPro[n]);

		System.out.println(namestr[m] + " " + n + " " + ProductDao.setSubImgArray(namestr[m])[n]);

		int sub = ProductDao.setSubImgArray(namestr[m])[n];
		JLabel[] jlbSpecificSub = new JLabel[sub - 1];
		ImageIcon[] iconProSub = new ImageIcon[sub - 1];
		JPanel tmpSub = new JPanel();
		tmpSub.setBackground(Color.WHITE);
		tmpSub.setBorder(new EmptyBorder(50, 0, 100, 0));

		if (!(sub == 1)) {
			for (int i = 0; i < jlbSpecificSub.length; i++) {
				iconProSub[i] = new ImageIcon(iconStr[m].concat(Integer.toString(n + 1)).concat("-")
						.concat(Integer.toString(i + 2)).concat(".jpg"));
				Image originSub = iconProSub[i].getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
				iconProSub[i] = new ImageIcon(originSub);
				jlbSpecificSub[i] = new JLabel(iconProSub[i]);
				jlbSpecificSub[i].addMouseListener(new MouseAdapter() {

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						if (sub == 2) {
							iconProSub[0] = new ImageIcon(iconStr[m].concat(Integer.toString(n + 1)).concat("-")
									.concat(Integer.toString(2)).concat(".jpg"));
							Image origin = iconProSub[0].getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH);
							iconProSub[0] = new ImageIcon(origin);
							jlbSpecific.setIcon(iconProSub[0]);
						} else if (sub == 3) {
							if (e.getSource() == jlbSpecificSub[0]) {
								iconProSub[0] = new ImageIcon(iconStr[m].concat(Integer.toString(n + 1)).concat("-")
										.concat(Integer.toString(2)).concat(".jpg"));
								Image origin = iconProSub[0].getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH);
								iconProSub[0] = new ImageIcon(origin);
								jlbSpecific.setIcon(iconProSub[0]);
							} else if (e.getSource() == jlbSpecificSub[1]) {
								iconProSub[1] = new ImageIcon(iconStr[m].concat(Integer.toString(n + 1)).concat("-")
										.concat(Integer.toString(2)).concat(".jpg"));
								Image origin = iconProSub[1].getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH);
								iconProSub[1] = new ImageIcon(origin);
								jlbSpecific.setIcon(iconProSub[1]);
							}
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						jlbSpecific.setIcon(iconPro[n]);
					}

				});
				tmpSub.add(jlbSpecificSub[i]);
			}
		}
		jpBorder[0].add("Center", jlbSpecific);
		jpBorder[0].add("South", tmpSub);

		jpBorder[1] = new JPanel(null); // center 상세 내용
		jpBorder[1].setBackground(Color.WHITE);

		jbtnHeart = new JButton(iconHeart);
		jbtnHeart.setBounds(150, 50, 40, 40);
		s.setStyle(jbtnHeart, Color.WHITE, Color.WHITE);
		jbtnHeart.setContentAreaFilled(false);
		jbtnHeart.setFocusPainted(false);
		String[] info = { ProductDao.Prolist(namestr[m]).get(n).getNAME(),
				ProductDao.Prolist(namestr[m]).get(n).getPRICE(), ProductDao.Prolist(namestr[m]).get(n).getCNAME() };
		stock = new JLabel("재고있음");
		stock.setBorder(new EmptyBorder(0, 10, 0, 0));
		stock.setBounds(150, 90, 510, 35);
		s.setStyle(stock, true, Color.BLACK, s.ssogYellow, s.nanum, Font.BOLD, 15);

		proInfo[0] = new JLabel(info[0]);
		proInfo[0].setBounds(150, 160, 510, 40);
		s.setStyle(proInfo[0], true, Color.BLACK, Color.WHITE, s.nanum, Font.BOLD, 30);
		proInfo[1] = new JLabel("제조사: " + info[2]);
		proInfo[1].setBounds(150, 190, 510, 40);
		s.setStyle(proInfo[1], true, Color.GRAY, Color.WHITE, s.nanum, Font.PLAIN, 25);
		jlbInfo[0] = new JLabel("<html><p style=\"text-decoration:line-through\">권장소비자 가격: "
				+ Integer.toString((int) (Integer.parseInt(info[1]) * 1.1)).concat("원") + "</p></html>");
		jlbInfo[0].setBounds(150, 260, 510, 30);
		s.setStyle(jlbInfo[0], true, Color.GRAY, Color.WHITE, s.nanum, Font.PLAIN, 15);
		jlbInfo[1] = new JLabel("판매 가격: " + info[1].concat("원"));
		jlbInfo[1].setBounds(150, 285, 510, 40);
		s.setStyle(jlbInfo[1], true, Color.BLACK, Color.WHITE, s.nanum, Font.BOLD, 25);
		jlbInfo[2] = new JLabel("할인액: "
				+ Integer.toString((int) (Integer.parseInt(info[1]) * 1.1) - Integer.parseInt(info[1])).concat("원"));
		jlbInfo[2].setBounds(150, 320, 510, 30);
		s.setStyle(jlbInfo[2], true, Color.GRAY, Color.WHITE, s.nanum, Font.PLAIN, 15);

		for (int j = 0; j < tmpJbtn.length; j++) {
			specificJbtn[j] = new JButton(tmpJbtnStr[j]);
			s.setStyle(specificJbtn[j], Color.WHITE, Color.BLACK, "나눔고딕", Font.BOLD, 15);
			specificJbtn[j].setBounds(330 + (100) * j, 390, 50, 30);
		}
		specificTf = new JTextField(5);
		specificTf.setBounds(380, 390, 50, 30);
		specificTf.setHorizontalAlignment(SwingConstants.CENTER);
		specificTf.setText(Integer.toString(count));

		putInCart = new JButton("장바구니에 담기");
		putInCart.setBounds(150, 430, 510, 40);
		s.setStyle(putInCart, s.ssogRed, Color.WHITE, "나눔고딕", Font.BOLD, 20);
		keepShopping = new JButton("계속 쇼핑하기");
		keepShopping.setBounds(150, 470, 510, 40);
		s.setStyle(keepShopping, Color.WHITE, s.ssogRed, "나눔고딕", Font.BOLD, 20);

		jpBorder[1].add(jbtnHeart);
		jpBorder[1].add(stock);
		jpBorder[1].add(proInfo[0]);
		jpBorder[1].add(proInfo[1]);
		jpBorder[1].add(jlbInfo[0]);
		jpBorder[1].add(jlbInfo[1]);
		jpBorder[1].add(jlbInfo[2]);
		jpBorder[1].add(specificJbtn[0]);
		jpBorder[1].add(specificTf);
		jpBorder[1].add(specificJbtn[1]);
		jpBorder[1].add(putInCart);
		jpBorder[1].add(keepShopping);

		jpBorder[2] = new JPanel(new BorderLayout()); // south 상품평
		jpBorder[2].setBackground(Color.WHITE);
		jpBorder[2].add(new Review(id, ProductDao.Prolistno(namestr[m], n + 1)));
		String[] border = { "West", "Center", "South" };
		for (int i = 0; i < jpBorder.length; i++) {
			jpSpecific.add(border[i], jpBorder[i]);
		}

		return jpSpecific;
	}

	public ProductLayout(int m, String id) {
		this.m = m;
		this.id = id;
	}
}