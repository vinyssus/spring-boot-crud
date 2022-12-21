package com.miniprojet.vehicule.service;

import java.util.List;

import com.miniprojet.vehicule.entities.Categorie;
import com.miniprojet.vehicule.entities.Vehicule;


public interface ICategorieService {

	public void ajouterCategorie(Categorie c);
	public List<Categorie> getAllCategorie();
	public void supprimerCategorie(int id);
	public Categorie getCategorie(int id);
	public List<Vehicule> getVehiculeByCategorie(int idc);
	
}
