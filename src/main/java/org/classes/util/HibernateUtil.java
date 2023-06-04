package org.classes.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

import org.maptabels.models.ProdutosEntity;

public class HibernateUtil {
    public static void persistirProduto(String nome, double preco, int quantidade){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            ProdutosEntity p1 = new ProdutosEntity();

            p1.setPreco(BigDecimal.valueOf(preco));
            p1.setNome(nome);
            p1.setQuantidade(quantidade);
            
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
