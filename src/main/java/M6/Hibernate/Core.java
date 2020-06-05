package M6.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Core {
		private static ServiceRegistry serviceRegistry;
		private static SessionFactory sessionFactory;
		
		private static SessionFactory getSessionFactory()
		{
			if(sessionFactory == null)
			{
				sessionFactory = buildSessionFactory();
			}
			return sessionFactory;
		}
		
		public static Session getNewSession()
		{
			return getSessionFactory().openSession();
		}

		
		public static synchronized SessionFactory buildSessionFactory() {
		    if ( sessionFactory == null ) {

		        serviceRegistry = new StandardServiceRegistryBuilder()
		                .configure("hibernate.cfg.xml")
		                .build();

		        sessionFactory = new MetadataSources( serviceRegistry )
		                    .buildMetadata()
		                    .buildSessionFactory();
		    }
		    return sessionFactory;
		}
	}
