package xg.receptorCFE;

import org.junit.Test;

import xg.beans.CFEBean;
import xg.generadorCFEs.FileXMLReader;
import xg.receptorcfe.ReceptorCFEMail;

public class ReceptorMailTest {
	@Test
	public void enviarMail() throws Exception{
		String xml = new FileXMLReader().getXMLFile("xmls/CFE.xml");
		CFEBean cfeBean = new CFEBean(xml);
		ReceptorCFEMail receptorMail = new ReceptorCFEMail();
		receptorMail.setHost("192.168.90.131");
		receptorMail.setEmail("d0178@dgi.gub.uy");
		receptorMail.enviarCFE(cfeBean);
	}

}
