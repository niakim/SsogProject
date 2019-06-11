package project.semi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.MenuBarUI;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableCellRenderer;

//https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html#custom
//https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
public class AdminLayout4 extends JFrame implements ActionListener {
	SetStyle s = new SetStyle();

	private JTabbedPane jtbp = new JTabbedPane(JTabbedPane.LEFT);
	private JTabbedPane jtbpSub = new JTabbedPane(JTabbedPane.LEFT);
	private String[] jpStr = { "회원 정보 조회", "주문 고객 관리", "포인트 및 쿠폰" };
	private JPanel memberInfo, order, point;
	private JPanel[] jp = new JPanel[jpStr.length];
	private String[] jcbStr = { "전체 선택", "등급", "회원상태", "포인트", "나의 추천코드", "추천인", "신규 가입일", "총 결제금액" };
	private JCheckBox[] jcb = new JCheckBox[jcbStr.length];
	private JMenuBar jmb;
	private String[] jmnStr = { "회원 관리", "나경", "민아", "현중" };
	private JMenu[] jmnTmp = new JMenu[3];
	private JMenu[] jmn = new JMenu[jmnStr.length];
	private JButton commitJbtn;
	private JCheckBox entireJcb = new JCheckBox();
	private int[] jcbCount = new int[jcb.length];
	private JTable jtb;
	private MemberJTableModel m;
	private JButton applyJbtn;
	private JCheckBox jcbTable = new JCheckBox();
	private JComboBox<String> jcboxGrade = new JComboBox<String>();
	private JComboBox<String> jcboxState = new JComboBox<String>();
	int row;
	int column;
	private CardLayout card = new CardLayout();
	private JButton[] cardJbtn = new JButton[2];
	private ImageIcon[] dotIcon = new ImageIcon[cardJbtn.length];
	private String dotIconStr = "C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\circleimg";

	private JPanel root;
	private JTextField searchJtf;
	private JButton searchJbtn;
	private JComboBox<String> searchJcb;
	private JComboBox<String> searchJcbSub;
	private String[] gradeStr = { "일반 회원", "특별 회원", "운영자" };
	private String[] stateStr = { "가입", "탈퇴" };
	private String[] totalStr = { "이상", "이하" };

	JPanel searchJp = new JPanel();

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		for (int i = 0; i < jcb.length; i++) {
			if (source == jcb[i]) {
				switch (i) {
				case 0:
					jcbCount[i] *= -1;
					if (jcb[i].isSelected() == true) {
						for (int j = 1; j < jcb.length; j++) {
							jcb[j].setSelected(true);
						}
					} else {
						for (int j = 1; j < jcb.length; j++) {
							jcb[j].setSelected(false);
						}
					}
					break;
				default:
					jcbCount[i] *= -1;
					break;
				}
			}
		}

		if (source == commitJbtn) {
			ArrayList<String> tmp = new ArrayList<String>();
			for (int i = 0; i < jcb.length; i++) {
				if (jcbCount[i] == 1) {
					tmp.add(jcb[i].getText());
				}
			}
			jcbStr = new String[tmp.size()];
			for (int i = 0; i < jcbStr.length; i++) {
				jcbStr[i] = tmp.get(i);
			}
			jtb.setModel(IdDao.selectColumnMember(jcbStr));
			for (int i = 0; i < jcb.length; i++) {
				jcbCount[i] = -1;
				jcb[i].setSelected(false);
			}
		}

		if (source == applyJbtn) {
//			m.fireTableDataChanged();
		}

		if (source == cardJbtn[0]) {
			cardJbtn[0].setIcon(dotIcon[0]);
			cardJbtn[1].setIcon(dotIcon[1]);
			card.show(root, Integer.toString(1));
		} else if (source == cardJbtn[1]) {
			cardJbtn[1].setIcon(dotIcon[0]);
			cardJbtn[0].setIcon(dotIcon[1]);
			card.show(root, Integer.toString(2));
		}

