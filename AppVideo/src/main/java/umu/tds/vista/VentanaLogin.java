package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.border.TitledBorder;

import umu.tds.controlador.ControladorAPP;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.awt.event.ActionEvent;

public class VentanaLogin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JButton botonRegistrar;
	private JButton botonIniciarSesion;
	private ControladorAPP controlador = ControladorAPP.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
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
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login");
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.getContentPane().setForeground(UIManager.getColor("CheckBox.select"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(173, 216, 230));
		panelCentro.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWeights = new double[]{0.0, 0.0};
		panelCentro.setLayout(gbl_panelCentro);
		
		textField = new JTextField();
		textField.setBackground(new Color(173, 216, 230));
		textField.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panelCentro.add(textField, gbc_textField);
		textField.setColumns(20);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(173, 216, 230));
		passwordField.setColumns(20);
		passwordField.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0, true)), "Contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 1;
		panelCentro.add(passwordField, gbc_passwordField);
		
		botonIniciarSesion = new JButton("Iniciar sesión");
		botonIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hacerLogin();
			}
		});
		GridBagConstraints gbc_botonIniciarSesion = new GridBagConstraints();
		gbc_botonIniciarSesion.gridwidth = 2;
		gbc_botonIniciarSesion.fill = GridBagConstraints.BOTH;
		gbc_botonIniciarSesion.insets = new Insets(0, 0, 5, 5);
		gbc_botonIniciarSesion.gridx = 0;
		gbc_botonIniciarSesion.gridy = 2;
		panelCentro.add(botonIniciarSesion, gbc_botonIniciarSesion);
		
		lblNewLabel = new JLabel("¿Aun no te has registrado?");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		panelCentro.add(lblNewLabel, gbc_lblNewLabel);
		
		
		botonRegistrar = new JButton("Registrarse");
		botonRegistrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				crearRegistro();
				
			}
		});
		GridBagConstraints gbc_botonRegistrar = new GridBagConstraints();
		gbc_botonRegistrar.gridx = 1;
		gbc_botonRegistrar.gridy = 3;
		panelCentro.add(botonRegistrar, gbc_botonRegistrar);
	}
	
	private void crearRegistro() {
		
		VentanaRegistrar.main(null);
	}
	
	private void hacerLogin() {
		
		String user = textField.getText();
		char[] pass = passwordField.getPassword();
		
		boolean isLogin = controlador.login(user, new String(pass));
		
		if (isLogin) {
			//Iniciar ventana principal.
			crearPrincipal();
			this.frame.dispose();
		}
		else {
			Object[] opciones = {"Ok", "Registrarse"};
			
			//Mostramos 
			int opt = JOptionPane.showOptionDialog(frame, 
					"Usuario o contraseña erroneos", 
					"Error Login", JOptionPane.OK_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, opciones, opciones[0]);
			switch (opt) {
			case 0:	//Presiona ok.
				break;
			case 1: //Presiona registrarse.
				crearRegistro();
				break;

			default:
				break;
			}
			
		}
			

		

	}
	
	private void crearPrincipal() {
		VentanaPrincipal.main(null);
	}

}
