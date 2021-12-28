package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VentanaPrincipal {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 782, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowWeights = new double[]{0.0, 1.0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JPanel panel_arriba = new JPanel();
		panel_arriba.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_arriba = new GridBagConstraints();
		gbc_panel_arriba.insets = new Insets(0, 0, 0, 5);
		gbc_panel_arriba.fill = GridBagConstraints.BOTH;
		gbc_panel_arriba.gridx = 1;
		gbc_panel_arriba.gridy = 1;
		panel.add(panel_arriba, gbc_panel_arriba);
		GridBagLayout gbl_panel_arriba = new GridBagLayout();
		gbl_panel_arriba.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_arriba.rowHeights = new int[]{0, 0};
		gbl_panel_arriba.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_arriba.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_arriba.setLayout(gbl_panel_arriba);
		
		JButton btnNewButton = new JButton("Registro");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 12;
		gbc_btnNewButton.gridy = 0;
		panel_arriba.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 13;
		gbc_btnNewButton_1.gridy = 0;
		panel_arriba.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 15;
		gbc_btnNewButton_2.gridy = 0;
		panel_arriba.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Premium");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 17;
		gbc_btnNewButton_3.gridy = 0;
		panel_arriba.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel panel_centro = new JPanel();
		frame.getContentPane().add(panel_centro, BorderLayout.CENTER);
		GridBagLayout gbl_panel_centro = new GridBagLayout();
		gbl_panel_centro.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_centro.rowHeights = new int[]{1, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_centro.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_centro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_centro.setLayout(gbl_panel_centro);
		
		JButton btnNewButton_4 = new JButton("Explorar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 1;
		panel_centro.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Mis listas");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 1;
		panel_centro.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Recientes");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 3;
		gbc_btnNewButton_6.gridy = 1;
		panel_centro.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Nueva lista");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 4;
		gbc_btnNewButton_7.gridy = 1;
		panel_centro.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JPanel panel_card = new JPanel();
		GridBagConstraints gbc_panel_card = new GridBagConstraints();
		gbc_panel_card.gridheight = 4;
		gbc_panel_card.gridwidth = 17;
		gbc_panel_card.insets = new Insets(0, 0, 5, 5);
		gbc_panel_card.fill = GridBagConstraints.BOTH;
		gbc_panel_card.gridx = 1;
		gbc_panel_card.gridy = 2;
		panel_centro.add(panel_card, gbc_panel_card);
		panel_card.setLayout(new CardLayout(0, 0));
		
		JPanel panel_Explorar = new JPanel();
		panel_card.add(panel_Explorar, "name_189746144326300");
		
		JPanel panel_1 = new JPanel();
		panel_Explorar.add(panel_1);
		
		textField = new JTextField();
		textField.setOpaque(false);
		textField.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Buscar:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(textField);
		textField.setColumns(50);
		
		JButton btnNewButton_8 = new JButton("Buscar");
		panel_1.add(btnNewButton_8);
		
		JPanel panel_Listas = new JPanel();
		panel_card.add(panel_Listas, "name_189750465124100");
		
		JPanel panel_Recientes = new JPanel();
		panel_card.add(panel_Recientes, "name_189752391118400");
		
		JPanel panel_NewLista = new JPanel();
		panel_card.add(panel_NewLista, "name_189754081105800");
		
		JButton btnNewButton_9 = new JButton("New button");
		panel_card.add(btnNewButton_9, "name_192537121817400");
	}

}
