package negocio;

import java.util.Iterator;

import exceptions.ProfessorNaoTemSubordinadoException;

public class Coordenador extends Pesquisador {

	public Coordenador(String nome, Pesquisador superior) {
		super(nome, superior);
	}

	@Override
	public int qtdSubordinados() {
		int soma = this.getSubordinados().size();
		
		for (Pesquisador pesquisador : this.getSubordinados()) {
			soma += pesquisador.getSubordinados().size();
		}
		
		return soma;
	}

	@Override
	public void addPesquisador(String nome, String tipo) throws ProfessorNaoTemSubordinadoException {
		if(tipo.equalsIgnoreCase("Professor")) {
			this.getSubordinados().add(new Professor(nome,this));
		}
		else {
			this.getSubordinados().add(new Coordenador(nome,this));
		}
	}

	@Override
	public double getValorPago() {
		return 300 - (0.025 * this.qtdSubordinados() * 300);
	}

}
