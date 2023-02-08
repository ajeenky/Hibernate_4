package one.to.one.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setFirst_name("Akhilesh");
		employee.setLast_name("Gargatte");
		
		Account account = new Account();
		account.setAc_type("Gold");
		account.setEmp(employee);
		employee.setAc(account);
		
//		we are not using cascade thats why both of the objects needs to be saved
//		if it was a unidirectional mapping then we had to save the object which Id will be used as a foreign key in the target table
//		because its an bidirectional mapping sequence doesn't matter
		session.save(employee);
		session.save(account);
		transaction.commit();
		session.close();
	}

}
