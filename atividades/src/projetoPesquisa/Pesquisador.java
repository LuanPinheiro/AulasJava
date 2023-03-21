package projetoPesquisa;

import exceptions.MaximoSubordinadosException;
import exceptions.ProfessorNaoTemSubordinadoException;

public abstract class Pesquisador {
	
	private String nome;
	private Pesquisador superior;
	
	public Pesquisador(String nome, Pesquisador superior) {
		this.nome = nome;
		this.superior = superior;
	}
	
	public Pesquisador(String nome) {
		this.nome = nome;
		this.superior = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pesquisador getSuperior() {
		return superior;
	}

	public void setSuperior(Pesquisador superior) {
		this.superior = superior;
	}
	
	public void listarSuperiores() {
		Pesquisador superiorAtual = this.getSuperior();
		
		if(superiorAtual!=null) {
			System.out.println(superiorAtual.getNome());
			superiorAtual.listarSuperiores();
		}
	}
	
	public abstract void addSubordinado(Pesquisador subordinado) throws ProfessorNaoTemSubordinadoException, MaximoSubordinadosException;
	public abstract void listarSubordinados() throws ProfessorNaoTemSubordinadoException;
	public abstract int qtdSubordinados() throws ProfessorNaoTemSubordinadoException;
}
