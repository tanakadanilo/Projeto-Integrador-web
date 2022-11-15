package br.com.tanaka.danilo.JPA.model;

import javax.persistence.Entity;

@Entity
public class Produto extends ModelBanco {

	private String nome;
	private float precoVenda;

	public Produto() {
	}

	public Produto(String nome, float precoVenda) {
		super();
		this.nome = nome;
		this.precoVenda = precoVenda;
	}

	public Produto(int id, String nome, float precoVenda) {
		super(id);
		this.nome = nome;
		this.precoVenda = precoVenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

}
