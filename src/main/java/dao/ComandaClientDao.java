package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import database.Clients;
import database.ComandaClient;
import database.Producte;

public class ComandaClientDao extends GenericDao<ComandaClient, Integer> implements IComandaClientDao{
	
	public boolean setProducte(ComandaClient c, Producte p) {
		Session session = sessionFactory.getCurrentSession();
		c.getComandes().add(p);
		p.getProducteComanda().add(p);
		try {
			session.beginTransaction();
			session.saveOrUpdate(c);
			session.saveOrUpdate(p);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (session != null && session.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			return false;
		}
	}

	public boolean setClient(ComandaClient c, Clients cl) {
		Session session = sessionFactory.getCurrentSession();
		c.setComprador(cl);
		cl.getComandes().add(c);
		try {
			session.beginTransaction();
			session.saveOrUpdate(cl);
			session.saveOrUpdate(c);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (session != null && session.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			return false;
		}
	}

}
