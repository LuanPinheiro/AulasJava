package empresa;

public class Empregado extends Pessoa{
	private Chefe superior;

	public Empregado(String nome, Chefe superior) {
		super(nome);
		this.superior = superior;
		this.superior.addSubordinado(this);
	}

	public Chefe getSuperior() {
		return this.superior;
	}

	@Override
	public String getListaEmpregadosAssociados() {
		String retorno = "Trabalhador: " + this.getNome();
		retorno += "\nSuperior: " + this.getSuperior().getNome();
		retorno += "\n---------";
		if(this.getSuperior().getSuperior() != null){
			System.out.println(this.getSuperior().getListaEmpregadosAssociados());
		}
		
		return retorno;
	}
}
