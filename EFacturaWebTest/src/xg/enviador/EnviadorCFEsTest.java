package xg.enviador;

import java.security.cert.X509Certificate;

import uy.gub.dgi.dao.DAO;
import xg.beans.CFEBean;
import xg.dao.DAODummy;
import xg.dgiproxy.DGIProxy;
import xg.dgiproxy.DGIProxyDummy;
import xg.generadorsobres.GeneradorSobre;
import xg.generadorsobres.GeneradorSobreDummy;
import xg.locator.LocatorDummy;

public class EnviadorCFEsTest {
	
	
	//ENVIAR CFE, FALLA PROXY
	public void testEnviarCFEFallaProxy(){
		GeneradorSobre generador = new GeneradorSobreDummy();
		DGIProxy dgiProxy = new DGIProxyDummy();
		DAO dao = new DAODummy();
		LocatorDummy locator = new LocatorDummy();
		X509Certificate certificate = getX09Certificate();
		EnviadorCFEImpl env =new EnviadorCFEImpl(certificate,dgiProxy,generador,dao);
		CFEBean cfe = getCFE();
		try {
			env.enviarCFE(cfe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private CFEBean getCFE() {
		// TODO Auto-generated method stub
		return null;
	}

	private X509Certificate getX09Certificate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//ENVIAR CFE NULO
	
	//ENVIAR CFE, SOBRE RECHAZADO, INDICAR HORA RECHAZO
	
	//ENVIAR CFE, SOBRE ACEPTADO, INDICAR HORA ACEPTADO, INDICAR TIEMPO CONSULTA, FALTA VALIDAR
		
	//ENVIAR CFE, SOBRE ACEPTADO,   
	
	
	//ENVIAR un sobre nulo, EnviadorCFEException
	
	
	
	
	

}
