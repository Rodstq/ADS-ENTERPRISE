package org.classes.util;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import org.maptabels.models.ClientesEntity;

public class HibernateUtilConsultaClientes {
	
	private String coluna;
	
	
	public void setColuna(String coluna) {
		this.coluna = coluna;
	}
		
	public String consultaCliente() {
	  
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();
	    
	    transaction.begin();

	    String consulta = "SELECT c."+this.coluna + " FROM ClientesEntity c";

	    TypedQuery<String> query = entityManager.createQuery(consulta, String.class);

	    List<String> resultados = query.getResultList();

	    String primeiroResultado = resultados.get(0);

	    transaction.commit();
	    entityManager.close();
	    entityManagerFactory.close();

	    return primeiroResultado;
	}

    
}
