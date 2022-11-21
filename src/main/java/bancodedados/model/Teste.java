package bancodedados.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

public class Teste {
	public static void main(String[] args) {

		Persistence.createEntityManagerFactory("modelo").createEntityManager();
				
	}
}
