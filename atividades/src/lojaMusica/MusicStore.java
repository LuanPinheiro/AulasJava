package lojaMusica;

import java.util.Calendar;

public class MusicStore{
	int openTime;
	int closeTime;
	String owner;
	MusicTitle[] discos = new MusicTitle[10];
	
	public MusicStore(){
		this.openTime = 9;
		this.closeTime = 21;
		this.owner = "Sem Dono";
	}
	
	public void setTitle(MusicTitle album, int posicao) {
		this.discos[posicao] = album;
	}
	
	public MusicTitle getTitle(int posicao) {
		return this.discos[posicao];
	}
	
	public void displayMusicTitles() {
		for(int i = 0; i < discos.length && discos[i] != null ; i++) {
			System.out.println("\n\nDisco " + (i+1) +
					"\nTitulo: " + discos[i].title +
					"\nArtista: " + discos[i].artist);
		}
	}
	
	public void displayHoursOfOperation() {
		System.out.println("Aberto às " + getOpen() +
				"\nFechado às " + getClose() + 
				"\nDono: " + getOwner());
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setOpen(int openTime) {
		this.openTime = openTime;
	}
	
	public int getOpen() {
		return this.openTime;
	}
	
	public void setClose(int closeTime) {
		this.closeTime = closeTime;
	}
	
	public int getClose() {
		return this.closeTime;
	}
	
	private boolean isOpen() {
		int horaAtual = getHourInt();
		
		if(horaAtual <= this.closeTime && horaAtual >= this.openTime) {
			return true;
		}
		return false;
	}
	
	private int getHourInt() {
		 Calendar c = Calendar.getInstance();
		 return c.get(Calendar.HOUR_OF_DAY);
	}
	
	public void getOpenClosedMessage() {
		if(isOpen()) {
			System.out.println("Loja Aberta");
		}
		else {
			System.out.println("Loja Fechada");
		}
	}
	
	@Override
	public String toString() {
		return "[Dono = " + this.owner +
				", Abre = " + this.openTime + 
				", Fecha = " + this.closeTime + "]";
	}
}