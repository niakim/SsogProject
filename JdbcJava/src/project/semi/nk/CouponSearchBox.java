package project.semi.nk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CouponSearchBox extends JFrame implements ActionListener {
	private JTextField jtf;
	private JButton jbtn;
	private JTable table;
	private nkJTableModel jtm;
	private JPanel jp, jpTitle;
	private JLabel jlbTitle, jlbSub;
	private PayLayout paylayout;

	private Font gothic1 = new Font("맑은 고딕", Font.PLAIN, 15);
	private Font gothic4 = new Font("맑은 고딕", Font.BOLD, 40);

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (jbtn == e.getSource()) {
			if (jtf.getText().length() == 0) {
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요^^");
				return;
			}
			CouponDao.selectZipCode(jtf.getText().trim(), table);
		}
	}

	public void initCouponLay() {
		jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.setBackground(new Color(10, 10, 10, 100));
		jpTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jpTitle.setBackground(new Color(242, 208, 144)); // SSOGyellow
		jpTitle.setPreferredSize(new Dimension(500, 100));
		jlbTitle = new JLabel("쏙 쿠폰 조회");
		jlbTitle.setFont(gothic4);
		jlbSub = new JLabel("※ 쏙 쿠폰 사용은 아이디를 입력한 후 확인 버튼을 클릭하시면 됩니다.");
		jlbSub.setFont(gothic1);
		jlbSub.setForeground(Color.gray);
		jpTitle.add(jlbTitle);
		jpTitle.add(jlbSub);

		LineBorder grayborder = new LineBorder(new Color(215, 215, 215));
		jp.add(jtf = new JTextField());
		jtf.setPreferredSize(new Dimension(200, 30));
		jtf.setFont(gothic1);
		jtf.setBorder(grayborder);
		jp.add(jbtn = new JButton("아이디 검색"));
		// jbtn.setBorderPainted(false);
		jbtn.setBackground(new Color(240, 240, 240));
		jbtn.setPreferredSize(new Dimension(130, 30));
		jbtn.setBorder(grayborder);
		jbtn.setFont(gothic1);

		jbtn.addActionListener(this);
		this.add("North", jpTitle);
		this.add("South", jp);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					int price = Integer.parseInt(table.getValueAt(row, 4).toString());
					// System.out.println(price);
					// paylayout.setWon2(Integer.toString(i));
					paylayout.getJlb4NonFixed()[2].setText(Integer.toString(price).concat(" 원"));
					paylayout.getJlb4NonFixed()[4].setText(Integer.toString(price).concat(" 원"));
					CouponSearchBox.this.dispose();

				}
			}
		});

		this.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
	}

	public CouponSearchBox(PayLayout paylayout) {
		this.paylayout = paylayout;

		initCouponLay();

		this.setBounds(100, 100, 500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/*
	 * public static void main(String[] args) { new CouponSearchBox(); }
	 */

}
