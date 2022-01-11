package umu.tds.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.Icon;

import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import java.awt.Point;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import componente.ComponenteBuscadorVideos;
import componente.IBuscadorVideos;
import tds.video.VideoWeb;
import umu.tds.controlador.ControladorAPP;
import umu.tds.modelo.Etiqueta;
import umu.tds.modelo.Filtro;
import umu.tds.modelo.ListaVideo;
import umu.tds.modelo.Video;

import java.awt.SystemColor;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import pulsador.Luz;
import pulsador.IEncendidoListener;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.TitledBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class VentanaPrueba2 {

	private JFrame frame;
	private JTextField buscador;
	private JTable table;
	private JTextField textField;
	private JScrollPane scrollVideosExplorar;
	private JListVideos listaVideosExplorar;
	private JList<Etiqueta> listaEtiqUsed ;
	private JTextField textFieldExplorarNuevaLista;
	private JListVideos listaListas;
	private JScrollPane scrollPane_1;
	private ListaVideo listaAModificar;
	private JComboBox<ListaVideo> comboBox;
	private JScrollPane scrollPane_3;
	private JList<Video> listaNuevaLista;
	private JLabel contadorVideos;
	private JListVideos listaRecientes;
	private JScrollPane scrollVideosRecientes;
	private JScrollPane scrollPaneMisListas;
	
	static boolean emergente=false;
	private JPanel panelReproductorRecientes;
	private JListVideos listaMisListas;
	private JList<Etiqueta> list_etiquetas;
	private DefaultListModel<Etiqueta> modeloEtiqUsadas;
	private JPanel panel_Card;
	private JPanel panelReproductorMisListas;
	private JComboBox<Filtro> comboFiltros;
	private JButton botonTop10;
	private VentanaPrueba2 instancia;
	private JPanel panel_Top10;
	private JListVideos listaTop10;
	private JScrollPane scrollPaneTop10;
	private Reproductor panelReproductorTop;
	private GridBagConstraints gbc_btnNewButton_14;
	private JButton btnNewButton_14;
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba2 window = new VentanaPrueba2();
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
	
	public VentanaPrueba2() {
		initialize();
		instancia=this;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 1042, 685);
		ImageIcon img = new ImageIcon(VentanaLogin.class.getResource("/umu/tds/res/logoicon.png"));
		frame.setIconImage(img.getImage());
		frame.setTitle("AppVideo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{20, 0, 20, 0};
		gbl_panel_1.rowHeights = new int[]{10, 0, 8, 0, 8, 0, 8, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.NORTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{60, 0, 0, 0, 0, 60, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JButton btnLupa = new JButton("");
		
		btnLupa.setIcon(new ImageIcon(VentanaPrueba2.class.getResource("/umu/tds/res/lupa (1).png")));

		
		buscador = new JTextField();
		buscador.setBorder(new TitledBorder(null, "Explorar", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		GridBagConstraints gbc_buscador = new GridBagConstraints();
		gbc_buscador.anchor = GridBagConstraints.SOUTH;
		gbc_buscador.fill = GridBagConstraints.HORIZONTAL;
		gbc_buscador.gridwidth = 3;
		gbc_buscador.insets = new Insets(0, 0, 1, 5);
		gbc_buscador.gridx = 1;
		gbc_buscador.gridy = 0;
		panel_4.add(buscador, gbc_buscador);
		buscador.setColumns(10);
		
	
		GridBagConstraints gbc_btnLupa = new GridBagConstraints();
		gbc_btnLupa.anchor = GridBagConstraints.SOUTH;
		gbc_btnLupa.insets = new Insets(0, 0, 0, 5);
		gbc_btnLupa.gridx = 4;
		gbc_btnLupa.gridy = 0;
		panel_4.add(btnLupa, gbc_btnLupa);
		
		JLabel lblNewLabel_8 = new JLabel("Videos a explorar:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 1;
		panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel contadorVideos = new JLabel(String.valueOf(ControladorAPP.getInstancia().getNVideosSistema()));
		GridBagConstraints gbc_contadorVideos = new GridBagConstraints();
		gbc_contadorVideos.anchor = GridBagConstraints.WEST;
		gbc_contadorVideos.insets = new Insets(0, 0, 0, 5);
		gbc_contadorVideos.gridx = 2;
		gbc_contadorVideos.gridy = 1;
		panel_4.add(contadorVideos, gbc_contadorVideos);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 3;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnNewButton = new JButton("Mis Listas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListaVideo selectedItem = (ListaVideo) comboBox.getSelectedItem();
				if (selectedItem==null) return;
				mostrarMisListas(selectedItem.getVideos());
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_3.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Nueva Lista");
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 0;
		panel_3.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Recientes");
		
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_6.gridx = 4;
		gbc_btnNewButton_6.gridy = 0;
		panel_3.add(btnNewButton_6, gbc_btnNewButton_6);
		
		botonTop10 = new JButton("Top 10");
		
		
		
		
		GridBagConstraints gbc_btnNewButton_13 = new GridBagConstraints();
		gbc_btnNewButton_13.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_13.gridx = 6;
		gbc_btnNewButton_13.gridy = 0;
		panel_3.add(botonTop10, gbc_btnNewButton_13);
		
		panel_Card = new JPanel();
		GridBagConstraints gbc_panel_Card = new GridBagConstraints();
		gbc_panel_Card.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Card.fill = GridBagConstraints.BOTH;
		gbc_panel_Card.gridx = 1;
		gbc_panel_Card.gridy = 5;
		panel_1.add(panel_Card, gbc_panel_Card);
		panel_Card.setLayout(new CardLayout(0, 0));
		
		
		JPanel panel_explorar = new JPanel();
		panel_Card.add(panel_explorar, "panelExplorar");
		//Cuando le das a la lupa se cargan videos y se muestra.
		btnLupa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar();
			}
		});
		panel_explorar.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_explorar.add(panel_9, BorderLayout.CENTER);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{258, 0};
		gbl_panel_9.rowHeights = new int[]{130, 0};
		gbl_panel_9.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		scrollVideosExplorar = new JScrollPane();
		GridBagConstraints gbc_scrollVideosExplorar = new GridBagConstraints();
		gbc_scrollVideosExplorar.fill = GridBagConstraints.BOTH;
		gbc_scrollVideosExplorar.gridx = 0;
		gbc_scrollVideosExplorar.gridy = 0;
		panel_9.add(scrollVideosExplorar, gbc_scrollVideosExplorar);
	
		
		
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_explorar.add(panel_10, BorderLayout.EAST);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{5, 101, 5, 0};
		gbl_panel_10.rowHeights = new int[]{0, 130, 5, 0, 0, 0, 5, 0};
		gbl_panel_10.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		JLabel lblNewLabel_5 = new JLabel("Etiquetas disponibles:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 0;
		panel_10.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(110, 200));
		scrollPane.setMaximumSize(new Dimension(150, 150));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.anchor = GridBagConstraints.WEST;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel_10.add(scrollPane, gbc_scrollPane);
		scrollPane.setMinimumSize(new Dimension(100, 100));
		
		list_etiquetas = new JList<Etiqueta>(new Vector<Etiqueta>(ControladorAPP.getInstancia().getEtiquetas()));
		list_etiquetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				añadirEtiquetaSeleccionadas();
			}
		});
		scrollPane.setViewportView(list_etiquetas);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Etiquedas usadas:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 3;
		panel_10.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(110, 150));
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 4;
		panel_10.add(scrollPane_2, gbc_scrollPane_2);
		
		modeloEtiqUsadas = new DefaultListModel<Etiqueta>();
		listaEtiqUsed = new JList<Etiqueta>(modeloEtiqUsadas);
		listaEtiqUsed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quitarEtiquetaDeSeleccionadas();
			}
		});
		scrollPane_2.setViewportView(listaEtiqUsed);
		
		JButton btnNewButton_7 = new JButton("Reproducir");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Video v = listaVideosExplorar.getSelectedValue();
				reproducirEmergente(v);

			}
		});
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 1;
		gbc_btnNewButton_7.gridy = 5;
		panel_10.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JPanel panel_misListas = new JPanel();
		panel_Card.add(panel_misListas, "panelMyLists");
		panel_misListas.setLayout(new BorderLayout(0, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout c2 = (CardLayout) (panel_Card.getLayout());
				c2.show(panel_Card, "panelMyLists");
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_misListas.add(panel_5, BorderLayout.WEST);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{46, 0};
		gbl_panel_5.rowHeights = new int[]{14, 0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione una lista: "); 
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_5.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboBox = new JComboBox<ListaVideo>(new Vector<ListaVideo>(ControladorAPP.getInstancia().getAllListaVideo()));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ListaVideo sel = ((ListaVideo) comboBox.getSelectedItem());
				mostrarMisListas(sel.getVideos());
				
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel_5.add(comboBox, gbc_comboBox);
		
		scrollPaneMisListas = new JScrollPane();
		scrollPaneMisListas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneMisListas.setPreferredSize(new Dimension(150, 150));
		GridBagConstraints gbc_scrollPaneMisListas = new GridBagConstraints();
		gbc_scrollPaneMisListas.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneMisListas.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneMisListas.gridx = 0;
		gbc_scrollPaneMisListas.gridy = 2;
		panel_5.add(scrollPaneMisListas, gbc_scrollPaneMisListas);
		
		listaMisListas = new JListVideos(new ArrayList<Video>());
		listaMisListas.setLayoutOrientation(JList.VERTICAL);
		scrollPaneMisListas.setViewportView(listaMisListas);
		
		JButton btnNewButton_12 = new JButton("Reproducir");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Video vid = listaMisListas.getSelectedValue();
				reproducirEmbeed((Reproductor) panelReproductorMisListas, vid);

			}
		});
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.gridx = 0;
		gbc_btnNewButton_12.gridy = 3;
		panel_5.add(btnNewButton_12, gbc_btnNewButton_12);
		
		panelReproductorMisListas = new Reproductor();
		panelReproductorMisListas.setVisible(false);
		panel_misListas.add(panelReproductorMisListas, BorderLayout.CENTER);
		
		JPanel panel_nuevaLista = new JPanel();
		panel_Card.add(panel_nuevaLista, "panelnewList");
		panel_nuevaLista.setLayout(new BorderLayout(0, 0));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout c3 = (CardLayout) (panel_Card.getLayout());
				c3.show(panel_Card, "panelnewList");
			}
		});
		//Cuando vas a escribir algo te sale el panel explorar solo
		buscador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CardLayout c1 = (CardLayout) (panel_Card.getLayout());
				c1.show(panel_Card, "panelExplorar");
			}
		});
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_nuevaLista.add(panel_7, BorderLayout.WEST);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0, 6, 0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Introducir nombre de la lista:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_7.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panel_7.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Buscar");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 ListaVideo lista = ControladorAPP.getInstancia().getLista(textField.getText()).orElse(null);
				 if(lista==null) {
					 int res = JOptionPane.showConfirmDialog(frame, 
								"Vaya parece quee esta lista no existe, ¿Desea crearla?", 
								"Crear Lista",
								JOptionPane.YES_NO_OPTION); 
					 if(res == JOptionPane.YES_OPTION) {
						 listaAModificar = ControladorAPP.getInstancia().crearListaVideo(textField.getText());
						 //comboBox = new JComboBox(new Vector(ControladorAPP.getInstancia().getAllListaVideo()));
						 
						 añadirListaCombo();
						 
					 }
				 }
				 else {
					 listaAModificar=lista;
					 mostrarListaNuevaLista(listaAModificar);
					 
					 
				 }
			}
				
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 1;
		panel_7.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Eliminar");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int res = JOptionPane.showConfirmDialog(frame, 
							"¿Seguro que quieres eliminar la lista?", 
							"Eliminar Lista",
							JOptionPane.YES_NO_OPTION); 
				 if(res == JOptionPane.YES_OPTION) {
					 if (listaAModificar!=null) {
							ControladorAPP.getInstancia().eliminarListaVideo(listaAModificar); 
							listaAModificar = null;
							mostrarListaNuevaLista(listaAModificar);
							comboBox.setModel(new DefaultComboBoxModel<ListaVideo>(new Vector<ListaVideo>(ControladorAPP.getInstancia().getAllListaVideo())));
						}
				 }
				
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridwidth = 2;
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 2;
		panel_7.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_8 = new JButton("Añadir");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (listaAModificar!=null) {
					List<Video> videosSelect = new LinkedList<>();
					videosSelect = listaListas.getSelectedValuesList();
					ControladorAPP.getInstancia().añadirVideoLV(listaAModificar, videosSelect);
					mostrarListaNuevaLista(listaAModificar);
				}
				
				
			}
		});
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setPreferredSize(new Dimension(110, 200));
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridwidth = 2;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 3;
		panel_7.add(scrollPane_3, gbc_scrollPane_3);
		
		listaNuevaLista = new JList<Video>();
		listaNuevaLista.setPreferredSize(new Dimension(100, 150));
		scrollPane_3.setViewportView(listaNuevaLista);
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 0;
		gbc_btnNewButton_8.gridy = 4;
		panel_7.add(btnNewButton_8, gbc_btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Quitar");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (listaAModificar!=null) {
					/*List<Video> videosSelect = new LinkedList<>();
					videosSelect = listaNuevaLista.getSelectedValuesList();
					ControladorAPP.getInstancia().eliminarVideoLV(videosSelect, listaAModificar);
					mostrarListaNuevaLista(listaAModificar);*/
					
					int[] idx;
					idx = listaNuevaLista.getSelectedIndices();
					ControladorAPP.getInstancia().eliminarVideoLV(idx, listaAModificar);
					mostrarListaNuevaLista(listaAModificar);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_9.gridx = 1;
		gbc_btnNewButton_9.gridy = 4;
		panel_7.add(btnNewButton_9, gbc_btnNewButton_9);
		
		JPanel panel_8 = new JPanel();
		panel_nuevaLista.add(panel_8, BorderLayout.CENTER);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		textFieldExplorarNuevaLista = new JTextField();
		GridBagConstraints gbc_textFieldExplorarNuevaLista = new GridBagConstraints();
		gbc_textFieldExplorarNuevaLista.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldExplorarNuevaLista.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldExplorarNuevaLista.gridx = 1;
		gbc_textFieldExplorarNuevaLista.gridy = 0;
		panel_8.add(textFieldExplorarNuevaLista, gbc_textFieldExplorarNuevaLista);
		textFieldExplorarNuevaLista.setColumns(10);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarLista();
			}
		});
		btnNewButton_11.setIcon(new ImageIcon(VentanaPrueba2.class.getResource("/umu/tds/res/lupa (1).png")));
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 2;
		gbc_btnNewButton_11.gridy = 0;
		panel_8.add(btnNewButton_11, gbc_btnNewButton_11);

		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_8.add(scrollPane_1, gbc_scrollPane_1);
		
		listaListas = new JListVideos(new LinkedList<>());
		scrollPane_1.setViewportView(listaListas);
		
		JPanel panel_recientes = new JPanel();
		panel_Card.add(panel_recientes, "panelRecents");
		GridBagLayout gbl_panel_recientes = new GridBagLayout();
		gbl_panel_recientes.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_recientes.rowHeights = new int[]{0, 0, 0};
		gbl_panel_recientes.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_recientes.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_recientes.setLayout(gbl_panel_recientes);
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout c4 = (CardLayout) (panel_Card.getLayout());
				c4.show(panel_Card, "panelRecents");
				mostrarRecientes();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Videos vistos recientemente por");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_recientes.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel nombreLBL = new JLabel("");
		nombreLBL.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_nombreLBL = new GridBagConstraints();
		gbc_nombreLBL.anchor = GridBagConstraints.WEST;
		gbc_nombreLBL.insets = new Insets(0, 0, 5, 5);
		gbc_nombreLBL.gridx = 1;
		gbc_nombreLBL.gridy = 0;
		panel_recientes.add(nombreLBL, gbc_nombreLBL);
		nombreLBL.setText(ControladorAPP.getInstancia().getUsuario().getUsername());
		
		JPanel panelVideosRecientes = new JPanel();
		GridBagConstraints gbc_panelVideosRecientes = new GridBagConstraints();
		gbc_panelVideosRecientes.insets = new Insets(0, 0, 0, 5);
		gbc_panelVideosRecientes.fill = GridBagConstraints.BOTH;
		gbc_panelVideosRecientes.gridx = 0;
		gbc_panelVideosRecientes.gridy = 1;
		panel_recientes.add(panelVideosRecientes, gbc_panelVideosRecientes);
		GridBagLayout gbl_panelVideosRecientes = new GridBagLayout();
		gbl_panelVideosRecientes.columnWidths = new int[]{0, 0};
		gbl_panelVideosRecientes.rowHeights = new int[]{0, 0, 0};
		gbl_panelVideosRecientes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelVideosRecientes.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panelVideosRecientes.setLayout(gbl_panelVideosRecientes);
		
		scrollVideosRecientes = new JScrollPane();
		//scrollVideosRecientes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollVideosRecientes = new GridBagConstraints();
		gbc_scrollVideosRecientes.fill = GridBagConstraints.BOTH;
		gbc_scrollVideosRecientes.insets = new Insets(0, 0, 5, 0);
		gbc_scrollVideosRecientes.gridx = 0;
		gbc_scrollVideosRecientes.gridy = 0;
		panelVideosRecientes.add(scrollVideosRecientes, gbc_scrollVideosRecientes);
		
		listaRecientes = new JListVideos(ControladorAPP.getInstancia().getRecientes());
		scrollVideosRecientes.setViewportView(listaRecientes);
		
		JButton btnNewButton_10 = new JButton("Reproducir");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirEmbeed((Reproductor) panelReproductorRecientes,listaRecientes.getSelectedValue());
				
			}
		});
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.gridx = 0;
		gbc_btnNewButton_10.gridy = 1;
		panelVideosRecientes.add(btnNewButton_10, gbc_btnNewButton_10);
		
		panelReproductorRecientes = new Reproductor();
		panelReproductorRecientes.setVisible(false);
		GridBagConstraints gbc_panelReproductorRecientes = new GridBagConstraints();
		gbc_panelReproductorRecientes.fill = GridBagConstraints.BOTH;
		gbc_panelReproductorRecientes.gridx = 3;
		gbc_panelReproductorRecientes.gridy = 1;
		panel_recientes.add(panelReproductorRecientes, gbc_panelReproductorRecientes);
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{20, 0, 20, 0};
		gbl_panel.rowHeights = new int[]{15, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 51, 51));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.SOUTH;
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 20, 0, 20, 0, 20, 0, 5, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		BufferedImage image = null;
		try {
			image = ImageIO.read(VentanaLogin.class.getResource("/umu/tds/res/logonegro.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Image dimg = image.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
		lblNewLabel.setIcon(imageIcon);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel usernameLBL = new JLabel("user");
		usernameLBL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_usernameLBL = new GridBagConstraints();
		gbc_usernameLBL.anchor = GridBagConstraints.WEST;
		gbc_usernameLBL.insets = new Insets(0, 0, 0, 5);
		gbc_usernameLBL.gridx = 3;
		gbc_usernameLBL.gridy = 0;
		panel_2.add(usernameLBL, gbc_usernameLBL);
		usernameLBL.setText(ControladorAPP.getInstancia().getUsuario().getUsername());
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int res = JOptionPane.showConfirmDialog(frame, 
														"¿Estas seguro de que quieres cerrar sesion?", 
														"Logout",
														JOptionPane.YES_NO_OPTION); 
				if(res == JOptionPane.YES_OPTION) {
					VentanaLogin vl = new VentanaLogin();
					vl.mostrarVentana();
					frame.dispose();
					
				}
						
				
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("Filtros:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 5;
		gbc_lblNewLabel_7.gridy = 0;
		panel_2.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		comboFiltros = new JComboBox<Filtro>(new Vector<>(ControladorAPP.getInstancia().getFiltros()));
		comboFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorAPP.getInstancia().setFiltro((Filtro) comboFiltros.getSelectedItem());

			}
		});

		comboFiltros.setEnabled(ControladorAPP.getInstancia().getUsuario().isPremium());
		comboFiltros.setEditable(false);
		comboFiltros.setPreferredSize(new Dimension(50, 22));
		GridBagConstraints gbc_comboFiltros = new GridBagConstraints();
		gbc_comboFiltros.insets = new Insets(0, 0, 0, 5);
		gbc_comboFiltros.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboFiltros.gridx = 6;
		gbc_comboFiltros.gridy = 0;
		panel_2.add(comboFiltros, gbc_comboFiltros);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 8;
		gbc_btnNewButton_2.gridy = 0;
		panel_2.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Premium");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPremium pr = new VentanaPremium();
				pr.mostrarVentanta(instancia);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.gridx = 10;
		gbc_btnNewButton_1.gridy = 0;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
		
		Luz luz = new Luz();
		luz.addEncendidoListener(new IEncendidoListener() {
			public void enteradoCambioEncendido(EventObject arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileNameExtensionFilter("XML FILES", "xml"));
				if (fc.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION) {
					ControladorAPP.getInstancia().cargar(fc.getSelectedFile());
					contadorVideos.setText(String.valueOf(ControladorAPP.getInstancia().getNVideosSistema()));
				
					list_etiquetas = new JList<Etiqueta>(new Vector<Etiqueta>(ControladorAPP.getInstancia().getEtiquetas()));
					scrollPane.setViewportView(list_etiquetas);


					

				};
			}
		});
		GridBagConstraints gbc_luz = new GridBagConstraints();
		gbc_luz.insets = new Insets(0, 0, 0, 5);
		gbc_luz.gridx = 12;
		gbc_luz.gridy = 0;
		panel_2.add(luz, gbc_luz);
		
		CardLayout c4 = (CardLayout) (panel_Card.getLayout());
		c4.show(panel_Card, "panelRecents");
		
		panel_Top10 = new JPanel();
		panel_Card.add(panel_Top10, "panelTop10");
		panel_Top10.setLayout(new BorderLayout(0, 0));
		botonTop10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c5 = (CardLayout) (panel_Card.getLayout());
				c5.show(panel_Card, "panelTop10");
			}
		});
	
		
		JPanel panel_6 = new JPanel();
		panel_Top10.add(panel_6, BorderLayout.NORTH);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		scrollPaneTop10 = new JScrollPane();
		scrollPaneTop10.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneTop10.setPreferredSize(new Dimension(300, 130));
		GridBagConstraints gbc_scrollPaneTop10 = new GridBagConstraints();
		gbc_scrollPaneTop10.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTop10.gridx = 0;
		gbc_scrollPaneTop10.gridy = 0;
		panel_6.add(scrollPaneTop10, gbc_scrollPaneTop10);
		
		mostrarTop10();
		
		JPanel panel_11 = new JPanel();
		panel_Top10.add(panel_11, BorderLayout.CENTER);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] {};
		gbl_panel_11.rowHeights = new int[] {0, 0, 0};
		gbl_panel_11.columnWeights = new double[]{1.0};
		gbl_panel_11.rowWeights = new double[]{0.0, 0.0, 1.0};
		panel_11.setLayout(gbl_panel_11);
		
		btnNewButton_14 = new JButton("Reproducir");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirEmbeed(panelReproductorTop, listaTop10.getSelectedValue());
			}
		});
		GridBagConstraints gbc_btnNewButton_14;
		gbc_btnNewButton_14 = new GridBagConstraints();
		gbc_btnNewButton_14.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_14.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_14.gridx = 0;
		gbc_btnNewButton_14.gridy = 0;
		panel_11.add(btnNewButton_14, gbc_btnNewButton_14);
		
		panelReproductorTop = new Reproductor();
		panelReproductorTop.setVisible(false);
		
		GridBagConstraints gbc_panelReproductorTop = new GridBagConstraints();
		gbc_panelReproductorTop.fill = GridBagConstraints.BOTH;
		gbc_panelReproductorTop.gridx = 0;
		gbc_panelReproductorTop.gridy = 2;
		panel_11.add(panelReproductorTop, gbc_panelReproductorTop);
		
		cargarCosasPremuim();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void mostrarListaExplorar(String titulo, Etiqueta...etiquetas) {
		listaVideosExplorar = new JListVideos(ControladorAPP.getInstancia().buscar(titulo,etiquetas)); 
		scrollVideosExplorar.setViewportView(listaVideosExplorar);
	}
	
	private void mostrarLista() {
		listaListas = new JListVideos(ControladorAPP.getInstancia().buscar(textFieldExplorarNuevaLista.getText()));
		scrollPane_1.setViewportView(listaListas);
	}
	
	private void mostrarListaNuevaLista(ListaVideo lista) { 
		if(lista==null) {
			scrollPane_3.setViewportView(null);
			return;
		}
		listaNuevaLista = new JListVideos(lista.getVideos());
		scrollPane_3.setViewportView(listaNuevaLista);
	}
	private void mostrarRecientes() {
		scrollVideosRecientes.setViewportView(listaRecientes);
	}
	
	private void mostrarMisListas(List<Video> lv) {
		listaMisListas=new JListVideos(lv);
		scrollPaneMisListas.setViewportView(listaMisListas);
	}
	
	private void quitarEtiquetaDeSeleccionadas() {
		int idx = listaEtiqUsed.getSelectedIndex();
		modeloEtiqUsadas.remove(idx);
	}

	private void añadirEtiquetaSeleccionadas() {
		Etiqueta sel =  (Etiqueta) list_etiquetas.getSelectedValue();
		if (modeloEtiqUsadas.contains(sel))
			return;
		modeloEtiqUsadas.addElement(sel);
		listaEtiqUsed.setModel(modeloEtiqUsadas);
	}

	private void buscar() {
		Etiqueta[] ets = new Etiqueta[modeloEtiqUsadas.size()];
		Iterator<Etiqueta> it = modeloEtiqUsadas.elements().asIterator();
		int i=0;
		while(it.hasNext()) {
			ets[i] = it.next();
			i++;
		}
		mostrarListaExplorar(buscador.getText(),ets);
		CardLayout c1 = (CardLayout) (panel_Card.getLayout());
		c1.show(panel_Card, "panelExplorar");
	}
	
	private void reproducirEmergente(Video v) {
		RepEmergente.getInstancia().reproducir(v);
		
	}


	private void reproducirEmbeed(Reproductor r, Video v) {
		r.setVisible(true);
		r.reproducir(v);
	}
	
	public void cargarCosasPremuim() {
		boolean p = ControladorAPP.getInstancia().getUsuario().isPremium();
		comboFiltros.setEnabled(p);	
		botonTop10.setEnabled(p);
		
		if(p) {
			//ListaVideo sel = ((ListaVideo) ControladorAPP.getInstancia().getTopTen());
			mostrarTop10();
		}
		btnNewButton_14.setEnabled(p);
		listaTop10.setVisible(p);
		comboFiltros.setSelectedIndex(0);
		ControladorAPP.getInstancia().setFiltro(Filtro.VACIO);
	
	}
	
	private void mostrarTop10() {
		List<Video> topTen = ControladorAPP.getInstancia().getTopTen();
		listaTop10 = new JListVideos(topTen);
		listaTop10.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listaTop10.setVisibleRowCount(1);
		scrollPaneTop10.setViewportView(listaTop10);
	}
	
	private void añadirListaCombo() {
		comboBox.setModel(new DefaultComboBoxModel<ListaVideo>(new Vector<ListaVideo>(ControladorAPP.getInstancia().getAllListaVideo())));
	}
	
}
