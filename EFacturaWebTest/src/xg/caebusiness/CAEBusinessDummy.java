package xg.caebusiness;

import java.io.IOException;

import xg.beans.CAEBean;
import xg.beans.CAEUtilizadoBean;
import xg.beans.CFEBean;
import xg.caebusiness.CAEBusiness;
import xg.caebusiness.CAEBusinessException;
import xg.generadorCFEs.FileXMLReader;
import xg.xml.XMLMarshallerException;

public class CAEBusinessDummy implements CAEBusiness {
	
	private CAEUtilizadoBean util =new CAEUtilizadoBean();


	@Override
	public void insertarCAE(String xmlFile) throws CAEBusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public CAEUtilizadoBean getCAE(int tipoCFE) throws CAEBusinessException {
		util.setUltimoNumero(0);
		try {
			util.setCae(getCae());
			return util;
		} catch (Exception e) {
			throw new CAEBusinessException(e);
		}
		
	}

	private CAEBean getCae() throws IOException, XMLMarshallerException {
		String xml = new FileXMLReader().getXMLFile("xmls/cae1.xml");
		CAEBean cae = new CAEBean(xml);
		return cae;
	}


	@Override
	public void insertarCFE(CFEBean cfe) throws CAEBusinessException {
		// TODO Auto-generated method stub
		
	}

}
