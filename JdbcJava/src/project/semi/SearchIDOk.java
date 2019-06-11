package project.semi;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
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



public class SearchIDOk extends JFrame {

	private String PATH = "C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\";
	private String imgStr = "back.jpg";
	private ImageIcon backImg;

	private JPanel idPanel;

	private String lbStr[] = { "아이디 찾기 완료", "아이디 찾기 본인 인증에 성공하셨습니다." };
	private JLabel idLabel[] = new JLabel[lbStr.length];

	private String btStr[] = { "로그인 하기", "비밀번호 찾기" };
	private JButton idBt[] = new JButton[btStr.length];

	private String id;
	private String date;

	private JLabel okLabel[] = new JLabel[2];

	SsgBean bean;

	int random;
	String number;

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

		for (int i = 0; i < lbStr.length; i++) {
			idLabel[i] = new JLabel(lbStr[i]);
			idPanel.add(idLabel[i]);
		}

		idLabel[0].setFont(new Font("맑은 고딕", Font.BOLD, 30));
		idLabel[0].setBounds(130, 5, 300, 60);
		idLabel[0].setForeground(Color.darkGray);

		idLabel[1].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		idLabel[1].setForeground(Color.darkGray);
		idLabel[1].setBounds(135, 55, 600, 30);

		JPanel centerPanel[] = new JPanel[2];

		for (int i = 0; i < okLabel.length; i++) {
			okLabel[i] = new JLabel();
			centerPanel[i] = new JPanel();
			centerPanel[i].setBackground(Color.white);
			okLabel[i].setForeground(Color.GRAY);
			idPanel.add(centerPanel[i]);
		}

		centerPanel[0].setBounds(0, 170, 500, 30);
		centerPanel[1].setBounds(0, 200, 500, 30);

		okLabel[0].setText(id);
		okLabel[0].setFont(new Font("맑은 고딕", Font.BOLD, 18));

		okLabel[1].setText("(가입일: 2012.08.25)");
		okLabel[1].setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		centerPanel[0].add(okLabel[0]);
		centerPanel[1].add(okLabel[1]);

		for (int i = 0; i < btStr.length; i++) {
			idBt[i] = new JButton(btStr[i]);
			idBt[i].setForeground(Color.WHITE);
			idBt[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			idBt[i].setBounds(40 + (210 * i), 300, 195, 50);
			idPanel.add(idBt[i]);
		}

		idBt[0].setBackground(new Color(232, 232, 232));
		idBt[0].setForeground(Color.gray);
		idBt[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("로그인 화면으로");

			}
		});

		idBt[1].setBackground(new Color(125, 28, 48));
		idBt[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new SearchPass();

			}
		});
		idBt[0].setBorderPainted(false);

		this.add(idPanel);

	}

	public SearchIDOk(String id) {
		super("아이디 찾기");
		this.id=id;
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

		this.setBounds(0, 0, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

/*	public static void main(String[] args) {
		new SearchIDOk();
	}*/
}
