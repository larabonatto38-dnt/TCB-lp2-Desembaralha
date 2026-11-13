package br.edu.ifpr.dao;
//DAO - data acess object

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/desembaralha";
    private static final String user = "aluno";
    private static final String password = "aluno";

    public static Connection conectar() throws SQLException{
        Connection conexao = DriverManager.getConnection(url, user, password);
        return conexao;
    }
}