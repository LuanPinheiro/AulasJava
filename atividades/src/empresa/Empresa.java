package empresa;

public class Empresa {
	private Chefe maior;
	
	public Empresa() {
		Chefe chefe = new Chefe("Ninguém");
		this.maior = new Chefe("Antonio Carlos Pereira");
		this.maior.setSuperior(chefe);
	}

	public Chefe getMaior() {
		return maior;
	}
}
