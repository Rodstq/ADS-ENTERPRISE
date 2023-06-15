package controladores;
import conexaoDb.Db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class ClienteConsultaDatabase {
	
	//é do tipo objeto porque permite armazenar qualquer outro tipo
	public  List<Object[]> consultaCliente(String nomeCliente, String cpfCliente) {
		
		List<Object[]> resultados = new ArrayList<>();
		try {
		
		Statement stmt = Db.Connect().createStatement();
		
			if(!nomeCliente.isEmpty()) {
			
		String query = "SELECT * FROM clientes JOIN clientesEndereco ON clientes.cpf = clientesEndereco.cpf "
				+ "WHERE clientes.nome = '" + nomeCliente + "'";


			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String dataNascimento = rs.getString("dataNascimento");
				String telefone = rs.getString("telefone");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				
				
				 Object[] cliente = { nome, cpf, dataNascimento, telefone, estado, cidade, bairro, rua };
                 resultados.add(cliente);

			}

			rs.close();
					
			//consulta clientes apenas pelo cpf
		}else 	if (!cpfCliente.isEmpty()) {
			
		String query = "SELECT * FROM clientes JOIN clientesEndereco ON clientes.cpf = "
				+ "clientesEndereco.cpf WHERE clientes.cpf = '" + cpfCliente + "'";

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				Date dataNascimento = rs.getDate("dataNascimento");
				String telefone = rs.getString("telefone");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				
				 Object[] cliente = { nome, cpf, dataNascimento, telefone, estado, cidade, bairro, rua };
                 resultados.add(cliente);
				
			}
			rs.close();
			
		}	else {
			
			System.out.println("Campos vázios");
		}
			
		stmt.close();
		Db.CloseDb();		
		
		}catch (Exception e){
			e.printStackTrace();
		}
		return resultados;
		
	}
	
	
	

}
	
	
