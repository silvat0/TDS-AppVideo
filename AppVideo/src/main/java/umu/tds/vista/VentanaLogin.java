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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
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
		
		btnNewButton_1 = new JButton("Iniciar sesión");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				char[] pass = passwordField.getPassword();
				
				boolean isLogin = controlador.login(user, pass.toString());
				
				if (isLogin) 
					;
				else {
					
					Object[] opciones = {"Ok", "Registrarse"};
					JOptionPane.showOptionDialog(frame, "Usuario o contraseña erroneos", "Error Login", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, opciones, opciones[0]);
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		panelCentro.add(btnNewButton_1, gbc_btnNewButton_1);
		
		lblNewLabel = new JLabel("¿Aun no te has registrado?");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		panelCentro.add(lblNewLabel, gbc_lblNewLabel);
		
		
		btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				crearRegistro();
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		panelCentro.add(btnNewButton, gbc_btnNewButton);
	}
	
	private void crearRegistro() {
		
		
		//!Modificar esto
		this.frame.setVisible(false);

		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					try {
						VentanaRegistrar windo = new VentanaRegistrar();
						windo.frame.setVisible(true);
						windo.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		this.frame.setVisible(true);
	}

}
