/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hci.spring.training.pkg2016.task.pkg2;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author marcw
 */
public class ImageGUI extends JPanel {

	JLabel IMG;
	String imageloc;
	Image image;

	public ImageGUI(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public ImageGUI(LayoutManager layout) {
		super(layout);
	}

	public ImageGUI(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public ImageGUI() {
		super();
		IMG = new JLabel();
		add(IMG);
	}

	public void setImage(String imageloc) {
		this.imageloc = imageloc;
		ImageIcon newIcon = new ImageIcon(imageloc);
		image = newIcon.getImage(); // transform it 
		paint();
		this.repaint();
	}
//GrayScaleIMG

	public void paint() {
		if (image != null) {
			IMG.setIcon(new ImageIcon(image.getScaledInstance(this.getWidth(), this.getHeight(), java.awt.Image.SCALE_SMOOTH)));
			IMG.setBounds(0, 0, this.getWidth(), this.getHeight());
		}
	}

	@Override
	public void paint(Graphics g) {
		paint();
		super.paint(g);
	}

}
