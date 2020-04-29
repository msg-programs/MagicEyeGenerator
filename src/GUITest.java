

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

public class GUITest extends JFrame {
	private JTextField cont;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUITest frame = new GUITest();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GUITest() {
		setTitle("Settings");
		setBounds(100, 100, 231, 372);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {5, 5};
		gridBagLayout.rowHeights = new int[] {10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		
		JButton txt = new JButton("Select Texture");
		GridBagConstraints gbc_txt = new GridBagConstraints();
		gbc_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt.insets = new Insets(0, 5, 5, 0);
		gbc_txt.gridx = 0;
		gbc_txt.gridy = 0;
		getContentPane().add(txt, gbc_txt);
		
		JLabel txtSel = new JLabel("Selected: None");
		GridBagConstraints gbc_txtSel = new GridBagConstraints();
		gbc_txtSel.ipady = 5;
		gbc_txtSel.insets = new Insets(-5, 5, 5, 0);
		gbc_txtSel.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtSel.gridx = 0;
		gbc_txtSel.gridy = 1;
		getContentPane().add(txtSel, gbc_txtSel);
		
		JButton img = new JButton("Select Depth Map");
		GridBagConstraints gbc_img = new GridBagConstraints();
		gbc_img.insets = new Insets(0, 5, 5, 0);
		gbc_img.fill = GridBagConstraints.HORIZONTAL;
		gbc_img.gridx = 0;
		gbc_img.gridy = 2;
		getContentPane().add(img, gbc_img);
		
		JLabel imgSel = new JLabel("Selected: None");
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
		
		JTextField scale = new JTextField();
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
		
		JTextField disp = new JTextField();
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
		
		JCheckBox invert = new JCheckBox("Invert Depth");
		GridBagConstraints gbc_invert = new GridBagConstraints();
		gbc_invert.insets = new Insets(0, 5, 5, 0);
		gbc_invert.anchor = GridBagConstraints.WEST;
		gbc_invert.gridx = 0;
		gbc_invert.gridy = 10;
		getContentPane().add(invert, gbc_invert);
		
		JButton go = new JButton("Render!");
		GridBagConstraints gbc_go = new GridBagConstraints();
		gbc_go.insets = new Insets(0, 5, 5, 0);
		gbc_go.fill = GridBagConstraints.HORIZONTAL;
		gbc_go.gridx = 0;
		gbc_go.gridy = 11;
		getContentPane().add(go, gbc_go);
		
		JButton save = new JButton("Save Image");
		GridBagConstraints gbc_save = new GridBagConstraints();
		gbc_save.insets = new Insets(0, 5, 0, 0);
		gbc_save.fill = GridBagConstraints.HORIZONTAL;
		gbc_save.gridx = 0;
		gbc_save.gridy = 12;
		getContentPane().add(save, gbc_save);

	}
}
