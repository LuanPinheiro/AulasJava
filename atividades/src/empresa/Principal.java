package empresa;

public class Principal {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		Chefe chefe = new Chefe("Teste Chefe", empresa.getMaior());
		Empregado empregado = new Empregado("Teste Empregado", chefe);
		Chefe chefe2 = new Chefe("Teste Chefe 2", chefe);
		Empregado empregado2 = new Empregado("Teste Empregado 2", chefe);
		System.out.println(empresa.getMaior().getListaEmpregadosAssociados());
	}
}
