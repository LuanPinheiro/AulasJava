package empresa;

public class Empregado extends Pessoa{
	private ChefeMaior superior;

	public Empregado(String nome, ChefeMaior superior) {
		super(nome);
		this.superior = superior;
		this.superior.addSubordinado(this);
	}

	public ChefeMaior getSuperior() {
		return superior;
	}

	@Override
	public String getListaEmpregadosAssociados() {
		String retorno = "[ Superior de: " + this.getNome() + this.getSuperior().getNome();
		retorno += "\n---------";
		return retorno;
	}
}
