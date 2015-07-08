package com.bankonet.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

@Embeddable

public class Adresse implements Serializable{

  private int numero;
  private String rue;
  private String ville;

  public Adresse(){}
  
  public Adresse(int numero, String rue,String ville){
	  this.numero = numero;
	  this.rue = rue;
	  this.ville = ville;
  }
  
  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getRue() {
    return rue;
  }

  public void setRue(String rue) {
    this.rue = rue;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

}
