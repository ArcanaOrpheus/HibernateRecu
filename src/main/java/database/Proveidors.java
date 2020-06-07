package database;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import Enums.ProveidorTipus;
import Enums.Stat;


@Entity
@Table(name="Proveidors")
public class Proveidors implements Serializable{

	@Id
	@Column(name = "idProveidor")
	protected int idProveidor;
	
	@Column(name="CIFF")
	private String CIFF;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="telefon")
	String telefon;
	
	@Column(name="personaContacte")
	String personaContacte;
	
	@Column(name="status")
	Stat status;
	
	@Column(name="tipus")
	ProveidorTipus tipus;
	
	//relacio 1 a 1 amb address
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address", nullable = false)
	private Direccio address;

	//relacio 1 a n amb peticioproveidor
	@OneToMany(mappedBy = "proveidor")
	Set<PeticionsProveidor> peticionsProvedor = new HashSet<PeticionsProveidor>();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		// cada clase debe tener un id unico
		int result = 1432;
		result = prime * result + idProveidor;
		return result;
	}

	
	
	public Proveidors(int idProveidor, String cIFF, String nom, String telefon, String personaContacte, Stat status,
			ProveidorTipus tipus, Direccio address, Set<PeticionsProveidor> peticionsProvedor) {
		super();
		this.idProveidor = idProveidor;
		CIFF = cIFF;
		this.nom = nom;
		this.telefon = telefon;
		this.personaContacte = personaContacte;
		this.status = status;
		this.tipus = tipus;
		this.address = address;
		this.peticionsProvedor = peticionsProvedor;
	}

	

	public int getIdProveidor() {
		return idProveidor;
	}

	public void setIdProveidor(int idProveidor) {
		this.idProveidor = idProveidor;
	}

	public String getCIFF() {
		return CIFF;
	}

	public void setCIFF(String cIFF) {
		CIFF = cIFF;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getPersonaContacte() {
		return personaContacte;
	}

	public void setPersonaContacte(String personaContacte) {
		this.personaContacte = personaContacte;
	}

	public Stat getStatus() {
		return status;
	}

	public void setStatus(Stat status) {
		this.status = status;
	}

	public ProveidorTipus getTipus() {
		return tipus;
	}

	public void setTipus(ProveidorTipus tipus) {
		this.tipus = tipus;
	}

	public Direccio getAddress() {
		return address;
	}

	public void setAddress(Direccio address) {
		this.address = address;
	}

	public Set<PeticionsProveidor> getPeticionsProvedor() {
		return peticionsProvedor;
	}

	public void setPeticionsProvedor(Set<PeticionsProveidor> peticionsProvedor) {
		this.peticionsProvedor = peticionsProvedor;
	}
	
	
	
}
