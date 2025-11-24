package ejFrutas;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main3 {

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
			for (int s = 0; s < cantidad; s++) {
				Node nodo = lista.item(s);

				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element fruta = (Element) nodo;
					String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
					String tipo = fruta.getElementsByTagName("tipo").item(0).getTextContent();
					String color = fruta.getElementsByTagName("color").item(0).getTextContent();
					String origen = fruta.getElementsByTagName("origen").item(0).getTextContent();
					String precio = fruta.getElementsByTagName("precio").item(0).getTextContent();
					String temporada = fruta.getElementsByTagName("temporada").item(0).getTextContent();
					//nada mas te vas a que lea la etiqueta de arriba (nutrientes en lugar de nutriente)
					String nutriente = fruta.getElementsByTagName("nutrientes").item(0).getTextContent();
					System.out.println("Los atributos de la fruta son: " + nombre + " , " + tipo + " , " + color + " , "
							+ origen + " , " + precio + " , " + temporada);
					System.out.println("Y sus nutrientes son: "+nutriente);
				}
				
				//comparar precios. imprimir el array de mayor a menor precio 
				ArrayList<String> precios = new ArrayList<String>(); 
				//carga el arraylist
				//es mas facil tener una clase
				
				boolean ordenado;
				String aux;
				do {
					ordenado = true;
					for (int s1 = 0; s1 < precios.size() - 1; s1++) {
						if (precios.get(s1).compareTo(precios.get(s1 + 1)) > 0) { //.get() the element at the specified position in this list
							aux = precios.get(s1);
							precios.set(s1, precios.get(s1 + 1));
							precios.set(s1 + 1, aux);
							ordenado = false;
						}
					}
				} while (!ordenado);
				for (int p = 0; p < precios.size(); p++) {
					System.out.println(precios.get(p));
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
