package negocio;

import java.util.*;

import exceptions.ProfessorNaoTemSubordinadoException;

public abstract class Pesquisador {
	
	private String nome;
	private Pesquisador superior;
	private List<Pesquisador> subordinados;
	
	public Pesquisador(String nome, Pesquisador superior) {
		this.nome = nome;
		this.superior = superior;
		this.subordinados = new ArrayList<Pesquisador>();
	}

	public String getNome() {
		return nome;
	}

	public Pesquisador getSuperior() {
		return superior;
	}

	public List<Pesquisador> getSubordinados() {
		return subordinados;
	}
	
	public Pesquisador encontrarPesquisador(String nome) {
		if(this.nome.equalsIgnoreCase(nome)) {
			return this;
		}
		for (Pesquisador pesquisador : subordinados) {
			Pesquisador pesquisadorAchar = pesquisador.encontrarPesquisador(nome);
			if(pesquisadorAchar != null) {
				return pesquisadorAchar;
			}
		}
		return null;
	}
	
	public abstract int qtdSubordinados();
	public abstract void addPesquisador(String nome, String tipo) throws ProfessorNaoTemSubordinadoException;
	public abstract double getValorPago();
}
