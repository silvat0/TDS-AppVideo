package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
//import javax.swing.WindowConstants;
import javax.swing.UIManager;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

import umu.tds.controlador.ControladorAPP;
import umu.tds.modelo.Usuario;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class VentanaRegistrar {


	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	JFrame frame;
	private VentanaLogin vl;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEmail;
	private JPanel panelFecha;
	private JDateChooser fechaNac;
	private JTextField textUsuario;
	private JPasswordField Contraseña1;
	private JPasswordField Contraseña2;
	private JButton BotonRegistrar;
	private JButton BotonCancelar;
	private JLabel camposObligatorios;
	private ControladorAPP controlador = ControladorAPP.getInstancia();

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
	
	public void mostrarVentana(VentanaLogin vl) {
		frame.setVisible(true);
		this.vl = vl;
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
				
		frame = new JFrame("Registro");
		frame.setType(Type.POPUP);
		frame.setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 811, 600);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ImageIcon img = new ImageIcon(VentanaLogin.class.getResource("/umu/tds/res/logoicon.png"));
		frame.setIconImage(img.getImage());
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 26, 0, 0, 0, 10, 0, 7, 0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		textNombre = new JTextField();
		textNombre.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Nombre*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 2;
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.gridx = 0;
		gbc_textNombre.gridy = 0;
		panel.add(textNombre, gbc_textNombre);
		textNombre.setColumns(35);
		
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
		textApellidos.setColumns(35);
		
		panelFecha = new JPanel();
		panelFecha.setOpaque(false);
		panelFecha.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Fecha de nacimiento*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelFecha = new GridBagConstraints();
		gbc_panelFecha.gridwidth = 2;
		gbc_panelFecha.insets = new Insets(0, 0, 5, 0);
		gbc_panelFecha.fill = GridBagConstraints.BOTH;
		gbc_panelFecha.gridx = 0;
		gbc_panelFecha.gridy = 2;
		panel.add(panelFecha, gbc_panelFecha);
		GridBagLayout gbl_panelFecha = new GridBagLayout();
		gbl_panelFecha.columnWidths = new int[]{0, 0};
		gbl_panelFecha.rowHeights = new int[]{0, 0};
		gbl_panelFecha.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelFecha.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelFecha.setLayout(gbl_panelFecha);
		
		fechaNac = new JDateChooser();
		GridBagConstraints gbc_fechaNac = new GridBagConstraints();
		gbc_fechaNac.fill = GridBagConstraints.BOTH;
		gbc_fechaNac.gridx = 0;
		gbc_fechaNac.gridy = 0;
		panelFecha.add(fechaNac, gbc_fechaNac);
		
		textEmail = new JTextField();
		textEmail.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.gridwidth = 2;
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textEmail.gridx = 0;
		gbc_textEmail.gridy = 3;
		panel.add(textEmail, gbc_textEmail);
		textEmail.setColumns(35);
		
		textUsuario = new JTextField();
		textUsuario.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Usuario*", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.gridwidth = 2;
		gbc_textUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_textUsuario.anchor = GridBagConstraints.WEST;
		gbc_textUsuario.gridx = 0;
		gbc_textUsuario.gridy = 5;
		panel.add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(20);
		
		Contraseña1 = new JPasswordField();
		Contraseña1.setColumns(20);
		Contraseña1.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Contrase\u00F1a*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_Contraseña1 = new GridBagConstraints();
		gbc_Contraseña1.gridwidth = 2;
		gbc_Contraseña1.insets = new Insets(0, 0, 5, 0);
		gbc_Contraseña1.anchor = GridBagConstraints.WEST;
		gbc_Contraseña1.gridx = 0;
		gbc_Contraseña1.gridy = 6;
		panel.add(Contraseña1, gbc_Contraseña1);
		
		Contraseña2 = new JPasswordField();
		Contraseña2.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 0)), "Repetir contrase\u00F1a*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Contraseña2.setColumns(20);
		GridBagConstraints gbc_Contraseña2 = new GridBagConstraints();
		gbc_Contraseña2.gridwidth = 2;
		gbc_Contraseña2.insets = new Insets(0, 0, 5, 0);
		gbc_Contraseña2.anchor = GridBagConstraints.WEST;
		gbc_Contraseña2.gridx = 0;
		gbc_Contraseña2.gridy = 7;
		panel.add(Contraseña2, gbc_Contraseña2);
		
		BotonRegistrar = new JButton("Resgistrar");
		BotonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hacerRegistro();
			}
		});
		GridBagConstraints gbc_BotonRegistrar = new GridBagConstraints();
		gbc_BotonRegistrar.insets = new Insets(0, 0, 5, 5);
		gbc_BotonRegistrar.anchor = GridBagConstraints.WEST;
		gbc_BotonRegistrar.gridx = 0;
		gbc_BotonRegistrar.gridy = 9;
		panel.add(BotonRegistrar, gbc_BotonRegistrar);
		
		BotonCancelar = new JButton("Cancelar");
		BotonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minimizar();
			}
		});
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
	
	private void minimizar() {
		this.frame.dispose();
		vl.mostrarVentana();
	}
	
	private void hacerRegistro() {
		//Cogo los campos
		String nombre = textNombre.getText();
		String email = textEmail.getText();
		char[] contraseña = Contraseña1.getPassword();
		char[] repContraseña = Contraseña2.getPassword();
		String apellidos = textApellidos.getText();
		String user = textUsuario.getText();
		String camposVacios = "";
		String errores = "";
		Date fecha = null;
		if (fechaNac.getCalendar()!= null) {
			
			fecha = fechaNac.getDate();
			if (fecha.after(Date.from(Instant.now()))) {
				errores = errores + "Fecha de nacimiento: es futura\n";
			}
		}else camposVacios = camposVacios + "fecha de nacimiento, ";

		String cont = new String(contraseña);
		String repCont = new String(repContraseña);
		
		if (nombre.equals("")) {
			camposVacios = camposVacios + "nombre, ";
		}
		
		if (user.equals("")) {
			camposVacios = camposVacios + "usuario, ";
		}
		else if (controlador.existeUsuario(user)) {
			errores = errores + "Nombre de usuario: Ya existe un usuario \""+user+"\"\n";
		}
		
		if (cont.equals("")) {
			camposVacios = camposVacios + "contraseña, ";
		}else if (repCont.equals("")){
			camposVacios = camposVacios + "repeticion de contraseña, ";
		}else if (!repCont.equals(cont)){
			errores = errores + "Contraseña: las contraseñas no coinciden\n";
		}
		
		
		if (!camposVacios.equals("") || !errores.isEmpty()) {
			if(!camposVacios.isEmpty()) {
				camposVacios = camposVacios.substring(0, camposVacios.length()-2);
			}
						JOptionPane.showMessageDialog(frame,
					errores+"Campos a completar: "+camposVacios, 
					"Error en el registro.", 
					JOptionPane.ERROR_MESSAGE);	
		}
		else {
			Usuario u = controlador.registro(user, new String(contraseña), email, fecha, nombre, apellidos);
			//Mostramos
				JOptionPane.showMessageDialog(frame, 
						"Registro satisfactorio.\n Bienvenido "+u.getNombre(), 
						"Informacion del registro.", 
						JOptionPane.INFORMATION_MESSAGE, 
						null);	
				
		}
		
		System.out.println(camposVacios);
			
	}
	
}
