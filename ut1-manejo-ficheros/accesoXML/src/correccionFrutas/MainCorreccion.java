package correccionFrutas;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;

public class MainCorreccion {

	public static int posicion(double precio,ArrayList<Fruta> Frutas) {
		int posicion =-1; //-1 es que no existe
		double valorAnterior=0;
		for (int i = 0; i < Frutas.size(); i++) {
			if(Frutas.get(i).getPrecio()==precio) {
				posicion=i;
			}else {
				if (valorAnterior>Frutas.get(i).getPrecio()) {
					posicion=i-1;
				}
			}
			valorAnterior=Frutas.get(i).getPrecio();
		}
		return posicion;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Fruta> Frutas = new ArrayList<>();
		try {
			File ficheroXML = new File("frutas.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docB = dbf.newDocumentBuilder();

			Document documento = docB.parse(ficheroXML);
			documento.getDocumentElement().normalize();// quitarle espacios y eso

			NodeList listaFrutas = documento.getElementsByTagName("fruta");
			int longitud = listaFrutas.getLength();

			for (int i = 0; i < args.length; i++) {
				Node nodo = listaFrutas.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) { // que pillas un nodo entero, esto es una comprobacion
					Element fruta = (Element) nodo;
					ArrayList<String> nutrientes = new ArrayList<>();
					Fruta piezaFruta = new Fruta(
							fruta.getElementsByTagName("nombre").item(0).getTextContent(),
							fruta.getElementsByTagName("tipo").item(0).getTextContent(),
							fruta.getElementsByTagName("color").item(0).getTextContent(),
							fruta.getElementsByTagName("origen").item(0).getTextContent(),
							Double.valueOf(fruta.getElementsByTagName("precio").item(0).getTextContent()),
							fruta.getElementsByTagName("temporada").item(0).getTextContent()
							);
					
					NodeList listaNutirentes = fruta.getElementsByTagName("nutriente");
					for (int j = 0; j < listaNutirentes.getLength(); j++) {
						nutrientes.add(listaNutirentes.item(j).getTextContent());
					}
					piezaFruta.setNutrientes(nutrientes);
					Frutas.add(piezaFruta);
				}
				//indicar el campo de la clase
				Frutas.sort(Comparator.comparing(Fruta::getPrecio));
			}
			for (Fruta elemento:Frutas) {
				System.out.println(elemento.toString());
				ArrayList<String> nutrientes = elemento.getNutrientes();
				for (String nutriente:nutrientes) {
					System.out.println(nutriente);
				}
			}

		} catch (Exception e) { // todos los errores, no solo entrada y salida
			e.printStackTrace();
		}

	}

}
