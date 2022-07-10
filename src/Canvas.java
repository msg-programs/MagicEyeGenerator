import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {

    BufferedImage res;

    public Canvas() {
        super();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(res, 0, 0, null);
    }

    public void start() {
        try {
            BufferedImage txt = ImageIO.read(new File("./txt/txt.jpg"));
            BufferedImage img = ImageIO.read(new File("./img/Unbenannt.png"));
            res = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
            
            float scale = 2f;

            txt = resizeImg(txt, (int) (txt.getWidth() / scale), (int) (txt.getHeight() / scale));

            BufferedImage vtile = new BufferedImage(txt.getWidth(), 700, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = vtile.createGraphics();
            Graphics2D g3d = res.createGraphics();

            for (int j = 0; j < 700; j += txt.getHeight()) {
                g2d.drawImage(txt, null, 0, j);
            }

            for (int iter = 0; iter < 700; iter += txt.getWidth()) {
                g3d.drawImage(vtile, null, iter, 0);
            }

            for (int iter = 0; iter < 700; iter += txt.getWidth()) {
                for (int x = 0; x < txt.getWidth(); x++) {
                    for (int y = 0; y < vtile.getHeight(); y++) {
                        int displace = (int) ((new Color(img.getRGB((x + iter) % 700, y % 700)).getRed()) / 255f *10f);
                        int dispRgb = vtile.getRGB((x + displace) % vtile.getWidth(), y);
                        vtile.setRGB(x, y, dispRgb);
                        try {
                            res.setRGB((x + iter), y, dispRgb);
                            repaint();
                        } catch (Exception e) {
                        }

                    }
                }

            }
            repaint();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage resizeImg(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        // g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        // RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

//    public static BufferedImage deepCopy(BufferedImage bi) {
//        ColorModel cm = bi.getColorModel();
//        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
//        WritableRaster raster = bi.copyData(bi.getRaster().createCompatibleWritableRaster());
//        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
//    }

}
