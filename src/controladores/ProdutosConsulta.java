package controladores;
import conexaoDb.Db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ProdutosConsulta {
	
	public List<Object[]> consultarProdutos(String nomeProduto) {
	
		List<Object[]> resultados = new ArrayList<>();
	try {
		
		Statement stmt = Db.Connect().createStatement();
		
		String query = "SELECT * FROM Produtos;";
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			 String id_produto = rs.getString(1);
			 String nome_produto = rs.getString(2);
			 int quantidade = rs.getInt(3);
			 double valor = rs.getDouble(4);
			 String id_estoque = rs.getString(5);
			 
			 Object[] produto = {id_produto,nome_produto,quantidade,valor,id_estoque};
		}
		rs.close();
		
		stmt.close();
		Db.CloseDb();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resultados;
	}

}
