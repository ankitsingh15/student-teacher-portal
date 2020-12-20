//founder of hibernate -Gavin King
import org.hibernate.*;
import org.hibernate.cfg.*;

class HibernateConnection {
	public static void main(String args[]){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	
		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = null;
		try {
			session = sfact.openSession(); 
			System.out.println("Connected");
		} catch( Exception e ) {
			System.out.println("Issue :" + e);

		} finally {
			if ( session != null ) {
				session.close();
				 System.out.println("Disconnected");
			}
		}
	}

}