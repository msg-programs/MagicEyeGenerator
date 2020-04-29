package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton txt, img, go, save;
	private JLabel txtSel, imgSel;
	private JTextField scale, disp;
	private JCheckBox invert;

	public GUI() {
		this.setTitle("Settings");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(230, 350));
		this.setMinimumSize(new Dimension(230, 350));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		getContentPane().setLayout(gridBagLayout);

		txt = new JButton("Select Texture");
		GridBagConstraints gbcTxt = new GridBagConstraints();
		gbcTxt.fill = GridBagConstraints.HORIZONTAL;
		gbcTxt.insets = new Insets(0, 5, 0, 5);
		gbcTxt.gridx = 0;
		gbcTxt.gridy = 0;
		getContentPane().add(txt, gbcTxt);

		txtSel = new JLabel("Selected: None");
		GridBagConstraints gbcTxtSel = new GridBagConstraints();
		gbcTxtSel.ipady = 5;
		gbcTxtSel.insets = new Insets(-5, 5, -5, 5);
		gbcTxtSel.anchor = GridBagConstraints.NORTHWEST;
		gbcTxtSel.gridx = 0;
		gbcTxtSel.gridy = 1;
		getContentPane().add(txtSel, gbcTxtSel);

		img = new JButton("Select Depth Map");
		GridBagConstraints gbcImg = new GridBagConstraints();
		gbcImg.insets = new Insets(0, 5, 0, 5);
		gbcImg.fill = GridBagConstraints.HORIZONTAL;
		gbcImg.gridx = 0;
		gbcImg.gridy = 2;
		getContentPane().add(img, gbcImg);

		imgSel = new JLabel("Selected: None");
		GridBagConstraints gbc_imgSel = new GridBagConstraints();
		gbc_imgSel.ipady = 5;
		gbc_imgSel.insets = new Insets(-5, 5, -5, 5);
		gbc_imgSel.anchor = GridBagConstraints.NORTHWEST;
		gbc_imgSel.gridx = 0;
		gbc_imgSel.gridy = 3;
		getContentPane().add(imgSel, gbc_imgSel);

		JLabel hntScale = new JLabel("Texture Scaling");
		GridBagConstraints gbcHntScale = new GridBagConstraints();
		gbcHntScale.insets = new Insets(-5, 5, -5, 5);
		gbcHntScale.anchor = GridBagConstraints.SOUTHWEST;
		gbcHntScale.gridx = 0;
		gbcHntScale.gridy = 4;
		getContentPane().add(hntScale, gbcHntScale);

		scale = new JTextField();
		GridBagConstraints gbcScale = new GridBagConstraints();
		gbcScale.insets = new Insets(0, 5, 0, 5);
		gbcScale.fill = GridBagConstraints.HORIZONTAL;
		gbcScale.gridx = 0;
		gbcScale.gridy = 5;
		getContentPane().add(scale, gbcScale);

		JLabel hntDisplacement = new JLabel("Displacement");
		GridBagConstraints gbcDisplacement = new GridBagConstraints();
		gbcDisplacement.insets = new Insets(-10, 5, -5, 5);
		gbcDisplacement.anchor = GridBagConstraints.SOUTHWEST;
		gbcDisplacement.gridx = 0;
		gbcDisplacement.gridy = 6;
		getContentPane().add(hntDisplacement, gbcDisplacement);

		disp = new JTextField();
		GridBagConstraints gbcDisp = new GridBagConstraints();
		gbcDisp.insets = new Insets(0, 5, 0, 5);
		gbcDisp.fill = GridBagConstraints.HORIZONTAL;
		gbcDisp.gridx = 0;
		gbcDisp.gridy = 7;
		getContentPane().add(disp, gbcDisp);

		invert = new JCheckBox("Invert");
		GridBagConstraints gbcInvert = new GridBagConstraints();
		gbcInvert.insets = new Insets(0, 5, 0, 5);
		gbcInvert.anchor = GridBagConstraints.WEST;
		gbcInvert.gridx = 0;
		gbcInvert.gridy = 8;
		getContentPane().add(invert, gbcInvert);

		go = new JButton("Render!");
		GridBagConstraints gbcGo = new GridBagConstraints();
		gbcGo.insets = new Insets(0, 5, 0, 5);
		gbcGo.fill = GridBagConstraints.HORIZONTAL;
		gbcGo.gridx = 0;
		gbcGo.gridy = 9;
		getContentPane().add(go, gbcGo);

		save = new JButton("Save Image");
		GridBagConstraints gbcSave = new GridBagConstraints();
		gbcSave.insets = new Insets(0, 5, 0, 5);
		gbcSave.fill = GridBagConstraints.HORIZONTAL;
		gbcSave.gridx = 0;
		gbcSave.gridy = 10;
		getContentPane().add(save, gbcSave);

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
			// go
			return;
		}

		if (obj.equals(save)) {
			// save
			return;
		}

		handleFileInput(obj);

	}

	private void handleFileInput(Object obj) {
		JFileChooser jfc = new JFileChooser();
		int ret = jfc.showOpenDialog(null);

		if (ret != JFileChooser.APPROVE_OPTION) {
			return;
		}

		File f = jfc.getSelectedFile();
		
		String name = f.getName();
		if (name == null || name.length()==0) {
			name = "Error";
		}
		
		if (obj.equals(img) && StereoGen.setImage(f)) {
			
			
			imgSel.setText("Selected: " + name);
		}
		
		if (obj.equals(txt) && StereoGen.setTexture(f)) {
			
		}
		
	}

}
