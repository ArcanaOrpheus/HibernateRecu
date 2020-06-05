package database;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Proveidors")
public class Proveidors implements Serializable{

	@Id
	@Column(name = "idProveidor")
	protected int idProveidor;
	
	@Column(name="CIFF")
	private int CIFF;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="telefon")
	String telefon;
	
	@Column(name="personaContacte")
	String personaContacte;
	
	@Column(name="status")
	Enum status;
	
	@Column(name="tipus")
	Enum tipus;
	
	//relacio 1 a 1 amb address
	@JoinColumn(name = "address", nullable = false)
	@OneToOne(cascade = CascadeType.PERSIST)
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

	
	
	public Proveidors(int idProveidor, int cIFF, String nom, String telefon, String personaContacte, Enum status,
			Enum tipus, Direccio address, Set<PeticionsProveidor> peticionsProvedor) {
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

	public int getCIFF() {
		return CIFF;
	}

	public void setCIFF(int cIFF) {
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

	public Enum getStatus() {
		return status;
	}

	public void setStatus(Enum status) {
		this.status = status;
	}

	public Enum getTipus() {
		return tipus;
	}

	public void setTipus(Enum tipus) {
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
