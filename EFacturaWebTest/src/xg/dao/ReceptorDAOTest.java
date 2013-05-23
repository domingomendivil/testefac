package xg.dao;

import uy.gub.dgi.dao.DAO;
import uy.gub.dgi.dao.DAOException;
import xg.beans.ReceptorBean;
import xg.config.Factory;


public class ReceptorDAOTest {
	
	public void testInsert1() throws DAOException {
		DAO dao = new Factory().getDAO();
		ReceptorBean receptor = new ReceptorBean();
		new ReceptorDAO().insert(receptor);
	}

}
