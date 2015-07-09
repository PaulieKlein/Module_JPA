package com.bankonet.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/** 
 * Un employé de l'entreprise.
 */
@Entity
@DiscriminatorValue("E")
public class Employe extends Personne {
  private BigDecimal salaire;
  @ManyToOne
  private Employe superieur;
  @ManyToOne
  private Departement departement;
	
  public Employe() {
  }
	
  public Employe(String nom) {
    super(nom);
  }

  public Employe(String nom, Departement departement, Employe superieur) {
    super(nom);
    departement.addEmploye(this);
    this.superieur = superieur;
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
