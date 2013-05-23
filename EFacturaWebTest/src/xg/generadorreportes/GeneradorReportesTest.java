package xg.generadorreportes;

import org.junit.Test;

import uy.gub.dgi.dao.DAO;
import xg.config.Factory;
import xg.dao.DAODummy;
import xg.generadorCFEs.GeneralConfigurationImpl;
import xg.generadorreportes.GeneradorReportesImpl;
import xg.xml.XMLMarshallerImpl;
import xg.xml.XMLSignerImpl;


public class GeneradorReportesTest {
	
	
	//GENERAR REPORTE: testeo no hay CFEs para generar sobres
	@Test
	public void testGenerarReporteNull() throws Exception{
		DAO dao = new DAODummy();
		GeneralConfigurationImpl config = new GeneralConfigurationImpl();
		XMLSignerImpl xmlSigner = new Factory().getXMLSigner();
		XMLMarshallerImpl xmlMarshaller = new XMLMarshallerImpl();
		GeneradorReportesImpl gen = new GeneradorReportesImpl(config,dao, xmlSigner, xmlMarshaller);
		InGenerarReporte in = new InGenerarReporte();
		gen.generarReporte(in);
	}
	
	
	//GENERAR REPORTE: testeo no hay CFEs en el día de ayer para generar sobre
	public void testGenerarReporteNoHayCFEsAyer(){
		
	}
	
	//GENERAR REPORTE: testeo hay un CFE ayer
	public void testGenerarReporteHayunCFEAyer(){
		
		//new GeneradorReportes(dao, xmlSigner, xmlMarshaller);
	}
	
	//GENERAR REPORTE: testeo hay CFEs solo antes de ayer
	public void testGenerarReporteHayCFEsAnteAyer(){
		
	}
	

	//GENERAR REPORTE: testeo hay CFEs ayer y anteayer: deben generarse dos sobres
	public void testGenerarReporteHayCFEsAyeryAnteayer(){
		
	}


}
