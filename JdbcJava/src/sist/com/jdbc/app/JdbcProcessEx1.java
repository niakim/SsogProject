package sist.com.jdbc.app;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import sist.com.dao.TableAccessDao;

public class JdbcProcessEx1 extends JFrame  implements ActionListener{
	private JTextArea jta;
	private JButton jbtn;
	private JTable jtable;
	private JPanel jpan,jpan2,jpan3;
	
	
	
	public JTable getJtable() {
		return jtable;
	}
	public void setJtable(JTable jtable) {
		this.jtable = jtable;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TableAccessDao.selectAccess(this, jta.getText());
		
	}
	public void initTable() {
		jpan=new JPanel();
		jpan.add(new JScrollPane(jta=new JTextArea(5, 35),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		jpan.add(jbtn=new JButton("Query"));
		jbtn.addActionListener(this);
		this.add("North",jpan);	
		jtable=new JTable();
		this.add(new JScrollPane(jtable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
	}
	public JdbcProcessEx1() {
		initTable();
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JdbcProcessEx1();

	}

}
