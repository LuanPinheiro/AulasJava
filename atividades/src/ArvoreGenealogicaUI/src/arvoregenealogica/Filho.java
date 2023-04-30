package arvoregenealogica;

import exceptions.NatimortoNaoTemFilhoException;

public class Filho extends Pessoa {

	public Filho(Pessoa pai, String nome) {
		super(pai,"Sr. "+ nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addDescendentes(String nome, String sexo) throws NatimortoNaoTemFilhoException {
		if(this.getDescendentes().size()==1) {
			this.getDescendentes().add(new Natimorto(this, nome));
		}else {
			if(sexo.equalsIgnoreCase("Masculino")) {
				this.getDescendentes().add(new Filho(this, nome));
			}else {
				this.getDescendentes().add(new Filha(this, nome));
			}
		}

	}

}
