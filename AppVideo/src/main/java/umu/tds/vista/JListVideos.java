package umu.tds.vista;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import umu.tds.controlador.Lanzadera;
import umu.tds.modelo.Video;


@SuppressWarnings("serial")
public class JListVideos extends JList<Video> {
	
	public class VideoListModel extends AbstractListModel<Video>{
		
		private List<Video> lista;
		public VideoListModel(List<Video> lv) {
			lista=lv ;
		}

		public int getSize() {
			return lista.size();
		}

		@Override
		public Video getElementAt(int index) {
			return lista.get(index);
		}
		
		public List<Video> getVideos(){
			return lista;
		}

	}

	public class VideoListCellRenderer extends DefaultListCellRenderer {
		
	    @Override
	    public Component getListCellRendererComponent(
	            JList list, Object value, int index,
	            boolean isSelected, boolean cellHasFocus) {
	
	        JLabel label = (JLabel) super.getListCellRendererComponent(
	                list, value, index, isSelected, cellHasFocus);
	        Video v = (Video) value;
	        ImageIcon im;
	        if (Lanzadera.videoWeb!=null)
	        	im = Lanzadera.videoWeb.getThumb(v.getUrl());
	        else im = new ImageIcon();
	        
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
	private List<Video> lista;
	public JListVideos(List<Video> lista) {
		
		super();
		this.setModel(new VideoListModel(lista));
		this.setCellRenderer(new VideoListCellRenderer());
		this.setVisibleRowCount(0);
		this.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	}
	


}
