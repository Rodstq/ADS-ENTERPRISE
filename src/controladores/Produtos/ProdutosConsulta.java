package controladores.Produtos;
import conexaoDb.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ProdutosConsulta{

	ResultSet rs;
	ResultSetMetaData rsmd;
	int cols;
	JTable tblData;
	String query = "";
	String escolha = "";
	String dado;
	
	public String consultarProdutos() throws Exception {
	String resultado="";
	try {
		
		Connection connection = Db.Connect();
		
		PreparedStatement pstmt  = connection.prepareStatement(query);
		
		pstmt.setString(1,dado);		
		ResultSet rs = pstmt.executeQuery();
		
		
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
					e1.printStackTrace();
				}
			}
		
		
		while(rs.next()){
			 int id_produto = rs.getInt("id_produto");
			 String nome_produto = rs.getString("nome_produto");
			 double valor = rs.getDouble("valor_de_venda");
			 int quantidade = rs.getInt("quantidade_produto");
			 String cnpj = rs.getString("cnpj_fornecedor");
			 resultado = id_produto + nome_produto + cnpj + valor + quantidade;
			 Object[] results = {id_produto,nome_produto,valor,quantidade,cnpj};
			 model.addRow(results);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	if(!resultado.isBlank()) {
		return resultado;
	} else {
		throw new Exception("Não foram encontrados resultados");
	}
	}
	
	public void getEscolha(String escolha, String dado1,String dado2) {
		
		if(escolha.equals("id")){
			this.query = "SELECT produto.id_produto, produto.nome_produto, estoque.quantidade_produto,produto.valor_de_venda, produto.cnpj_fornecedor\r\n"
					+ "FROM produto\r\n"
					+ "JOIN estoque ON produto.id_estoque = estoque.id_estoque\r\n"
					+ "WHERE produto.id_produto = ?;";
			this.dado = dado1;
		} else {
			this.query = "SELECT produto.id_produto, produto.nome_produto, estoque.quantidade_produto,produto.valor_de_venda, produto.cnpj_fornecedor\r\n"
					+ "FROM produto\r\n"
					+ "JOIN estoque ON produto.id_estoque = estoque.id_estoque\r\n"
					+ "WHERE produto.nome_produto like ?;";
			this.dado = "%" + dado2 + "%";
		}
			this.escolha = escolha;		
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
