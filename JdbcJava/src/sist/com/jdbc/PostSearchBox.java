package sist.com.jdbc;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sist.com.dao.ZipcodeDao;
import sist.com.model.ZipcodeBean;

public class PostSearchBox extends JFrame implements ActionListener {
	private TextField tf;
	private JButton jbtn;
	private JTable table;
	private JTableModel jtm;
	private JPanel jp;
	private MemberView memberView;
	
	
	



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(jbtn==e.getSource()) {
			if(tf.getText().length()==0) {
				JOptionPane.showMessageDialog(this, "주소를 입력하세요.");
				return;
			}
			
			ZipcodeDao.selectZipCode(tf.getText().trim(),table);
			//jtm = new JTableModel(new Object[0][8]);
			/*table.setModel(jtm);
			*/
		}
	}


	public void initPostLay() {
		jp = new JPanel();
		jp.add(tf = new TextField(30));
		jp.add(jbtn = new JButton("검색"));
		jbtn.addActionListener(this);
		this.add("North",jp);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2) {
					int row=table.getSelectedRow();
					ZipcodeBean bean=(ZipcodeDao.selectBean(ZipcodeDao.getSeq(row)));
					memberView.getTf()[0].setText(bean.getZipcode().split("-")[0]);
					memberView.getTf()[1].setText(bean.getZipcode().split("-")[1]);
					memberView.getTf()[2].setText(bean.getSido()+bean.getGugu()+bean.getDong());
					PostSearchBox.this.dispose();
					
				}

			}
			
			
		});
		this.add(new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
	}
	
	
	public PostSearchBox(MemberView memberView) {
		this.memberView = memberView;
		initPostLay();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				PostSearchBox.this.dispose();
			}
			
			
			
			
		});
		this.setBounds(350, 250, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

/*	public static void main(String[] args) {
		new PostSearchBox();
	}*/

}