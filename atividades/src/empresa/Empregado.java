package empresa;

public class Empregado extends Pessoa{

	public Empregado(String nome) {
		super(nome);
	}

	@Override
	public String getListaEmpregadosAssociados() {
		String retorno = "[ Superior de: " + this.getNome() + this.getSuperior().getNome();
		retorno += "\n---------";
		return retorno;
	}
	
}
