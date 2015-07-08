package com.bankonet.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

	@Entity

public class Personne implements Serializable{
	
	@Id @GeneratedValue
	private int id;
	private String nom;

	public Personne (){}
	
	public Personne (String nom){
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
}
