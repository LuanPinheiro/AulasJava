package banco;

public class Corrente extends Conta {
	public Corrente(String numero, int saldo) {
		super(numero, saldo);
	}

	@Override
	public void atualizarSaldo() {
		this.saldo -= 1;
	}
}
