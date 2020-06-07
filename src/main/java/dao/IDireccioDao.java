package dao;
import java.util.List;

import database.Direccio;
import database.Clients;
import database.Proveidors;


public interface IDireccioDao extends IGenericDao<Direccio, Integer>{

	void saveOrUpdate(Direccio a);

	Direccio get(Integer id);

	List<Direccio> list();

	void delete(Integer id);
	
}