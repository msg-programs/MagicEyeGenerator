// File is part of MagicEyeGenerator (c) msg-programs 2020, see LICENSE

package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Display extends JPanel {

	private static final long serialVersionUID = 1L;
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
		this.setSize(buf.getWidth(), buf.getHeight());
	}
}
