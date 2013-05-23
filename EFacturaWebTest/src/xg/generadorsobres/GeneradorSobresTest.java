package xg.generadorsobres;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uy.gub.dgi.cfe.CAEdefType;
import xg.beans.CAEBean;
import xg.beans.CFEBean;
import xg.beans.SobreBean;
import xg.generadorCFEs.FileXMLReader;
import xg.xml.XMLMarshallerException;
import xg.xml.XMLMarshallerImpl;

public class GeneradorSobresTest {

	// ENVIAR CFES firmados con diferentes claves
	@Test
	public void testGenerarSobreNulo() {
		GeneradorSobre generador = new GeneradorSobreImpl(10);
		boolean excepcion = false;
		try {
			generador.generarSobre(null);
		} catch (GeneradorSobreException e) {
			excepcion = true;
		}
	}

	@Test
	public void testGenerarSobreCFE() throws Exception {
		GeneradorSobre generador = new GeneradorSobreImpl(10);
		boolean excepcion = false;
			InGenerarSobre in = new InGenerarSobre();
			in.setCfe_x(getCFes());
			X509Certificate x = getX509Certificate();
			System.out.println("x509 "+x);
			in.setX509Certificate(x);
			in.setIdEmisor(BigInteger.valueOf(123123));
			List<SobreBean> sobre = generador.generarSobre(in);
			boolean cant = sobre.get(0).getEnvioCFE().getCaratula().getCantCFE() == in
					.getCfe_x().size();
			String xml = new XMLMarshallerImpl()
					.unmarshall(sobre.get(0).getEnvioCFE());
			System.out.println(xml);
	}

	private CAEdefType getCAE() throws Exception {
		String xml = new FileXMLReader().getXMLFile("xmls/cae1.xml");
		CAEBean cae = new CAEBean(xml);
		return cae.getCae();
	}

	private X509Certificate getX509Certificate() throws Exception {

		System.out.println("getPublicKey");
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

		String keyStoreAlias = "servicios.dgi.red.uy";
		java.io.FileInputStream fis = null;
		try {
			String keyStoreDir = "keystores/agesic_prod.jks";
			String keyStorePwd = "pep1to";
			;
			 fis = new FileInputStream(new File(keyStoreDir));
			ks.load(fis, keyStorePwd.toCharArray());
			return (X509Certificate) ks.getCertificate(keyStoreAlias);
		} finally {
			if (fis != null) {
				fis.close();
			}
		}


	}

	private List<CFEBean> getCFes() throws IOException, XMLMarshallerException {
		ArrayList<CFEBean> lista = new ArrayList<CFEBean>();
		String xml = new FileXMLReader().getXMLFile("xmls/CFE.xml");
		CFEBean cfeBean = new CFEBean(xml);
		lista.add(cfeBean);
		return lista;
	}

}
