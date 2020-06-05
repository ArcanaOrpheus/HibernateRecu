package dao;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

import database.Producte;



public class SaveUpdateEventListenerImp implements SaveOrUpdateEventListener {
   
   private static final long serialVersionUID = 1L;

   public void onSaveOrUpdate(SaveOrUpdateEvent e) throws HibernateException {

	  System.out.println("SOME SHIT HAPPENED");
      Object obj = e.getEntity();
      if (obj instanceof Producte) {
    	  Producte p = (Producte) obj;
    	  System.out.println("Hola Producto "+p.getNom_producte());
      }       

   }
}

