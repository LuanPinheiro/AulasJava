package empresa;

import java.util.ArrayList;
import java.util.List;

public class Chefe extends Pessoa{
	private Chefe superior;
	private List<Pessoa> subordinados;

	public Chefe(String nome, Chefe superior) {
		super(nome);
		this.superior = superior;
		this.superior.addSubordinado(this);
		this.subordinados = new ArrayList<Pessoa>();
	}

	public Chefe(String nome) {
		super(nome);
		this.subordinados = new ArrayList<Pessoa>();
	}

	public Chefe getSuperior() {
		return this.superior;
	}

	public List<Pessoa> getSubordinados() {
		return this.subordinados;
	}

	public void addSubordinado(Pessoa subordinado){
		this.subordinados.add(subordinado);
	}

	@Override
	public String getListaEmpregadosAssociados() {
		String retorno;
		retorno = "Trabalhador: " + this.getNome();
		
		if(this.superior != null){
			retorno += "\nSuperior: " + this.superior.getNome();
		}
		
		if(this.getSubordinados().size() == 0){
			retorno += "\nNão há Subordinados para este Chefe";
		}
		for(int i = 0; i < this.getSubordinados().size(); i++) {
			retorno += "\nSubordinado(s): " + this.getSubordinados().get(i).getNome();
			if(this.getSubordinados().get(i).getClass().getName().contains("Chefe")){
				System.out.println(this.getSubordinados().get(i).getListaEmpregadosAssociados());
			}
		}
		retorno += "\n---------";
		return retorno;
	}
}
