package project.semi.nk;
//로그인창

//회원가입
//
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import project.semi.IdDao;
import project.semi.LayOut;
import project.semi.Member;
import project.semi.SearchPass;
import project.semi.SetStyle;
import project.semi.SignUpLayout;

public class CrudLogin extends JFrame implements ActionListener {
	private Image loginimg = Toolkit.getDefaultToolkit().createImage(
			"C:\\Users\\Nia\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\코드\\NK\\crudimg7\\SSOGLOGIN.gif");
//	private Image loginimg = Toolkit.getDefaultToolkit().createImage(
//			"/Users/y/Dropbox/나경 JAVA/조별 Project/2.CRUD(19.03.08)/코드/NK/crudimg7/SSOGLOGIN.gif");
	private JPanel jp1, jp2, jp3, jp4, jp5, jp6;
	// jp1 배경패널 , jp2 기능패널(jp3+jp4),jp3 ID입력, jp4 PW입력, jp5 버튼패널, jp6 jlabel
	// (아이디비번잊었쇽?)
	JLabel jlbId, jlbPw, jlbLoss;
	JTextField tfid;
	SetStyle setColor = new SetStyle();
	LineBorder redBorder = new LineBorder(new Color(125, 28, 48), 1);
	JPasswordField jps;
	private JButton jbtnLogin, jbtnJoin;
	String[] logInfo = new String[3];

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == jbtnLogin || e.getActionCommand().equals("login")) {
			boolean idCheck = IdDao.searchId(tfid.getText().trim());
			boolean pwCheck = IdDao.pwCheck(tfid.getText().trim(), jps.getText().trim());
			if (idCheck == true && pwCheck == true) {
				Member m = IdDao.searchName(tfid.getText().trim());
				logInfo[0] = m.getId();
				logInfo[1] = m.getPw();
				logInfo[2] = m.getName();
				new LayOut(logInfo[0], logInfo[1], logInfo[2]);
				CrudLogin.this.dispose();
			} else if (idCheck == true && pwCheck == false) {
				JOptionPane.showMessageDialog(CrudLogin.this, "<html><div color=red>비밀번호를 다시 확인해주세요.",
						"저런... 다시 잘 생각해봐요.", JOptionPane.WARNING_MESSAGE);
				jps.setText("");
			} else {
				JOptionPane.showMessageDialog(CrudLogin.this, "<html><div color=red>회원이신가요...?", "저런... 다시 잘 생각해봐요.",
						JOptionPane.WARNING_MESSAGE);
				tfid.setText("");
				jps.setText("");
			}
		}

		if (source == jbtnJoin) {
			new SignUpLayout();
		}
	}

	public void mainLay() {
		jp1 = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				if (loginimg != null) {
					g.drawImage(loginimg, 0, 0, this);
				}
			}
		};
		jp1.setLayout(null);

		jp2 = new JPanel(new GridLayout(2, 1));
		jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3.add(jlbId = new JLabel("   ID"));
		jlbId.setForeground(Color.white);
		jp3.add(tfid = new JTextField(19));
		// Font fontField = new Font("Arial", Font.BOLD, 12);//
		// tfid.setFont(fontField);//
		// tfid.setColumns(19);//
		tfid.registerKeyboardAction(this, "login", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		tfid.setOpaque(false);
		tfid.setForeground(Color.white);
		jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp4.add(jlbPw = new JLabel("PW"));
		jlbPw.setForeground(Color.white);
		jp4.add(jps = new JPasswordField(19));
		jps.registerKeyboardAction(this, "login", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		jps.setOpaque(false);
		jps.setForeground(Color.white);

		jp5 = new JPanel(new GridLayout(1, 3));
		jp5.add(jbtnLogin = new JButton("Login"));
		jp5.add(jbtnJoin = new JButton("Join"));
		jbtnLogin.setActionCommand("login");
		jbtnLogin.addActionListener(this);
		jbtnJoin.addActionListener(this);
		// setColor.setStyle(jbtnJoin, Color.darkGray);
		jbtnJoin.setForeground(Color.white);
		jbtnLogin.setForeground(Color.white);
		jbtnJoin.setBorder(redBorder);
		jbtnLogin.setBorder(redBorder);
		jbtnJoin.setBackground(new Color(245, 245, 245, 30));
		jbtnLogin.setBackground(new Color(245, 245, 245, 30));

		jp6 = new JPanel();
		jp6.add(jlbLoss = new JLabel("비밀번호를 잊어버리셨나요?"));
		jlbLoss.setForeground(Color.LIGHT_GRAY);
		jlbLoss.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 커서모양 변경

		jlbLoss.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new SearchPass();
			}
		});

		jp2.setOpaque(false);
		jp3.setOpaque(false);
		jp4.setOpaque(false);
		jp5.setOpaque(false);
		jp6.setOpaque(false);

		jp2.setBounds(59, 420, 270, 60);
		jp5.setBounds(87, 500, 216, 30);
		jp6.setBounds(85, 550, 220, 30);

		jp2.add(jp3);
		jp2.add(jp4);

		jp1.add(jp2);
		jp1.add(jp5);
		jp1.add(jp6);
		this.add(jp1);
	}

	public CrudLogin() {
		super("ㅆㅗㄱ");
		mainLay();

		this.setBounds(100, 100, 415, 689);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CrudLogin();
	}
}