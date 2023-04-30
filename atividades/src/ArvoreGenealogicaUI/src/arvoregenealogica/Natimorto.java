package arvoregenealogica;

import exceptions.NatimortoNaoTemFilhoException;

public class Natimorto extends Pessoa{

	public Natimorto(Pessoa pai, String nome) {
		super(pai, "Natimorto " +nome);
		
	}

	@Override
	public void addDescendentes(String nome, String sexo)throws NatimortoNaoTemFilhoException {
		throw new NatimortoNaoTemFilhoException();
	}

}
