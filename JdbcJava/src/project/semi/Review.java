package project.semi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Review extends JPanel implements ActionListener {
	private JPanel[] jp = new JPanel[7];
	private JPanel grid;
	private JPanel flow;
	private JButton jbtn12, jbtnok;
	private JPanel jbtt;
	private JPanel boder[] = new JPanel[8];
	private JPanel boder1[] = new JPanel[7];
	private String[] jlstr = { "유형", "내용", "작성자", "작성일" };
	private JLabel[] jl = new JLabel[jlstr.length];
	private JLabel[] aa = new JLabel[7];
	private JPanel[] boder2 = new JPanel[7];
	private JButton jbtttt;
	private JButton[] jbtn = new JButton[7];
	private JLabel[] cc = new JLabel[7];
	private JLabel[] dd = new JLabel[7];
	private String a, b, c;
	private JTextArea jta;
	private ArrayList<JButton> list = new ArrayList<JButton>();
	private List<ReviewModel> Alist;
	private String no = "";
	SetStyle s = new SetStyle();

	String id = "";

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jbtnok) {

			new Reviewpan("", "", "");

		}

		for (int i = 0; i < flow.getComponentCount(); i++) {
			flow.getComponent(i).setForeground(Color.black);
		}

		for (int i = 0; i < flow.getComponentCount(); i++) {
			if (e.getSource() == (Object) flow.getComponent(i)) {

				hihi(Integer.parseInt(e.getActionCommand()));
				flow.getComponent(i).setForeground(s.ssogRed);
				break;
			}
		}

	}

	public void init() {
		this.setLayout(new BorderLayout());
		Alist = proDao.listreview(no);
		int p = 1;

		grid = new JPanel(new GridLayout(8, 1));
		this.add(grid);

		for (int i = 0; i < boder.length; i++) {
			boder[i] = new JPanel(new BorderLayout());
			boder[i].setBackground(Color.white);

			grid.add(boder[i]);
			grid.setBackground(Color.WHITE);

		}
		for (int i = 0; i < jp.length; i++) {
			jp[i] = new JPanel(new BorderLayout());
			boder1[i] = new JPanel(new BorderLayout());
			jp[i].setBackground(Color.WHITE);
			boder[i].add("East", jp[i]);
			boder[i].add(boder1[i]);

		}
		for (int i = 0; i < jl.length; i++) {
			jl[i] = new JLabel(jlstr[i]);
			s.setStyle(jl[i], true, Color.white, s.ssogRed, s.nanum, Font.BOLD, 20);

		}
		jl[0].setPreferredSize(new Dimension(85, 50));
		jl[2].setPreferredSize(new Dimension(200, 50));
		jl[3].setPreferredSize(new Dimension(140, 50));
		for (int i = 1; i < 7; i++) {

			aa[i - 1] = new JLabel();
			cc[i - 1] = new JLabel();
			dd[i - 1] = new JLabel();
			boder2[i - 1] = new JPanel(new BorderLayout());
			aa[i - 1].setFont(new Font("나눔고딕", Font.PLAIN, 20));
			aa[i - 1].setBackground(Color.white);
			aa[i - 1].setOpaque(true);
			aa[i - 1].setPreferredSize(new Dimension(85, 50));
			aa[i - 1].setHorizontalAlignment(SwingConstants.CENTER);
			cc[i - 1].setPreferredSize(new Dimension(150, 30));
			dd[i - 1].setPreferredSize(new Dimension(185, 50));
			cc[i - 1].setBackground(Color.white);
			cc[i - 1].setOpaque(true);
			cc[i - 1].setHorizontalAlignment(SwingConstants.LEFT);
			dd[i - 1].setHorizontalAlignment(SwingConstants.CENTER);
			cc[i - 1].setBackground(Color.RED);
			dd[i - 1].setBackground(Color.white);
			dd[i - 1].setOpaque(true);

			s.setStyle(aa[i - 1], true, Color.black, Color.WHITE, s.nanum, Font.PLAIN, 20);
			s.setStyle(cc[i - 1], true, Color.black, Color.WHITE, s.nanum, Font.PLAIN, 20);
			s.setStyle(dd[i - 1], true, Color.black, Color.WHITE, s.nanum, Font.PLAIN, 20);

			boder1[i].add("West", aa[i - 1]);
			boder1[i].add(boder2[i - 1]);
			boder1[i].add("East", dd[i - 1]);
			boder1[i].setBackground(Color.WHITE);

			boder2[i - 1].add(jbtn[i - 1] = new JButton());
			jbtn[i - 1].setBackground(Color.WHITE);
			jbtn[i - 1].addActionListener(this);
			jbtn[i - 1].setBorderPainted(false);
			jbtn[i - 1].setContentAreaFilled(false);
			jbtn[i - 1].setFocusPainted(false);
			jbtn[i - 1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jbtn[i - 1].setHorizontalAlignment(SwingConstants.LEFT);
			jbtn[i - 1].setFont(new Font(s.nanum, Font.PLAIN, 20));
			boder2[i - 1].add("East", cc[i - 1]);
			boder2[i - 1].setBackground(Color.white);
		}

		boder1[1].setBackground(Color.white);
		boder1[2].setBackground(Color.white);
		boder1[3].setBackground(Color.white);
		boder1[4].setBackground(Color.white);
		boder1[5].setBackground(Color.white);
		boder1[6].setBackground(Color.white);

		boder1[0].add("West", jl[0]);
		boder1[0].add(jl[1]);
		boder1[0].add("East", jl[2]);

		jl[0].setHorizontalAlignment(SwingConstants.CENTER);
		jl[1].setHorizontalAlignment(SwingConstants.CENTER);
		jl[2].setHorizontalAlignment(SwingConstants.LEFT);

		jp[0].add(jl[3]);

		jbtnok = new JButton("리뷰 작성");
		jbtnok.addActionListener(this);
		jbtnok.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		jbtnok.setBackground(s.ssogYellow);
		jbtnok.setBorderPainted(false);
		this.add("South", jbtt = new JPanel(new BorderLayout()));
		jbtt.add("East", jbtnok);
		jbtt.setBackground(Color.WHITE);
		jbtt.add(flow = new JPanel());
		flow.setBackground(Color.WHITE);
		flow.add(jbtttt = new JButton("1"));
		jbtttt.setBackground(Color.WHITE);
		jbtttt.setBorderPainted(false);
		jbtttt.addActionListener(this);
		jbtttt.setFont(new Font(s.nanum, Font.PLAIN, 25));

		hihi(p);

	}

	public void foroh() {
		int j = 2;
		for (int i = 0; i < Alist.size(); i++) {
			if (i % 6 == 0 && i != 0) {

				list.add(new JButton(Integer.toString(j)));
				flow.add(list.get(j - 2));
				list.get(j - 2).addActionListener(this);
				list.get(j - 2).setBackground(Color.white);
				list.get(j - 2).setBorderPainted(false);
				;
				list.get(j - 2).setFont(new Font(s.nanum, Font.PLAIN, 25));
				j++;

			}

		}
	}

	public void hihi(int p) {
		int staP = ((p * 6) - (6)); // 6부터
		int endP = ((p * 6) - (p * 1) + (p - 1)); // 5 11 / 10 / 1 5되야함 10까지

		foroh();

		for (int i = 0; i < 6; i++) {
			aa[i].setText("");
			cc[i].setText("");
			dd[i].setText("");
			jbtn[i].setText("");
		}

		for (int i = 0; i < 6; i++) {
			if (staP == (endP + 1))
				return;
			if (staP == Alist.size())
				return;

			aa[i].setText(Alist.get(staP).getReview());

			cc[i].setText(Alist.get(staP).getTitle());

			dd[i].setText(Alist.get(staP).getDate1());

			jbtn[i].setText("      " + Alist.get(staP).getContancs());
			staP++;

		}

	}

	public Review(String id, String no) {
		super();
		this.id = id;
		this.no = no;
		init();

		// this.setBounds(0, 0, 900, 650);
		this.setVisible(true);

	}

	public class Reviewpan extends JFrame implements ActionListener {
		private JLabel a, b, c;// 빈깡통
		private String[] titlename = { "    리뷰내용 작성", "리뷰 유형      ", "내용" };
		private JLabel[] jl = new JLabel[titlename.length];
		private String[] name = { "상품", "배송", "색상", "사이즈", "품질", "기타" };
		private JRadioButton[] jbox = new JRadioButton[name.length];
		private ButtonGroup bg = new ButtonGroup();
		private JPanel jbtngr;
		private JPanel contants[] = new JPanel[3];
		private JTextArea jta;
		private JPasswordField jf1;
		private JButton jbtn1, jbtn2;
		private JPanel boder1, boder2, boder3, boder4;
		private JTextField jf2, jf3;
		private JScrollPane jsp;
		private String aa = "";
		private JPanel jpp;

		private String ddd;

		public JRadioButton[] getJbox() {
			return jbox;
		}

		public void setJbox(JRadioButton[] jbox) {
			this.jbox = jbox;
		}

		public JTextArea getJta() {
			return jta;
		}

		public void setJta(JTextArea jta) {
			this.jta = jta;
		}

		public JTextField getJf1() {
			return jf1;
		}

		public JTextField getJf2() {
			return jf2;
		}

		public void setJf2(JTextField jf2) {
			this.jf2 = jf2;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < jbox.length; i++) {
				if (e.getSource() == jbox[i]) {
					aa = jbox[i].getText().trim();
				}
			}
			if (e.getSource() == jbtn1) {
				if (jta.getText() == null || jta.getText() == "" || jf3.getText() == null || jf3.getText() == ""
						|| aa == null || aa == "") {
					JOptionPane.showMessageDialog(this, "다시 확인해");
				} else {
					JOptionPane.showMessageDialog(this, "접수가 완료되었습니다.");

					proDao.reveiwupdate(aa, id, jta.getText().trim(), no);
					Alist = proDao.listreview(no);
					hihi(1);

					this.dispose();
				}

			}
			if (e.getSource() == jbtn2) {
				this.dispose();
			}

		}

		public void init(String ac, String bc, String cc) {
			for (int i = 0; i < jl.length; i++) {
				jl[i] = new JLabel(titlename[i]);// 라벨생성
				jl[i].setOpaque(true);
				jl[i].setBackground(Color.WHITE);
			}
			jl[0].setBackground(s.ssogRed);

			jl[0].setForeground(Color.WHITE);
			jl[0].setFont(new Font("나눔고딕", Font.BOLD, 18));
			jl[1].setFont(new Font("나눔고딕", Font.BOLD, 18));
			jl[2].setFont(new Font("나눔고딕", Font.BOLD, 20));
			jl[2].setPreferredSize(new Dimension(102, 10));
			jl[2].setHorizontalAlignment(SwingConstants.CENTER);
			for (int i = 0; i < contants.length; i++) {// 판생성
				contants[i] = new JPanel();
				contants[i].setBackground(Color.WHITE);

			}

			/*
			 * jbtngr=new JPanel(new GridLayout(2,1)); this.add(jbtngr);
			 */

			this.add("North", jl[0]);

			jl[0].setFont(new Font("고딕", 2, 25));
			;

			this.add(boder1 = new JPanel(new BorderLayout()));
			boder1.add("North", contants[1]); // 그리드1,2 (1)의 북쪽부분

			contants[1].add(jl[1]);

			for (int i = 0; i < name.length; i++) {
				jbox[i] = new JRadioButton(name[i]); // 체크박스 생성
				jbox[i].addActionListener(this);

				bg.add(jbox[i]);
				contants[1].add(jbox[i]);
				jbox[i].setBackground(Color.white);
			}

			boder1.add(boder2 = new JPanel(new BorderLayout()));
			boder2.add("West", jl[2]);

			boder2.add(jsp = new JScrollPane(jta = new JTextArea(1, 1), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

			boder2.add("North", jpp = new JPanel(new BorderLayout()));
			jpp.add("West", c = new JLabel("제목"));
			c.setPreferredSize(new Dimension(102, 10));
			c.setHorizontalAlignment(SwingConstants.CENTER);
			jpp.setBackground(Color.WHITE);
			c.setFont(new Font("나눔고딕", Font.PLAIN, 16));
			c.setBackground(Color.white);
			jpp.add(jf3 = new JTextField());
			// boder1.add("South",boder3=new JPanel(new BorderLayout())); //그리드 1,3 (1)의 남쪽
			jf3.setBackground(Color.white);

			jf3.setText(ac);

			jta.setText(bc);
			for (int i = 0; i < name.length; i++) {
				if (name[i].equals(cc)) {
					jbox[i].setSelected(true);
					;
				}
			}

			// jbtngr.add(boder4=new JPanel(new BorderLayout()));

			this.add("South", contants[0]);
			// boder4.add("West",a=new JLabel(" "));
			// boder4.add("East",b=new JLabel(" "));

			contants[0].add(jbtn1 = new JButton("등록"));
			jbtn1.addActionListener(this);
			contants[0].add(jbtn2 = new JButton("취소"));
			jbtn2.addActionListener(this);

		}

		public Reviewpan(String a, String b, String c) {

			init(a, b, c);

			this.setBounds(0, 0, 500, 320);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			this.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					Reviewpan.this.dispose();
				}

			});

		}

	}

}
