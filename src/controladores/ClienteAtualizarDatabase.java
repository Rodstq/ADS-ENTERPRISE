package controladores;

import java.sql.Statement;
import java.util.ArrayList;

import classesCliente.Clientes;
import conexaoDb.Db;

public class ClienteAtualizarDatabase {
    public void setAtualizarDadosCliente(Clientes cliente) {
        ArrayList<Object> infoCliente = new ArrayList<Object>();
        infoCliente.add(cliente.getNomeCliente());
        infoCliente.add(cliente.getDataNascimentoCliente());
        infoCliente.add(cliente.getTelefoneCliente());
        

        ArrayList<Object> colunas = new ArrayList<Object>();
        colunas.add("nome_cliente");
        colunas.add("nascimento_cliente");
        colunas.add("telefone");

        for (int i = 0; i < infoCliente.size(); i++) {
        Object element = infoCliente.get(i);
        if (element != null && !element.toString().isEmpty()) {
                try {
                    Statement stmt = Db.Connect().createStatement();
                    String atualizarCliente = "UPDATE cliente SET " + colunas.get(i) + " = '" + infoCliente.get(i) + "' WHERE cpf_cliente = '" + cliente.getCpf() + "'";
                    stmt.execute(atualizarCliente);
                    stmt.close();
                    Db.CloseDb();
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }finally {
                	             
                     Db.CloseDb();
                	
                }
            }
        }
    }
    
    public void atualizarEnderecoCliente(Clientes cliente) {
        ArrayList<Object> enderecoCliente = new ArrayList<Object>();
        
        enderecoCliente.add(cliente.getCepCliente());
        enderecoCliente.add(cliente.getEstadoCliente());
        enderecoCliente.add(cliente.getCidadeCliente());
        enderecoCliente.add(cliente.getBairroCliente());
        enderecoCliente.add(cliente.getRuaCliente());
        enderecoCliente.add(cliente.getDescricaoRuaCliente());
        

        ArrayList<Object> colunas = new ArrayList<Object>();
        colunas.add("cep");
        colunas.add("estado");
        colunas.add("cidade");
        colunas.add("bairro");
        colunas.add("rua");
        colunas.add("complemento");
        
       
        for (int i = 0; i < enderecoCliente.size(); i++) {
        	
        	Object element = enderecoCliente.get(i);
            if (element != null && !element.toString().isEmpty()) {
                try {
                    Statement stmt = Db.Connect().createStatement();
                    String dadosEndecoCliente = "UPDATE cliente_endereco SET " + colunas.get(i) + " = '" + enderecoCliente.get(i) + "' WHERE cpf_cliente = '" + cliente.getCpf() + "'";
                    stmt.execute(dadosEndecoCliente);
                    stmt.close();
                    Db.CloseDb();
                } catch (Exception e) {
                    e.printStackTrace();
                  
                }finally {
                	
                	Db.CloseDb();
                	
                }
            }
        }
    }
}


