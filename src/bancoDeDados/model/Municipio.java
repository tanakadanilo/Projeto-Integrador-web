package br.com.tanaka.danilo.JPA.model;

import javax.persistence.Entity;

@Entity
public class Municipio extends ModelBanco {

	private String nome;
	private String uf;
	private int codigoIbge;

	public Municipio() {
	}

	public Municipio(int id, String nome, String uf, int codigoIbge) {
		super(id);
		this.nome = nome;
		this.uf = uf;
		this.codigoIbge = codigoIbge;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(int codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

}
