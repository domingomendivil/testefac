package xg.beans;

import java.io.IOException;

import org.junit.Test;

import xg.generadorCFEs.FileXMLReader;
import xg.xml.XMLMarshallerException;

public class CAEBeanTest {
	
	@Test
	public void testCAECreate() throws IOException, XMLMarshallerException{
		String xml=new FileXMLReader().getXMLFile("xmls/CAE_219999830019_90120000194_e-Ticket.xml");
		System.out.println(xml);
		CAEBean cae = new CAEBean(xml);
	}

}
