package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
	public static void insertarDatos(Transaction transaction, Session session) {
		Persona persona = new Persona("Beatriz", 21);
		session.save(persona); // insert
		transaction.commit();

	}

	public static void lectura(Session session, Transaction transaction, int clavePrimaria) {
		Persona personaResultante = session.get(Persona.class, clavePrimaria);
		if (personaResultante != null) {
			System.out.println(personaResultante.toString());
		}
		transaction.commit();
	}

	public static void modificacion(Session session, Transaction transaction, int clavePrimaria) {
		Persona personaModificada = session.get(Persona.class, clavePrimaria);
		if (personaModificada != null) {
			personaModificada.setNombre("Mateo");
		}
		transaction.commit();
	}

	public static void borrar(Session session, Transaction transaction, int clavePrimaria) {
		Persona personaBorrar = session.get(Persona.class, clavePrimaria);
		if (personaBorrar != null) {
			session.remove(personaBorrar);
		}
		transaction.commit();
	}

	public static void consultaHQL (Session session, Transaction transaction, int edad) {
		String consultaHql="from persona p where p.edad >: edadMinima";
		//Query
		//List <Persona> listaPersonas=session.createQuery(consultaHql).getResultList();
	}

	public static void main(String[] args) {
		// como en ficheros abres tuberia
		Session session = HibernateUtil.getSessionFactory().openSession(); // conecta bbdd
		Transaction transaction = session.beginTransaction(); // transaccion, como un tunel

		// lectura(session,transaction,1);
		modificacion(session, transaction, 1);

		/* pque ahora lo haces en clases separadas */
		// Persona persona = new Persona("Beatriz",21);
		// session.save(persona); //insert
		// transaction.commit(); //esto cuidado pque no se puede quedar intermedio
		// session.close(); //cerrar
		// HibernateUtil.shutdown(); //cerrar

		/* rollback */
	}

}
