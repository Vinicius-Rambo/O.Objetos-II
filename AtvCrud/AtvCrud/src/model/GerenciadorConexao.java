package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
    private static Connection conexao;

    public static Connection pegarConexao() throws SQLException{

        String url = "jdbc:mysql://127.0.0.1/dbProjetos"; //Conexão do Java ao mysql -> dbProjetos
        String usuario = "root"; //Usuario utilizado
        String senha = "bancodedados"; //Senha

        conexao = DriverManager.getConnection(url, usuario, senha);

        return conexao;
    }
}