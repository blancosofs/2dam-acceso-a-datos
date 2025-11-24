package ejFrutas;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main2 {

	public static void main(String[] args) {
		try {
			File ficheroXML = new File("frutas.xml");

			// libreria xml
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docB = dbf.newDocumentBuilder();

			Document doc = docB.parse(ficheroXML);
			// Normaliza el documento eliminando saltos de linea y espacios en blanco
			doc.getDocumentElement().normalize();

			NodeList lista = doc.getElementsByTagName("fruta");
			int cantidad = lista.getLength();
			for (int i = 0; i < cantidad; i++) {
				Node nodo = lista.item(i);

				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element fruta = (Element) nodo;
					String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
					String tipo = fruta.getElementsByTagName("tipo").item(0).getTextContent();
					String color = fruta.getElementsByTagName("color").item(0).getTextContent();
					String origen = fruta.getElementsByTagName("origen").item(0).getTextContent();
					String precio = fruta.getElementsByTagName("precio").item(0).getTextContent();
					String temporada = fruta.getElementsByTagName("temporada").item(0).getTextContent();
					System.out.println("Los atributos de la fruta son: " + nombre + " , " + tipo + " , " + color + " , "
							+ origen + " , " + precio + " , " + temporada);

					NodeList lista2 = doc.getElementsByTagName("nutrientes");
					int cantidad2 = lista2.getLength();;
					for (int j = 0; j < cantidad2; j++) {
						Node nodo2 = lista2.item(j);
						if (nodo2.getNodeType() == Node.ELEMENT_NODE) {
							String nutriente = fruta.getElementsByTagName("nutriente").item(j).getTextContent();
							System.out.println("Y sus nutriente son: " + nutriente);
						}
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
