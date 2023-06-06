//package org.testesDiversos;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//import java.math.BigDecimal;
//
//import org.maptabels.models.ClientesEntity;
//import org.maptabels.models.ProdutosEntity;
//
//public class HibernateUtilCliente {
//    public static void persistirCliente(String cpf, String nome, String telefone){
//
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        try{
//            transaction.begin(); 
//       
//            ClientesEntity c1 = new ClientesEntity();
//
//            c1.setCpf(cpf);
//            c1.setNomeCliente(nome);
//            c1.setTelefoneCliente(telefone);
//            
//            entityManager.persist(c1);
//
//            transaction.commit();
//            } finally {
//            if(transaction.isActive()) {
//                    transaction.rollback();
//            }
//                entityManager.close();
//                entityManagerFactory.close();
//            }
//
//    }
//    
//}
