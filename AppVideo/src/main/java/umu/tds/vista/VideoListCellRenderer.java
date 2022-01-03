package umu.tds.vista;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import umu.tds.modelo.Video;

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
        return label;
    }
	
}