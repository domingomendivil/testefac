package xg.empresaproxy;

import static junit.framework.Assert.*;

import org.junit.Test;

import xg.beans.SobreBean;

public class EmpresaProxyTest {
	
	//Test env�o, sobre nulo, que tire EmpresaProxyException
	
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
	
	//Test env�o Sobre, CFE nulo, que tire EmpresaProxyException
	
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
	
	//Test env�o Sobre, mala configuraci�n 
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
			assertEquals("No existe configuraci�n para la conexi�n", msg);
		}
		assertTrue(excepcion);
	}
	
	//Test env�o, mala configuraci�n al servidor de correo, que tire EmpresaProxyException
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
	
	//Test env�o, error en el web service de env�o, que tire EmpresaProxyException
	
	//Test env�o a ning�n mail, no pasa nada
	
	//Test agregar un correo incorrecto, que tire error EmpresaProxyException
	
	//Test env�o a dos mails, chequeo que llegue a los dos mails
	
	//Test modificar acceso al WSDL de la empresa, (error de acceso), que tire EmpresaProxyException
	
	//Test modificar acceso al WSDL de la empresa, acceso correcto
	
	//Test agregar acceso al almac�n de claves, error ruta de acceso, que tire EmpresaProxyException
	
	//Test agregar acceso al almac�n de claves, error de clave, , que tire EmpresaProxyException
}
