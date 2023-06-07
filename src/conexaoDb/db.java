package conexaoDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class db {
    private static String url = "jdbc:mysql://172.16.238.2:3306/adsDb";
    private static String user = "root";
    private static String password = "root";
    
   public static Connection con = null;
   
    public static Connection Connect () {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Sucesso ao conectar");
            
            return con;
            
        } catch (Exception e) {
        	throw new DbErrorException("Erro ao finalizar conexão");
        	
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
