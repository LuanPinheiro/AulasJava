package empresa;

public class Principal {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		Chefe chefe = new Chefe("Luan");
		chefe.setSuperior(empresa.getMaior());
		Empregado empregado = new Empregado("Teste");
		empregado.setSuperior(chefe);
		System.out.println(empresa.getMaior().getListaEmpregadosAssociados());
		System.out.println(chefe.getListaEmpregadosAssociados());
	}
}
