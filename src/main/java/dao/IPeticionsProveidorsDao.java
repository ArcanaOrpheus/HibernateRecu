package dao;

import java.util.List;
import database.PeticionsProveidor;
import database.Producte;
import database.Proveidors;

public interface IPeticionsProveidorsDao extends IGenericDao<PeticionsProveidor, Integer>{

	void saveOrUpdate(PeticionsProveidor a);

	PeticionsProveidor get(Integer id);

	List<PeticionsProveidor> list();

	void delete(Integer id);
	
	boolean setProveidor(PeticionsProveidor pp, Proveidors p);
	
	boolean setProducte(PeticionsProveidor pp, Producte p);
}