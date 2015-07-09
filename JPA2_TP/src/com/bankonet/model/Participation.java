package com.bankonet.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity 
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"IDP","IDE"}))
public class Participation implements Serializable {
	@Id @GeneratedValue
	  private int id;
	private String fonction;
	@ManyToOne 
	@JoinColumn(name="IDP")
	  private Projet projet;
	@ManyToOne
	@JoinColumn(name="IDE")
	  private Employe employe;
		

	public Participation(){}
	
	public Participation(String fonction,Projet projet,Employe employe){
		this.fonction = fonction;
	}
	
	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}
