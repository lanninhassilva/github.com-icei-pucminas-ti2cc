package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() {

        try {

            String url = "jdbc:postgresql://localhost:5432/exercicio_java";
            String usuario = "postgres";
            String senha = "1234"; 

            Connection conn = DriverManager.getConnection(url, usuario, senha);

            return conn;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}