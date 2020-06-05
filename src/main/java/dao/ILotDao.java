package dao;

import java.util.List;
import database.Lot;
import database.Producte;

public interface ILotDao extends IGenericDao<Lot,Integer>{

	void saveOrUpdate(Lot p);

	Lot get(Integer id);

	List<Lot> list();

	void delete(Integer id);
	
	boolean setProducte(Lot l, Producte p);
	
	
}