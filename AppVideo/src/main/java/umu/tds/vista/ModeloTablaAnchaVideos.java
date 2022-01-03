package umu.tds.vista;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import umu.tds.modelo.Video;


public class ModeloTablaAnchaVideos extends DefaultTableModel {
	
	public static final int COLUMNAS = 4;
	private int filas;
	private List<Video> videos;
	
	public ModeloTablaAnchaVideos(List<Video> videos) {
		this.videos = videos;
		filas=1;
		
	}

	@Override
	public int getRowCount() {
		return filas;
	}

	@Override
	public int getColumnCount() {
		return COLUMNAS;
	}
	

	@Override
	public Video getValueAt(int rowIndex, int columnIndex) {
		
		if (rowIndex < 0 || rowIndex >= getRowCount())
			return null;
		if (columnIndex <0 || columnIndex >= getColumnCount())
			return null;
		
		return videos.get(COLUMNAS*rowIndex + columnIndex);
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return Video.class;
	}
}
