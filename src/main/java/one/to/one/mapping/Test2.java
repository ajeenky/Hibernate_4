package one.to.one.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Employee employee = session.get(Employee.class, 1);
		System.out.println(employee.getId()+" "+employee.getFirst_name()+" "+employee.getLast_name()+" "+employee.getAc());
//		toString method is required in order to print the object[Account ac] which a variable in Employee class...
		session.close();
	}

}
