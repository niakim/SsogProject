package project.semi;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class QnA extends JFrame implements ActionListener {
	private JLabel a, b, c;// 빈깡통
	private String[] titlename = { "    문의내용 작성", "문의 유형      ", "        내용          ", "    문의 비밀번호", "   urcl  ",
			"    알아두세요!" };
	private JLabel[] jl = new JLabel[titlename.length];
	private String[] name = { "상품", "배송", "반품/취소", "교환/변경", "기타" };
	private JRadioButton[] jbox = new JRadioButton[name.length];
	private ButtonGroup bg = new ButtonGroup();
	private JPanel jbtngr;
	private JPanel contants[] = new JPanel[6];
	private JTextArea jta, jta1;
	private JPasswordField jf1;
	private JButton jbtn1, jbtn2;
	private JPanel boder1, boder2, boder3, boder4;
	private JTextField jf2, jf3;
	private JScrollPane jsp;
	private String aa = "";
	private JPanel jpp;
	private String id;
	MyInfo myInfo;

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
			if (jta.getText() == null || jta.getText() == "" || jf1.getText() == null || jf1.getText() == ""
					|| aa == null || aa == "") {
				JOptionPane.showMessageDialog(this, "다시 확인해");
			} else {
				
				proDao.uppro(aa, jta.getText().trim(), jf1.getText().trim(), id);
				JOptionPane.showMessageDialog(this, "접수가 완료되었습니다.");
				myInfo.getQnA2111().hi(1, 1);

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
		}

		for (int i = 0; i < contants.length; i++) {// 판생성
			contants[i] = new JPanel();

		}

		jbtngr = new JPanel(new GridLayout(2, 1));
		this.add(jbtngr);

		this.add("North", jl[0]);

		jl[0].setFont(new Font("고딕체", 2, 25));
		;

		jbtngr.add(boder1 = new JPanel(new BorderLayout()));
		boder1.add("North", contants[1]); // 그리드1,2 (1)의 북쪽부분

		contants[1].add(jl[1]);

		for (int i = 0; i < name.length; i++) {
			jbox[i] = new JRadioButton(name[i]); // 체크박스 생성
			jbox[i].addActionListener(this);

			bg.add(jbox[i]);
			contants[1].add(jbox[i]);
		}

		boder1.add(contants[2]); // 그리드 1,2 (1)의 센터부분
		contants[2].add(boder2 = new JPanel(new BorderLayout()));
		boder2.add("West", jl[2]);
		boder2.add(jsp = new JScrollPane(jta = new JTextArea(8, 33), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));

		boder2.add("North", jpp = new JPanel(new BorderLayout()));
		jpp.add("West", c = new JLabel("         제목         "));
		jpp.add(jf3 = new JTextField());
		boder1.add("South", boder3 = new JPanel(new BorderLayout())); // 그리드 1,3 (1)의 남쪽
		boder3.add("West", jl[3]);
		boder3.add(contants[3]);
		contants[3].add(jf1 = new JPasswordField(13));
		contants[3].add(jl[4]);
		contants[3].add(jf2 = new JTextField(13));

		jf3.setText(ac);
		jf1.setText(ac);
		jta.setText(bc);
		for (int i = 0; i < name.length; i++) {
			if (name[i].equals(cc)) {
				jbox[i].setSelected(true);
				;
			}
		}

		jbtngr.add(boder4 = new JPanel(new BorderLayout()));
		boder4.add("North", jl[5]);
		boder4.add(jta1 = new JTextArea("\n" + "*  전화번호, 이메일, 배송지 주소, 환불계좌정보 등 개인정보가 포함된 글은,비밀글로\r\n"
				+ "   (문의해 주시기 바랍니다.단, 상품 문의유형은 비밀글 설정 불가) \r\n"
				+ "*  상품 Q&A에 등록한 게시글은 내정보 보기 > 상품 Q&A에서 확인하실 수 있습니다. \r\n"
				+ "*  부적절한 게시물 등록시 ID이용 제한 및 게시물이 삭제될 수 있습니다. \r\n" + "-  전화번호, 이메일 주소 등 연락처를 기재하여 할인/직거래 등을 유도 \r\n"
				+ "-  비방/욕설/명예훼손, 가격비교정보, 물품과 관련 없는 광고글 등 \r\n" + "-  다만 상품에 대한 단순 불만, 판매자에게 불리한 내용이라는 이유만으로는  \r\n"
				+ "   삭제하지 않습니다. \r\n" + "*  게시글에 회원님의 이메일, 휴대폰번호와 같은 개인 정보의 입력은 금지되어\r\n"
				+ "   있으며, 발생하는 모든 피해에 대해 SSOG MALL은 책임지지 않습니다. \r\n" + ""));
		jta1.setEditable(false);
		jta1.setOpaque(false);
		boder4.add("South", contants[0]);
		boder4.add("West", a = new JLabel("         "));
		boder4.add("East", b = new JLabel("    "));

		contants[0].add(jbtn1 = new JButton("등록"));
		jbtn1.addActionListener(this);
		contants[0].add(jbtn2 = new JButton("취소"));
		jbtn2.addActionListener(this);

	}

	public QnA(String a, String b, String c, String id, MyInfo myInfo) {
		this.id = id;
		init(a, b, c);
		this.myInfo = myInfo;

		this.setBounds(0, 0, 500, 620);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				QnA.this.dispose();
			}

		});

	}

}
