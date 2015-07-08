package com.bankonet.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

@Entity 

public class Projet extends Participation implements Serializable{
	@Id @GeneratedValue
  private int id;
  private String nom;
  @OneToMany
  private Participation participation;
	
  public Projet(){}
  
  public Projet(int id,String nom){
	  this.id = id;
	  this.nom = nom;
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
  
  public void ajouterParticipant(Employe employe, String fonction){
	  participation = new Participation(employe,fonction);
  }
}
