package projetoPesquisa;

import exceptions.MaximoSubordinadosException;
import exceptions.ProfessorNaoTemSubordinadoException;

public class Projeto {
	private Coordenador mara;
	private Pesquisador pesquisadores[];
	private int posicaoPesquisadores;
	
	public Projeto() {
		this.mara = new Coordenador("Mara");
		this.pesquisadores = new Pesquisador[10];
		this.posicaoPesquisadores = 0;
	}
	
	public Coordenador getMara() {
		return mara;
	}

	public void setMara(Coordenador mara) {
		this.mara = mara;
	}

	public Pesquisador[] getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(Pesquisador[] pesquisadores) {
		this.pesquisadores = pesquisadores;
	}

	public int getPosicaoPesquisadores() {
		return posicaoPesquisadores;
	}

	public void setPosicaoPesquisadores(int posicaoPesquisadores) {
		this.posicaoPesquisadores = posicaoPesquisadores;
	}

	public void inserirPesquisador(Pesquisador pesquisador) throws MaximoSubordinadosException, ProfessorNaoTemSubordinadoException {
		if(this.posicaoPesquisadores > 9){
			throw new MaximoSubordinadosException();
		}
		else {
			this.pesquisadores[this.posicaoPesquisadores] = pesquisador;
			this.posicaoPesquisadores++;
			pesquisador.getSuperior().addSubordinado(pesquisador);
		}
	}
	
	public int getQtdPesquisadores(Pesquisador pesquisador) throws ProfessorNaoTemSubordinadoException{
		int total = 0;
		Pesquisador pesquisadorAtual = pesquisador.getSuperior();
		
		// Conta a quantidade de superiores
		while(pesquisadorAtual != null) {
			pesquisadorAtual = pesquisadorAtual.getSuperior();
			total++;
		}
		
		// Conta a quantidade de subordinados
		total += pesquisador.qtdSubordinados();
		
		return total;
	}
	
	public int getValorPago() {
		return 0;
	}
}
