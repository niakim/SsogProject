package project.semi.nk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PayLayoutSuccess extends JFrame implements ActionListener {

	private Font gothic1 = new Font("맑은 고딕", Font.PLAIN, 12); // 라벨에 쓰일 글씨체
	private Font gothic2 = new Font("맑은 고딕", Font.BOLD, 20); // 라벨에 쓰일 글씨체
	private Font gothic3 = new Font("맑은 고딕", Font.BOLD, 25); // 라벨에 쓰일 글씨체
	private Font gothic4 = new Font("맑은 고딕", Font.BOLD, 40); // 라벨에 쓰일 글씨체

	private JPanel jp1, jp2, jp3;
	private JLabel jlbPayNum1, jlbPayNum2;
	private String[] jlb1Str = { "박진영님 결제완료 되었습니다.", "SSOG을 이용해주셔서 감사합니다.",
			"※ 구매하신 물품에 대한 문의사항이 있으시다면 고객센터 1234-4568로 문의바랍니다.", "※ 구매하신 수단 및 상품에 대한 변경은 상품 출고 전에 가능합니다." };
	private JLabel[] jlb1 = new JLabel[jlb1Str.length];
	private JButton jbtnOut;

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public JLabel[] getJlb1() {
		return jlb1;
	}

	public void setJlb1(JLabel[] jlb1) {
		this.jlb1 = jlb1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (jbtnOut == source) {
			PayLayoutSuccess.this.dispose();
		}

	}

	public void iniLayout() {
		jp1 = new JPanel(); // 배경 패널!
		jp1.setLayout(null);

		jbtnOut = new JButton("메인 화면으로");
		jbtnOut.setFont(gothic3);
		jbtnOut.setBackground(new Color(168, 39, 53));
		jbtnOut.setForeground(Color.white);
		jbtnOut.setBounds(350, 650, 700, 65);
		jbtnOut.addActionListener(this);
		jbtnOut.setBorderPainted(false);
		jbtnOut.setFocusPainted(false);
		jbtnOut.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnOut.setBackground(Color.black);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jbtnOut.setBackground(new Color(168, 39, 53));
			}
		});

		jp2 = new JPanel(); // 흰색 패널!
		jp2.setLayout(null);
		jp2.setBackground(Color.white);
		jp2.setBounds(350, 300, 700, 400);

		jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 노란 패널!
		jp3.setBackground(new Color(242, 208, 144));
		jp3.setBounds(0, 0, 700, 100);
		jlbPayNum1 = new JLabel("　　　　　　　　　　주문번호　　　　　　　　　　");
		jlbPayNum1.setFont(gothic3);
		// jlbPayNum1.setBounds(0,0,600,50);
		// 주문번호 랜덤생성 (ss+오늘날짜+랜덤숫자);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
		int ran = (int) (Math.random() * 9999 + 1);
		String orderNum = "S" + strToday + "-" + ran;
		jlbPayNum2 = new JLabel(orderNum);
		jlbPayNum2.setFont(gothic3);
		// jlbPayNum2.setBounds(100,90,600,50);

		jp3.add(jlbPayNum1);
		jp3.add(jlbPayNum2);
		jp2.add(jp3);

		for (int i = 0; i < jlb1.length; i++) {
			jlb1[i] = new JLabel(jlb1Str[i]);
			jp2.add(jlb1[i]);
			jlb1[i].setHorizontalAlignment(SwingConstants.CENTER);
			if (i == 0) {
				jlb1[i].setFont(gothic4);
			} else if (i == 1) {
				jlb1[i].setFont(gothic2);

			} else {
				jlb1[i].setFont(gothic1);
				jlb1[i].setHorizontalAlignment(SwingConstants.LEFT);
				jlb1[i].setForeground(Color.gray);
			}
		}
		jlb1[1].setBounds(100, 95, 500, 100);
		jlb1[0].setBounds(0, 165, 700, 100);
		jlb1[2].setBounds(80, 240, 500, 100);
		jlb1[3].setBounds(80, 260, 500, 100);

		jp1.add(jp2);
		jp1.add(jbtnOut);

		this.add(jp1);

	}

	public PayLayoutSuccess() {
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
				PayLayoutSuccess.this.dispose();
			}
		});

		this.setUndecorated(true);
		this.setBounds((d.width / 4)-78, 0, (d.width - (d.width / 4))+78, d.height);// (d.height / 3 * 2) + d.height / 3 * 2
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}

//	public static void main(String[] args) {
//
//		new PayLayoutSuccess();
//
//	}
}
