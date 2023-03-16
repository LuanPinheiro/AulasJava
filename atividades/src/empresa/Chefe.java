package empresa;

import java.util.ArrayList;
import java.util.List;

public class Chefe extends ChefeMaior{
	private ChefeMaior superior;

	public Chefe(String nome, ChefeMaior superior) {
		super(nome);
		this.superior = superior;
		this.superior.addSubordinado(this);
	}

	public ChefeMaior getSuperior() {
		return this.superior;
	}

	@Override
	public String getListaEmpregadosAssociados() {
		String retorno;
		if(this.getSuperior() != null) {
			retorno = "Superior de " + this.getNome() + ": " + this.getSuperior().getNome();
			if(this.getSuperior() != null){

			}
		}
		else {
			retorno = this.getNome();
		}
		
		for(int i = 0; i < this.getSubordinados().size(); i++) {
			retorno += "\nSubordinado(s): " + this.getSubordinados().get(i).getNome();
			if(this.getSubordinados().get(i).getClass().getName().contains("Chefe")) {
				this.getSubordinados().get(i).getListaEmpregadosAssociados();
			}
		}
		retorno += "\n---------";
		return retorno;
	}
}
