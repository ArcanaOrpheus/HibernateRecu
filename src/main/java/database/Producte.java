package database;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

import Enums.Tipus;
import Enums.UnitatMesura;

@Entity
@Table(name="Producte")
public class Producte implements Serializable{

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nom_producte")
	String nom_producte;
	
	@Column(name="descripcio_producte")
	String descripcio_producte;
	
	@Column(name="preu")
	double preu;
	
	@Column(name="stock")
	int stock;
	
	@Column(name="stock_minim")
	int stock_minim;
	
	@Column(name="tipus_producte")
	Tipus tipus_producte;
	
	@Column(name="unitat_mesura")
	UnitatMesura unitat_mesura;

	//relacio 1 a n amb lot
	@OneToMany(mappedBy="producte")
	private Set<Lot> lotes = new HashSet<Lot>();
	
	//relacio n a n amb ell mateix
	@JoinTable(name="composicio", joinColumns={@JoinColumn(name="codiProducte")})
	@ManyToMany(cascade=CascadeType.REFRESH)
	private Set<Producte> composicio = new HashSet<Producte>();

	//relacio 1 a n amb peticionsproveidor
	@OneToMany(mappedBy="proveidor")
	private Set<PeticionsProveidor> peticioProveidor = new HashSet<PeticionsProveidor>();

	//relacio n a n amb comanda
	@JoinTable(name="ProducteComanda", joinColumns= {@JoinColumn(name="id_Producte")}, inverseJoinColumns= {@JoinColumn(name="id_comanda")})
	@ManyToMany(cascade=CascadeType.REFRESH)
	private Set<Producte> producteComanda = new HashSet<Producte>();

	
	
	public Producte(int id, String nom_producte, String descripcio_producte, double preu, int stock, int stock_minim,
			Tipus tipus_producte, UnitatMesura unitat_mesura, Set<Lot> lotes, Set<Producte> composicio,
			Set<PeticionsProveidor> peticioProveidor, Set<Producte> producteComanda) {
		
		this.id = id;
		this.nom_producte = nom_producte;
		this.descripcio_producte = descripcio_producte;
		this.preu = preu;
		this.stock = stock;
		this.stock_minim = stock_minim;
		this.tipus_producte = tipus_producte;
		this.unitat_mesura = unitat_mesura;
		this.lotes = lotes;
		this.composicio = composicio;
		this.peticioProveidor = peticioProveidor;
		this.producteComanda = producteComanda;
	}
	
	// Another necessary generator for this class
	public Producte(int id, String nomProducte, int stock, int stockMin, UnitatMesura unitat, Tipus vendible, double preuVenda) {
		this.id=id;
		nom_producte = nomProducte;
		this.stock=stock;
		stock_minim=stockMin;
		this.unitat_mesura=unitat;
		this.tipus_producte=vendible;
		preu=preuVenda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_producte() {
		return nom_producte;
	}

	public void setNom_producte(String nom_producte) {
		this.nom_producte = nom_producte;
	}

	public String getDescripcio_producte() {
		return descripcio_producte;
	}

	public void setDescripcio_producte(String descripcio_producte) {
		this.descripcio_producte = descripcio_producte;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock_minim() {
		return stock_minim;
	}

	public void setStock_minim(int stock_minim) {
		this.stock_minim = stock_minim;
	}

	public Tipus getTipus_producte() {
		return tipus_producte;
	}

	public void setTipus_producte(Tipus tipus_producte) {
		this.tipus_producte = tipus_producte;
	}

	public UnitatMesura getUnitat_mesura() {
		return unitat_mesura;
	}

	public void setUnitat_mesura(UnitatMesura unitat_mesura) {
		this.unitat_mesura = unitat_mesura;
	}

	public Set<Lot> getLotes() {
		return lotes;
	}

	public void setLotes(Set<Lot> lotes) {
		this.lotes = lotes;
	}

	public Set<Producte> getComposicio() {
		return composicio;
	}

	public void setComposicio(Set<Producte> composicio) {
		this.composicio = composicio;
	}

	public Set<PeticionsProveidor> getPeticioProveidor() {
		return peticioProveidor;
	}

	public void setPeticioProveidor(Set<PeticionsProveidor> peticioProveidor) {
		this.peticioProveidor = peticioProveidor;
	}

	public Set<Producte> getProducteComanda() {
		return producteComanda;
	}

	public void setProducteComanda(Set<Producte> producteComanda) {
		this.producteComanda = producteComanda;
	}
	
	
	
}
