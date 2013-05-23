package xg.xml;

import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

import org.junit.Test;

import xg.config.Factory;
import xg.generadorCFEs.FileXMLReader;
import xg.xml.XMLSignerImpl;

public class XMLSignerTest {
	

	private  PublicKey getPublicKey() throws Exception{
	
		System.out.println("getPublicKey");
		 KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());



		    java.io.FileInputStream fis = null;
		    try {
		        fis = new java.io.FileInputStream("C:/Users/d0178/workspace/efactura/classes/agesic_prod_saml.jks");
		        ks.load(fis,"pep1to".toCharArray());
		    } finally {
		        if (fis != null) {
		            fis.close();
		        }
		    }
		    
			ProtectionParameter p = new KeyStore.PasswordProtection("pep1to".toCharArray());
			// get my private key
		    return  ks.getCertificate("*.dgi.gub.uy").getPublicKey();
		
	}

	
	private  PrivateKey getPrivateKey() throws Exception{
		
		 KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());


		    java.io.FileInputStream fis = null;
		    try {
		        fis = new java.io.FileInputStream("C:/Users/d0178/workspace/efactura/classes/agesic_prod_saml.jks");
		        ks.load(fis,"pep1to".toCharArray());
		    } finally {
		        if (fis != null) {
		            fis.close();
		        }
		    }
		    
			// get my private key
			ProtectionParameter p = new KeyStore.PasswordProtection("pep1to".toCharArray());
		    KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)
		        ks.getEntry("prod.dgi.gub.uy",p);
		    PrivateKey myPrivateKey = pkEntry.getPrivateKey();

		 return myPrivateKey;   
		
	}
	
	
	//FIRMAR UN DOCUMENTO NORMAL

	
	//FIRMAR UN DOCUMENTO CON UN CERTIFICADO VENCIDO
	@Test
	public void testXML() throws Exception {
		
		PrivateKey privateKey = getPrivateKey();
		Certificate cert = new Factory().getCertificate();
		XMLSignerImpl xmlSigner= new XMLSignerImpl(privateKey,cert);
		xmlSigner.sign(new FileXMLReader().getXMLFile("C:/Users/d0178/workspace/EFacturaWebTest/xmls/factura.xml"));
	}
	
	
	
	
	
	
	
	
	


}
