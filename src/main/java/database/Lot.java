package database;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Lot")
public class Lot implements Serializable{
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="stock")
	int stock;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_entrada")
	Date data_entrada;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_caducitat")
	Date data_caducitat;
	
	//relacio n a 1 amb producte
	@ManyToOne
	@JoinColumn(name = "producte")
	private Producte producte;

	//Generador id unico
	public int hashCode() {
		final int prime = 31;
		// cada clase debe tener un result distinto
		int result = 12334;
		result = prime * result + id;
		return result;
	}
	
	public Lot(int id, int stock, Date data_entrada, Date data_caducitat, Producte producte) {
		super();
		this.id = hashCode();
		this.stock = stock;
		this.data_entrada = data_entrada;
		this.data_caducitat = data_caducitat;
		this.producte = producte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public Date getData_caducitat() {
		return data_caducitat;
	}

	public void setData_caducitat(Date data_caducitat) {
		this.data_caducitat = data_caducitat;
	}

	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}
		
}