		if (source == searchJcb) {
			System.out.println(searchJcb.getSelectedIndex());
			if (searchJcb.getSelectedItem().equals("등급")) {
				searchJcbSub.removeAllItems();
				for (int i = 0; i < gradeStr.length; i++) {
					searchJcbSub.addItem(gradeStr[i]);
				}
				searchJcbSub.setEnabled(true);
				searchJtf.setText("");
				searchJtf.setEnabled(false);
			} else if (searchJcb.getSelectedItem().equals("회원상태")) {
				searchJcbSub.removeAllItems();
				for (int i = 0; i < stateStr.length; i++) {
					searchJcbSub.addItem(stateStr[i]);
				}
				searchJcbSub.setEnabled(true);
				searchJtf.setText("");
				searchJtf.setEnabled(false);
			} else if (searchJcb.getSelectedItem().equals("총 결제금액")) {
				searchJcbSub.removeAllItems();
				for (int i = 0; i < totalStr.length; i++) {
					searchJcbSub.addItem(totalStr[i]);
				}
				searchJcbSub.setEnabled(true);
				searchJtf.setText("");
				searchJtf.setEnabled(true);
			} else if (searchJcb.getSelectedItem().equals("포인트")) {
				searchJcbSub.removeAllItems();
				for (int i = 0; i < totalStr.length; i++) {
					searchJcbSub.addItem(totalStr[i]);
				}
				searchJcbSub.setEnabled(true);
				searchJtf.setText("");
				searchJtf.setEnabled(true);
			} else if (searchJcb.getSelectedItem().equals("이름") || searchJcb.getSelectedItem().equals("나의 추천코드")
					|| searchJcb.getSelectedItem().equals("추천인") || searchJcb.getSelectedItem().equals("신규 가입일")) { // id왜안됨
				searchJcbSub.removeAllItems();
				searchJcbSub.addItem("--------------------");
				searchJcbSub.setEnabled(false);
				searchJtf.setText("");
				searchJtf.setEnabled(true);
			}
		}

