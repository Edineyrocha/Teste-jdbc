package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.Userposjava;

public class TesteBancojdbc {
	
	// metodo para inserir no banco de dados.
	/*@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		
		Userposjava userposjava = new  Userposjava();
		
		userposjava.setId(7L);
		userposjava.setNome("Joao");
		userposjava.setEmail("joao@gmail");
		
		userPosDao.salvar(userposjava);
	}*/
	
	
	// metodo para listar os compoentes do banco todos.
	
/*	@Test
public void initlistar() {
	UserPosDao dao = new UserPosDao();
	
	try {
		List<Userposjava> list = dao.listar();
		for (Userposjava userposjava : list) {
			System.out.println(userposjava.toString());
			System.out.println("---------------------------------------------------");
			
			
		}
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
	
}*/
	//método para buscar pelo ID.
	@Test
	public void initBuscar() {
		UserPosDao dao = new UserPosDao();
		
		try {
			Userposjava userposjava = dao.buscar(5L);
			System.out.println(userposjava);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}
