package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		//
		Session session = HibernateUtil.getSessionFactory().openSession(); //conecta

		Transaction transaction = session.beginTransaction(); //transaccion, como un tunel
		
		Persona persona = new Persona("Beatriz",21);
		session.save(persona); //insert
		
		transaction.commit();
		session.close(); //cerrar
		
		HibernateUtil.shutdown(); //cerrar
		
	}

}
