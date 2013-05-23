package xg.dgiproxy;

import static junit.framework.Assert.*;

import java.security.PrivateKey;
import java.security.PublicKey;

import org.junit.Test;

import uy.gub.dgi.WSEFacturaSoapPort;

public class DGIProxyTest {

	private void assertDGICreate(String url, PrivateKey privateKey,
			PublicKey publicKey) {
		boolean exception = false;
		try {
			WSEFacturaSoapPort port = null;
			new DGIProxyImpl(port);
		} catch (DGIProxyException e) {
			exception = true;
		}
		assertEquals(true, exception);
	}

	// TEST CREATE DGIPROXYIMPL URL NULA

	public void testCreateDGIProxyImp1() {
		assertDGICreate(null, null, null);
	}

	// TEST CREATE DGIPROXYIMPL URL MAL FORMADA

	public void testCreateDGIProxyImp2() {
		assertDGICreate("a", null, null);
	}

	// TEST CREATE DGIPROXYIMPL ALMACÉN NULO

	public void testCreateDGIProxyImp3() {
		assertDGICreate("http://www.a.com", null, null);
	}

	// TEST CREATE DGIPROXYIMPL ALMACÉN NO PUEDE ACCEDERSE

	public void testCreateDGIProxyImp4() {
		PrivateKey privateKey = getPrivateKeyTrucho();
		assertDGICreate("http://www.a.com", privateKey, null);
	}

	private PrivateKey getPrivateKeyTrucho() {
		// TODO Auto-generated method stub
		return null;
	}

	// TEST ENVIAR SOBRE, SOBRE NULO
	@Test
	public void enviarSobre1(){
		DGIProxyImpl dgiProxyImpl = getDGIProxy();
		boolean exception=false;
		try {
			dgiProxyImpl.enviarSobre(null);
		} catch (DGIProxyException e) {
			exception=true;
		}
		assertEquals(true,exception);
	}

	private DGIProxyImpl getDGIProxy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	// TEST ENVIAR SOBRE, TIMEOUT ACCESO URL
	
	// TEST ENVIAR SOBRE COMUN
	

	// TEST ENVIAR SOBRE, TIMEOUT URL RESPUESTA INESPERADA

	// TEST CONSULTAR SOBRE, COSULTA NULA

	// TEST CONSULTAR SOBRE, TIMEOUT ACCESO URL

	// TEST CONSULTAR SOBRE, URL RESPUESTA INESPERADA

	// TEST ENVIAR REPORTE, COSULTA NULA

	// TEST ENVIAR REPORTE, TIMEOUT ACCESO URL

	// TEST ENVIAR REPORTE, URL RESPUESTA INESPERADA

}
