package ejemplo;

import java.io.File;

//para la libreria de xml:
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Main {
	public static void main (String[] args) {
		try {
			File ficheroXML = new File("persona.xml");

			// libreria xml
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docB = dbf.newDocumentBuilder();

			Document doc = docB.parse(ficheroXML);
			// Normaliza el documento eliminando saltos de linea y espacios en blanco
			doc.getDocumentElement().normalize();
			
			NodeList lista = doc.getElementsByTagName("persona");
			int cantidad = lista.getLength();
			for (int i = 0; i < cantidad; i++) {
				Node nodo = lista.item(i);
				
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element persona = (Element)nodo;
					String nombre = persona.getElementsByTagName("nombre").item(0).getTextContent();
					String edad = persona.getElementsByTagName("edad").item(0).getTextContent();
					String ciudad = persona.getElementsByTagName("ciudad").item(0).getTextContent();
				
					System.out.println("La persona es: "+nombre+" su edad es: "+edad+" y es de: "+ciudad);
						
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
