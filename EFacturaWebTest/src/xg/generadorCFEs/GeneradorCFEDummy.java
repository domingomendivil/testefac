package xg.generadorCFEs;

import uy.gub.dgi.cfe.CAEdefType;
import uy.gub.dgi.cfe.CFEDefTypeX;
import xg.beans.CFEBean;
import xg.generadorcfes.GeneradorCFEException;
import xg.generadorcfes.GeneradorCFEs;

public class GeneradorCFEDummy implements GeneradorCFEs {

	@Override
	public CFEBean generarCFE(CFEDefTypeX cfe_x, CAEdefType cae, int nro)
			throws GeneradorCFEException {
		try {
			String xml = new FileXMLReader().getXMLFile("xmls/CFE.xml");
			CFEBean cfe = new CFEBean(xml);
			return cfe;
		} catch (Exception e) {
			throw new GeneradorCFEException(e);
		}
		
	}

}
