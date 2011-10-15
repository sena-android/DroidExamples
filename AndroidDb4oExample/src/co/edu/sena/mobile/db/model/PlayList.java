package co.edu.sena.mobile.db.model;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

	private String title;
    private List<Song> songs = new ArrayList<Song>();
    
    
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	
	
	
	
	
}
