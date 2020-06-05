package dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import database.ComandaClient;
import database.Lot;
import database.PeticionsProveidor;
import database.Producte;

public class ProducteDao extends GenericDao<Producte,Integer> implements IProducteDao{


	public boolean setLot(Producte p, Lot l) {
		Session session = sessionFactory.getCurrentSession();
		p.getLotes().add(l);
		l.setProducte(p);
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

	public boolean setIngredient(Producte p, Producte p2) {
		Session session = sessionFactory.getCurrentSession();
		p.getComposicio().add(p2);
		p2.getComposicio().add(p);
		try {
			session.beginTransaction();
			session.saveOrUpdate(p);
			session.saveOrUpdate(p2);
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

	public boolean setPeticio(Producte p, PeticionsProveidor pp) {
		Session session = sessionFactory.getCurrentSession();
		p.getPeticioProveidor().add(pp);
		pp.setProducte(p);
		try {
			session.beginTransaction();
			session.saveOrUpdate(p);
			session.saveOrUpdate(pp);
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

	public boolean setComanda(Producte p, ComandaClient c) {
		Session session = sessionFactory.getCurrentSession();
		p.getProducteComanda().add(p); 
		c.getComandes().add(p);
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

}
