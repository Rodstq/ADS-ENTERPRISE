package conexaoDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExemploDeQuery {
    private static String url = "jdbc:mysql://172.16.238.2:3306/adsDb";
    private static String user = "root";
    private static String password = "root";
    
   public static Connection con = null;
   
    public static void ConnectDb () {
    	try{
    		Connection con = DriverManager.getConnection(url, user, password);

    		Statement stmt = con.createStatement();

    		String query = "Select nome, valor from loja";
    		ResultSet rs = stmt.executeQuery(query);

    		while(rs.next()){
    			String nome = rs.getString("nome");
    			double valor = rs.getDouble("valor");
    			
    			System.out.println("nome: " + nome);
    			System.out.println("valor: "+ valor);


    		}

    		rs.close();
    		stmt.close();
    		con.close();
    		} catch (Exception e){
    			e.printStackTrace();
    		}

    }
  
}
