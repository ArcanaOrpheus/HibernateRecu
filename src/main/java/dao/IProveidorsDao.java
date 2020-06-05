package dao;

import java.util.List;
import database.Direccio;
import database.PeticionsProveidor;
import database.Proveidors;

public interface IProveidorsDao extends IGenericDao<Proveidors,Integer>{

	void saveOrUpdate(Proveidors p);

	Proveidors get(Integer id);

	List<Proveidors> list();

	void delete(Integer id);
	
	boolean setAddress(Proveidors p, Direccio a);
	
	boolean setPeticio(Proveidors p, PeticionsProveidor pp);
	
}
