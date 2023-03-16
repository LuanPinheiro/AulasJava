package empresa;

import java.util.ArrayList;
import java.util.List;

public class Chefe extends Pessoa{
	private List<Pessoa> subordinados;
	
	public Chefe(String nome) {
		super(nome);
		this.subordinados = new ArrayList<Pessoa>();
	}
	
	public List<Pessoa> getSubordinados() {
		return subordinados;
	}

	public void addSubordinado(Pessoa subordinado) {
		this.subordinados.add(subordinado);
	}

	@Override
	public String getListaEmpregadosAssociados() {
		String retorno;
		if(this.getSuperior() != null) {
			retorno = "Superior de " + this.getNome() + ": " + this.getSuperior().getNome();
		}
		else {
			retorno = this.getNome();
		}
		
		for(int i = 0; i < this.subordinados.size(); i++) {
			retorno += "\nSubordinado(s): " + this.subordinados.get(i).getNome();
			if(this.subordinados.get(i).getClass().getName().contains("Chefe")) {
				this.subordinados.get(i).getListaEmpregadosAssociados();
			}
		}
		retorno += "\n---------";
		return retorno;
	}
}
