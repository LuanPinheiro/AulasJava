package lojaMusica;

public class MusicTitle{
	String title;
	String artist;
	
	public MusicTitle() {
		this.title = "Sem Titulo";
		this.artist = "Sem Artista";
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getArtist() {
		return this.artist;
	}
}