package M6.Hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import com.mysql.cj.Session;

import Enums.ComandaEstat;
import Enums.ProveidorTipus;
import Enums.Stat;
import Enums.Tipus;
import Enums.UnitatMesura;
import dao.LotDao;
import dao.ClientDao;
import dao.ComandaClientDao;
import dao.DireccioDao;
import database.Clients;
import database.ComandaClient;
import database.Direccio;
import database.Lot;
import database.PeticionsProveidor;
import database.Producte;
import database.Proveidors;

public class App 
{
	public static void main(String[] args) {
		initD();
		DaoTest();
	}
	static void initD() {
		
	}
	
	static void DaoTest() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		Producte p = new Producte(724, "Dani", 10,1, UnitatMesura.UNITAT, Tipus.VENDIBLE, 10.0);
		Lot l = new Lot(70, 1, date, date, p);
		LotDao ld = new LotDao();
		//Afegim el lot al producte
		ld.setProducte(l, p);
		ComandaClientDao cd = new ComandaClientDao();
		Set<ComandaClient> sp = new HashSet<ComandaClient>();
		//Direccio creada en el generator
		Direccio d = new Direccio(1,2,"street","town",1234,"country");
		Clients cl= new Clients("this", "that", true, sp, d);
		ComandaClient c = new ComandaClient(30,date,date,ComandaEstat.PENDENT,null,null);
		//Afegim la comanda
		cd.setClient(c, cl);
		cd.setProducte(c, p);
	}
	
}
