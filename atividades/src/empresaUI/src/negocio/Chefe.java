package negocio;

import exceptions.EmpregadoNaoTemSubordinadoException;

public class Chefe extends Pessoa {

	public Chefe(String nome, Pessoa superior) {
		super(nome, superior);
	}

	@Override
	public void addColaborador(String nome, String tipo) throws EmpregadoNaoTemSubordinadoException {
		if(tipo.equalsIgnoreCase("Empregado")) {
			this.getColaboradores().add(new Empregado(nome, this));
		}
		else {
			this.getColaboradores().add(new Chefe(nome, this));
		}
	}

	@Override
	public String getListaColaboradores() {
		String lista = "";
		
		for (Pessoa colaborador : this.getColaboradores()) {
			lista += colaborador.getNome() + "\n";
			lista += colaborador.getListaColaboradores();
		}
		
		return lista;
	}
}
