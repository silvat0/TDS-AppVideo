package umu.tds.vista;

import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import umu.tds.modelo.Video;


@SuppressWarnings("serial")
public class ListaVideos extends JList<Video> {
	

	public class VideoListCellRenderer extends DefaultListCellRenderer {
		
	    @Override
	    public Component getListCellRendererComponent(
	            JList list, Object value, int index,
	            boolean isSelected, boolean cellHasFocus) {
	
	        JLabel label = (JLabel) super.getListCellRendererComponent(
	                list, value, index, isSelected, cellHasFocus);
	        Video v = (Video) value;
	        ImageIcon im = VentanaPrueba2.videoWeb.getThumb(v.getUrl());
	        label.setIcon(im);
	        label.setHorizontalTextPosition(JLabel.CENTER);
	        label.setVerticalTextPosition(JLabel.BOTTOM);
	        label.setText(v.getTitulo());
	        
	        Dimension d = new Dimension(im.getIconWidth()+10, im.getIconHeight()+label.getIconTextGap()+20);
	        label.setMaximumSize(d);
	        label.setPreferredSize(d);
	        label.setMinimumSize(d);
	        
	        return label;
	    }
		
	}
	
	public ListaVideos(List<Video> lista) {
		super(new Vector<>(lista));
		this.setCellRenderer(new VideoListCellRenderer());
		this.setVisibleRowCount(0);
		this.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	}

}
