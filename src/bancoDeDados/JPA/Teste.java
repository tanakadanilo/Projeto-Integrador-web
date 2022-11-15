package br.com.tanaka.danilo.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tanaka.danilo.JPA.model.Estoque;

public class Teste {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco_calaca");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
//		
		Estoque e = entityManager.find(Estoque.class, 1);
//		Estoque e = new Estoque(5, 3);
		System.out.println(e);
		
		entityManager.getTransaction().begin();
		entityManager.persist(e);
		entityManager.getTransaction().commit();
	}
}
