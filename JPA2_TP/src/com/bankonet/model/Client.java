package com.bankonet.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

@Entity 
public class Client extends Personne implements Serializable {

@Embedded
  private Adresse adresse;

  public Client(){}
  
  public Client(String nom, Adresse adresse){
	  super(nom);
	  this.adresse = adresse;
  }
  
  public Adresse getAdresse() {
    return adresse;
  }

  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }

}
