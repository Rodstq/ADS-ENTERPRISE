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
	
	public String consultarProdutos(String nomeProduto) {
	String resultado="";
	try {
		
		Statement stmt = Db.Connect().createStatement();
		
		String query = "SELECT * FROM Produtos;";
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			 String id_produto = rs.getString("id_produto");
			 String nome_produto = rs.getString("nome_produto");
			 int quantidade = rs.getInt("quantidade");
			 double valor = rs.getDouble("valor");
			 String id_estoque = rs.getString("id_produto");
			 System.out.println(id_produto + " " + quantidade);
			 resultado = nome_produto;			 
		}
		
//		rs.close();
//		
//		stmt.close();
//		Db.CloseDb();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resultado;
	}

}
