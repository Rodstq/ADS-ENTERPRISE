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
	
	public  List<Object[]> consultaNomeClienteEndereco(String nomeCliente) {
		
		List<Object[]> resultados = new ArrayList<>();
		try {
		
		Statement stmt = Db.Connect().createStatement();
				
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
				String complemento = rs.getString("complemento");
				
				 Object[] cliente = { nome, cpf, dataNascimento, telefone, complemento, estado, cidade, bairro, rua, cep };
                resultados.add(cliente);
				}
			}catch(Exception e) {


			}finally {
				
				Db.CloseDb();
			}
		return resultados;
}



		public  List<Object[]> consultaCpfClienteEndereco(String cpfCliente) {
	
		List<Object[]> resultados = new ArrayList<>();
		try {
	
			
		String query = "SELECT * FROM cliente JOIN cliente_endereco ON cliente.cpf_cliente = "
				+ "cliente_endereco.cpf_cliente WHERE cliente.cpf_cliente = '" + cpfCliente + "'";

		Statement stmt = Db.Connect().createStatement();
			
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
				String complemento = rs.getString("complemento");
				
				 Object[] cliente = { nome, cpf, dataNascimento, telefone, complemento, estado, cidade, bairro, rua, cep };
                 resultados.add(cliente);
				
			}

		}catch (Exception e){
			e.printStackTrace();
			
		}finally {
			
			Db.CloseDb();
		}
		return resultados;
	}
		
		
//	public  List<Object[]> consultaNomeOnlyCliente(String nomeCliente) {
//			
//			List<Object[]> resultados = new ArrayList<>();
//			try {
//			
//			Statement stmt = Db.Connect().createStatement();
//			
//			String query = "SELECT * FROM cliente WHERE cliente.nome_cliente = '" + nomeCliente + "'";
//			ResultSet rs = stmt.executeQuery(query);
//			
//			while(rs.next()){
//				String nome = rs.getString("nome_cliente");
//				String cpf = rs.getString("cpf_cliente");
//				String dataNascimento = rs.getString("nascimento_cliente");
//				String telefone = rs.getString("telefone");
//
//							
//				 Object[] cliente = { nome, cpf, dataNascimento, telefone};
//                 resultados.add(cliente);
//                 
//     			rs.close();
//     			stmt.close();
//     			Db.CloseDb();
//				}
//			}catch(Exception e) {
//
//			}finally {
//				
//				Db.CloseDb();
//			}
//			return resultados;
//		}
}

