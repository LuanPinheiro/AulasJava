package empresa;

public class Principal {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		Chefe chefe = new Chefe("Teste", empresa.getMaior());
		Chefe chefe2 = new Chefe("Teste2", chefe);
		System.out.println(empresa.getMaior().getListaEmpregadosAssociados());
	}
}
