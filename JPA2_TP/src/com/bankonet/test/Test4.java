package com.bankonet.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bankonet.model.Adresse;
import com.bankonet.model.Client;
import com.bankonet.model.Departement;
import com.bankonet.model.Employe;

public class Test4 {
	 public static void main(String[] args) {
		    EntityManagerFactory emf = null;
		    EntityManager em = null;
			EntityTransaction tx = null;
		    try {
		      emf = Persistence.createEntityManagerFactory("Employes");
		      em = emf.createEntityManager();
		      tx = em.getTransaction();
		      tx.begin();
		      
		      tx.commit();
		    }
		    catch(Exception e) {
		      // En "vrai" il faudrait affiner un peu plus...
		      e.printStackTrace();
		      if (tx != null) {
		        tx.rollback();
		      }
		    }
		    finally {
		      if (em != null) {
		        em.close();
		      }
		      if (emf != null) {
		        emf.close();
		      }
		    }
		  }
}
