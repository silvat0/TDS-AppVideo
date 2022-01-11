package umu.tds.controlador;

import java.awt.EventQueue;

import tds.video.VideoWeb;
import umu.tds.vista.VentanaLogin;

public class Lanzadera {
	/**
	 * Launch the application.
	 */
	public static VideoWeb videoWeb;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					videoWeb = new VideoWeb();
					VentanaLogin window = new VentanaLogin();
					window.mostrarVentana();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
