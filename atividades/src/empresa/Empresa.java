package empresa;

public class Empresa {
	private Chefe maior;
	
	public Empresa() {
		this.maior = new Chefe("Antonio Carlos Pereira");
	}

	public Chefe getMaior() {
		return this.maior;
	}
}
