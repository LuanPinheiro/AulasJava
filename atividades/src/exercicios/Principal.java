package exercicios;

import exceptions.NatimortoNaoTemDescendente;

public class Principal {
	public static void main(String args[]) throws NatimortoNaoTemDescendente {
		Pessoa joao = new Filho("joao");
		
		joao.cadastrarFilho("Marcelo", "m");
		joao.cadastrarFilho("Carla", "f");
		
		joao.listarDescendentes();
		// ver melhor como funciona lambda
		// contunuar exercícios XVIII
	}
}
