package xg.generadorCFEs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.KeyStore.ProtectionParameter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uy.gub.dgi.cfe.CAEdefType;
import uy.gub.dgi.cfe.CFEDefType;
import uy.gub.dgi.cfe.CFEDefTypeX;
import uy.gub.dgi.cfe.CFEDefTypeX.EFactX;
import uy.gub.dgi.cfe.CFEDefTypeX.EFactX.Detalle;
import uy.gub.dgi.cfe.ItemDetFact;
import xg.beans.CAEBean;
import xg.beans.CFEBean;
import xg.config.Factory;
import xg.config.FactoryException;
import xg.generadorcfes.GeneradorCFEs;
import xg.generadorcfes.GeneradorCFEsImpl;
import xg.xml.XMLMarshallerException;
import xg.xml.XMLMarshallerImpl;
import xg.xml.XMLSignerImpl;

public class GeneradorCFEsTest  {

	private CAEdefType getCAE() throws IOException, XMLMarshallerException {
		String xml=new FileXMLReader().getXMLFile("xmls/cae1.xml");
		CAEBean cae = new CAEBean(xml);
		return cae.getCae();
	}

	private CFEDefTypeX getFactura() {
		CFEDefTypeX cfe_x = new CFEDefTypeX();
		EFactX efact = new EFactX();
		Detalle detalle = new Detalle();
		ItemDetFact item = new ItemDetFact();
		detalle.getItem().add(item);
		efact.setDetalle(detalle);
		cfe_x.setEFactX(efact);
		return cfe_x;
	}

	
	@Test
	//GENERAR CFE
	//testear generar un CFE sin problemas en nada
	//chequear fecha de timestamp
	//chequear que verifique contra el xml generado
	public void testGenerarCFE() throws Exception {
		XMLSignerImpl xmlSigner = getXMLSigner();
		GeneradorCFEsImpl generador = new GeneradorCFEsImpl(xmlSigner);
		CFEDefTypeX cfe_x = getFactura();
		int nro = 2;
		CAEdefType cae = getCAE();
		CFEBean cfe = generador.generarCFE(cfe_x, cae, nro);
		String xml =new XMLMarshallerImpl().unmarshall(cfe.getCfe());
		System.out.println(xml);
	}


	//TEST GENERAR SOBRE CFE NULO
	
	//TEST GENERAR SOBRE UN CFE
	
	//TEST GENERAR SOBRE 2 CFEs
	
	//TEST GENERAR SOBRE
	
	
	

	private XMLSignerImpl getXMLSigner() throws Exception {
		PrivateKey privateKey = getPrivateKey();
		Certificate certificate = getX509Certificate();
		XMLSignerImpl xmlSigner = new XMLSignerImpl(privateKey, certificate);
		return xmlSigner;
	}

	//GENERAR SOBRE: testeo no hay CFEs en el día de ayer para generar sobre
	public void testGenerarSobreNoHayCFEsAyer(){
		
	}
	
	//GENERAR SOBRE: testeo hay un CFE ayer
	public void testGenerarSobreHayunCFEAyer(){
		
	}
	
	//GENERAR SOBRE: testeo hay CFEs solo antes de ayer
	public void testGenerarSobreHayCFEsAnteAyer(){
		
	}
	

	//GENERAR SOBRE: testeo hay CFEs ayer y anteayer: deben generarse dos sobres
	public void testGenerarSobreHayCFEsAyeryAnteayer(){
		
	}
	
	//GENERAR SOBRE: testo generar un sobre con certificado vencido
	public void testGenerarSobreCertificadoVencido(){
		XMLSignerImpl xmlSigner;
		try {
			xmlSigner = new Factory().getXMLSigner();
			GeneradorCFEs generador = new GeneradorCFEsImpl(xmlSigner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	//	generador.generarCFE(cfe_x, cae, nro);
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

	private PrivateKey getPrivateKey() throws Exception {

		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

		java.io.FileInputStream fis = null;
		
		try {
			fis = new java.io.FileInputStream("keystores//agesic_prod.jks");
			ks.load(fis, "pep1to".toCharArray());
		} finally {
			if (fis != null) {
				fis.close();
			}
		}

		// get my private key
		ProtectionParameter p = new KeyStore.PasswordProtection(
				"pep1to".toCharArray());
		KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) ks
				.getEntry("servicios.dgi.red.uy", p);
		PrivateKey myPrivateKey = pkEntry.getPrivateKey();

		return myPrivateKey;

	}


	
	
	

	
	

	private List<CFEDefTypeX> getFacturas() {
		CFEDefTypeX cfe = getFactura();
		ArrayList<CFEDefTypeX> lista = new ArrayList();
		lista.add(cfe);
		return lista;
	}

}
