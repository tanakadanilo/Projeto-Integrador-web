package bancodedados.model;

public class Modelo extends ModelBanco {

	private String nome;
	private String nomeMarca;

	public Modelo() {
	}

	public Modelo(String nome, String nomeMarca) {
		this.nome = nome;
		this.nomeMarca = nomeMarca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

}