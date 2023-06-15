package controladores;
import java.sql.Statement;

import conexaoDb.Db;
public class ClienteDeleteDatabase {

	
	public void deletarCliente(String cpfCliente, String nomeCliente) {
		
			
		
		try {
			Statement stmt = Db.Connect().createStatement();
			String deleteEndereco = "delete from clientesEndereco where cpf='"+cpfCliente+"'";;
			String deleteCliente ="delete from clientes where cpf='"+cpfCliente+"'";
			
			
			stmt.execute(deleteEndereco);
			stmt.execute(deleteCliente);
			
		}catch(Exception e) {
			
			
		}
		
		
		}
		
		
	}
	
	
	

