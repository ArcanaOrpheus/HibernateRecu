package database;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Clients")
public class Clients implements Serializable{

	@Id
	@Column(name="NIF")
	private String NIF;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="status")
	boolean status;

	/*/relacio 1 a n amb comanda*/
	@OneToMany(mappedBy="comprador")
	Set<ComandaClient> comandes = new HashSet<ComandaClient>();

	/*/relacio 1 a 1 amb adreça*/
	@JoinColumn(name="Direccio", nullable=false)
	@OneToOne(cascade = CascadeType.ALL)
	private Direccio adreca;
		
	public Clients(String nIF, String nom, boolean status, Set<ComandaClient> comandes, Direccio adreca) {
		super();
		NIF = nIF;
		this.nom = nom;
		this.status = status;
		this.comandes = comandes;
		this.adreca = adreca;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<ComandaClient> getComandes() {
		return comandes;
	}

	public void setComandes(Set<ComandaClient> comandes) {
		this.comandes = comandes;
	}

	public Direccio getAdreca() {
		return adreca;
	}

	public void setAdreca(Direccio adreca) {
		this.adreca = adreca;
	}
	
	
	
}
