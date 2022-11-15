package br.com.tanaka.danilo.JPA.model;

import javax.persistence.Entity;

@Entity
public class Servico extends ModelBanco {

	private String nome;
	private float preco;

	public Servico() {
	}

	public Servico(int id, String nome, float preco) {
		super(id);
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
