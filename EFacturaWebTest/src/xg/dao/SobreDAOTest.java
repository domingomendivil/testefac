package xg.dao;

import java.io.IOException;

import org.junit.Test;

import uy.gub.dgi.cfe.EnvioCFE;
import xg.beans.SobreBean;
import xg.config.Factory;
import xg.generadorCFEs.FileXMLReader;
import xg.xml.XMLMarshallerException;
import xg.xml.XMLMarshallerImpl;

public class SobreDAOTest {
	
	@Test
	public void testSobre() throws Exception{
		new Factory().getDAO();
		SobreBean sobre = new SobreBean();
		sobre.setEnvioCFE(getEnvioCFE());
			new SobreDAO().insert(sobre);
	}
	
	@Test
	public void updateSobre() throws Exception{
		new Factory().getDAO();
		SobreBean sobre = new SobreBean();
		sobre.setEnvioCFE(getEnvioCFE());
		sobre.setEstadoDGI(SobreBean.ESTADO_DGI_ENVIADO);
		new SobreDAO().update(sobre);
	}


	private EnvioCFE getEnvioCFE() throws IOException, XMLMarshallerException {
		String xml = getXMLFile("xmls/sobre1.xml");
		EnvioCFE envio = (EnvioCFE)new XMLMarshallerImpl().marshall(EnvioCFE.class,xml);
		return envio;
	}
	
	private String getXMLFile(String string) throws IOException {
		return new FileXMLReader().getXMLFile(string);
	}

}
