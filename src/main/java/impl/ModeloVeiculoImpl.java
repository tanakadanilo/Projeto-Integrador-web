package impl;

import javax.persistence.Persistence;

import bancodedados.model.Modelo;

public class ModeloVeiculoImpl {

	public void adicionar(Modelo modelo) {
		Persistence.createEntityManagerFactory("Modelo").createEntityManager().persist(modelo);
	}

	public void adicionar() {
		Persistence.createEntityManagerFactory("Modelo").createEntityManager().persist(new Modelo());
	}
}
