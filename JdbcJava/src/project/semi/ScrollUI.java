package project.semi;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

// http://egloos.zum.com/tobby48/v/2803133
public class ScrollUI extends BasicScrollBarUI {
	SetStyle s = new SetStyle();

	@Override
	protected void configureScrollBarColors() {
		// TODO Auto-generated method stub
		thumbColor = s.bar;
//		thumbDarkShadowColor = Color.DARK_GRAY;
//		thumbHighlightColor = new Color(0xffccff);
//		thumbLightShadowColor = Color.LIGHT_GRAY;
		trackColor = s.track;
		trackHighlightColor = Color.WHITE;
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		// TODO Auto-generated method stub
//		JButton b = new BasicArrowButton(direction, background, shadow, darkShadow, highlight)
		JButton button = new BasicArrowButton(orientation, s.track, s.track, s.track, s.track);
		return button;
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		// TODO Auto-generated method stub
		JButton button = new BasicArrowButton(orientation, s.track, s.track, s.track, s.track);
		return button;
	}
}
