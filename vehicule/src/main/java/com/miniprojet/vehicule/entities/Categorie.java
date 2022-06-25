package com.miniprojet.vehicule.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	
	//@OneToMany (mappedBy = "categorie",fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
		@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
		@JsonProperty(access = Access.WRITE_ONLY)
	List<Vehicule> liste = new ArrayList<>();
    		
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Vehicule> getListe() {
		return liste;
	}
	public void setListe(List<Vehicule> liste) {
		this.liste = liste;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Categorie() {
		super();
	}
	
	public int getListeLength() {
		if(!this.liste.isEmpty()) {
			return liste.size();
		}
		return 0;
		
	}
	public Categorie(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
}
