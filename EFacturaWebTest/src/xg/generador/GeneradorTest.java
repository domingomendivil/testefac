package xg.generador;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

import uy.gub.dgi.cfe.CFEDefTypeX;
import xg.beans.CAEUtilizadoBean;
import xg.beans.CFEBean;
import xg.caebusiness.CAEBusinessDummy;
import xg.dao.DAODummy;
import xg.generadorCFEs.FileXMLReader;
import xg.generadorCFEs.GeneradorCFEDummy;
import xg.xml.XMLMarshallerImpl;

public class GeneradorTest {
	
	@Test
	public void generadorOK() throws Exception{
		CAEBusinessDummy caeBusiness = new CAEBusinessDummy();
		GeneradorCFEDummy generadorCFES = new GeneradorCFEDummy();
		DAODummy dao = new DAODummy();
		CFEDefTypeX cfe_x = getCFE();
		int temp = caeBusiness.getCAE(cfe_x.getTipoCFE()).getUltimoNumero();
		System.out.println("temp "+temp);
		GeneradorImpl generador = new GeneradorImpl(caeBusiness, generadorCFES, dao);
		CFEBean cfe = generador.generarCFE(cfe_x);
		CFEBean cfe2 = (CFEBean)dao.getById(cfe.getTimeStamp(),CFEBean.class);
		CAEUtilizadoBean util = caeBusiness.getCAE(cfe.getTipoCFE());
		System.out.println("ultimo numero "+util.getUltimoNumero());
		assertTrue(util.getUltimoNumero() == (temp+1)); 
		assertEquals(cfe,cfe2);
	}

	private CFEDefTypeX getCFE() throws Exception {
		String xml =new FileXMLReader().getXMLFile("xmls/factura.xml");
		CFEDefTypeX cfe = (CFEDefTypeX)new XMLMarshallerImpl().marshall(CFEDefTypeX.class, xml);
		return cfe;
	}

}
