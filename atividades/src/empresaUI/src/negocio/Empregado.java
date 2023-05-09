package negocio;

import exceptions.EmpregadoNaoTemSubordinadoException;

public class Empregado extends Pessoa {

	public Empregado(String nome, Pessoa superior) {
		super(nome, superior);
	}

	@Override
	public void addColaborador(String nome, String tipo) throws EmpregadoNaoTemSubordinadoException{
		throw new EmpregadoNaoTemSubordinadoException();
	}

	@Override
	public String getListaColaboradores() {
		return "";
	}

}
