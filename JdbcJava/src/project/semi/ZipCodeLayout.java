package project.semi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class ZipCodeLayout extends JFrame implements ActionListener {
	private JPanel[] jp = new JPanel[4];
	private JTextField jtf;
	private JLabel jlb;
	private JButton jbt;
	private JTable jtb;
	private SignUpLayout signUp;

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == jbt || e.getActionCommand().equals("search")) {
			if (jtf.getText().length() == 0) {
				JOptionPane.showMessageDialog(this, "동을 입력하세요.");
				return;
			} else {
				ZipCodeDao.searchZipCode(jtf.getText().trim(), jtb);
			}
		}
	}

	public void layOut() {
		jp[0] = new JPanel(new BorderLayout());
		jp[1] = new JPanel();
		jp[2] = new JPanel(new BorderLayout());
		jp[3] = new JPanel();

		jtf = new JTextField(15);
		jtf.registerKeyboardAction(this, "search", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		jbt = new JButton("검색");
		jbt.addActionListener(this);
		jbt.setActionCommand("search");
		jbt.setBackground(Color.DARK_GRAY);
		jbt.setForeground(Color.WHITE);
		jlb = new JLabel("도로명주소를 입력하세요.");
		jlb.setHorizontalAlignment(SwingConstants.CENTER);
		jtb = new JTable();
		jtb.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) {
					int row = jtb.getSelectedRow();
					ZipCodeBean bean = ZipCodeDao.selectBean((String) jtb.getValueAt(row, 0));
					signUp.getJtf()[9].setText(bean.getZipcode());
					signUp.getJtf()[10].setText(bean.getSido() + " " + bean.getSigungu() + " " + bean.getDoro());
					ZipCodeLayout.this.dispose();
				}
			}
		});

		jp[1].add(jtf);
		jp[1].add(jbt);
		jp[2].add("North", jlb);
		jp[2].add(
				new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		jp[1].setBackground(Color.WHITE);
		jp[2].setBackground(Color.WHITE);

		jp[0].add("North", jp[1]);
		jp[0].add(jp[2]);

		this.add(jp[0]);
	}

	public ZipCodeLayout(SignUpLayout signUp) {
		layOut();

		this.signUp = signUp;

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
				ZipCodeLayout.this.dispose();
			}
		});

		this.setBounds(0, 0, 800, 300);
		this.setLocation(((d.width - this.getWidth()) / 2), ((d.height - this.getHeight()) / 2));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
