package pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DbManager;

public class PessoaDAO {
	private Connection dbConnection;
	private PreparedStatement stmt;
	public PessoaDAO() {
	}
	
	public List<Pessoa> listarPessoas(){
		try {
			dbConnection = DbManager.getConexaoMysql();
			 stmt = dbConnection.prepareStatement("SELECT * FROM pessoa");
			 prepararLista(stmt);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void buscarPessoaPorNome(Pessoa pessoa) {

		 try {
			dbConnection = DbManager.getConexaoMysql();
			stmt = dbConnection.prepareStatement("SELECT * FROM pessoa where nome = " + pessoa.getNome());
			prepararLista(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void prepararLista(PreparedStatement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery();
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		while(rs.next()) {
			pessoas.add(new Pessoa(rs.getLong("id"),rs.getString("nome")));
			System.out.println(pessoas);
		}
	}
	public void inserirPessoa(Pessoa pessoa) {
		
	}		
}
