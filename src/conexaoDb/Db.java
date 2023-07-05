package conexaoDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
    private static String url = "jdbc:mysql://127.0.0.1:3306/adsDb";
    private static String user = "root";
    private static String password = "root";
    
   public static Connection con = null;
   
    public static Connection Connect () throws SQLException{
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Sucesso ao conectar");
            
            return con;
            
        }catch (SQLException e) {
                throw new SQLException("Erro ao conectar ao banco de dados", e);
            }
        	
        }
      
    public static void CloseDb() {
    	
    	if(con != null) {
    		try {
    		
    		con.close();
    		
    		System.out.println("Sucesso ao finalizar conexão");
    		} catch(Exception msg){
    			
    			throw new DbErrorException("Erro ao finalizar conexão");
    			
    		}
    	}
    	
    }
  
}
