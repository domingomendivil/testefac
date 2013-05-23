package xg.dao;

import static junit.framework.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import uy.gub.dgi.dao.DAO;
import uy.gub.dgi.dao.DAOException;
import xg.beans.CAEBean;
import xg.config.Factory;
import xg.generadorCFEs.FileXMLReader;
import xg.xml.XMLMarshallerException;


public class CAEDAOTest {
	
	@Test
	public void testInsert1() throws DAOException, XMLMarshallerException, IOException{
		DAO dao = new Factory().getDAO();
		CAEBean cae = new CAEBean(getXMLFile("xmls/CAE_219999830019_90120000194_e-Ticket.xml"));
		CAEDAO caeDAO = new CAEDAO();
		caeDAO.insert(cae);
		CAEBean cae2 = (CAEBean)caeDAO.getById(cae.getFecha());
		//assertEquals(cae.getFecha(),cae2.getFecha());
	}
	
	@Test
	public void testGetAll() throws DAOException{
		DAO dao = new Factory().getDAO();
		ArrayList lista= new CAEDAO().getAll();
	}

	private String getXMLFile(String string) throws IOException {
		return new FileXMLReader().getXMLFile(string);
	}
	
	
	private CAEBean getCAE(String string) throws IOException, XMLMarshallerException {
		String xml=new FileXMLReader().getXMLFile(string);
		CAEBean cae = new CAEBean(xml);
		return cae;
	}

}
