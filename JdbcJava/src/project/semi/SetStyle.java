package project.semi;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class SetStyle {
	Color track = new Color(240, 240, 240);
	Color bar = new Color(205, 205, 205);
	Color arrow = new Color(96, 96, 96);
	Color ssogYellow = new Color(241, 207, 143);
	Color ssogRed = new Color(125, 28, 48);
	Color lightGray = new Color(232, 232, 232);
	Color darkGray = new Color(87, 89, 89);
	String nanum = "나눔고딕";

	public void setStyle(JLabel jlb, Color bg) {
		jlb.setOpaque(true);
		jlb.setBackground(bg);
	}

	public void setStyle(JLabel jlb, boolean opaque) {
		jlb.setOpaque(opaque);
		jlb.setBackground(Color.PINK);
	}

	public void setStyle(JLabel jlb, boolean opaque, Color fg) {
		jlb.setOpaque(opaque);
		jlb.setBackground(Color.PINK);
		jlb.setForeground(fg);
	}

	public void setStyle(JLabel jlb, boolean opaque, Color fg, String name, int style, int size) {
		jlb.setOpaque(opaque);
		jlb.setBackground(Color.PINK);
		jlb.setForeground(fg);
		jlb.setFont(new Font(name, style, size));
	}

	public void setStyle(JLabel jlb, boolean opaque, Color fg, Color bg, String name, int style, int size) {
		jlb.setOpaque(opaque);
		jlb.setBackground(bg);
		jlb.setForeground(fg);
		jlb.setFont(new Font(name, style, size));
	}

	public void setStyle(JLabel jlb, boolean opaque, Color fg, String name, int style, int size, int alignment) {
		jlb.setOpaque(opaque);
		jlb.setBackground(Color.PINK);
		jlb.setForeground(fg);
		jlb.setFont(new Font(name, style, size));
		jlb.setHorizontalAlignment(alignment);
	}

	public void setStyle(JButton jlb, Color bg) {
		jlb.setOpaque(true);
		jlb.setBackground(bg);
		jlb.setBorderPainted(false);
	}

	public void setStyle(JButton jlb, Color bg, Color fg) {
		jlb.setOpaque(true);
		jlb.setBackground(bg);
		jlb.setForeground(fg);
		jlb.setBorderPainted(false);
	}

	public void setStyle(JButton jlb, Color fg, String name, int style, int size) {
		jlb.setOpaque(true);
		jlb.setForeground(fg);
		jlb.setBorderPainted(false);
		jlb.setFont(new Font(name, style, size));
	}

	public void setStyle(JButton jlb, Color bg, Color fg, String name, int style, int size) {
		jlb.setOpaque(true);
		jlb.setBackground(bg);
		jlb.setForeground(fg);
		jlb.setBorderPainted(false);
		jlb.setFont(new Font(name, style, size));
	}

	public void setStyle(JButton jlb, Color bg, Color fg, String name, int style, int size, Color borderColor,
			int thickness) {
		jlb.setBackground(bg);
		jlb.setForeground(fg);
		jlb.setFont(new Font(name, style, size));
		jlb.setBorder(new LineBorder(borderColor, thickness));
	}

	public void setStyle(JCheckBox jlb, Color bg, String name, int style, int size) {
		jlb.setBackground(bg);
		jlb.setFont(new Font(name, style, size));
	}
}
