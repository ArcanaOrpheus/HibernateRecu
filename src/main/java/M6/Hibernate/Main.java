package M6.Hibernate;


import org.hibernate.Session;
import M6.Hibernate.Core;

public class Main {

	static Session session;
	
	
    public static void main( String[] args )
    {
        /*Database generator: run only first time for saving time, can be run any number of times tho
        SchemaGenerator.execute();*/
        //session start
        session = Core.getNewSession();
        App.DaoTest();
    }
    
    
}
