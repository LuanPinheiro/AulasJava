package negocio;

public class Participante {
	private String nome;
	private String codigo;
	private int votos;
	
	public Participante(String nome, String codigo) {
		this.nome = nome;
		this.codigo = codigo;
		this.votos = 0;
	}

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public int getVotos() {
		return votos;
	}
	
	public void addVoto() {
		votos++;
	}
}
