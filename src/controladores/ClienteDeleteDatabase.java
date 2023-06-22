package controladores;
import java.sql.Statement;

import conexaoDb.Db;
public class ClienteDeleteDatabase {

	
	public void deletarCliente(String cpfCliente, String nomeCliente) {
		
			
		
		try {
			Statement stmt = Db.Connect().createStatement();
			String deleteEndereco = "delete from cliente_endereco where cpf_cliente='"+cpfCliente+"'";;
			String deleteCliente ="delete from cliente where cpf_cliente='"+cpfCliente+"'";
			String deleteProdutoCliente ="delete from pedido where cpf_cliente='" + cpfCliente+"'";
			
			stmt.execute(deleteEndereco);
			stmt.execute(deleteCliente);
			stmt.execute(deleteProdutoCliente);
			
		}catch(Exception e) {
			
			
		}
		
		
		}
		
		
	}
	
	
	

