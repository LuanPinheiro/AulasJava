package banco;

public class Cliente {
	String nome;
	Conta conta;
	
	public Cliente(String nome, Conta conta) {
		this.nome = nome;
		this.conta = conta;
	}
}
