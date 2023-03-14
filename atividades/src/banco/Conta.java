package banco;

public abstract class Conta {
	String numero;
	int saldo;
	
	Conta(String numero, int saldo){
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public int getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(int deposito) {
		this.saldo += deposito;
	}
	
	public void retirar(int saque) {
		this.saldo -= saque;
	}
	
	public void consultarSaldo() {
		System.out.println("Saldo");
	}
	
	public abstract void atualizarSaldo();
}
