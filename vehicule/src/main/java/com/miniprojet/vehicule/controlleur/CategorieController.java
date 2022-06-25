package com.miniprojet.vehicule.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miniprojet.vehicule.entities.Categorie;
import com.miniprojet.vehicule.repository.CategorieRepository;
import com.miniprojet.vehicule.service.ICategorieService;
import com.miniprojet.vehicule.service.VehiculeService;

@Controller
@RequestMapping("/apicategorie")
public class CategorieController {

	@Autowired ICategorieService sc;

	@Autowired CategorieRepository cr;

	@GetMapping(value={"/","/all"})
	public String getAllCategories(Model m) {
		List<Categorie> liste=sc.getAllCategorie();
		m.addAttribute("liste",liste);
		m.addAttribute("categories", cr.findAll());
		return "categories";
	}
	
	@GetMapping("/supprimercategorie/{id}")
	public String supprimerCategorie(@PathVariable int id) {
		sc.supprimerCategorie(id);
		return "redirect:/apicategorie/all";
	}
	
	@GetMapping("/ajoutercategorie")
	public String ajouterCategorie(Model m) {
		m.addAttribute("listeCat",sc.getAllCategorie());
		return "categories";
	}
	
	@GetMapping("/modifiercategorie/{idc}")
	public String modifierProduit(Model m, @PathVariable("idc") int id) {
		System.out.println(id);
		m.addAttribute("categorie",sc.getCategorie(id));
		m.addAttribute("listeCat",sc.getAllCategorie());
		return "categories";
	}
	
	@PostMapping("/ajoutercategorie")
	public String ajouter(Model m, Categorie c,
			@RequestParam("idc") String idc) {
		if(!idc.equals(""))
			c.setId(Integer.parseInt(idc));
		sc.ajouterCategorie(c);
		return "redirect:/apicategorie/all";
	}
}
