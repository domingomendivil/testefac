package xg.generadorCFEs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileXMLReader {
	
	
	public String getXMLFile(String string) throws IOException {
		return readFile(string);
		
	}
	
	
	
	private String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}
	

}
