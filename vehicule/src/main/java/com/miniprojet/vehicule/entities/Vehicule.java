package com.miniprojet.vehicule.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marque;
	
	@Max(value=4)
	private int annee;
	
	@NotEmpty
	
	private double matricule;
	private String image;
	
	
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@ManyToOne
	private Categorie categorie;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@NotNull
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	@NotNull
	@Max(value=4)
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	@NotNull
	@Max(value=7)
	public double getMatricule() {
		return matricule;
	}
	public void setMatricule(double matricule) {
		this.matricule = matricule;
	}
	public Vehicule(Integer id, String marque, int annee, double matricule) {
		super();
		this.id = id;
		this.marque = marque;
		this.annee = annee;
		this.matricule = matricule;
	}
	public Vehicule() {
		super();
	}
	public Vehicule(Integer id, String marque, int annee, double matricule, Categorie categorie) {
		super();
		this.id = id;
		this.marque = marque;
		this.annee = annee;
		this.matricule = matricule;
		this.categorie = categorie;
	}
	

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Vehicule(Integer id, String marque, int annee, double matricule, String image, Categorie categorie) {
		super();
		this.id = id;
		this.marque = marque;
		this.annee = annee;
		this.matricule = matricule;
		this.image = image;
		this.categorie = categorie;
	}
}
