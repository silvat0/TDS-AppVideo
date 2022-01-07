package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tds.video.VideoWeb;
import umu.tds.modelo.Video;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

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
	
	public void mostrar() {
		frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void play(Video v) {
		//VentanaPrueba2.videoWeb.playVideo(v.getUrl());
		panelRep = Reproductor.getInstancia();
		((Reproductor) panelRep).play(v);
		frame.setVisible(true);
		frame.getContentPane().add(panelRep, BorderLayout.CENTER);

		
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 400, 500);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panelRep = new JPanel();
		frame.getContentPane().add(panelRep, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Cerrar reproductor emergente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}
	
	public void cerrar() {
		VentanaPrueba2.videoWeb.cancel();
		frame.dispose();
	}

}
