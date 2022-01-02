package componente;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ComponenteBuscadorVideos implements Serializable, IBuscadorVideos {
	
	private List<VideosListener> listeners = new ArrayList();
	private File archivoVideos;

	public void buscarVideos(File xml) {
		
		setArchivoVideos(xml);
	}

	public File getArchivoVideos() {
		return archivoVideos;
	}

	public void setArchivoVideos(File archivoVideos) {
		this.archivoVideos = archivoVideos;
		notificarNuevosVideos(new VideosEvent(this, MapperVideosXMLtoJava.cargarVideos(archivoVideos.getAbsolutePath())));
	}
	
	private void notificarNuevosVideos(VideosEvent ev) {
		listeners.stream().forEach(l -> l.nuevosVideos(ev) );
	}
	
	public synchronized void addArchivoListener(VideosListener listener) {
		listeners.add(listener);
	}

}
