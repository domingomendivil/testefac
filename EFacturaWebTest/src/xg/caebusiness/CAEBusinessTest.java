package xg.caebusiness;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import xg.beans.CAEBean;
import xg.beans.CAEUtilizadoBean;
import xg.beans.CFEBean;
import xg.dao.DAODummy;
import xg.generadorCFEs.FileXMLReader;
import xg.generadorCFEs.GeneralConfigurationImpl;
import xg.xml.XMLMarshallerException;

public class CAEBusinessTest {
	
	
	private CAEBusinessImpl getCAEBusiness(){
		DAODummy dao = new DAODummy();
		GeneralConfigurationImpl config = new GeneralConfigurationImpl();
		CAEBusinessImpl caeBusiness = new CAEBusinessImpl(config,dao);
		return caeBusiness;
	}
	
	//Testea que ande cuando no hay ningún CAE disponible para ser usado
	@Test
	public void testGetCAENoHayNinguno() throws Exception{
		DAODummy dao = new DAODummy();
		GeneralConfigurationImpl config = new GeneralConfigurationImpl();
		CAEBusinessImpl caeBusiness = new CAEBusinessImpl(config,dao);
		CAEUtilizadoBean caeUtilizado = new CAEUtilizadoBean();
		boolean excepcion=false;
		try{
			CAEUtilizadoBean cae = caeBusiness.getCAE(CFEBean.EFACTURA);
		}catch (CAEBusinessException e){
			excepcion=true;
		}
		assertTrue(excepcion);
	}
	
	//Testea que ande cuando no hay números disponibles para ser usados
	@Test
	public void testGetCAESinNumeracionDisponible() throws Exception{
		DAODummy dao = new DAODummy();
		CAEUtilizadoBean caeUtilizado = getCAEUtilizado();
		dao.insert(caeUtilizado);
		GeneralConfigurationImpl config = new GeneralConfigurationImpl();
		CAEBusinessImpl caeBusiness = new CAEBusinessImpl(config,dao);
		boolean excepcion=false;
		try{
			CAEUtilizadoBean cae = caeBusiness.getCAE(CFEBean.EFACTURA);
		}catch (CAEBusinessException e){
			excepcion=true;
		}
		assertTrue(excepcion);;
		
	}
	
	private CAEUtilizadoBean getCAEUtilizado() throws IOException, XMLMarshallerException {
		CAEUtilizadoBean util = new CAEUtilizadoBean();
		CAEBean cae = getCAE();
		util.setUltimoNumero(cae.getHastaNumero());
		util.setCae(cae);
		return util;
	}

	private CAEBean getCAE() throws IOException, XMLMarshallerException {
		String xml =new FileXMLReader().getXMLFile("xmls/cae1.xml");
		return new CAEBean(xml);
	}

	//Testea que ande cuando el CAE se venció
	@Test
	public void testGetCAEVencido() throws Exception{
		DAODummy dao = new DAODummy();
		CAEBean cae = getCAEVencido();
		GeneralConfigurationImpl config = new GeneralConfigurationImpl();
		GregorianCalendar gr = cae.getCae().getDA().getFVD().toGregorianCalendar();
		gr.add(Calendar.DAY_OF_MONTH, 1); //SETEAMOS LA FECHA MAYOR
		config.setFechaActual(gr.getTime());
		dao.insert(cae);
		CAEBusinessImpl caeBusiness = new CAEBusinessImpl(config,dao);
		boolean excepcion=false;
		try{
			CAEUtilizadoBean caeRes = caeBusiness.getCAE(CFEBean.EFACTURA);
		}catch (CAEBusinessException e){
			excepcion=true;
		}
		assertTrue(excepcion);//No se retorna ningún CAE porque todos se encuentran vencidos
	}
	

	private CAEBean getCAEVencido() throws Exception {
		CAEBean cae = new CAEBean(getXMLFile("xmls/caevencido.xml"));
		return cae;
	}
	
	private String getXMLFile(String string) throws IOException {
		return new FileXMLReader().getXMLFile(string);
	}
	


	//Testea incrementar cuando hay números disponibles
	public void testIncrementarCAENumerosDisponibles() throws Exception{
		CAEBusinessImpl caeBusiness = getCAEBusiness();
		CAEUtilizadoBean cae = caeBusiness.getCAE(CFEBean.EFACTURA);
	}

	//Testea incrementar cuando es el último número y hay que utilizar un nuevo CAE
	@Test
	public void testIncrementarCAEUltimoNumero() throws Exception{
		DAODummy dao = new DAODummy();
		CAEBean cae = getCAE("xmls/cae1.xml");
		CAEUtilizadoBean caeUtil = new CAEUtilizadoBean();
		caeUtil.setCae(cae);
		caeUtil.setUltimoNumero(cae.getHastaNumero());
		CAEBean cae2 = getCAE("xmls/cae2.xml");
		dao.insert(cae);
		dao.insert(cae2);
		dao.insert(caeUtil);
		GeneralConfigurationImpl config = new GeneralConfigurationImpl();
		CAEBusinessImpl caeBusiness = new CAEBusinessImpl(config,dao);
		CAEUtilizadoBean cae3 = caeBusiness.getCAE(CFEBean.EFACTURA);
		assertEquals(cae2,cae3.getCae());
	}
	
	
	private CAEBean getCAE(String string) throws IOException, XMLMarshallerException {
		String xml = new FileXMLReader().getXMLFile(string);
		return new CAEBean(xml);
	}

	//Testea incrementar cuando es el último número y no hay más CAEs disponibles
	public void testIncrementarCAEUltimoNumeroYNoMasDisponibles() throws Exception{
		DAODummy dao = new DAODummy();
		GeneralConfigurationImpl config = new GeneralConfigurationImpl();
		CAEBusinessImpl caeBusiness = new CAEBusinessImpl(config,dao);
		CAEUtilizadoBean cae = caeBusiness.getCAE(CFEBean.EFACTURA);
		
		
	}
	
	//Testea insertar un CAE que ya está vencido
	public void testInsertarCAEVencido() {
		DAODummy dao = new DAODummy();
		GeneralConfigurationImpl config = new GeneralConfigurationImpl();
		CAEBusinessImpl caeBusiness = new CAEBusinessImpl(config,dao);
		boolean excepcion=false;
		try {
			caeBusiness.insertarCAE("cae.xml");
			
		} catch (CAEBusinessException e) {
			excepcion=true;
		
		}
		assertTrue(excepcion);
	}
	
	//Testea insertar un CAE no válido en xml
	public void testInsertarCAENoValido(){
		
	}
	
	//Testea insertar un CAE no puede verificarse certificado
	public void testInsertarCAENoVerificable(){
		
	}
	
	//Testea insertar primer CAE
	public void testInsertarPrimerCAE(){
		
	}
	
	//Testea insertar segundo CAE
	public void testInsertarSegundoCAE(){
		
	}

	
	
	
	
	
	
	
	
	
	

}
