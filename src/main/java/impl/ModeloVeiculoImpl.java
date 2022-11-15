package impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bancodedados.model.Modelo;

public class ModeloVeiculoImpl {

	public void adicionar(Modelo modelo) {
		Persistence.createEntityManagerFactory("Modelo").createEntityManager().persist(modelo);
	}
}
