package dao;

import java.io.Serializable;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class LoggingInterceptor extends EmptyInterceptor {

		private static final long serialVersionUID = 1L;
		
		
		@Override
		public boolean onSave(Object entity, Serializable id, Object[] state,
		        String[] propertyNames, Type[] types) {
		 System.out.println("onSave method is called.");
		  return super.onSave(entity, id, state, propertyNames, types);
		  
		}
		
		@Override
		public boolean onLoad(Object entity, Serializable id, Object[] state,
		        String[] propertyNames, Type[] types) {
		 System.out.println("onLoad method is called.");
		 System.out.println(id);
		  return super.onLoad(entity, id, state, propertyNames, types);
		  
		}
		
		
		
		
		@Override
		public String onPrepareStatement(String sql) {
		  //logger.info(sql);
		  return super.onPrepareStatement(sql);
		}
}
