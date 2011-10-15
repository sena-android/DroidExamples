package co.edu.sena.mobile.db.model;

import java.util.List;

public class Song {
	private long id;
	private String name; 
	private String author;
	private String genre;
	private String album;
	private long year; 
	private long track;

	
	 public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}


	public long getYear() {
		return year;
	}


	public void setYear(long year) {
		this.year = year;
	}


	public long getTrack() {
		return track;
	}


	public void setTrack(long track) {
		this.track = track;
	}


	@Override
     public String toString() {
         return this.name + " " + this.author + ", " + this.album;
     }

}
