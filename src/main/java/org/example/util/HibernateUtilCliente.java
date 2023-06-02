package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import org.example.models.ClientesEntity;
import org.example.models.ProdutosEntity;
import java.math.BigDecimal;

public class HibernateUtilCliente {
    public static void persistirCliente(int cpf, String nome, int telefone){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
       
            ClientesEntity c1 = new ClientesEntity();

            c1.setCpf(cpf);
            c1.setNomeCliente(nome);
            c1.setTelefoneCliente(telefone);
            
            entityManager.persist(c1);

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
