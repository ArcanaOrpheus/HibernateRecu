package dao;

import java.util.List;
import database.ComandaClient;
import database.Lot;
import database.PeticionsProveidor;
import database.Producte;

public interface IProducteDao extends IGenericDao<Producte,Integer>{

	void saveOrUpdate(Producte p);

	Producte get(Integer id);

	List<Producte> list();

	void delete(Integer id);
	
	boolean setLot(Producte p, Lot l);
	
	boolean setIngredient(Producte p, Producte p2);
	
	boolean setPeticio(Producte p, PeticionsProveidor pp);
	
	boolean setComanda(Producte p, ComandaClient c);
}
