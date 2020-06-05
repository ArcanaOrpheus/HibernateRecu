package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import database.Lot;
import database.Producte;

public class LotDao extends GenericDao<Lot,Integer> implements ILotDao{

	
	public boolean setProducte(Lot l, Producte p) {
		Session session = sessionFactory.getCurrentSession();
		l.setProducte(p);
		p.getLotes().add(l);
		try {
			session.beginTransaction();
			session.saveOrUpdate(p);
			session.saveOrUpdate(l);
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

