package conexaoDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private static String url = "jdbc:mysql://localhost:3306/ads";
    private static String user = "root";
    private static String password = "root";
    private static Connection con = null;

    public static Connection Connect() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Sucesso ao conectar");

            return con;

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    public static Connection getCon() {
        return con;
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
