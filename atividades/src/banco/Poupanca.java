package banco;

public class Poupanca extends Conta {
	public Poupanca(String numero, int saldo) {
		super(numero, saldo);
	}

	@Override
	public void atualizarSaldo() {
		this.saldo += (this.saldo/100);
	}
}
