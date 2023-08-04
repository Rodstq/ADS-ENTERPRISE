package controladores.Fornecedores;

	import conexaoDb.Db;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;


	public class FornecedoresConsultar {

		ResultSet rs;
		ResultSetMetaData rsmd;
		int cols;
		JTable tblData;
		String query = "";
		String escolha = "";
		String dado;
		
		public String consultarFornecedor() throws Exception {
		String resultado="";
		try {
			
			Connection connection = Db.Connect();
			
			PreparedStatement pstmt  = connection.prepareStatement(query);
			
			System.out.println(query);
			
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
				 String nome_fornecedor = rs.getString("nome_fornecedor");
				 String cnpj = rs.getString("cnpj_fornecedor");
				 resultado = cnpj + nome_fornecedor;
				 Object[] results = {cnpj,nome_fornecedor};
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
			
			if(escolha.equals("cnpj")){
				this.query = "select * from fornecedor where cnpj_fornecedor = ?";
				this.dado = dado1;
			} else {
				this.query = "SELECT * from fornecedor where nome_fornecedor like ?;";
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

