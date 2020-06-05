package M6.Hibernate;


import org.hibernate.Session;
import M6.Hibernate.Core;

public class Main {

	static Session session;
	
	
    public static void main( String[] args )
    {
        //Database generator
        SchemaGenerator.execute();
        //session start
        session = Core.getNewSession();
        
    }
    
    
}
