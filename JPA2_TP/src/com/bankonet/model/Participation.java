package com.bankonet.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

@Entity 

public class Participation implements Serializable {
	@Id @GeneratedValue
	  private int id;
	@ManyToOne
	private Employe employe;
	private String fonction;
	
	public Participation(){}
	public Participation(Employe employe,String fonction){
		this.employe = employe;
		this.fonction = fonction;
	}
	
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	

}
