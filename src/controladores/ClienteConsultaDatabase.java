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
			
		String query = "SELECT * FROM cliente JOIN cliente_endereco ON cliente.cpf_cliente = cliente_endereco.cpf_cliente "
				+ "WHERE cliente.nome_cliente = '" + nomeCliente + "'";


			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String nome = rs.getString("nome_cliente");
				String cpf = rs.getString("cpf_cliente");
				String dataNascimento = rs.getString("nascimento_cliente");
				String telefone = rs.getString("telefone");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				String cep = rs.getString("cep");
				
				
				 Object[] cliente = { nome, cpf, dataNascimento, telefone, estado, cidade, bairro, rua, cep};
                 resultados.add(cliente);

			}

			rs.close();
					
			//consulta clientes apenas pelo cpf
		}else 	if (!cpfCliente.isEmpty()) {
			
		String query = "SELECT * FROM cliente JOIN cliente_endereco ON cliente.cpf_cliente = "
				+ "cliente_endereco.cpf_cliente WHERE cliente.cpf_cliente = '" + cpfCliente + "'";

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				

				String nome = rs.getString("nome_cliente");
				String cpf = rs.getString("cpf_cliente");
				Date dataNascimento = rs.getDate("nascimento_cliente");
				String telefone = rs.getString("telefone");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				String cep = rs.getString("cep");
				
				 Object[] cliente = { nome, cpf, dataNascimento, telefone, estado, cidade, bairro, rua, cep };
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
	
	
