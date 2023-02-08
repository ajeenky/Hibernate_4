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
		
		employee.setAc(account);
//		we used cascade on account reference variable thats why we only need to save the employee 
//		account will be automatically saved
//		session.save(account);
		session.save(employee);
		transaction.commit();
		session.close();
	}

}
