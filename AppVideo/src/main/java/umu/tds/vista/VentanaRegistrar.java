package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaRegistrar {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textField;
	private JPanel panel_1;
	private JDateChooser dateChooser;
	private JTextField textField_1;
	private JPasswordField Contraseña1;
	private JPasswordField contraseña2;
	private JButton BotonRegistrar;
	private JButton BotonCancelar;
	private JLabel camposObligatorios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrar window = new VentanaRegistrar();
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
	public VentanaRegistrar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 811, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 26, 0, 0, 0, 10, 0, 7, 0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		textNombre = new JTextField();
		textNombre.setBackground(new Color(173, 216, 230));
		textNombre.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Nombre*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 2;
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.gridx = 0;
		gbc_textNombre.gridy = 0;
		panel.add(textNombre, gbc_textNombre);
		textNombre.setColumns(40);
		
		textApellidos = new JTextField();
		textApellidos.setOpaque(false);
		textApellidos.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Apellidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textApellidos.setBackground(new Color(173, 216, 230));
		GridBagConstraints gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.gridwidth = 2;
		gbc_textApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_textApellidos.gridx = 0;
		gbc_textApellidos.gridy = 1;
		panel.add(textApellidos, gbc_textApellidos);
		textApellidos.setColumns(40);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Fecha de nacimiento*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 0;
		gbc_dateChooser.gridy = 0;
		panel_1.add(dateChooser, gbc_dateChooser);
		
		textField = new JTextField();
		textField.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setBackground(new Color(173, 216, 230));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		panel.add(textField, gbc_textField);
		textField.setColumns(35);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Usuario*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField_1.setBackground(new Color(173, 216, 230));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 5;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(35);
		
		Contraseña1 = new JPasswordField();
		Contraseña1.setColumns(35);
		Contraseña1.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Contrase\u00F1a*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Contraseña1.setBackground(new Color(173, 216, 230));
		GridBagConstraints gbc_Contraseña1 = new GridBagConstraints();
		gbc_Contraseña1.gridwidth = 2;
		gbc_Contraseña1.insets = new Insets(0, 0, 5, 0);
		gbc_Contraseña1.anchor = GridBagConstraints.WEST;
		gbc_Contraseña1.gridx = 0;
		gbc_Contraseña1.gridy = 6;
		panel.add(Contraseña1, gbc_Contraseña1);
		
		contraseña2 = new JPasswordField();
		contraseña2.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Repetir contrase\u00F1a*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contraseña2.setBackground(new Color(173, 216, 230));
		contraseña2.setColumns(35);
		GridBagConstraints gbc_contraseña2 = new GridBagConstraints();
		gbc_contraseña2.gridwidth = 2;
		gbc_contraseña2.insets = new Insets(0, 0, 5, 0);
		gbc_contraseña2.anchor = GridBagConstraints.WEST;
		gbc_contraseña2.gridx = 0;
		gbc_contraseña2.gridy = 7;
		panel.add(contraseña2, gbc_contraseña2);
		
		BotonRegistrar = new JButton("Resgistrar");
		GridBagConstraints gbc_BotonRegistrar = new GridBagConstraints();
		gbc_BotonRegistrar.insets = new Insets(0, 0, 5, 5);
		gbc_BotonRegistrar.anchor = GridBagConstraints.WEST;
		gbc_BotonRegistrar.gridx = 0;
		gbc_BotonRegistrar.gridy = 9;
		panel.add(BotonRegistrar, gbc_BotonRegistrar);
		
		BotonCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_BotonCancelar = new GridBagConstraints();
		gbc_BotonCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_BotonCancelar.anchor = GridBagConstraints.EAST;
		gbc_BotonCancelar.gridx = 1;
		gbc_BotonCancelar.gridy = 9;
		panel.add(BotonCancelar, gbc_BotonCancelar);
		
		camposObligatorios = new JLabel("*Campos obligatorios");
		camposObligatorios.setForeground(new Color(178, 34, 34));
		camposObligatorios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_camposObligatorios = new GridBagConstraints();
		gbc_camposObligatorios.insets = new Insets(0, 0, 0, 5);
		gbc_camposObligatorios.gridx = 0;
		gbc_camposObligatorios.gridy = 11;
		panel.add(camposObligatorios, gbc_camposObligatorios);
	}

}
