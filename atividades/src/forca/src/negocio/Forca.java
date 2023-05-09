package negocio;

import java.util.*;

public class Forca {
	private String categoria;
	private String[] filmes = {"Spartacus", "Meninas Malvadas", "Thor", "Clube da Luta"};
	private String[] novelas = {"Avenida Brasil", "Chocolate com Pimenta", "Pantanal", ""};
	private String[] carros = {"Uno", "Gol", "Ferrari", "Corolla"};
	private String palavra;
	private int erros;
	
	public Forca() {
		erros = 0;
	}

	public String getCategoria() {
		return categoria;
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

	public String getPalavra() {
		return palavra;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void setErros(int erros) {
		this.erros = erros;
	}
	
	public int getErros() {
		return erros;
	}
	
	public void setPalavra() {
		Random rand = new Random();
		int pos = rand.nextInt(4);
		switch(categoria) {
			case "Filmes": palavra = filmes[pos].toUpperCase(); break;
			case "Novelas": palavra = novelas[pos].toUpperCase(); break;
			case "Carros": palavra = carros[pos].toUpperCase(); break;
 		}
	}
	
	public String addTentativa(String tentativa, String tentativasRealizadas) {
		tentativasRealizadas += " " + tentativa.toUpperCase();
		return tentativasRealizadas;
	}
	
	public String gerarUnderline() {
		String underline = "";
		
		for (int i = 0; i < palavra.length(); i++) {
			if(palavra.charAt(i) != ' ') {
				underline += "_";
			}
			else {
				underline += " ";
			}
		}
		
		return underline;
	}
	
	public String alteraUnderline(String underline, String letra) {
		String palavraOriginal = palavra;
		char letraChar = letra.charAt(0);
		StringBuilder sb = new StringBuilder(underline);
		for(int i = 0; i < underline.length(); i++) {
			if(palavra.charAt(i) == letraChar) {
				sb.setCharAt(i, letraChar);
			}
		}
		palavra.replaceAll(letra, ";");
		if(palavra.equalsIgnoreCase(palavraOriginal)) {
			erros++;
		}
		return sb.toString();
	}
	
}
