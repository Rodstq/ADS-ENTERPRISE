import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Main {
    private static final String url = "jdbc:mysql://172.19.0.2:3306/Banco";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String args[]) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            // Criação do objeto Statement
            Statement stmt = con.createStatement();

            // Execução da consulta SQL
            String query = "SELECT nome, valor FROM loja";
            ResultSet rs = stmt.executeQuery(query);

            // Iteração pelos resultados
            while (rs.next()) {
                String nome = rs.getString("nome");
                double valor = rs.getDouble("valor");

                // Impressão dos valores
                System.out.println("Nome: " + nome);
                System.out.println("Valor: " + valor);
            }

            // Fechamento dos recursos
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
