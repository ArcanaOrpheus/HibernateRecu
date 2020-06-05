package dao;

import java.util.List;
import database.Clients;
import database.ComandaClient;
import database.Producte;

public interface IComandaClientDao extends IGenericDao<ComandaClient,Integer>{
	
	void saveOrUpdate(ComandaClient p);

	ComandaClient get(Integer id);

	List<ComandaClient> list();

	void delete(Integer id);
	
	boolean setProducte(ComandaClient c, Producte p);
	
	boolean setClient(ComandaClient c, Clients cl);
}
