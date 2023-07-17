package controladores;
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
	
	public String consultarProdutos(String nomeProduto) {
	String resultado="";
	try {
		
		Statement stmt = Db.Connect().createStatement();
		
		String query = "SELECT * FROM Produtos;";
		
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
			 String id_produto = rs.getString("id_produto");
			 String nome_produto = rs.getString("nome_produto");
			 int quantidade = rs.getInt("quantidade");
			 double valor = rs.getDouble("valor");
			 String id_estoque = rs.getString("id_produto");
			 resultado = id_produto + nome_produto + quantidade + valor + id_estoque;
			 Object[] results = {id_produto,nome_produto,quantidade,valor,id_estoque};
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
