package exercicios;

import exceptions.NatimortoNaoTemDescendente;

public class Natimorto extends Pessoa {

	public Natimorto(String nome) {
		super("Natimorto " + nome);
	}
	
	public Natimorto(String nome, Pessoa ascendente) {
		super("Natimorto " + nome, ascendente);
	}

	@Override
	public void cadastrarFilho(String descendente, String sexo) throws NatimortoNaoTemDescendente {
		throw new NatimortoNaoTemDescendente();
	}
}
