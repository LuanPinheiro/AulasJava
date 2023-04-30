package arvoregenealogica;

import java.util.Random;

import exceptions.NatimortoNaoTemFilhoException;

public class Filha extends Pessoa{

	public Filha(Pessoa pai, String nome) {
		super(pai, "Sra. "+nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addDescendentes(String nome, String sexo) throws NatimortoNaoTemFilhoException {
		
		if(sexo.equalsIgnoreCase("Masculino")) {
			Random rand=new Random();
			int numero=rand.nextInt(2);
			if(numero==0) {
				this.getDescendentes().add(new Filho(this,nome));
			}else {
				this.getDescendentes().add(new Natimorto(this,nome));
			}
		}else {
			this.getDescendentes().add(new Filha(this,nome));
		}
	}

}
