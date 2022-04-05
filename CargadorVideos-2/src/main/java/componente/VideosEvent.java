package componente;

import java.util.EventObject;

@SuppressWarnings("serial")
public class VideosEvent extends EventObject{

	protected Videos videos;
	public VideosEvent(Object source, Videos videos) {
		super(source);
		this.videos=videos;
	}
	
	public Videos getVideos() {
		return videos;
	}

}
