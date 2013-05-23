package xg.beans;

import java.io.IOException;

import org.junit.Test;

import xg.generadorCFEs.FileXMLReader;
import xg.xml.XMLMarshallerException;
import static junit.framework.Assert.assertNotNull;

public class CFEBeanTest {

	
	@Test
	public void testCFECreate() throws IOException, XMLMarshallerException{
		String xml=new FileXMLReader().getXMLFile("xmls/CFE.xml");
		System.out.println(xml);
		CFEBean cfe = new CFEBean(xml);
		assertNotNull(cfe.getCfe());
	}
}
