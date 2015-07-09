package com.bankonet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
/** 
 * Un employé de l'entreprise.
 */

@Entity
@NamedQuery(name = "findName",query="Select e.nom From Employe as e where upper(e.departement.nom) =:nomDept")

public class Employe extends Personne implements Serializable{
	
	
	private BigDecimal salaire;
	@ManyToOne
	private Employe superieur;
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	private Departement departement;
	@ManyToMany
	@JoinTable(name="EMP_PROJ",
				joinColumns={@JoinColumn(name="EMP_ID",referencedColumnName="ID")},
				inverseJoinColumns={@JoinColumn(name="PROJ_ID",referencedColumnName="ID")})
	private Collection<Projet> projets = new ArrayList<Projet>();
	
	  @OneToMany (mappedBy="employe", cascade=CascadeType.PERSIST)
	  private Collection<Participation> participations= new ArrayList<Participation>();

	

	public Employe(){}
	
	public Employe(String nom){
		super(nom);
	}
	
	public Employe(String nom,Departement departement,Employe superieur){
		super(nom);
		departement.addEmploye(this);
		this.superieur = superieur;
	}
	
	public Employe(String nom,BigDecimal salaire,Employe superieur,Departement departement){
		super();
		this.salaire = salaire;
		this.superieur = superieur;
		departement.addEmploye(this);
	}
	
	public BigDecimal getSalaire() {
		return salaire;
	}

	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}

	public Employe getSuperieur() {
		return superieur;
	}

	public void setSuperieur(Employe employe) {
		this.superieur = employe;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public Collection<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Collection<Projet> projets) {
		this.projets = projets;
	}
	
	public void addProjet(Projet p){
		projets.add(p);
	    p.getEmployes().add(this);
	}
	public void removeProjet(Projet p){
		p.getEmployes().remove(this);
		this.projets.remove(p);
	}
	public Collection<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(Collection<Participation> participations) {
		this.participations = participations;
	}
	
	public static List<String> listEmployes(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employes");
		 EntityManager em = emf.createEntityManager();
		Query query3 = em.createNamedQuery("findName");
		query3.setParameter("nomDept", "Direction");
		return query3.getResultList();
	}
}
