package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Display extends JPanel {

	BufferedImage img = null;

	public Display() {
		super();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, null, 0, 0);
	}

	public void setImage(BufferedImage buf) {
		img = buf;
		this.setSize(buf.getWidth(), buf.getHeight())	;
		}
}
