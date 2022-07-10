package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Display extends JPanel {

	BufferedImage img = null;

	public Display(BufferedImage i) {
		super();
		img = i;
		this.setSize(i.getWidth(), i.getHeight());
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, null, 0, 0);
	}
}
