package com.bankonet.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity 

public class Projet  implements Serializable{
	@Id @GeneratedValue
  private int id;
  private String nom;
 @ManyToMany(mappedBy="projets")
private Collection<Employe> employes = new ArrayList<Employe>();
 
  @OneToMany (mappedBy="projet", cascade=CascadeType.PERSIST)
  private Collection<Participation> participations= new ArrayList<Participation>();

public Projet(){}
  
  public Projet(String nom){
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
  
 public Collection<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
  
	public Collection<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(Collection<Participation> participations) {
		this.participations = participations;
	}

	
 public void ajouterParticipant(Employe employe, String fonction){
	 Participation participation = new Participation(fonction,this,employe);
	 employe.getParticipations().add(participation);
	 this.getParticipations().add(participation);
  }
}
