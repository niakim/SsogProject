package project.semi;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AdminTabbedPaneUI extends javax.swing.plaf.basic.BasicTabbedPaneUI {
	SetStyle s = new SetStyle();

	@Override
	protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
			boolean isSelected) {
		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, w, h);
	}

	@Override
	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
			boolean isSelected) {
		// TODO Auto-generated method stub
//		g.setColor(Color.BLACK);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x, y, w, h);
	}

	@Override
	protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
	}

}
