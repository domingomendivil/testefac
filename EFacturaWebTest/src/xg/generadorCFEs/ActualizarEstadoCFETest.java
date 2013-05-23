package xg.generadorCFEs;

import actualizadorEstado.ActualizadorEstadoCFEs;
import xg.dao.DAODummy;
import xg.dgiproxy.DGIProxyDummy;

public class ActualizarEstadoCFETest {
	
	
	
	//No hay Sobres pendientes
	public void testNoHaySobres(){
		DAODummy dao = new DAODummy();
		DGIProxyDummy dgi = new DGIProxyDummy();
		ActualizadorEstadoCFEs actual = new ActualizadorEstadoCFEs(dao,dgi);
		actual.actualizarEstado();
		
	}
	
	//Hay un sobre pendiente, error conexión DGI
	public void testDGIerrorConexion(){
		DAODummy dao = new DAODummy();
		DGIProxyDummy dgi = new DGIProxyDummy();
		ActualizadorEstadoCFEs actual = new ActualizadorEstadoCFEs(dao,dgi);
		actual.actualizarEstado();
	}
	
	//Hay un sobre pendiente, DGI sigue sin actualizar
	public void testDGISigueIgual(){
		DAODummy dao = new DAODummy();
		DGIProxyDummy dgi = new DGIProxyDummy();
		ActualizadorEstadoCFEs actual = new ActualizadorEstadoCFEs(dao,dgi);
		actual.actualizarEstado();
	}
	
	//Hay un sobre pendiente, DGI aceptado
	public void testDGIAceptado(){
		DAODummy dao = new DAODummy();
		DGIProxyDummy dgi = new DGIProxyDummy();
		ActualizadorEstadoCFEs actual = new ActualizadorEstadoCFEs(dao,dgi);
		actual.actualizarEstado();
	}	
	
	//Hay un sobre pendiente, DGI rechazado
	
	public void testDGIRechazado(){
		DAODummy dao = new DAODummy();
		DGIProxyDummy dgi = new DGIProxyDummy();
		ActualizadorEstadoCFEs actual = new ActualizadorEstadoCFEs(dao,dgi);
		actual.actualizarEstado();
	}	
	

}
