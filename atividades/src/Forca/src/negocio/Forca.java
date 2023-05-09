package negocio;

import java.util.*;

public class Forca {
	private String categoria;
	private String[] filmes = {"Spartacus", "Thor", "Clube da Luta", "Meninas Malvadas"};
	private String[] novelas = {"Avenida Brasil", "Chocolate com Pimenta", "Carrossel", "Pantanal"};
	private String[] carros = {"Uno", "Gol", "Ferrari", "Corolla"};
	private String palavra;
	private List<String> tentativas;
	
	public Forca() {
		this.tentativas = new ArrayList<String>();
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String[] getFilmes() {
		return filmes;
	}

	public String[] getNovelas() {
		return novelas;
	}

	public String[] getCarros() {
		return carros;
	}

	public List<String> getTentativas() {
		return tentativas;
	}
	
	public void addTentativa(String tentativa) {
		this.tentativas.add(tentativa);
	}
	
	public String getPalavra() {
		return palavra;
	}
	
	public void setPalavra() {
		Random rand = new Random();
		int pos = rand.nextInt(4);
		
		switch(categoria) {
			case "Filmes": palavra = filmes[pos]; break;
			case "Novelas": palavra = novelas[pos]; break; 
			case "Carros": palavra = carros[pos]; break; 
		}
	}
	
	public int letraEmPalavra(String letra) {
		if(this.tentativas.contains(letra)) {
			return -1;
		}
		if(this.palavra.contains(letra)) {
			return 1;
		}
		
		return 0;
	}
}
