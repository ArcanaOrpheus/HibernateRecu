package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import Enums.ComandaEstat;

import javax.persistence.*;


@Entity
@Table(name="Comanda_Client")
public class ComandaClient implements Serializable{

	@Id
	@Column(name="id", nullable = false)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_peticio", nullable = false)
	Date data_peticio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_limit", nullable = false)
	Date data_limit;
	
	@Column(name="estat", nullable = false)
	ComandaEstat estat;
	
	@Column(name="ports")
	int ports;

	//relacio n a n amb producte
	@JoinTable(name="ProducteComanda", joinColumns={@JoinColumn(name="id_producte")}, inverseJoinColumns={@JoinColumn(name="id_comanda")})
	@ManyToMany(cascade=CascadeType.REFRESH)
	private Set<Producte> comandes = new HashSet<Producte>();

	//relacio n a 1 amb client
	@JoinColumn(name="comprador", nullable=false)
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Clients comprador;
	
	public ComandaClient(int id, Date data_peticio, Date data_limit, ComandaEstat estat, Set<Producte> comandes,
			Clients comprador) {
		super();
		this.id = id;
		this.data_peticio = data_peticio;
		this.data_limit = data_limit;
		this.estat = estat;
		this.comandes = comandes;
		this.comprador = comprador;
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

	public ComandaEstat getEstat() {
		return estat;
	}

	public void setEstat(ComandaEstat estat) {
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
		return comprador;
	}

	public void setComprador(Clients comprador) {
		this.comprador = comprador;
	}
	
}
