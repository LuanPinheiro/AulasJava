package empresa;

public abstract class Pessoa {
	private Chefe superior;
	private String nome;
	
	public Pessoa(String nome) {
		this.superior = superior;
		this.nome = nome;
	}
	
	public Chefe getSuperior() {
		return superior;
	}
	public void setSuperior(Chefe superior) {
		this.superior = superior;
		this.superior.addSubordinado(this);
	}
	public String getNome() {
		return nome;
	}
	
	public abstract String getListaEmpregadosAssociados();
}
