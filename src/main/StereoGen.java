package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class StereoGen {

	private static BufferedImage img = null;
	private static BufferedImage txt = null;

	private static boolean error = false;

	public static boolean setImage(File f) {
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public static boolean setTexture(File f) {
		try {
			txt = ImageIO.read(f);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public static BufferedImage render(String s, String d, String c,  boolean doInvert) {

		error = false;

		float scale = 1f / parseScale(s);
		float cont = parseContrast(c);
		int displ = parseDispl(d);
		
		if (txt == null) {
			JOptionPane.showMessageDialog(null, "Select a texture first!", "Error", JOptionPane.ERROR_MESSAGE);
			error = true;
		}

		if (img == null) {
			JOptionPane.showMessageDialog(null, "Select a displacement map first!", "Error", JOptionPane.ERROR_MESSAGE);
			error = true;
		}
		
		if (error) {
			return null;
		}
		
		BufferedImage res = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		BufferedImage txtSized = resizeImg(txt, (int)(txt.getWidth()*scale), (int)(txt.getHeight()*scale));
		
		BufferedImage vSlice = new BufferedImage(txtSized.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = vSlice.createGraphics();
		
		for (int y = 0; y<vSlice.getHeight(); y+=txtSized.getHeight()) {
			g2d.drawImage(txtSized, null, 0, y);
		}	
		
		g2d.dispose();
		
		g2d = res.createGraphics();
		
		int sliceW = vSlice.getWidth();
		
		for (int sliceNo = 0; sliceNo < (res.getWidth() / sliceW) +1; sliceNo++) {
			for (int x = 0; x<vSlice.getWidth(); x++) {
				for (int y = 0; y<vSlice.getHeight(); y++) {
					try {
					int displAtMap = (img.getRGB(x+sliceNo*sliceW, y)>> 16) & 0xFF; // red channel
					if (doInvert) {
						displAtMap = 255- displAtMap;
					}
					displAtMap = (int)((((((float)displAtMap/255f) - 0.5f) * cont) + 0.5f) * 255f);
					displAtMap = Math.max(0, Math.min(displAtMap,255));
					int displace = (int)(((float)displAtMap/255f) * displ);
					int colAtDispl = vSlice.getRGB((x+displace) %sliceW , y);
					vSlice.setRGB(x, y, colAtDispl);
//					res.setRGB(x+sliceNo*sliceW,y,new Color(displAtMap,displAtMap,displAtMap).getRGB());
					} catch (ArrayIndexOutOfBoundsException e) {
						
					}
				}
			}
			g2d.drawImage(vSlice, null, sliceNo*sliceW, 0);
		}
		return res;
	}
	
	 private static float parseContrast(String s) {
		 if (s == null) {
				JOptionPane.showMessageDialog(null, "Enter a contrast first!", "Error", JOptionPane.ERROR_MESSAGE);
				error = true;
				return 0;
			}

			try {
				float scale = Float.parseFloat(s);
				return scale;
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Invalid float in contrast factor!", "Error", JOptionPane.ERROR_MESSAGE);
				return 0;
			}
	}

	private static BufferedImage resizeImg(BufferedImage img, int newW, int newH) {
	        int w = img.getWidth();
	        int h = img.getHeight();
	        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
	        Graphics2D g = dimg.createGraphics();
	        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
	        g.dispose();
	        return dimg;
	    }

	private static int parseDispl(String s) {
		if (s == null) {
			JOptionPane.showMessageDialog(null, "Enter a displacement first!", "Error", JOptionPane.ERROR_MESSAGE);
			error = true;
			return 0;
		}

		try {
			int displ = Integer.parseInt(s);
			return displ;
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Invalid int in displacement factor!", "Error",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}

	private static float parseScale(String s) {
		if (s == null) {
			JOptionPane.showMessageDialog(null, "Enter a scale first!", "Error", JOptionPane.ERROR_MESSAGE);
			error = true;
			return 0;
		}

		try {
			float scale = Float.parseFloat(s);
			return scale;
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Invalid float in scale factor!", "Error", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}

}
