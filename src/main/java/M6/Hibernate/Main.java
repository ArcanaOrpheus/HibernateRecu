package M6.Hibernate;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import Enums.ComandaEstat;
import Enums.ProveidorTipus;
import Enums.Stat;
import Enums.Tipus;
import Enums.UnitatMesura;
import M6.Hibernate.Core;
import dao.ClientDao;
import dao.ComandaClientDao;
import dao.DireccioDao;
import dao.LotDao;
import dao.ProducteDao;
import dao.ProveidorDao;
import database.Clients;
import database.ComandaClient;
import database.Direccio;
import database.Lot;
import database.PeticionsProveidor;
import database.Producte;
import database.Proveidors;

public class Main {

	static Session session;
	
	
    public static void main( String[] args )
    {
        /*Database generator: run only first time for saving time, can be run any number of times tho
        SchemaGenerator.execute();*/
        //session start
        session = Core.getNewSession();
        generator();
        App.DaoTest();
    }
    
   static void generator() {
	   
	   //Generate several products
		Producte p = new Producte(724, "Dani", 10,1, UnitatMesura.UNITAT, Tipus.VENDIBLE, 10.0);
		Producte p2 = new Producte(725, "Recuperacio", 10,1, UnitatMesura.UNITAT, Tipus.VENDIBLE, 10.0);
		Producte p3 = new Producte(726, "Tastat blau", 10,1, UnitatMesura.UNITAT, Tipus.VENDIBLE, 10.0);
		//Generate address
		Direccio d = new Direccio(1,2,"street","town",1234,"country");
		
		//Generate Proveidors
		Set<PeticionsProveidor> sp = new HashSet<PeticionsProveidor>();
		Proveidors prov = new Proveidors(3,"CIFF","muñecopaja","phone","dummy",Stat.ACTIU,ProveidorTipus.AUTONOM,d,sp);
		//Generate Clients
		Set<ComandaClient> sc= new HashSet<ComandaClient>();
		Clients cl= new Clients("Test1", "Test1", true, sc, d);
		
		//Marc is right, i'm dumb
		DireccioDao dd = new DireccioDao();
		dd.saveOrUpdate(d);
		
		//Save products
		ProducteDao pd = new ProducteDao();
		pd.saveOrUpdate(p);
		pd.saveOrUpdate(p2);
		pd.saveOrUpdate(p3);
		
		/*Save address
		dd.setClient(d, cl);
		dd.setProveidor(d, prov);*/
		
		//Save proveidors
		ProveidorDao prd= new ProveidorDao();
		prd.saveOrUpdate(prov);
		//Save clients 
		ClientDao cld = new ClientDao();
		cld.saveOrUpdate(cl);
				
   }
   
   
     
}