		if (source == searchJbtn) {
			jtb.setModel(IdDao.searchCondition(
					searchJcb.getSelectedItem() + "#" + searchJcbSub.getSelectedItem() + "#" + searchJtf.getText()));
		}

	}

	public void layOut() {
//		this.add(new JPanel());

//		for (int i = 0; i < jp.length; i++) {
		jtbpSub.setUI(new AdminTabbedPaneUI());
		jtbpSub.addTab(jpStr[0], jp[0] = new JPanel(new BorderLayout()));
		jp[0].setBorder(new EmptyBorder(0, 25, 0, 0));
		jtbpSub.addTab("회원 탈퇴 현황", jp[1] = new JPanel(new BorderLayout()));
//		}
//		jtbp.addTab("<html><table width = '70'>회원 관리</table><html>", jtbpSub);
//		this.add(jtbp);
		this.add(jtbpSub);

		root = new JPanel(card);
		JPanel northJp0 = new JPanel(new GridLayout(2, 1));
		JPanel jcbJp = new JPanel();
		for (int i = 0; i < jcb.length; i++) {
			jcb[i] = new JCheckBox(jcbStr[i]);
			jcb[i].addActionListener(this);
			jcbJp.add(jcb[i]);
			jcbCount[i] = -1;
		}
		commitJbtn = new JButton("적용");
		commitJbtn.addActionListener(this);
		jcbJp.add(commitJbtn);
		northJp0.add(new JLabel("<html><font size = \"4\"; face = \"나눔고딕\"><b>화면에 보여주기</b></font></html>"));
		northJp0.add(jcbJp);
		root.add(northJp0, "1");

		JPanel northJp1 = new JPanel(new GridLayout(2, 1));
		JPanel searchJp = new JPanel();
		searchJcb = new JComboBox<String>();
		searchJcb.addActionListener(this);
		searchJcb.addItem("아이디");
		searchJcb.addItem("이름");
		for (int i = 0; i < jcbStr.length - 1; i++) {
			searchJcb.addItem(jcbStr[i + 1]);
		}

		searchJcbSub = new JComboBox<String>();
		searchJcbSub.addItem("--------------------");

		searchJtf = new JTextField(15);
		searchJbtn = new JButton("검색");
		searchJbtn.addActionListener(this);

		searchJp.add(searchJcb);
		searchJp.add(searchJcbSub);
		searchJp.add(searchJtf);
		searchJp.add(searchJbtn);

		northJp1.add(new JLabel("<html><font size = \"4\"; face = \"나눔고딕\"><b>검색</b></font></html>"));
		northJp1.add(searchJp);
		root.add(northJp1, "2");

		jp[0].add("North", root);

		JPanel rootCenter = new JPanel(new BorderLayout());
		JPanel jbtnJp = new JPanel();

		dotIcon[0] = new ImageIcon(dotIconStr.concat(".png"));
		Image origin = dotIcon[0].getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		dotIcon[0] = new ImageIcon(origin);
		dotIcon[1] = new ImageIcon(dotIconStr.concat("2.png"));
		Image origin2 = dotIcon[1].getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		dotIcon[1] = new ImageIcon(origin2);

		for (int i = 0; i < cardJbtn.length; i++) {
			cardJbtn[i] = new JButton(dotIcon[1]);
			cardJbtn[i].setPreferredSize(new Dimension(20, 20));
			cardJbtn[i].setContentAreaFilled(false);
			cardJbtn[i].setFocusPainted(false);
			cardJbtn[i].addActionListener(this);
			cardJbtn[i].setBorderPainted(false);
			jbtnJp.add(cardJbtn[i]);
		}
		rootCenter.add("North", jbtnJp);
		JPanel rootCenterSub = new JPanel(new BorderLayout());
		rootCenterSub.add("North", new JLabel("<html><font size = \"6\"; face = \"나눔고딕\">회원 목록</font></html>"));

		jtb = new JTable(m = IdDao.selectMember());

		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// TODO Auto-generated method stub
				JCheckBox jcb = new JCheckBox();
				jcb.setSelected(((Boolean) value).booleanValue());
				jcb.setHorizontalAlignment(SwingConstants.CENTER);
				return jcb;
			}
		};
		
		for (int i = 0; i < gradeStr.length; i++) {
			jcboxGrade.addItem(gradeStr[i]);
		}
		jtb.getColumn("등급").setCellEditor(new DefaultCellEditor(jcboxGrade));
		
		for (int i = 0; i < stateStr.length; i++) {
			jcboxState.addItem(stateStr[i]);
		}
		jtb.getColumn("회원상태").setCellEditor(new DefaultCellEditor(jcboxState));
		
		jtb.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 1) {
					row = jtb.getSelectedRow();
					column = jtb.getSelectedColumn();
//					setRow(jtb.getSelectedRow());
//					setColumn(jtb.getSelectedColumn());

					System.out.println(row + "..." + column);
//					jtb.isCellEditable(row, column);
//					jtb.setValueAt(jtb.editCellAt(row, column), row, column);

//					jtb.setValueAt(jtb.editCellAt(row, column), row, column);
//					IdDao.updateMember(row, column, 수정한거);
				}
			}

		});
		JScrollPane jsclTbl;
		rootCenterSub.add("Center",
				jsclTbl = new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		jsclTbl.setBorder(null);
		rootCenter.setBorder(null);
		rootCenter.add("Center", rootCenterSub);
//		jp[0].setBorder(null);
		jp[0].add("Center", rootCenter);
//		JPanel southJp0 = new JPanel(); // 다음페이지 버튼
//		southJp0.setBackground(Color.CYAN);
//		southJp0.add(applyJbtn = new JButton("적용"));
//		applyJbtn.addActionListener(this);
//		jp[0].add("South", southJp0);
		/////////////////////////////////

//		jtbp.add("<html><table width = '150'>현중</table><html>", new JPanel());
//		jtbp.add("<html><table width = '150'>민아</table><html>", new JPanel());
//		jtbp.add("<html><table width = '150'>나경</table><html>", new JPanel());
	}

	public AdminLayout4() {
		layOut();

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				cardJbtn[0].setIcon(dotIcon[0]);
				searchJcbSub.setEnabled(false);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				AdminLayout4.this.dispose();
			}

		});

		this.setBounds(0, 0, 1200, 800);
		this.setLocation(((d.width - this.getWidth()) / 2), ((d.height - this.getHeight()) / 2));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public static void main(String[] args) {

		new AdminLayout4();

	}
}