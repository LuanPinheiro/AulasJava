package empresa;

public class Empresa {
	private ChefeMaior maior;
	
	public Empresa() {
		this.maior = new ChefeMaior("Antonio Carlos Pereira");
	}

	public ChefeMaior getMaior() {
		return maior;
	}
}
