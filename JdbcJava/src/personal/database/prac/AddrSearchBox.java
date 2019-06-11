package personal.database.prac;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AddrSearchBox extends JFrame implements ActionListener{

	public AddrSearchBox() {
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				AddrSearchBox.this.dispose();
			}
			
			
			
			
		});
		this.setBounds(1200, 100, 500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public static void main(String[] args) {
		new AddrSearchBox();
	}
}
