package controladores;
import conexaoDb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class consultaCliente {

	public static void consultaCliente(String nomeCliente, String cpfCliente) {
		
	
		try {
		
		Statement stmt = db.Connect().createStatement();
		
		if(!nomeCliente.isEmpty()) {
			
			String query = "SELECT * FROM clientes WHERE nome = '" + nomeCliente + "'";

			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String nome = rs.getString("nome");
				int cpf = rs.getInt("cpf");
				
				System.out.println("nome: " + nome);
				System.out.println("valor: "+ cpf);

			}

			rs.close();
			
		}else if (!cpfCliente.isEmpty()) {
			
			String query = "SELECT * FROM clientes WHERE cpf = " + cpfCliente;
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String nome = rs.getString("nome");
				int cpf = rs.getInt("cpf");
				
				System.out.println("nome: " + nome);
				System.out.println("valor: "+ cpf);


			}
			rs.close();
			
		}else if(!cpfCliente.isEmpty() && !nomeCliente.isEmpty()){
			
			String query = "SELECT cpf, nome FROM clientes WHERE cpf = " + cpfCliente + " AND nome = " + nomeCliente;
		}else {
			
			System.out.println("Campos vázios");
		}
	
	

		
		stmt.close();
		db.CloseDb();		
		
		}catch (Exception e){
			e.printStackTrace();
		}
	
	
	}
}
	
	
