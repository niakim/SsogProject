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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultEditorKit.PasteAction;

import project.semi.nk.CrudLogin;



public class SearchPassOk extends JFrame {

	protected static final Component SearchPassOk = null;
	private String PATH = "C:\\Users\\SIST\\Dropbox\\나경 JAVA\\조별 Project\\2.CRUD(19.03.08)\\IMG\\crudimg\\";
	private String imgStr = "back3.jpg";
	private ImageIcon backImg;

	private JPanel passPanel;

	private String lbStr[] = { "비밀번호 등록", "아이디 찾기 본인 인증에 성공하셨습니다." };
	private JLabel passLabel[] = new JLabel[lbStr.length];

	private String tfStr[] = { "비밀번호", "비밀번호 확인", "주의해 주세요.",
			"<html>· 비밀번호는 영문과 숫자를 조합하여 8~20자리로 입력해 주세요.<br><br>· 아이디와 같은 비밀번호나 주민등록번호, 생일, 학번, 전화번호 등 개인정보와 관련된 숫자, 연속된 숫자, 동일 반복된 숫자 등 다른 사람이 쉽게 알아낼 수 있는 비밀번호는 사용하지 않도록 주의하여 주시기 바랍니다.</html>"};
	private JLabel tfLabel [] = new JLabel[tfStr.length];
	private JTextField passTf [] = new JTextField[tfStr.length];
	
	private ImageIcon img = new ImageIcon(PATH + "중요.png");
	private JLabel imgLb;
	
	private JButton idBt;

	private JLabel okLabel[] = new JLabel[2];

	SsgBean bean;

	int random;
	String number;
	String pass;
	String id;

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

		passPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stubx

				if (backImg != null) {
					g.drawImage(backImg.getImage(), 0, 0, this);
				}
			}
		};

		passPanel.setLayout(null);

		for (int i = 0; i < lbStr.length; i++) {
			passLabel[i] = new JLabel(lbStr[i]);
			passPanel.add(passLabel[i]);
		}

		passLabel[0].setFont(new Font("맑은 고딕", Font.BOLD, 30));
		passLabel[0].setBounds(130, 5, 300, 60);
		passLabel[0].setForeground(Color.darkGray);

		passLabel[1].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		passLabel[1].setForeground(Color.darkGray);
		passLabel[1].setBounds(135, 55, 600, 30);


		for (int i = 0; i < tfStr.length-2; i++) {
			tfLabel[i] = new JLabel(tfStr[i]);
			passTf[i] = new JTextField();
			passTf[i].setBounds(40, 170 + (90 * i), 405, 50);
			passTf[i].setBorder(null);
			passTf[0].setBackground(Color.red);
			passTf[i].setOpaque(false);
			tfLabel[i].setBounds(40, 140 + (90 * i), 600, 30);
			tfLabel[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			tfLabel[i].setOpaque(false);
			passPanel.add(tfLabel[i]);
			passPanel.add(passTf[i]);
		}

		imgLb = new JLabel(img);
		imgLb.setBounds(40, 416, 30, 30);
		passPanel.add(imgLb);
	
		tfLabel[2] = new JLabel(tfStr[2]);
		tfLabel[2].setBounds(70, 380, 405, 100);
		tfLabel[2].setFont(new Font("맑은 고딕", Font.BOLD, 15));
		tfLabel[2].setForeground(Color.DARK_GRAY);
		passPanel.add(tfLabel[2]);

		tfLabel[3] = new JLabel(tfStr[3]);
		tfLabel[3].setBounds(40, 450, 405, 100);
		tfLabel[3].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tfLabel[3].setForeground(Color.DARK_GRAY);
		passPanel.add(tfLabel[3]);

		idBt = new JButton("확인");
		idBt.setBorderPainted(false);
		idBt.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		idBt.setBounds(40, 320, 405, 50);
		passPanel.add(idBt);

		idBt.setBackground(new Color(125, 28, 48));
		idBt.setForeground(Color.white);
		idBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (passTf[0].getText().equals(passTf[1].getText())) { //비밀번호와 비밀번호 확인이 같다.
					SsgDao.modifyPass(passTf[0].getText(), pass, id);
					
				} else {
					JOptionPane.showMessageDialog(SearchPassOk, "비밀번호가 다릅니다.", "비밀번호 에러",JOptionPane.INFORMATION_MESSAGE);
				}

				if (SsgDao.getInstance().checkPass(passTf[0].getText(),id)) {
					JOptionPane.showMessageDialog(SearchPassOk, "비밀번호가 변경되었습니다.", "비밀번호 변경",JOptionPane.INFORMATION_MESSAGE);
					SearchPassOk.this.dispose();
					new CrudLogin();
				} else {
				}
			}
		});

		this.add(passPanel);

	}

	public SearchPassOk(String pass, String id) {
		super("비밀 번호 찾기");
		this.pass = pass;
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

		this.setBounds(0, 0, 500, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

/*	public static void main(String[] args) {
		new SearchPassOk("비번쓰");
	}*/
}
