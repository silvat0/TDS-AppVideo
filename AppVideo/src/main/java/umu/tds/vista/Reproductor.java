package umu.tds.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Random;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import tds.video.VideoWeb;
import umu.tds.controlador.ControladorAPP;
import umu.tds.modelo.Video;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reproductor extends JPanel {
	
	private static Reproductor instancia;
	private JPanel panelEtiquetas;
	private JPanel panel_2;
	private JPanel panelReproductor;
	private JLabel visitasLabel;
	private JLabel tituloLabel;
	private JTextField textFieldNombreEtq;
	
	private JLabel randColorLabel(String s) {
		JLabel lbl = new JLabel(s);
		lbl.setOpaque(true);
		Random r = new Random();
		lbl.setBackground(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), 75));
		lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		return lbl;
	}
	
	private void rellenarEtiq() {
		ControladorAPP.getInstancia().getUltimoVideo().getEtiquetas().stream().forEach(e -> panelEtiquetas.add(randColorLabel(e.getNombre())));
		panelEtiquetas.revalidate();
        panelEtiquetas.repaint();
	}
	
	public void reproducir(Video v) {
		
		VentanaPrueba2.videoWeb.playVideo(v.getUrl());
		ControladorAPP.getInstancia().reproducir(v);
		this.setVisible(true);
		panelEtiquetas.removeAll();
		Video ultimoVideo = ControladorAPP.getInstancia().getUltimoVideo();
		visitasLabel.setText(String.valueOf(ultimoVideo.getVisitas()));
		tituloLabel.setText(ultimoVideo.getTitulo());
		rellenarEtiq();
		crearPanelRep();
		panelReproductor.revalidate();
		panelReproductor.repaint();
		this.setVisible(true);


	}
	
	public static Reproductor getInstancia() {
		if (instancia==null) {
			instancia = new Reproductor();
		}
		return instancia;
	}


	/**
	 * Create the panel.
	 */
	public Reproductor() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {10, 30, 10};
		gridBagLayout.rowHeights = new int[] {10, 30, 0, 10};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		crearPanelRep();
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.NORTH;
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {0};
		gbl_panel_2.rowHeights = new int[] {0, 10, 0, 0, 0, 30};
		gbl_panel_2.columnWeights = new double[]{1.0};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		panel_2.setLayout(gbl_panel_2);
		
		ponerEtiquetas();
		//ControladorAPP.getInstancia().getUltimoVideo().getEtiquetas().stream().forEach(e -> panelEtiquetas.add(new JLabel(e.getNombre())));

		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 4;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		textFieldNombreEtq = new JTextField("");
		textFieldNombreEtq.setColumns(15);
		GridBagConstraints gbc_textFieldNombreEtq = new GridBagConstraints();
		gbc_textFieldNombreEtq.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombreEtq.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldNombreEtq.gridx = 1;
		gbc_textFieldNombreEtq.gridy = 0;
		panel_4.add(textFieldNombreEtq, gbc_textFieldNombreEtq);
		
		JButton btnNewButton = new JButton("Nueva etiqueta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nom = textFieldNombreEtq.getText();
				if (nom.strip().isBlank()) {
					return;
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel_4.add(btnNewButton, gbc_btnNewButton);

	}
	

	private void crearPanelRep() {
		panelReproductor = new JPanel();
		GridBagConstraints gbc_panelReproductor = new GridBagConstraints();
		gbc_panelReproductor.insets = new Insets(0, 0, 5, 5);
		gbc_panelReproductor.fill = GridBagConstraints.BOTH;
		gbc_panelReproductor.gridx = 1;
		gbc_panelReproductor.gridy = 1;
		add(panelReproductor, gbc_panelReproductor);
		panelReproductor.add(VentanaPrueba2.videoWeb);
	}

	private void ponerEtiquetas() {
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel_2.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {30, 30, 10, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{14, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_2 = new JLabel("Titulo: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tituloLabel = new JLabel("New label");
		GridBagConstraints gbc_tituloLabel = new GridBagConstraints();
		gbc_tituloLabel.insets = new Insets(0, 0, 0, 5);
		gbc_tituloLabel.anchor = GridBagConstraints.WEST;
		gbc_tituloLabel.gridx = 1;
		gbc_tituloLabel.gridy = 0;
		panel.add(tituloLabel, gbc_tituloLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Visitas:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		visitasLabel = new JLabel("New label");
		GridBagConstraints gbc_visitasLabel = new GridBagConstraints();
		gbc_visitasLabel.insets = new Insets(0, 0, 0, 5);
		gbc_visitasLabel.anchor = GridBagConstraints.EAST;
		gbc_visitasLabel.gridx = 4;
		gbc_visitasLabel.gridy = 0;
		panel.add(visitasLabel, gbc_visitasLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Etiquetas:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		panelEtiquetas = new JPanel();
		GridBagConstraints gbc_panelEtiquetas = new GridBagConstraints();
		gbc_panelEtiquetas.insets = new Insets(0, 0, 5, 0);
		gbc_panelEtiquetas.fill = GridBagConstraints.BOTH;
		gbc_panelEtiquetas.gridx = 0;
		gbc_panelEtiquetas.gridy = 3;
		panel_2.add(panelEtiquetas, gbc_panelEtiquetas);
		rellenarEtiq();
		//panelEtiquetas.setVisible(true);
	}
	
	

}
