package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import umu.tds.controlador.ControladorAPP;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class VentanaPremium {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPremium window = new VentanaPremium();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPremium() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 522, 333);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {30, 0, 30, 0};
		gbl_panel.rowHeights = new int[] {30, 30, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0, 10, 30, 0, 0, 10};
		gbl_panel_1.rowHeights = new int[] {0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Hola");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel usernameLBL = new JLabel("");
		usernameLBL.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_usernameLBL = new GridBagConstraints();
		gbc_usernameLBL.anchor = GridBagConstraints.WEST;
		gbc_usernameLBL.insets = new Insets(0, 0, 0, 5);
		gbc_usernameLBL.gridx = 3;
		gbc_usernameLBL.gridy = 0;
		panel_1.add(usernameLBL, gbc_usernameLBL);
		usernameLBL.setText(ControladorAPP.getInstancia().getUsuario().getUsername());
		
		JLabel premiumLBL = new JLabel("premium");
		premiumLBL.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_premiumLBL = new GridBagConstraints();
		gbc_premiumLBL.anchor = GridBagConstraints.WEST;
		gbc_premiumLBL.insets = new Insets(0, 0, 0, 5);
		gbc_premiumLBL.gridx = 4;
		gbc_premiumLBL.gridy = 0;
		panel_1.add(premiumLBL, gbc_premiumLBL);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {0, 0, 0, 0, 0, 15, 30};
		gbl_panel_2.rowHeights = new int[] {15, 0, 15, 15, 0, 0, 0, 30, 0, 30, 0, 0, 30, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		
		 Boolean isPremium = ControladorAPP.getInstancia().getUsuario().isPremium();
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Premium");
		if(isPremium) {
			chckbxNewCheckBox.setSelected(true);
			premiumLBL.setText(", actualmente dispones de Premium");
		}
		else {
			chckbxNewCheckBox.setSelected(false);
			premiumLBL.setText(", actualmente no dispones de Premium");
		}
		
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ControladorAPP.getInstancia().getUsuario().isPremium()) {
					 premiumLBL.setText(", actualmente no dispones de Premium");
					ControladorAPP.getInstancia().getUsuario().setPremium(false);
				}
				else {
					ControladorAPP.getInstancia().getUsuario().setPremium(true);
					premiumLBL.setText(", actualmente dispones de Premium");
				}
			}
		});
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 3;
		gbc_chckbxNewCheckBox.gridy = 2;
		panel_2.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Generar pdf con \"Mis Listas\"");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 4;
		panel_2.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Generar lista Top 10");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 5;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
		BufferedImage image = null;
		try {
			image = ImageIO.read(VentanaLogin.class.getResource("/umu/tds/res/logonegro.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Image dimg = image.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
       
		
		
		
	}

}
