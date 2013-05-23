package xg.dgiproxy;

import java.io.IOException;

import org.junit.Test;

import uy.gub.dgi.Data;
import uy.gub.dgi.WSEFacturaEFACCONSULTARESTADOENVIOResponse;
import xg.beans.RespuestasCFEBean;
import xg.dgiproxy.consultarestadoenvio.ConsultaEstadoEnvioParserException;
import xg.dgiproxy.consultarestadoenvio.ConsultarEstadoEnvioParser;
import xg.generadorCFEs.FileXMLReader;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
public class ConsultarEstadoEnvioOutParserTest {

	
	private WSEFacturaEFACCONSULTARESTADOENVIOResponse getRespuesta(
			String string) throws IOException {
		WSEFacturaEFACCONSULTARESTADOENVIOResponse res = new WSEFacturaEFACCONSULTARESTADOENVIOResponse();
		Data data = new Data();
		String s =new FileXMLReader().getXMLFile(string);
		data.setXmlData(s);
		res.setDataout(data);
		return res;
		
	}

	
	//1) RESPUESTA CON ERROR
	@Test
	public void testRespuestaError() throws Exception{
		WSEFacturaEFACCONSULTARESTADOENVIOResponse res =getRespuesta("xmls/consultaEstadoEnvios/ack_consultaenvio_mal.xml");
		RespuestasCFEBean out =new ConsultarEstadoEnvioParser().parse(res);
		assertNotNull(out);
		assertFalse(out.isOk());
		assertNotNull(out.getRespuestas());
		assertEquals(6,out.getRespuestas().getRespuesta().getCodigo());
		assertEquals("Error al consumir el Servicio Web",out.getRespuestas().getRespuesta().getDescripcion());
		assertEquals("No se ha podido determinar el RUC del consumidor del Servicio Web",out.getRespuestas().getRespuesta().getDetalle());
	}
	
	

	//2) RESPUESTA INESPERADA
	@Test
	public void testRespuestaInesperada() throws IOException{
		WSEFacturaEFACCONSULTARESTADOENVIOResponse res =getRespuesta("xmls/consultaEstadoEnvios/ACK_inesperada.xml");
		boolean excepcion = false;
		try {
			new ConsultarEstadoEnvioParser().parse(res);
		} catch (ConsultaEstadoEnvioParserException e) {
			excepcion=true;
		}
		assertTrue(excepcion);
	}
	
	//3) RESPUESTA NULA
	@Test
	public void testRespuestaNula() throws IOException{
		boolean excepcion = false;
		try {
			new ConsultarEstadoEnvioParser().parse(null);
		} catch (ConsultaEstadoEnvioParserException e) {
			excepcion=true;
		}
		assertTrue(excepcion);
	}
	
	
	
	//4) RESPUESTA CORRECTA
	@Test
	public void testRespuestaOK() throws Exception{
		WSEFacturaEFACCONSULTARESTADOENVIOResponse res =getRespuesta("xmls/consultaEstadoEnvios/ACK_CFE_bien.xml");		
		RespuestasCFEBean out =new ConsultarEstadoEnvioParser().parse(res);
		assertNotNull(out);
		assertTrue(out.isOk());
		assertNull(out.getRespuestas());
		assertNotNull(out.getAckCFE());
	}
	
	
	

}
