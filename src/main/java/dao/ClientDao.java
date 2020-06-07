package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import database.Clients;
import database.Direccio;
import database.ComandaClient;

public class ClientDao extends GenericDao<Clients,Integer> implements IClientDao{


	public boolean setComanda(Clients c, ComandaClient co) {
		Session session = sessionFactory.getCurrentSession();
		c.getComandes().add(co);
		co.setComprador(c);
		try {
			session.beginTransaction();
			session.saveOrUpdate(c);
			session.saveOrUpdate(co);
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

	public boolean setAddress(Clients c, Direccio a) {
 		Session session = sessionFactory.getCurrentSession();
		c.setAdreca(a);
		try {
			session.beginTransaction();
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