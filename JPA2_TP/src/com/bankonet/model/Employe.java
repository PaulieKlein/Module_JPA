package com.bankonet.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
/** 
 * Un employé de l'entreprise.
 */

@Entity

public class Employe extends Personne implements Serializable{
	
	
	private BigDecimal salaire;
	@ManyToOne
	private Employe superieur;
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	private Departement departement;

	public Employe(){}
	
	public Employe(String nom){
		super(nom);
	}
	
	public Employe(String nom,Departement departement,Employe superieur){
		super(nom);
		departement.addEmploye(this);
		this.superieur = superieur;
		
	}
	
	public Employe(String nom,BigDecimal salaire,Employe superieur,Departement departement){
		super();
		this.salaire = salaire;
		this.superieur = superieur;
		this.departement = departement;
		
	}
	
	public BigDecimal getSalaire() {
		return salaire;
	}

	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}

	public Employe getSuperieur() {
		return superieur;
	}

	public void setSuperieur(Employe employe) {
		this.superieur = employe;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
}
