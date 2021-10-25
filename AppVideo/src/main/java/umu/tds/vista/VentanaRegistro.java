package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaRegistro {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField textApellidos;
	private JTextField textemail;
	private JTextField textUsuario;
	private JPasswordField contraseña;
	private JPasswordField repetirContraseña;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel textCampos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
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
	public VentanaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[]{0, 0, 0, 314, 0, 31, 0, 0, 0};
		gbl_panelCentro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCentro.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCentro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCentro.setLayout(gbl_panelCentro);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Nombre*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNombre.setToolTipText("");
		txtNombre.setBackground(new Color(173, 216, 230));
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 2;
		panelCentro.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(50);
		
		textApellidos = new JTextField();
		textApellidos.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Apellidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textApellidos.setBackground(new Color(173, 216, 230));
		GridBagConstraints gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidos.gridwidth = 2;
		gbc_textApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textApellidos.gridx = 3;
		gbc_textApellidos.gridy = 3;
		panelCentro.add(textApellidos, gbc_textApellidos);
		textApellidos.setColumns(50);
		
		textemail = new JTextField();
		textemail.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textemail.setBackground(new Color(173, 216, 230));
		GridBagConstraints gbc_textemail = new GridBagConstraints();
		gbc_textemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textemail.gridwidth = 2;
		gbc_textemail.insets = new Insets(0, 0, 5, 5);
		gbc_textemail.gridx = 3;
		gbc_textemail.gridy = 5;
		panelCentro.add(textemail, gbc_textemail);
		textemail.setColumns(50);
		
		textUsuario = new JTextField();
		textUsuario.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Usuario*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textUsuario.setBackground(new Color(173, 216, 230));
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textUsuario.gridx = 3;
		gbc_textUsuario.gridy = 7;
		panelCentro.add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(25);
		
		contraseña = new JPasswordField();
		contraseña.setColumns(25);
		contraseña.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Contrase\u00F1a*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contraseña.setBackground(new Color(173, 216, 230));
		GridBagConstraints gbc_contraseña = new GridBagConstraints();
		gbc_contraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_contraseña.insets = new Insets(0, 0, 5, 5);
		gbc_contraseña.gridx = 3;
		gbc_contraseña.gridy = 8;
		panelCentro.add(contraseña, gbc_contraseña);
		
		repetirContraseña = new JPasswordField();
		repetirContraseña.setColumns(25);
		repetirContraseña.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Repetir Contrase\u00F1a*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		repetirContraseña.setBackground(new Color(173, 216, 230));
		GridBagConstraints gbc_repetirContraseña = new GridBagConstraints();
		gbc_repetirContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_repetirContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_repetirContraseña.gridx = 3;
		gbc_repetirContraseña.gridy = 9;
		panelCentro.add(repetirContraseña, gbc_repetirContraseña);
		
		btnNewButton = new JButton("Registrar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 11;
		panelCentro.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("Cancelar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 11;
		panelCentro.add(btnNewButton_1, gbc_btnNewButton_1);
		
		textCampos = new JLabel("* Campos Obligatorios");
		textCampos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCampos.setForeground(new Color(165, 42, 42));
		GridBagConstraints gbc_textCampos = new GridBagConstraints();
		gbc_textCampos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCampos.insets = new Insets(0, 0, 0, 5);
		gbc_textCampos.gridx = 3;
		gbc_textCampos.gridy = 13;
		panelCentro.add(textCampos, gbc_textCampos);
	}

}
