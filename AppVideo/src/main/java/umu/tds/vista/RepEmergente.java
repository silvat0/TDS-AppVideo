package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import umu.tds.controlador.Lanzadera;
import umu.tds.modelo.Video;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RepEmergente {

	private static RepEmergente instancia;
	private JFrame frame;
	private JPanel panelRep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepEmergente window = new RepEmergente();
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
	public static RepEmergente getInstancia() {
		if (instancia==null) {
			instancia = new RepEmergente();
		}
		return instancia;
	}
	
	private RepEmergente() {
		initialize();
	}
	
	public void reproducir(Video v) {
		frame.setVisible(true);
		((Reproductor) panelRep).reproducir(v);

	}
	
	public JFrame getFrame() {
		return frame;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Reproductor emergente");
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ImageIcon img = new ImageIcon(VentanaLogin.class.getResource("/umu/tds/res/logoicon.png"));
		frame.setIconImage(img.getImage());
		
		panelRep = new Reproductor();
		//((Reproductor) panelRep).mostrar();
		frame.getContentPane().add(panelRep, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Cerrar reproductor emergente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}
	
	public void cerrar() {
		//frame.remove(panelRep);
		Lanzadera.videoWeb.cancel();
		frame.dispose();
	}

}
