package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import database.PeticionsProveidor;
import database.Producte;
import database.Proveidors;

public class PeticionsProveidorsDao extends GenericDao<PeticionsProveidor, Integer> implements IPeticionsProveidorsDao{

	public boolean setProveidor(PeticionsProveidor pp, Proveidors p) {
		Session session = sessionFactory.getCurrentSession();
		pp.setProveidor(p);
		p.getPeticionsProvedor().add(pp);
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

	public boolean setProducte(PeticionsProveidor pp, Producte p) {
		Session session = sessionFactory.getCurrentSession();
		pp.setProducte(p);
		p.getPeticioProveidor().add(pp);
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
