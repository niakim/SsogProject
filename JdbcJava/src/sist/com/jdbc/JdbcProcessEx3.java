package sist.com.jdbc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sist.com.dao.DemoDao;
import sist.com.model.EmpBean;

//1.EMP 2.STUDENT
//window10과 흡사
public class JdbcProcessEx3 extends JFrame {
	
	JScrollPane jsp;
	JTable jTable;
	JTableModel jTableModel = new JTableModel();
	Object [][]data;
	JLabel jLabel = new JLabel(" ");
	
	
	
	
	public void setEmp() {
		List<EmpBean>list = DemoDao.selectEMP();
		data = new Object[list.size()][jTableModel.getColumnCount()];
		
		for(int i=0; i<data.length; i++) {
			int j=0;
			EmpBean bean = list.get(i);
			data[i][j++]=bean.getEmpno();
			data[i][j++]=bean.getEname();
			data[i][j++]=bean.getJob();
			data[i][j++]=bean.getMgr();
			data[i][j++]=bean.getHiredate();
			data[i][j++]=bean.getSal();
			data[i][j++]=bean.getComm();
			data[i][j++]=bean.getDeptno();
		}
		jTableModel.setData(data);
	}
	
	public void initLay() {
		jsp = new JScrollPane(jTable = new JTable(jTableModel=new JTableModel(new Object[10][8])));
		jTable.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = jTable.getSelectedRow();
				if(e.getClickCount()==2) {
					//int col = jTable.getSelectedColumn();
					int empno = (int)jTableModel.getValueAt(row, 0);
					EmpBean b=DemoDao.selectEmpInfo(empno);
					jLabel.setText(b.getEmpno()+" "+b.getEname());
				}
			}
		});
		
		this.add(jsp);
		setEmp(); //위치에 따라서 결과값이 안나올수있당.
		this.add("South",jLabel);//얘만 추가해줘도 밑에 결과값이 뜬다.
	}
	
	
	
	public JdbcProcessEx3() {
		initLay();
		this.setBounds(100,100,500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		
		
	}
	
	
	public static void main(String[] args) {
		//System.out.println(DemoDao.selectEMP());
		new JdbcProcessEx3();
	}
}
