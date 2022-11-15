package br.com.tanaka.danilo.JPA.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Veiculo extends ModelBanco {

	@OneToOne
	private Modelo Modelo;
	private int ano;
	private int anoModelo;
	private int km;
	private String placa;

	public Veiculo() {
	}

	public Veiculo(br.com.tanaka.danilo.JPA.model.Modelo modelo, int ano, int anoModelo, int km, String placa) {
		Modelo = modelo;
		this.ano = ano;
		this.anoModelo = anoModelo;
		this.km = km;
		this.placa = placa;
	}

	public Modelo getModelo() {
		return Modelo;
	}

	public void setModelo(Modelo modelo) {
		Modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
