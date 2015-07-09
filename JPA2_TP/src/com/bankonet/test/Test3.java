package com.bankonet.test;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bankonet.model.Adresse;
import com.bankonet.model.Client;
import com.bankonet.model.Departement;
import com.bankonet.model.Employe;



public class Test3 implements Serializable {
	
	
	

	public static void main(String[] args) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employes");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = null;
	    
	      em = emf.createEntityManager();
	      //Query 1
	      String texteQuery1 = "Select e From Employe as e where upper(e.departement.nom) =:nomDept";
	      Query query1 = em.createQuery(texteQuery1);
	      query1.setParameter("nomDept", "Direction");
	      List<Employe> listeEmployes = (List<Employe>) query1.getResultList();
	     
	      for(Employe employe :listeEmployes){
	      System.out.println("Query 1 : Employés du département Direction = "+employe.getNom());
	      }
	    
	      //Query 2
	      
	      String texteQuery2 = "Select e.nom, e.salaire From Employe as e where upper(e.departement.nom) =:nomDept";
	      Query query2 = em.createQuery(texteQuery2);
	      query2.setParameter("nomDept", "Direction");
	      List <Object[]> liste = (List <Object[]>) query2.getResultList();
	      
	      for(Object[] info : liste){
	      System.out.println("Query 2 : Employés du département Direction = "+ info[0] +" gagne "+info[1]);
	      }
	      //Query 3
	 
	
	      for(String info : (List<String>)Employe.listEmployes()){
		      System.out.println("Query 3 : Employés du département Direction = "+ info);
		      }
	      
	      //Query 4
	     tx.begin();
	     for (Employe employe : listeEmployes){
	    	 employe.getSalaire();
	     } 
	     tx.commit();
	     Employe emp = new Employe();
	     em.refresh(emp);
	      for(Employe employe :listeEmployes){
	    	  
	      System.out.println("Query 4 : Employés du département Direction = "+employe.getNom()+" gagne "+employe.getSalaire());
	      
	      }
	      
	      em.close();
	      emf.close();
	      
	      
	}

}
