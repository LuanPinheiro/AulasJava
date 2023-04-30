package arvoregenealogica;

import java.util.ArrayList;
import java.util.List;

import exceptions.NatimortoNaoTemFilhoException;

public abstract class Pessoa {
	
	private Pessoa pai;
	private String nome;
	private List<Pessoa> descendentes;
	
	public Pessoa(Pessoa pai, String nome){
		super();
		this.pai = pai;
		this.nome = nome;
		this.descendentes= new ArrayList<Pessoa>();
	}
	
	public List<String> listarDescendentes() {
		List<String> descendentesLista = new ArrayList<String>();
		for (Pessoa pessoa : descendentes) {
			descendentesLista.addAll(pessoa.listarDescendentes());
		}
		descendentesLista.add(0, this.getNome());
		return descendentesLista;
	}
	
	public String listarAscendentes() {
		String ascendentes = this.getNome();
		Pessoa paiAtual=this.getPai();
		if(paiAtual!=null) {
			ascendentes += "\n" + paiAtual.getNome();
			paiAtual.listarAscendentes();
		}
		return ascendentes;
	}
	
	public Pessoa encontrarPessoa(String nome) {
		Pessoa encontrado = null;
		if(this.nome.equalsIgnoreCase(nome)) {
			return this;
		}
		for (Pessoa pessoa : descendentes) {
			encontrado = pessoa.encontrarPessoa(nome);
			if(encontrado != null) {
				break;
			}
		}
		return encontrado;
	}
	
	
	public abstract void addDescendentes(String nome, String sexo) throws NatimortoNaoTemFilhoException;

	public Pessoa getPai() {
		return pai;
	}

	public String getNome() {
		return nome;
	}

	public List<Pessoa> getDescendentes() {
		return descendentes;
	}
	
	
	public int getQtdFilhos() {
		int qtd=0;
		for (Pessoa pessoa : descendentes) {
			if(pessoa instanceof Filho) {
				qtd++;
			}
		}
		return qtd;
	}
	
	

}
