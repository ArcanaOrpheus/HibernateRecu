package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Comanda_Client")
public class ComandaClient implements Serializable{

	@Id
	@Column(name="id")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_peticio")
	Date data_peticio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_limit")
	Date data_limit;
	
	@Column(name="estat")
	Enum estat;
	
	@Column(name="ports")
	int ports;

	//relacio n a n amb producte
	@JoinTable(name="ProducteComanda", joinColumns={@JoinColumn(name="id_producte")}, inverseJoinColumns={@JoinColumn(name="id_comanda")})
	@ManyToMany(cascade=CascadeType.REFRESH)
	private Set<Producte> comandes = new HashSet<Producte>();

	//relacio n a 1 amb client
	@JoinColumn(name="comprador", nullable=false)
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Clients client;
	
	public ComandaClient(int id, Date data_peticio, Date data_limit, Enum estat, int ports, Set<Producte> comandes,
			Clients comprador) {
		super();
		this.id = id;
		this.data_peticio = data_peticio;
		this.data_limit = data_limit;
		this.estat = estat;
		this.ports = ports;
		this.comandes = comandes;
		this.client = comprador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData_peticio() {
		return data_peticio;
	}

	public void setData_peticio(Date data_peticio) {
		this.data_peticio = data_peticio;
	}

	public Date getData_limit() {
		return data_limit;
	}

	public void setData_limit(Date data_limit) {
		this.data_limit = data_limit;
	}

	public Enum getEstat() {
		return estat;
	}

	public void setEstat(Enum estat) {
		this.estat = estat;
	}

	public int getPorts() {
		return ports;
	}

	public void setPorts(int ports) {
		this.ports = ports;
	}

	public Set<Producte> getComandes() {
		return comandes;
	}

	public void setComandes(Set<Producte> comandes) {
		this.comandes = comandes;
	}

	public Clients getComprador() {
		return client;
	}

	public void setComprador(Clients comprador) {
		this.client = comprador;
	}
	
}