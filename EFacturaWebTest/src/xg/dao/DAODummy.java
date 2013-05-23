package xg.dao;

import java.util.ArrayList;

import uy.gub.dgi.dao.DAO;
import uy.gub.dgi.dao.DAOException;
import uy.gub.dgi.dao.Filter;
import xg.beans.CAEBean;
import xg.beans.CAEUtilizadoBean;
import xg.beans.CFEBean;

public class DAODummy implements DAO {
	
	private ArrayList lista = new ArrayList();

	@Override
	public void delete(Object arg0) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList getAll(Class arg0) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList getByFilter(Filter arg0, Class arg1, Class arg2)
			throws DAOException {
		ArrayList listaRes = new ArrayList();
		if (arg0 instanceof CAEFilter){
			CAEFilter filtro = (CAEFilter)arg0;
			if (arg1.equals(CAEUtilizadoBean.class)){
				for (Object objeto:lista){
					if (objeto instanceof CAEUtilizadoBean){
						CAEUtilizadoBean bean = (CAEUtilizadoBean)objeto;
						listaRes.add(bean);
						return listaRes;
					}
				}
				
			}else if (arg1.equals(CAEBean.class)){
				for (Object objeto:lista){
					if (objeto instanceof CAEBean){
						CAEBean bean = (CAEBean)objeto;
						if (filtro.isActual()==bean.isActual()){
							listaRes.add(bean);	
							return listaRes;
						}
						
					}
				}
			}
		}
		return null;
	}

	@Override
	public Object getById(Object arg0, Class arg1) throws DAOException {
		for (Object objeto:lista){
			if (objeto.getClass().equals(arg1)){
				if (arg1.equals(CFEBean.class)){
					return objeto;
				}
			}
		}
		return null;
/**		int index= lista.indexOf(arg0);
		if (index>=0){
			return lista.get(index);
		}else{
			return null;
		}**/
		
		
	}

	@Override
	public int getCount(Class arg0, Filter arg1) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getObjectByFilter(Filter arg0, Class arg1, Class arg2)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList getTotals(Class arg0, String arg1, String arg2)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList getTotals(Class arg0, Filter arg1, String arg2, String arg3)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Object arg0) throws DAOException {
		lista.add(arg0);
	}

	@Override
	public void update(Object arg0) throws DAOException {
		// TODO Auto-generated method stub

	}

}
