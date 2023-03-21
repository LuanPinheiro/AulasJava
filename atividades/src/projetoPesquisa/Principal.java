package projetoPesquisa;

import exceptions.MaximoSubordinadosException;
import exceptions.ProfessorNaoTemSubordinadoException;

public class Principal {

	public static void main(String[] args) throws MaximoSubordinadosException, ProfessorNaoTemSubordinadoException {
		Projeto projeto = new Projeto();
		projeto.inserirPesquisador(new Coordenador("Luan", projeto.getMara()));
		projeto.inserirPesquisador(new Professor("Mario", projeto.getPesquisadores()[0]));
		System.out.println(projeto.getQtdPesquisadores(projeto.getMara()));
		System.out.println(projeto.getPesquisadores()[1].getNome());
	}

}
