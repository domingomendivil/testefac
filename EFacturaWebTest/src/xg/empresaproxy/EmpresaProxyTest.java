package xg.empresaproxy;

import static junit.framework.Assert.*;

import org.junit.Test;

import xg.beans.SobreBean;

public class EmpresaProxyTest {
	
	//Test envío, sobre nulo, que tire EmpresaProxyException
	
	@Test
	public void testEnviarSobreNulo(){
		EmpresaProxyImpl emp = new EmpresaProxyImpl();
		boolean excepcion = false;
		try{
			emp.enviarSobre(null);
		} catch (EmpresaProxyException e) {
			String msg = e.getMessage();
			excepcion = true;
			assertEquals("Sobre NULL", msg);
		}
		assertTrue(excepcion);
	}
	
	//Test envío Sobre, CFE nulo, que tire EmpresaProxyException
	
	@Test
	public void testEnviarCFENulo(){
		EmpresaProxyImpl emp = new EmpresaProxyImpl();
		boolean excepcion = false;
		try{
			emp.enviarCFE(null);
		} catch (EmpresaProxyException e) {
			String msg = e.getMessage();
			excepcion = true;
			assertEquals("CFE NULL", msg);
		}
		assertTrue(excepcion);
	}
	
	//Test envío Sobre, mala configuración 
	@Test
	public void testEnviarSobreMalaConfiguracion(){
		EmpresaProxyImpl emp = new EmpresaProxyImpl();
		SobreBean sobre = new SobreBean();
		boolean excepcion = false;
		try {
			emp.enviarSobre(sobre);
		} catch (EmpresaProxyException e) {
			String msg = e.getMessage();
			excepcion = true;
			assertEquals("No existe configuración para la conexión", msg);
		}
		assertTrue(excepcion);
	}
	
	//Test envío, mala configuración al servidor de correo, que tire EmpresaProxyException
	@Test
	public void testServidorCorreoMal(){
		EmpresaProxyImpl emp = new EmpresaProxyImpl();
		emp.setServidorCorreo("pepe");
		SobreBean sobre = new SobreBean();
		boolean excepcion = false;
		try {
			emp.enviarSobre(sobre);
		} catch (EmpresaProxyException e) {
			String msg = e.getMessage();
			excepcion = true;
			assertEquals("Imposible conectarse al servidor de correo", msg);
		}
		assertTrue(excepcion);
	}
	
	//Test envío, error en el web service de envío, que tire EmpresaProxyException
	
	//Test envío a ningún mail, no pasa nada
	
	//Test agregar un correo incorrecto, que tire error EmpresaProxyException
	
	//Test envío a dos mails, chequeo que llegue a los dos mails
	
	//Test modificar acceso al WSDL de la empresa, (error de acceso), que tire EmpresaProxyException
	
	//Test modificar acceso al WSDL de la empresa, acceso correcto
	
	//Test agregar acceso al almacén de claves, error ruta de acceso, que tire EmpresaProxyException
	
	//Test agregar acceso al almacén de claves, error de clave, , que tire EmpresaProxyException
}
