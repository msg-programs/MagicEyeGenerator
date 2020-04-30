package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener {

	private static final String THIS_DIR = ClassLoader.getSystemClassLoader().getResource(".").getPath()
			.replaceAll("%20", " ").substring(1);

	private JButton txt, img, go, save;
	private JLabel txtSel, imgSel;
	private JTextField scale, disp, cont;
	private JCheckBox invert;

	private JFrame frame = null;

	public GUI() {
		this.setTitle("Settings");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(230, 370));
		this.setMinimumSize(new Dimension(230, 370));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 5 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0 };
		getContentPane().setLayout(gridBagLayout);

		txt = new JButton("Select Texture");
		GridBagConstraints gbc_txt = new GridBagConstraints();
		gbc_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt.insets = new Insets(0, 5, 5, 0);
		gbc_txt.gridx = 0;
		gbc_txt.gridy = 0;
		getContentPane().add(txt, gbc_txt);

		txtSel = new JLabel("Selected: None");
		GridBagConstraints gbc_txtSel = new GridBagConstraints();
		gbc_txtSel.ipady = 5;
		gbc_txtSel.insets = new Insets(-5, 5, 5, 0);
		gbc_txtSel.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtSel.gridx = 0;
		gbc_txtSel.gridy = 1;
		getContentPane().add(txtSel, gbc_txtSel);

		img = new JButton("Select Depth Map");
		GridBagConstraints gbc_img = new GridBagConstraints();
		gbc_img.insets = new Insets(0, 5, 5, 0);
		gbc_img.fill = GridBagConstraints.HORIZONTAL;
		gbc_img.gridx = 0;
		gbc_img.gridy = 2;
		getContentPane().add(img, gbc_img);

		imgSel = new JLabel("Selected: None");
		GridBagConstraints gbc_imgSel = new GridBagConstraints();
		gbc_imgSel.ipady = 5;
		gbc_imgSel.insets = new Insets(-5, 5, 5, 0);
		gbc_imgSel.anchor = GridBagConstraints.NORTHWEST;
		gbc_imgSel.gridx = 0;
		gbc_imgSel.gridy = 3;
		getContentPane().add(imgSel, gbc_imgSel);

		JLabel hntTexScale = new JLabel("Texture Scaling");
		GridBagConstraints gbc_hntTexScale = new GridBagConstraints();
		gbc_hntTexScale.insets = new Insets(0, 5, 0, 0);
		gbc_hntTexScale.anchor = GridBagConstraints.SOUTHWEST;
		gbc_hntTexScale.gridx = 0;
		gbc_hntTexScale.gridy = 4;
		getContentPane().add(hntTexScale, gbc_hntTexScale);

		scale = new JTextField();
		GridBagConstraints gbc_scale = new GridBagConstraints();
		gbc_scale.insets = new Insets(0, 5, 5, 0);
		gbc_scale.fill = GridBagConstraints.HORIZONTAL;
		gbc_scale.gridx = 0;
		gbc_scale.gridy = 5;
		getContentPane().add(scale, gbc_scale);

		JLabel hntDisplacement = new JLabel("Displacement");
		GridBagConstraints gbc_hntDisplacement = new GridBagConstraints();
		gbc_hntDisplacement.insets = new Insets(0, 5, 0, 0);
		gbc_hntDisplacement.anchor = GridBagConstraints.SOUTHWEST;
		gbc_hntDisplacement.gridx = 0;
		gbc_hntDisplacement.gridy = 6;
		getContentPane().add(hntDisplacement, gbc_hntDisplacement);

		disp = new JTextField();
		GridBagConstraints gbc_disp = new GridBagConstraints();
		gbc_disp.insets = new Insets(0, 5, 5, 0);
		gbc_disp.fill = GridBagConstraints.HORIZONTAL;
		gbc_disp.gridx = 0;
		gbc_disp.gridy = 7;
		getContentPane().add(disp, gbc_disp);

		JLabel hntContrast = new JLabel("Contrast");
		GridBagConstraints gbc_hntContrast = new GridBagConstraints();
		gbc_hntContrast.anchor = GridBagConstraints.SOUTHWEST;
		gbc_hntContrast.insets = new Insets(0, 5, 0, 0);
		gbc_hntContrast.gridx = 0;
		gbc_hntContrast.gridy = 8;
		getContentPane().add(hntContrast, gbc_hntContrast);

		cont = new JTextField();
		GridBagConstraints gbc_cont = new GridBagConstraints();
		gbc_cont.insets = new Insets(0, 5, 5, 0);
		gbc_cont.fill = GridBagConstraints.HORIZONTAL;
		gbc_cont.gridx = 0;
		gbc_cont.gridy = 9;
		getContentPane().add(cont, gbc_cont);
		cont.setColumns(10);

		invert = new JCheckBox("Invert Depth");
		GridBagConstraints gbc_invert = new GridBagConstraints();
		gbc_invert.insets = new Insets(0, 5, 5, 0);
		gbc_invert.anchor = GridBagConstraints.WEST;
		gbc_invert.gridx = 0;
		gbc_invert.gridy = 10;
		getContentPane().add(invert, gbc_invert);

		go = new JButton("Render!");
		GridBagConstraints gbc_go = new GridBagConstraints();
		gbc_go.insets = new Insets(0, 5, 5, 0);
		gbc_go.fill = GridBagConstraints.HORIZONTAL;
		gbc_go.gridx = 0;
		gbc_go.gridy = 11;
		getContentPane().add(go, gbc_go);

		save = new JButton("Save Image");
		GridBagConstraints gbc_save = new GridBagConstraints();
		gbc_save.insets = new Insets(0, 5, 0, 0);
		gbc_save.fill = GridBagConstraints.HORIZONTAL;
		gbc_save.gridx = 0;
		gbc_save.gridy = 12;
		getContentPane().add(save, gbc_save);

		txt.addActionListener(this);
		img.addActionListener(this);
		go.addActionListener(this);
		save.addActionListener(this);

		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj.equals(go)) {
			BufferedImage buf = StereoGen.render(scale.getText(), disp.getText(), cont.getText(), invert.isSelected());

			if (buf == null) {
				return;
			}

			Display d = new Display();
			
			if (frame == null) {
				d = new Display();
				frame = new JFrame("Display");
				frame.setSize(buf.getWidth(), buf.getHeight());
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
			
			d.setImage(buf);
			frame.add(d);
			d.repaint();


			return;
		}

		if (obj.equals(save)) {
			BufferedImage buf = StereoGen.render(scale.getText(), disp.getText(), cont.getText(), invert.isSelected());
			try {
				String name = "";
				do {
					name = System.currentTimeMillis() + ".png";
				} while (new File(THIS_DIR + name).exists());

				ImageIO.write(buf, "png", new File(THIS_DIR + name));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Error while saving:\n" + e1.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			return;
		}

		JLabel sel = null;

		if (obj.equals(txt)) {
			sel = txtSel;
		}

		if (obj.equals(img)) {
			sel = imgSel;
		}

		if (sel == null) {
			return;
		}

		File f = doFileSelect();

		if (f == null) {
			return;
		}

		if (sel.equals(txtSel)) {
//			File f = new File("D:\\workspace\\3D\\txt\\satin1.gif");
			if (StereoGen.setTexture(f)) {
				sel.setText("Selected: " + f.getName());
				return;
			}
		} else {
//			File f = new File("D:\\workspace\\3D\\img\\map.jpg");
			if (StereoGen.setImage(f)) {
				sel.setText("Selected: " + f.getName());
				return;
			}
		}
		sel.setText("Error while opening file!");

	}

	private File doFileSelect() {
		JFileChooser jfc = new JFileChooser(/*"D:/workspace/3D"*/);
		jfc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg","jpeg", "png", "gif", "bmp","wbmp"));
		int ret = jfc.showOpenDialog(null);

		if (ret != JFileChooser.APPROVE_OPTION) {
			return null;
		}

		return jfc.getSelectedFile();
	}

}
