package xg.dao;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import uy.gub.dgi.dao.DAO;
import xg.beans.CFEBean;
import xg.config.Factory;
import xg.generadorCFEs.FileXMLReader;

public class CFEDAOTest {

	
	
	@Test
	public void testInsert1() throws Exception {
		DAO dao = new Factory().getDAO();
		CFEBean cfe = new CFEBean(getXMLFile("xmls/CFE.xml"));
		new CFEDAO().insert(cfe);
	}
	
	
	private String getXMLFile(String string) throws IOException{
		return new FileXMLReader().getXMLFile(string);
	}
	
	@Test
	public void testGetAll() throws Exception {
		DAO dao = new Factory().getDAO();
		ArrayList lista=new CFEDAO().getAll();
		CFEBean cfe=(CFEBean)lista.get(0);
		System.out.println("cfe "+cfe.getCodigoSucursal());
		
	}
	
	@Test
	public void testUpdate() throws Exception {
		DAO dao = new Factory().getDAO();
		//CFEBean cfe = new CFEBean(new FileXMLReader().getXMLFile(string));
		//new CFEDAO().insert(cfe);
	}
	
	
}
