package controladores;

import java.sql.Statement;
import java.util.ArrayList;

import classesPrincipais.Clientes;
import conexaoDb.Db;

public class ClienteAtualizarDatabase {
    public void atualizarDadosCliente(Clientes cliente) {
        ArrayList<Object> infoCliente = new ArrayList<Object>();
        infoCliente.add(cliente.getNomeCliente());
        infoCliente.add(cliente.getDataNascimentoCliente());
        infoCliente.add(cliente.getTelefoneCliente());
        

        ArrayList<Object> colunas = new ArrayList<Object>();
        colunas.add("nome");
        colunas.add("dataNascimento");
        colunas.add("telefone");

        for (int i = 0; i < infoCliente.size(); i++) {
        Object element = infoCliente.get(i);
        if (element != null && !element.toString().isEmpty()) {
                try {
                    Statement stmt = Db.Connect().createStatement();
                    String atualizarCliente = "UPDATE clientes SET " + colunas.get(i) + " = '" + infoCliente.get(i) + "' WHERE cpf = '" + cliente.getCpf() + "'";
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
        colunas.add("descricao");
        
       
        for (int i = 0; i < enderecoCliente.size(); i++) {
        	
        	Object element = enderecoCliente.get(i);
            if (element != null && !element.toString().isEmpty()) {
                try {
                    Statement stmt = Db.Connect().createStatement();
                    String dadosEndecoCliente = "UPDATE clientesEndereco SET " + colunas.get(i) + " = '" + enderecoCliente.get(i) + "' WHERE cpf = '" + cliente.getCpf() + "'";
                    stmt.execute(dadosEndecoCliente);
                    stmt.close();
                    Db.CloseDb();
                } catch (Exception e) {
                    e.printStackTrace();
                  
                }
            }
        }
    }
}


