package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import database.Direccio;
import database.Proveidors;
import database.Clients;

public class DireccioDao extends GenericDao<Direccio, Integer> implements IDireccioDao{

	public boolean setProveidor(Direccio a, Proveidors p) {
		Session session = sessionFactory.getCurrentSession();
		a.setProveidor(p);
		p.setAddress(a);
		try {
			session.beginTransaction();
			session.saveOrUpdate(a);
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

	public boolean setClient(Direccio a, Clients c) {
		Session session = sessionFactory.getCurrentSession();
		a.setClient(c);
		c.setAdreca(a);
		try {
			session.beginTransaction();
			session.saveOrUpdate(a);
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
