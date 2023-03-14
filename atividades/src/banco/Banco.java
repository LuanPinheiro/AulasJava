package banco;

public class Banco {
	public static void main(String args[]) {
		Cliente[] clientes = new Cliente[4];
		Conta conta = new Poupanca("1", 100);
		clientes[0] = new Cliente("Cliente 1", conta);
		conta = new Poupanca("2", 100);
		clientes[1] = new Cliente("Cliente 2", conta);
		conta = new Poupanca("3", 100);
		clientes[2] = new Cliente("Cliente 3", conta);
		conta = new Corrente("4", 100);
		clientes[3] = new Cliente("Cliente 4", conta);
		
		String numeroBusca = clientes[0].conta.getNumero();
		
		System.out.println(clientes[3].conta.getNumero());
	}
}
