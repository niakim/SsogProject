package sist.com.jdbc.app;
//18.12.11 JTree 
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class WindowEx12 extends JFrame implements TreeSelectionListener {

	Object[] gen = { "Programe", "System", "Design" };
	JTree jTree;
	JScrollPane jsp;
	Vector<Vector<String>> node1 = new Vector<Vector<String>>() {
		
		@Override
		public  String toString() {
			// TODO Auto-generated method stub
			return "JYP";
		}

	};
	Vector<String> node2 = new Vector<String>() {

		@Override
		public  String toString() {
			// TODO Auto-generated method stub
			return "GIRL";
		}

	};
	Vector<String> node3 = new Vector<String>() {

		@Override
		public  String toString() {
			// TODO Auto-generated method stub
			return "BOY";
		}

	};

	
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {

  	String msg=e.getNewLeadSelectionPath().getLastPathComponent().toString();
  	if(msg.equals("WonderGirls")) {
  		new WindowEx12();
  	}
  	if(msg.equals("MissA")) {
  		this.dispose();
  	}

	}

	String[][] strNode = { { "WonderGirls", "MissA", "Twice"}, { "Got7", "Day6", "2pm"} };

	public void addTreeNode(Vector<String> node, int index) {
		for (String s : strNode[index]) {
			node.add(s);
		}

	}

	public void initTree() {
		node1.addElement(node2);
		node1.addElement(node3);
		
		node2.addElement("WonderGirls");
		node2.addElement("MissA");
		node2.addElement("Twice");
		
		node3.addElement("www");
		
		addTreeNode(node2, 0); //위에와 같은 것을 배열과 포문으로 빼고 이렇게 간략하게 정리함.
		addTreeNode(node3, 1);

		gen[0] = node1;

		jsp = new JScrollPane(jTree = new JTree(gen));
		jTree.addTreeSelectionListener(this);
		jTree.setRootVisible(true);
		this.add(jTree);

	}

	public WindowEx12() {
		initTree();
		System.out.println(node1);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// WindowEx12 w=new WindowEx12();
		new WindowEx12();
	}

}
