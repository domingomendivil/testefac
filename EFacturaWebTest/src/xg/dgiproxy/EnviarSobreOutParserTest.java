package xg.dgiproxy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import uy.gub.dgi.Data;
import uy.gub.dgi.WSEFacturaEFACRECEPCIONSOBREResponse;
import xg.beans.RespuestaSobreBean;

public class EnviarSobreOutParserTest {

	@Test
	public void testACKSobreBien() throws Exception {
		WSEFacturaEFACRECEPCIONSOBREResponse response = new WSEFacturaEFACRECEPCIONSOBREResponse();
		Data data = new Data();
		String xml = getXMLFile("xmls/envioSobres/ack_sobre.xml");
	//	System.out.println(xml);
		data.setXmlData(xml);
		response.setDataout(data);
		RespuestaSobreBean out = new EnviarSobreOutParser().parse(response);
		System.out.println(out.getAckSobre().getCaratula().getRUCEmisor());
	}
	
	
	@Test
	public void testACKSobreMal() throws Exception {
		WSEFacturaEFACRECEPCIONSOBREResponse response = new WSEFacturaEFACRECEPCIONSOBREResponse();
		Data data = new Data();
		String xml = getXMLFile("xmls/envioSobres/ack_sobre_mal.xml");
		data.setXmlData(xml);
		response.setDataout(data);
		RespuestaSobreBean out = new EnviarSobreOutParser().parse(response);
		System.out.println(out.getRespuestas().getRespuesta().getDescripcion());
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
