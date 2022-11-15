package bancodedados.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Veiculo extends ModelBanco {

	@OneToOne
	private Modelo modelo;
	private int ano;
	private int anoModelo;
	private int km;
	private String placa;

	public Veiculo() {
	}

	public Veiculo(Modelo modelo, int ano, int anoModelo, int km, String placa) {
		this.modelo = modelo;
		this.ano = ano;
		this.anoModelo = anoModelo;
		this.km = km;
		this.placa = placa;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
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
