package exercicios;

import java.util.*;

import exceptions.NatimortoNaoTemDescendente;

public class Filha extends Pessoa {

	public Filha(String nome) {
		super("Sra. " + nome);
	}
	
	public Filha(String nome, Pessoa ascendente) {
		super("Sra. " + nome, ascendente);
	}

	@Override
	public void cadastrarFilho(String descendente, String sexo) throws NatimortoNaoTemDescendente{
		if(sexo.equalsIgnoreCase("m")) {
			if(new Random().nextInt(2) == 0) {
				this.getDescendentes().add(new Natimorto(descendente, this));
			}
			else {
				this.getDescendentes().add(new Filho(descendente, this));
			}
		}
		else {
			this.getDescendentes().add(new Filha(descendente, this));
		}
	}

}
