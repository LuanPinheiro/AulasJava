package negocio;

import exceptions.ProfessorNaoTemSubordinadoException;

public class Professor extends Pesquisador {

	public Professor(String nome, Pesquisador superior) {
		super(nome, superior);
	}

	@Override
	public int qtdSubordinados() {
		return 0;
	}

	@Override
	public void addPesquisador(String nome, String tipo) throws ProfessorNaoTemSubordinadoException{
		throw new ProfessorNaoTemSubordinadoException();
	}

	@Override
	public double getValorPago() {
		return 220 + (0.3 * this.getSuperior().getValorPago());
	}

}
