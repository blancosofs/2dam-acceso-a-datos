package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	//SessionFactory(nombre variable) sessionFactory(tipo variable)
	private static final SessionFactory sessionFactory= buildSessionFactory();

	public static SessionFactory buildSessionFactory() {
		//try-catch pque es como un fichero. abres lo de antes lo lees lo cargas y te conecta por el hibernate
		try {
			//esto lo hace directo hibernate. estas cargando todos los datos quqe has puesto en el cfg
			return new Configuration().configure().buildSessionFactory();
		}catch(Throwable e){
			System.err.println("Error: "+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		getSessionFactory().close(); //por lo de antes hay que cerrarlo ("fichero de lectura")
	}
	//--------------------------------
	/*todo esto es estandar: 
	 * el pom.xml(cargar dependencias de maven(en lugar de importar jar)),
	 *  hibernate.cfg(fichero de configuracion),
	 *  HibernateUtil(clase que te lee y cierra la conecion)
	*/
}
