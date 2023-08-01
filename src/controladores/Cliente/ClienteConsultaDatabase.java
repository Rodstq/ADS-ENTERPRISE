package controladores.Cliente;
import conexaoDb.Db;

import data.tratamento.clients.Clientes;
import interfacesCliente.InterfaceConsultaCliente;

import interfacesCliente.InterfaceClienteEstatic;
import data.tratamento.clients.Clientes;
import interfacesCliente.InterfaceConsultaCliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteConsultaDatabase  implements InterfaceConsultaCliente {
	
	public List<Object[]> infoCliente(Clientes cliente) {
		
		List<Object[]> resultados = new ArrayList<>();
		try {
			Connection connection = Db.Connect();
			
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente JOIN cliente_endereco ON cliente.cpf_cliente = cliente_endereco.cpf_cliente WHERE cliente.nome_cliente LIKE ?");

			
			pstmt.setString(1, "%" + cliente.getNomeCliente() + "%");

			ResultSet rs = pstmt.executeQuery();

			
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
				
				 Object[] clienteDados = { nome, cpf, dataNascimento, telefone, complemento, estado, cidade, bairro, rua, cep };
                resultados.add(clienteDados);
				}
			}catch(Exception e) {
				
			

			}finally {
				
				Db.CloseDb();
			}
		return resultados;
		
}



		public List<Object[]> infoClienteCpf(Clientes cliente) {
	
		List<Object[]> resultados = new ArrayList<>();
		try {
			
	        Connection connection = Db.Connect();
	        PreparedStatement pstmt = connection.prepareStatement ("SELECT * FROM cliente JOIN cliente_endereco ON cliente.cpf_cliente = cliente_endereco.cpf_cliente WHERE cliente.cpf_cliente = ?");
	        
	       
	        pstmt.setString(1, cliente.getCpf());
	        ResultSet rs = pstmt.executeQuery();

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
				
				 Object[] clienteDados = { nome, cpf, dataNascimento, telefone, complemento, estado, cidade, bairro, rua, cep };
                 resultados.add(clienteDados);
				
			}

		}catch (Exception e){
			e.printStackTrace();
			
		}finally {
			
			Db.CloseDb();
		}
		return resultados;
		}

}
