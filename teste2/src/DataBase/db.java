package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class db {
    private static String url = "jdbc:mysql://172.19.0.2:3306/Banco";
    private static String user = "root";
    private static String password = "root";
    
   public static Connection con = null;
   
    public static void ConnectDb () {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Sucesso ao conectar");
        } catch (Exception e) {
        	throw new DbErrorException ("Erro ao concetar no banco de dados");
        	
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

