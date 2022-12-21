package com.miniprojet.vehicule.restcontrolleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniprojet.vehicule.entities.Categorie;
import com.miniprojet.vehicule.service.ICategorieService;

@RestController
@RequestMapping("/restapicategorie")
public class categorieapi {

	@Autowired ICategorieService cs;
	
	
	@RequestMapping("/all")
	public List<Categorie> getAllCategorie(){
		return cs.getAllCategorie();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delevetement(@PathVariable("id") int id) {
		cs.supprimerCategorie(id);
	}
}
