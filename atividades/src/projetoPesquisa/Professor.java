package projetoPesquisa;

import exceptions.MaximoSubordinadosException;
import exceptions.ProfessorNaoTemSubordinadoException;

public class Professor extends Pesquisador {

	public Professor(String nome) {
		super(nome);
	}
	
	public Professor(String nome, Pesquisador superior) {
		super(nome, superior);
	}

	@Override
	public void addSubordinado(Pesquisador subordinado) throws ProfessorNaoTemSubordinadoException, MaximoSubordinadosException {
		throw new ProfessorNaoTemSubordinadoException();
	}

	@Override
	public void listarSubordinados() throws ProfessorNaoTemSubordinadoException {
		throw new ProfessorNaoTemSubordinadoException();
	}

	@Override
	public int qtdSubordinados(){
		return 0;
	}

}
