package database;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Direccio")
public class Direccio implements Serializable{

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="bloc")
	int bloc;
	
	@Column(name="carrer")
	String carrer;
	
	@Column(name="poblacio")
	String poblacio;
	
	@Column(name="codi_postal")
	int codi_postal;
	
	@Column(name="pais")
	String pais;
	
	@Column(name="latitud")
	int latitud;
	
	@Column(name="longitud")
	int longitud;

	/*/relacio 1 a 1 amb partner*/
	@JoinColumn(name = "partner", nullable = false)
	@OneToOne(cascade = CascadeType.PERSIST)
	private Proveidors proveidor;
	
	/*/relacio 1 a 1 amb client*/
	@JoinColumn(name = "client", nullable = false)
	@OneToOne(cascade = CascadeType.PERSIST)
	private Clients client;
	
	public Direccio(int id, int bloc, String carrer, String poblacio, int codi_postal, String pais, int latitud,
			int longitud, Proveidors proveidor, Clients client) {
		super();
		this.id = id;
		this.bloc = bloc;
		this.carrer = carrer;
		this.poblacio = poblacio;
		this.codi_postal = codi_postal;
		this.pais = pais;
		this.latitud = latitud;
		this.longitud = longitud;
		this.proveidor = proveidor;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBloc() {
		return bloc;
	}

	public void setBloc(int bloc) {
		this.bloc = bloc;
	}

	public String getCarrer() {
		return carrer;
	}

	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public int getCodi_postal() {
		return codi_postal;
	}

	public void setCodi_postal(int codi_postal) {
		this.codi_postal = codi_postal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getLatitud() {
		return latitud;
	}

	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public Proveidors getProveidor() {
		return proveidor;
	}

	public void setProveidor(Proveidors proveidor) {
		this.proveidor = proveidor;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}
}
