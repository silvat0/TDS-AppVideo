package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.border.TitledBorder;

import org.apache.commons.io.IOUtils;

import tds.video.VideoWeb;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

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
	private JLabel lblNewLabel_1;
	

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
	
	public void mostrarVentana() {
		frame.setVisible(true);
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
		
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		frame = new JFrame("Login");
		frame.getContentPane().setForeground(UIManager.getColor("CheckBox.select"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(VentanaLogin.class.getResource("/umu/tds/res/logoicon.png"));
		frame.setIconImage(img.getImage());
		frame.setTitle("Login AppVideo");

		
		JPanel panelCentro = new JPanel();
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWeights = new double[]{0.0, 0.0};
		panelCentro.setLayout(gbl_panelCentro);
		
		
		
		lblNewLabel_1 = new JLabel("");
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(VentanaLogin.class.getResource("/umu/tds/res/LOGO.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Image dimg = image.getScaledInstance(175, 85, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        lblNewLabel_1.setIcon(imageIcon);
		//lblNewLabel_1.setIcon(new ImageIcon(VentanaLogin.class.getResource("/umu/tds/res/LOGO.png")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panelCentro.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panelCentro.add(textField, gbc_textField);
		textField.setColumns(20);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		passwordField.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0, true)), "Contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 2;
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
		gbc_botonIniciarSesion.insets = new Insets(0, 0, 5, 0);
		gbc_botonIniciarSesion.gridx = 0;
		gbc_botonIniciarSesion.gridy = 3;
		panelCentro.add(botonIniciarSesion, gbc_botonIniciarSesion);
		
		lblNewLabel = new JLabel("¿Aun no te has registrado?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 4;
		panelCentro.add(lblNewLabel, gbc_lblNewLabel);
		
		
		botonRegistrar = new JButton("Registrarse");
		botonRegistrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				crearRegistro();
				
			}
		});
		GridBagConstraints gbc_botonRegistrar = new GridBagConstraints();
		gbc_botonRegistrar.gridx = 1;
		gbc_botonRegistrar.gridy = 4;
		panelCentro.add(botonRegistrar, gbc_botonRegistrar);
	}
	
	private void crearRegistro() {
		
		VentanaRegistrar vr = new VentanaRegistrar();
		vr.mostrarVentana(this);
		frame.setVisible(false);
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
		VentanaPrueba2 vp = new VentanaPrueba2();
		vp.mostrarVentana();
	}

}
