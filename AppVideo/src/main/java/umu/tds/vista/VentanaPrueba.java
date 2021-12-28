package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class VentanaPrueba {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba window = new VentanaPrueba();
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
	public VentanaPrueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 657, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{20, 0, 20, 0};
		gbl_panel_1.rowHeights = new int[]{10, 0, 8, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.NORTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{60, 0, 0, 0, 60, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_4.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		panel_4.add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 3;
		gbc_btnNewButton_8.gridy = 0;
		panel_4.add(btnNewButton_8, gbc_btnNewButton_8);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 3;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_3.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_3 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 0;
		panel_3.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_6.gridx = 4;
		gbc_btnNewButton_6.gridy = 0;
		panel_3.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_7.gridx = 6;
		gbc_btnNewButton_7.gridy = 0;
		panel_3.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 4;
		panel_1.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new CardLayout(0, 0));
		
		JLayeredPane layerExplorar = new JLayeredPane();
		panel_5.add(layerExplorar, "name_3972460051100");
		
		JLayeredPane layerMisListas = new JLayeredPane();
		panel_5.add(layerMisListas, "name_3978642883400");
		
		JLayeredPane layerNuevaLista = new JLayeredPane();
		panel_5.add(layerNuevaLista, "name_3982275151600");
		
		JLayeredPane layerRecientes = new JLayeredPane();
		panel_5.add(layerRecientes, "name_4004733500900");
		
		JLayeredPane layerMasVistos = new JLayeredPane();
		panel_5.add(layerMasVistos, "name_5422929274000");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{20, 0, 20, 0};
		gbl_panel.rowHeights = new int[]{15, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.SOUTH;
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 10, 0, 10, 0, 20, 0, 5, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrueba.class.getResource("/umu/tds/res/d2.jpg")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 0;
		panel_2.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 0;
		panel_2.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 6;
		gbc_btnNewButton_2.gridy = 0;
		panel_2.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.gridx = 8;
		gbc_btnNewButton_1.gridy = 0;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
