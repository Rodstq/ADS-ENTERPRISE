package org.classes.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

import org.Interfaces.ModuloClientes.moduloClientesCadastro;
import org.maptabels.models.ClientesEntity;
import org.maptabels.models.ProdutosEntity;

public class HibernateUtilCadastroClientes {
    public static void persistirCliente(String nomeCliente, String cpfCliente, String dataNascimentoCLiente, String telefoneCliente, String estadoCliente,
    		String cidadeCliente, String bairroCliente, String cepCliente, String ruaCliente, String descricaoRuaCliente){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        
          
        try{
            transaction.begin(); 
       
            ClientesEntity c1 = new ClientesEntity();

            c1.setNomeCliente(nomeCliente);
            c1.setCpf(cpfCliente);
            c1.setDataNascimentoCliente(dataNascimentoCLiente);
            c1.setTelefoneCliente(telefoneCliente);
            c1.setEstadoCliente(estadoCliente);
            c1.setCidadeCliente(cidadeCliente);
            c1.setBairroCliente(bairroCliente);
            c1.setCepCliente(cepCliente);
            c1.setRuaCliente(ruaCliente);
            c1.setDescricaoRuaCliente(descricaoRuaCliente);
         
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
