package empresa;

import java.util.ArrayList;
import java.util.List;

public class ChefeMaior extends Pessoa{
    private List<Pessoa> subordinados;
    
    public ChefeMaior(String nome) {
        super(nome);
        this.subordinados = new ArrayList<Pessoa>();
    }

    public List<Pessoa> getSubordinados() {
		return this.subordinados;
	}

	public void addSubordinado(Pessoa subordinado) {
		this.subordinados.add(subordinado);
	}

    @Override
    public String getListaEmpregadosAssociados() {
        String retorno = "Chefe Maior " + this.getNome();

        for(int i = 0; i < this.getSubordinados().size(); i++) {
			retorno += "\nSubordinado(s): " + this.getSubordinados().get(i).getNome();
			if(this.getSubordinados().get(i).getClass().getName().contains("Chefe")) {
				System.out.println(this.getSubordinados().get(i).getListaEmpregadosAssociados());
			}
		}
		retorno += "\n---------";
		return retorno;
    }
    
}
