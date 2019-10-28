package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	public static String status = "n�o conectou...";
	
	public DbManager() {
		
	}
	
	public static Connection getConexaoMysql() {
		Connection connection = null;
		
		try {
			String driverName = "com.mysql.jdbc.Driver";
			
			Class.forName(driverName);
			
			String serverName = "localhost";
			
			String myDatabase = "fonetica";
			
			String url = "jdbc:mysql://" + serverName + "/" + myDatabase;
			
			String username = "root";
			
			String password = "123456";
			
			connection = DriverManager.getConnection(url,username,password);
			
			if(connection != null) {
				status = ("STATUS--->Conectado com sucesso!");
			}else {
				status = ("STATUS--->N�o foi possivel realizar conex�o");
			}
			
			return connection;
		}catch(ClassNotFoundException e) {//Driver n�o encontrado
			
			System.out.println("O driver especificado n�o foi encontrado");
			return null;
		}catch(SQLException e) {
			System.out.println("N�o foi possivel conectar ao banco de dados");
			return null;
		}
	}
	
	public static String statusConection() {
		return status;
	}
	
	public static boolean fecharConexao() {
		try {
			DbManager.getConexaoMysql().close();
			return true;
		}catch(SQLException e) {
			return false;
		}
	}
	
	public static Connection reiniciarConexao() {
		fecharConexao();
		
		return DbManager.getConexaoMysql();
	}
}
