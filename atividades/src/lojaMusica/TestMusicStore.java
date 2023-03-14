package lojaMusica;

public class TestMusicStore{
	 public static void main (String args[]) {
		 MusicStore loja = new MusicStore();
		 loja.setOwner("Luan");
		 loja.getOpenClosedMessage();
		 loja.displayHoursOfOperation();
		 
		 MusicTitle album = new MusicTitle();
		 album.setTitle("Heroes");
		 album.setArtist("David Bowie");
		 loja.setTitle(album, 0);
		 
		 loja.displayMusicTitles();
		 
		 System.out.println(loja.toString());
	}
}