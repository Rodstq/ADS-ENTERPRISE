package controladores.Produtos;
import conexaoDb.Db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ProdutosConsulta{
	
	
	ResultSet rs;
	ResultSetMetaData rsmd;
	int cols;
	JTable tblData;
	String query = "";
	
	public String consultarProdutos() {
	String resultado="";
	try {
		
		Statement stmt = Db.Connect().createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		
		DefaultTableModel model = (DefaultTableModel) tblData.getModel();
		
		while(model.getRowCount() > 0)
		{
			model.removeRow(0);
		}
		
		String[] colName = new String[cols];
		 
		 
		 
		 for(int i = 0 ; i<cols ; i++) {
				try {
					colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		
		while(rs.next()){
			 int id_produto = rs.getInt("id_produto");
			 String nome_produto = rs.getString("nome_produto");
			 String cnpj = rs.getString("cnpj_fornecedor");
			 double valor = rs.getDouble("valor_de_venda");
			 int id_estoque = rs.getInt("id_estoque");
			 resultado = id_produto + nome_produto + cnpj + valor + id_estoque;
			 Object[] results = {id_produto,nome_produto,valor,id_estoque,cnpj};
			 model.addRow(results);
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
	
	// LÓGICA PARA MUDAR QUERY DE ACORDO COM SELEÇÃO POR ID OU POR NOME
	public void setQuery(String escolha, String id, String nome) {
		if(escolha.equals("id")){
			this.query = "SELECT * FROM produto WHERE id_produto =" + id + ";";
			System.out.println(query);
		} else {
			this.query = "SELECT * FROM produto WHERE nome_produto like '%" + nome + "%';";
			System.out.println(query);
		}
	
	}
	public ResultSet get_Rs() {
		return rs;
	}
	
	public ResultSetMetaData get_Rsmd() {
		return rsmd;
		
	}
	public int get_Cols() {
		return cols;
	}
	
	public void setTblData(JTable tblData) {
		this.tblData = tblData;
	}
}
