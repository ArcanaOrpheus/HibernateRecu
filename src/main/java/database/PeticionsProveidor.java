package database;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="Peticions_Proveidor")
public class PeticionsProveidor {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="tipus_peticio")
	Enum tipus_peticio;
	
	@Column(name="quant_producte")
	int quant_producte;
	
	@Column(name="data_Ordre")
	Date data_ordre;
	
	@Column(name="data_Recepcio")
	Date data_recepcio;
	
	@Column(name="estat")
	Enum estat;
	
	//relacio n a 1 amb proveidor
	@ManyToOne
	@JoinColumn(name = "proveidor")
	private Proveidors proveidor;

	//relacio n a 1 amb producte
	@ManyToOne
	@JoinColumn(name = "producte")
	private Producte producte;

	public PeticionsProveidor(int id, Enum tipus_peticio, int quant_producte, Date data_ordre, Date data_recepcio,
			Enum estat, Proveidors proveidor, Producte producte) {
		super();
		this.id = id;
		this.tipus_peticio = tipus_peticio;
		this.quant_producte = quant_producte;
		this.data_ordre = data_ordre;
		this.data_recepcio = data_recepcio;
		this.estat = estat;
		this.proveidor = proveidor;
		this.producte = producte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Enum getTipus_peticio() {
		return tipus_peticio;
	}

	public void setTipus_peticio(Enum tipus_peticio) {
		this.tipus_peticio = tipus_peticio;
	}

	public int getQuant_producte() {
		return quant_producte;
	}

	public void setQuant_producte(int quant_producte) {
		this.quant_producte = quant_producte;
	}

	public Date getData_ordre() {
		return data_ordre;
	}

	public void setData_ordre(Date data_ordre) {
		this.data_ordre = data_ordre;
	}

	public Date getData_recepcio() {
		return data_recepcio;
	}

	public void setData_recepcio(Date data_recepcio) {
		this.data_recepcio = data_recepcio;
	}

	public Enum getEstat() {
		return estat;
	}

	public void setEstat(Enum estat) {
		this.estat = estat;
	}

	public Proveidors getProveidor() {
		return proveidor;
	}

	public void setProveidor(Proveidors proveidor) {
		this.proveidor = proveidor;
	}

	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}
	
	
	
}
