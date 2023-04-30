package exercicios;

import java.util.ArrayList;
import java.util.List;

public class Filho extends Pessoa {

	public Filho(String nome) {
		super("Sr. " + nome);
	}
	public Filho(String nome, Pessoa ascendente) {
		super("Sr. " + nome, ascendente);
	}

	@Override
	public void cadastrarFilho(String descendente, String sexo) {
		if(this.getDescendentes().size() == 1) {
			this.getDescendentes().add(new Natimorto(descendente, this));
		}
		else {
			if(sexo.equalsIgnoreCase("m")) {
				this.getDescendentes().add(new Filho(descendente, this));
			}
			else {
				this.getDescendentes().add(new Filha(descendente, this));
			}
		}

	}
}
