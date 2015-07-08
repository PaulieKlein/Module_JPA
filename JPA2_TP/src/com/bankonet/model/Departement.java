 package com.bankonet.model;

import java.util.ArrayList;
import java.util.Collection;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="Departement")

public class Departement implements Serializable {

@Id @GeneratedValue
  private int id;
@Column(name= "NOM", length =25,nullable =false,unique=true)
  private String nom;
@Column(name= "LIEU",nullable =false)
  private String lieu;
@OneToMany(mappedBy ="departement")
 private Collection<Employe> employes = new ArrayList<Employe>();

  /**
   * Retourne l'identificateur géré par le SGBD. Identifie une ligne
   * de la base.
   */
public Departement(){}

public Departement(String nom,String lieu){
	this.nom = nom;
	this.lieu = lieu;
}

  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getLieu() {
    return lieu;
  }

  public void setLieu(String lieu) {
    this.lieu = lieu;
  }

public Collection<Employe> getEmployes() {
    return employes;
  }

  /**
   * Méthode utilitaire souvent employée pour les associations
   * bidirectionnelles pour éviter d'oublier de mettre à jour
   * un des bouts de l'assocation.
   * @param employe
   */
 public void addEmploye(Employe employe) {
    // Si l'employé est déjà dans un département, il faut l'enlever de
    // ce département dans la liste des employés de ce département
    Departement ancienDept;
    if ((ancienDept = employe.getDepartement()) != null) {
      ancienDept.employes.remove(employe);
    }
    employes.add(employe);
    employe.setDepartement(this);
  }

}
