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

import java.awt.SystemColor;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import pulsador.Luz;
import pulsador.IEncendidoListener;
import java.util.EventObject;

public class VentanaPrueba2 {

	private JFrame frame;
	private JTextField buscador;
	private JTable table;
	public static VideoWeb videoWeb;
	private JTable table_1;
	private JTextField textField;
	private JTable table_2;
	private JTable table_3;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					videoWeb = new VideoWeb();
					VentanaPrueba2 window = new VentanaPrueba2();
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
	public VentanaPrueba2() {
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
		frame = new JFrame();
		frame.setBounds(100, 100, 968, 571);
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
		gbl_panel_4.columnWidths = new int[]{60, 0, 0, 60, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JButton btnLupa = new JButton("");
		
		btnLupa.setIcon(new ImageIcon(VentanaPrueba2.class.getResource("/umu/tds/res/lupa (1).png")));
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		buscador = new JTextField();
		GridBagConstraints gbc_buscador = new GridBagConstraints();
		gbc_buscador.insets = new Insets(0, 0, 5, 5);
		gbc_buscador.fill = GridBagConstraints.HORIZONTAL;
		gbc_buscador.gridx = 1;
		gbc_buscador.gridy = 0;
		panel_4.add(buscador, gbc_buscador);
		buscador.setColumns(10);
		
	
		GridBagConstraints gbc_btnLupa = new GridBagConstraints();
		gbc_btnLupa.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLupa.insets = new Insets(0, 0, 5, 5);
		gbc_btnLupa.gridx = 2;
		gbc_btnLupa.gridy = 0;
		panel_4.add(btnLupa, gbc_btnLupa);
		
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
		
		JPanel panel_Card = new JPanel();
		GridBagConstraints gbc_panel_Card = new GridBagConstraints();
		gbc_panel_Card.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Card.fill = GridBagConstraints.BOTH;
		gbc_panel_Card.gridx = 1;
		gbc_panel_Card.gridy = 5;
		panel_1.add(panel_Card, gbc_panel_Card);
		panel_Card.setLayout(new CardLayout(0, 0));
		((CardLayout) panel_Card.getLayout()).show(panel_Card, "panel_misListas");
		
		
		JPanel panel_explorar = new JPanel();
		panel_Card.add(panel_explorar, "panelExplorar");
		GridBagLayout gbl_panel_explorar = new GridBagLayout();
		gbl_panel_explorar.rowHeights = new int[]{2, 0, 67};
		gbl_panel_explorar.columnWeights = new double[]{1.0, 1.0, 0.0};
		gbl_panel_explorar.rowWeights = new double[]{0.0, 0.0, 1.0};
		panel_explorar.setLayout(gbl_panel_explorar);
		btnLupa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout c1 = (CardLayout) (panel_Card.getLayout());
				c1.show(panel_Card, "panelExplorar");
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(100, 100));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		panel_explorar.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"oleeeeeeeeeeee", "olesd", "sf", "asd", "c", "", "cdsa", "c", "a"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_explorar.add(scrollPane_1, gbc_scrollPane_1);
		
		
		
	    String[] columns = {"", "", "", ""};
	    //data for JTable in a 2D table
	    //ImageIcon thum = videoWeb.getThumb("https://www.youtube.com/watch?v=0243Z0YXPpY");
//	    Object[][] data = {
//	      {thum, thum, thum,thum},
//	      {2, "Jean", "Arizona", new ImageIcon(VentanaPrueba2.class.getResource("/umu/tds/res/lupa (1).png")) },
//	      {4, "Emily", "Florida", new ImageIcon() }
//	    };
//		
	    //DefaultTableModel model = new DefaultTableModel(data, columns);
		JTable table = new JTable() {
//			@Override
//			public Class<?> getColumnClass(int column) {
//				// TODO Auto-generated method stub
//				return Icon.class;
//			}

			
		};
		
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		table.setFillsViewportHeight(true);
		//table.setModel(model);
		table.setRowHeight(100);
		table.setTableHeader(null);
		



		scrollPane_1.setViewportView(table);
		
		
	
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
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione una lista: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_5.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel_5.add(comboBox, gbc_comboBox);
		
		table_1 = new JTable();
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.insets = new Insets(0, 0, 5, 0);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 2;
		panel_5.add(table_1, gbc_table_1);
		
		JPanel panel_6 = new JPanel();
		panel_misListas.add(panel_6, BorderLayout.CENTER);
		
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
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_nuevaLista.add(panel_7, BorderLayout.WEST);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0, 0, 6, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 1;
		panel_7.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Eliminar");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridwidth = 2;
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 2;
		panel_7.add(btnNewButton_5, gbc_btnNewButton_5);
		
		table_2 = new JTable();
		GridBagConstraints gbc_table_2 = new GridBagConstraints();
		gbc_table_2.insets = new Insets(0, 0, 5, 0);
		gbc_table_2.gridwidth = 2;
		gbc_table_2.fill = GridBagConstraints.BOTH;
		gbc_table_2.gridx = 0;
		gbc_table_2.gridy = 3;
		panel_7.add(table_2, gbc_table_2);
		
		JButton btnNewButton_8 = new JButton("Añadir");
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 0;
		gbc_btnNewButton_8.gridy = 5;
		panel_7.add(btnNewButton_8, gbc_btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Quitar");
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_9.gridx = 1;
		gbc_btnNewButton_9.gridy = 5;
		panel_7.add(btnNewButton_9, gbc_btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Aceptar");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.gridwidth = 2;
		gbc_btnNewButton_10.gridx = 0;
		gbc_btnNewButton_10.gridy = 7;
		panel_7.add(btnNewButton_10, gbc_btnNewButton_10);
		
		JPanel panel_8 = new JPanel();
		panel_nuevaLista.add(panel_8, BorderLayout.CENTER);
		
		JPanel panel_recientes = new JPanel();
		panel_Card.add(panel_recientes, "panelRecents");
		GridBagLayout gbl_panel_recientes = new GridBagLayout();
		gbl_panel_recientes.columnWidths = new int[]{0, 0, 0};
		gbl_panel_recientes.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_recientes.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_recientes.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_recientes.setLayout(gbl_panel_recientes);
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout c4 = (CardLayout) (panel_Card.getLayout());
				c4.show(panel_Card, "panelRecents");
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
		gbc_nombreLBL.insets = new Insets(0, 0, 5, 0);
		gbc_nombreLBL.gridx = 1;
		gbc_nombreLBL.gridy = 0;
		panel_recientes.add(nombreLBL, gbc_nombreLBL);
		nombreLBL.setText(ControladorAPP.getInstancia().getUsuario().getUsername());
		
		table_3 = new JTable();
		GridBagConstraints gbc_table_3 = new GridBagConstraints();
		gbc_table_3.gridwidth = 2;
		gbc_table_3.insets = new Insets(0, 0, 0, 5);
		gbc_table_3.fill = GridBagConstraints.BOTH;
		gbc_table_3.gridx = 0;
		gbc_table_3.gridy = 2;
		panel_recientes.add(table_3, gbc_table_3);
		
		
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
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 20, 0, 5, 0, 5, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int res = JOptionPane.showConfirmDialog(frame, 
														"¿Estas seguro de que quieres cerrar sesion?", 
														"Logout",
														JOptionPane.YES_NO_OPTION); 
				if(res == JOptionPane.YES_OPTION) {
					VentanaLogin.main(null);
					frame.dispose();
				}
						
				
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 0;
		panel_2.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Premium");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPremium.main(null);
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.gridx = 7;
		gbc_btnNewButton_1.gridy = 0;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
		
		Luz luz = new Luz();
		luz.addEncendidoListener(new IEncendidoListener() {
			public void enteradoCambioEncendido(EventObject arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileNameExtensionFilter("XML FILES", "xml"));
				if (fc.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION) {
					ControladorAPP.getInstancia().cargar(fc.getSelectedFile());
					PruebasGrid.main(null);
				};
			}
		});
		GridBagConstraints gbc_luz = new GridBagConstraints();
		gbc_luz.insets = new Insets(0, 0, 0, 5);
		gbc_luz.gridx = 9;
		gbc_luz.gridy = 0;
		panel_2.add(luz, gbc_luz);
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
}
