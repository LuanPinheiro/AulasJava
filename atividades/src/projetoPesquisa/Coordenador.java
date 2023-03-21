package projetoPesquisa;

import exceptions.ProfessorNaoTemSubordinadoException;
import exceptions.MaximoSubordinadosException;

public class Coordenador extends Pesquisador {
	
	private Pesquisador subordinados[];
	private int posicaoSubordinados;

	public Coordenador(String nome, Pesquisador superior) throws MaximoSubordinadosException, ProfessorNaoTemSubordinadoException {
		super(nome, superior);
		this.posicaoSubordinados = 0;
		this.subordinados = new Pesquisador[10];
	}
	
	public Coordenador(String nome) {
		super(nome);
		this.subordinados = new Pesquisador[10];
		this.posicaoSubordinados = 0;
	}

	@Override
	public void addSubordinado(Pesquisador subordinado) throws ProfessorNaoTemSubordinadoException, MaximoSubordinadosException {
		if(this.posicaoSubordinados > 9){
			throw new MaximoSubordinadosException();
		}
		else {
			this.subordinados[this.posicaoSubordinados] = subordinado;
			this.posicaoSubordinados++;
		}
	}

	@Override
	public void listarSubordinados() throws ProfessorNaoTemSubordinadoException {
		for(int i = 0; i < this.posicaoSubordinados; i++) {
			System.out.println(this.subordinados[i].getNome());
		}
	}

	@Override
	public int qtdSubordinados() throws ProfessorNaoTemSubordinadoException {
		int total = this.posicaoSubordinados;
		if(this.posicaoSubordinados > 0) {
			for(int i = 0; i < this.posicaoSubordinados; i++) {
				total += this.subordinados[i].qtdSubordinados();
			}
		}
		
		return total;
	}
}
