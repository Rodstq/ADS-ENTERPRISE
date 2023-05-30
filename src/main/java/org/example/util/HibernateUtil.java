package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.models.ProdutosEntity;

public class HibernateUtil {
    public static void persistirProduto(String nome, double preco, int qntd){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            ProdutosEntity p1 = new ProdutosEntity();

            // p1.setId(1);
            p1.setPreco(preco);
            p1.setNome(nome);
            p1.setQntd(qntd);
            
            entityManager.persist(p1);

            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
