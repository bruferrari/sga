package br.com.sga.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {


		private static final String USUARIO = "root";
		private static final String SENHA = "root";
		private static final String URL = "jdbc:mysql://localhost:3306/projeto_sga";

		public static Connection conectar() throws SQLException {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conexao;
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			return conexao;
		}
	}
