package umu.tds.vista;

import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import umu.tds.modelo.Video;



public class TablaVideos extends JTable {
	
	//Renderizador para un objeto video
	public class VideoRenderer extends DefaultTableCellRenderer {

        public VideoRenderer() {
            setHorizontalTextPosition(JLabel.CENTER);
            setVerticalTextPosition(JLabel.BOTTOM);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        	
            JLabel r = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
            Video vid = (Video) value;
            String url = vid.getUrl();
            r.setIcon(VentanaPrueba2.videoWeb.getThumb(url));
            r.setText(vid.getTitulo());
            return r;
        }
    }
	
	
	public TablaVideos(List<Video> lv) {
		ModeloTablaAnchaVideos modelo = new ModeloTablaAnchaVideos(lv);
        this.setAutoCreateRowSorter(true);
        this.setDefaultRenderer(Video.class, new VideoRenderer());

	}
	
    @Override
    public int getRowHeight() {
    	
        return super.getRowHeight() + 300;
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(
            (5 * super.getPreferredSize().width) / 4,
            4 * this.getRowHeight());
    }

}
