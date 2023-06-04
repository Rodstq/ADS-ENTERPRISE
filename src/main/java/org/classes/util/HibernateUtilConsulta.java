package org.classes.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

import org.maptabels.models.ProdutosEntity;

public class HibernateUtilConsulta {

    public static String consultaProduto() {
    
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        transaction.begin();

        String consulta = "SELECT p.nome FROM ProdutosEntity p ";

        TypedQuery<String> query = entityManager.createQuery(consulta, String.class);


        List<String> nomesProdutos = query.getResultList();

        String primeiroNomeProduto = nomesProdutos.get(0);
        

        transaction.commit();
        
    
        entityManager.close();
        entityManagerFactory.close();

        return primeiroNomeProduto;
    }
}
