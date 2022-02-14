package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDao {
	private Connection connection;

	public UserPosDao() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Userposjava userposjava) {
		try {
			String sql = "insert into userposjava (id,nome,email) values(?, ?, ?)";

			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			insert.execute();
			connection.commit();// salva no banco
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				connection.rollback();//reverte a operacao.
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}
	public List<Userposjava> listar() throws Exception{
		List<Userposjava> list = new ArrayList<Userposjava>();
		
		String sql = "select * from userposjava";
		
		PreparedStatement statment = connection.prepareStatement(sql);
		ResultSet resultado = statment.executeQuery();
		
		while(resultado.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			
			
			list.add(userposjava);
			
			
		}
		
		return list;
		
		
		
	}
	public Userposjava buscar(long id) throws Exception {
		
	Userposjava retorno = new Userposjava();
	
       String sql = "select * from userposjava where id = " + id;
		
		PreparedStatement statment = connection.prepareStatement(sql);
		ResultSet resultado = statment.executeQuery();
		
		while(resultado.next()) {
			
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
		
		
	}
		return retorno;
}
}
