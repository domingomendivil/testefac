package xg.dgiproxy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import uy.gub.dgi.Data;
import uy.gub.dgi.WSEFacturaEFACRECEPCIONREPORTEResponse;
import xg.beans.RespuestasReporteBean;
import static junit.framework.Assert.assertTrue;

public class EnviarReporteOutParserTest {

	//ACK Sobre bien
	@Test
	public void testACKSobreBien() throws Exception {
		WSEFacturaEFACRECEPCIONREPORTEResponse response = new WSEFacturaEFACRECEPCIONREPORTEResponse();
		Data data = new Data();
		String xml = getXMLFile("xmls/envioReportes/ack_reporte_bien.xml");
		data.setXmlData(xml);
		response.setDataout(data);
		RespuestasReporteBean out = new EnviarReporteParser().parse(response);
		
	}
	
	
	//ACK Sobre Mal
	@Test
	public void testACKSobreMal() throws Exception {
		WSEFacturaEFACRECEPCIONREPORTEResponse response = new WSEFacturaEFACRECEPCIONREPORTEResponse();
		Data data = new Data();
		String xml = getXMLFile("xmls/envioReportes/ack_reporte_mal.xml");
		data.setXmlData(xml);
		response.setDataout(data);
		RespuestasReporteBean out = new EnviarReporteParser().parse(response);
		
	}
	
	
	//ACK Nulo
	@Test
	public void testACKSobreNulo() {
		boolean excepcion=false;
		try {
			RespuestasReporteBean out = new EnviarReporteParser().parse(null);
		} catch (EnviarReporteOutParserException e) {
			excepcion=true;
		}
		assertTrue(excepcion);
		
	}


	

	private String getXMLFile(String string) throws IOException {
		return readFile(string);
		
	}
	
	
	
	private String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}

}
