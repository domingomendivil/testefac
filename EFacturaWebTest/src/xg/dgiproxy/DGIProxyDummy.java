package xg.dgiproxy;

import java.util.List;

import xg.beans.CAEBean;
import xg.beans.CFEBean;
import xg.beans.ReporteBean;
import xg.beans.SobreBean;

public class DGIProxyDummy implements DGIProxy {

	@Override
	public void enviarSobre(SobreBean sobre) throws DGIProxyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enviarReporte(ReporteBean reporte) throws DGIProxyException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public CAEBean obtenerCAE(InObtenerCAE in) throws DGIProxyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void consultarEstadoEnvio(SobreBean sobre) throws DGIProxyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CFEBean> consultarCFEs(InConsultarCFEs in)
			throws DGIProxyException {
		// TODO Auto-generated method stub
		return null;
	}



}
