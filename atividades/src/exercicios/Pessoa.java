package exercicios;

import java.util.*;

import exceptions.NatimortoNaoTemDescendente;

public abstract class Pessoa {
	
	private String nome;
	private Pessoa ascendente;
	private List<Pessoa> descendentes;
	
	public Pessoa(String nome, Pessoa ascendente) {
		this.nome = nome;
		this.ascendente = ascendente;
		this.descendentes = new ArrayList<Pessoa>();
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
		this.descendentes = new ArrayList<Pessoa>();
	}
	
	public String getNome() {
		return this.nome;
	}
	public Pessoa getAscendente() {
		return this.ascendente;
	}
	
	public List<Pessoa> getDescendentes() {
		return descendentes;
	}
	
	public void listarAscendentes() {
		if(this.getAscendente() != null) {
			System.out.println("Ascendente de " + this.nome + ": " + this.getAscendente());
			this.getAscendente().listarAscendentes();
		}
		else {
			System.out.println("Sem Ascendente");
		}
	}
	
	public void listarDescendentes() throws NatimortoNaoTemDescendente{
		descendentes.stream().forEach(descendente -> {
			System.out.println("Descendente de " + this.nome + ": " + descendente.getNome());
			try {
				descendente.listarDescendentes();
			} catch (NatimortoNaoTemDescendente e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public abstract void cadastrarFilho(String descendente, String sexo) throws NatimortoNaoTemDescendente;
}
