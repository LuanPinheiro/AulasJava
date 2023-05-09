package negocio;

import java.util.*;

import exceptions.EmpregadoNaoTemSubordinadoException;

public abstract class Pessoa {
	private String nome;
	private Pessoa superior;
	private List<Pessoa> colaboradores;
	
	public Pessoa(String nome, Pessoa superior) {
		this.nome = nome;
		this.superior = superior;
		this.colaboradores = new ArrayList<Pessoa>();
	}

	public String getNome() {
		return nome;
	}

	public Pessoa getSuperior() {
		return superior;
	}

	public List<Pessoa> getColaboradores() {
		return colaboradores;
	}
	
	public String getListaSuperiores() {
		String lista = "";
		
		if(this.getSuperior() != null) {
			lista += this.getSuperior().getNome();
			lista += this.getSuperior().getListaSuperiores();
		}
		
		return lista;
	}
	
	public Pessoa encontrarColaborador(String nome) {
		if(this.getNome().equalsIgnoreCase(nome)) {
			return this;
		}
		
		Pessoa achou = null;
		for (Pessoa colaborador : colaboradores) {
			if(colaborador.getNome().equalsIgnoreCase(nome)) {
				return colaborador;
			}
			achou = colaborador.encontrarColaborador(nome);
			if(achou != null) {
				return achou;
			}
		}
		
		return achou;
	}
	
	public abstract void addColaborador(String nome, String tipo) throws EmpregadoNaoTemSubordinadoException;
	public abstract String getListaColaboradores();
	
}
