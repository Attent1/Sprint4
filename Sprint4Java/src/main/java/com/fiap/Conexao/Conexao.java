package com.fiap.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static final String USER =Credenciais.user;
	private static final String PWD = Credenciais.pwd;
	
	public static Connection getConnection() throws SQLException{		
		return DriverManager.getConnection(URL, USER, PWD);
		
	}
}
