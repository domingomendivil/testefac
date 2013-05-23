package xg.dao;

import java.io.IOException;

import org.junit.Test;

import uy.gub.dgi.dao.DAO;
import xg.beans.CAEBean;
import xg.beans.CAEUtilizadoBean;
import xg.config.Factory;
import xg.generadorCFEs.FileXMLReader;
import xg.xml.XMLMarshallerException;
import static junit.framework.Assert.assertEquals;

public class CAEUtilizadoDAOTest {
	
	@Test
	public void testInsert1() throws Exception{
		DAO dao = new Factory().getDAO();
		CAEUtilizadoBean caeUtilizado = new CAEUtilizadoBean();
		CAEBean cae = getCAE();
		caeUtilizado.setCae(cae);
		caeUtilizado.setTipoCFE(cae.getTipoCFE());
		caeUtilizado.setUltimoNumero(3);
		new CAEUtilizadoDAO().insert(caeUtilizado);
	}
	
	@Test
	public void testGetById() throws Exception{
		DAO dao = new Factory().getDAO();
		CAEUtilizadoBean caeUtilizado = new CAEUtilizadoBean();
		CAEBean cae = getCAE();
		caeUtilizado.setCae(cae);
		caeUtilizado.setTipoCFE(cae.getTipoCFE());
		caeUtilizado.setUltimoNumero(3);
		CAEUtilizadoDAO util = new CAEUtilizadoDAO();
		util.insert(caeUtilizado);
		CAEUtilizadoBean bean2 = (CAEUtilizadoBean)util.getById(cae.getTipoCFE());
		assertEquals(cae.getTipoCFE(),bean2.getTipoCFE());
		
	}

	private CAEBean getCAE() throws Exception {
		CAEBean cae = getCAE("xmls/cae1.xml");
		new CAEDAO().insert(cae);
		return cae;
	}
	
	
	private CAEBean getCAE(String string) throws IOException, XMLMarshallerException {
		String xml=new FileXMLReader().getXMLFile(string);
		CAEBean cae = new CAEBean(xml);
		return cae;
	}
	

}
