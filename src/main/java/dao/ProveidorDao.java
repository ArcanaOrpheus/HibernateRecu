package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import database.Direccio;
import database.PeticionsProveidor;
import database.Proveidors;

public class ProveidorDao extends GenericDao<Proveidors,Integer> implements IProveidorsDao{

	public boolean setAddress(Proveidors p, Direccio a) {
		Session session = sessionFactory.getCurrentSession();
		p.setAddress(a);
		try {
			session.beginTransaction();
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

	public boolean setPeticio(Proveidors p, PeticionsProveidor pp) {
		Session session = sessionFactory.getCurrentSession();
		p.getPeticionsProvedor().add(pp);
		pp.setProveidor(p);
		try {
			session.beginTransaction();
			session.saveOrUpdate(pp);
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

}
