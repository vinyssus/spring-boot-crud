package com.miniprojet.vehicule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniprojet.vehicule.entities.Categorie;
import com.miniprojet.vehicule.entities.Vehicule;
import com.miniprojet.vehicule.repository.CategorieRepository;

@Service
public class CategorieService implements ICategorieService{
	
	@Autowired CategorieRepository cr;

	@Override
	public void ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		cr.save(c);
	}

	@Override
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public void supprimerCategorie(int id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}

	@Override
	public Categorie getCategorie(int id) {
		// TODO Auto-generated method stub
		return cr.findById(id).get();
	}

	@Override
	public List<Vehicule> getVehiculeByCategorie(int idc) {
		// TODO Auto-generated method stub
		return cr.getById(idc).getListe();
	}



}
