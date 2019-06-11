package personal.database.tested;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sist.com.dao.ZipcodeDao;

public class IdCheckBox77 extends JFrame {
	private JPanel panel,panel2;
	private TextField tfId;
	private JButton jbtnId;
	private boolean flag;
	private JLabel label;
	private MemberView77 memberView;
	
	public void initIdLay() {
		panel2=new JPanel(new GridLayout(3,1));
		panel = new JPanel();
		panel.add(tfId = new TextField(20));
		tfId.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				tfId.setText("");//�ؽ�Ʈ�ʵ� Ŭ���ϸ� ����
			}
		});
		panel.add(jbtnId = new JButton("Search"));
		jbtnId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean flag = ZipcodeDao.idCheckBoolean(tfId.getText());
				label.setText(flag?"�̹� ������Դϴ� �ٸ����̵� �Է��ϼ���.":"��밡���� ���̵��Դϴ�.");
			}
		});

		panel2.add(new JLabel(" "));
		panel2.add(panel);
		panel2.add(label = new JLabel("ID�� �Է��ϼ���!"));
		label.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(!flag) {
					memberView.getTfLogin().setText(tfId.getText());
					IdCheckBox77.this.dispose(); //��밡���ϸ� â ������ ���ֱ�.through ��
					
				}
			}
			
			
			
		});
		this.add("North",panel2);
	}
	
	public IdCheckBox77(MemberView77 memberView) {
		super("���̵� �ߺ� üũ");
		this.memberView = memberView;
		initIdLay();
		this.setBounds(350, 250, 300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

/*	public static void main(String[] args) {
		new IdCheckBox();
	}*/

}