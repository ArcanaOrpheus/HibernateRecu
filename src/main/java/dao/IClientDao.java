package dao;
import java.util.List;

import database.Direccio;
import database.Clients;
import database.ComandaClient;


public interface IClientDao extends IGenericDao<Clients,Integer>{

	void saveOrUpdate(Clients p);

	Clients get(Integer id);

	List<Clients> list();

	void delete(Integer id);
	
	boolean setComanda(Clients c, ComandaClient co);
	
	boolean setAddress(Clients c, Direccio a);
	
	
}