package com.miniprojet.vehicule.controlleur;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.miniprojet.vehicule.entities.Vehicule;
import com.miniprojet.vehicule.repository.CategorieRepository;
import com.miniprojet.vehicule.service.CategorieService;
import com.miniprojet.vehicule.service.VehiculeService;

@Controller
@RequestMapping("/apivehicule")
public class VehiculeController {

	@Autowired CategorieService cr;
	
	@Autowired CategorieRepository repo;
	
	@Autowired VehiculeService vr;
	
	@GetMapping("/all")
	public String getAllVehicule(Model m) {
		List<Vehicule> liste = vr.getAllVehicule();
		m.addAttribute("liste", liste);
		m.addAttribute("categories", repo.findAll());
		m.addAttribute("categorie", "Toutes les categories");
		return "vehicules";
		
	}
	
	@GetMapping("/vehiculemc")
	public String getVehiculeBMC(@RequestParam String mc,Model m) {
		List<Vehicule> liste = vr.getVehiculeByMc(mc);
		m.addAttribute("liste", liste);
		return "vehicules";
		
	}
	
	@GetMapping("/vehiculeParCategorie")
	public String getVehiculeByMc(@RequestParam("categorie") int idc,Model m) {
		m.addAttribute("categories", cr.getAllCategorie());
		if(idc == 0) {
			m.addAttribute("liste", vr.getAllVehicule());
			return "redirect:/apivehicule/all";
		}else {
			m.addAttribute("liste", cr.getVehiculeByCategorie(idc));
			m.addAttribute("categorie", repo.getById(idc).getNom());
			return "vehicules";
		}
		
		
	}
	
	@GetMapping("/supprimervehicule/{id}")
	public String supprimerVehicule(@PathVariable int id) throws IOException {
		vr.supprimerVehicule(id);
		return "redirect:/apivehicule/all";
	}
	
	@GetMapping("/ajoutervehicule")
	public String ajoutervehicule(Model m) {
		m.addAttribute("categories", cr.getAllCategorie());
		return "ajouterVehicule";
		
	}
	
	@PostMapping("/ajoutervehicule")
	public String ajouter(@ModelAttribute Vehicule v,@RequestParam("file") MultipartFile mf, Model m)throws IOException {
		Integer id=v.getId();
		vr.ajouterVehicule(v, mf);
		if(id!=null) {
			return "redirect:/apivehicule/all";
		}
		else
		{
			m.addAttribute("message","Ajout Avec Sucses");
			m.addAttribute("categories",cr.getAllCategorie());
			return "ajouterVehicule";
		}
	}
//	@PostMapping("/ajoutervehicule")
//	public String ajouter(Model m, Vehicule v, @RequestParam("categorie") int idc,@RequestParam("id") String idv) {
//		Categorie c = cr.getCategorie(idc);
//		v.setCategorie(c);
//		if(!idv.equals("")) {
//			v.setId(Integer.parseInt(idv));
//		}
//		vr.ajouterVehicule(v);
//		return "redirect:/apivehicule/all";
//	}

	@GetMapping("/modifiervehicule/{id}")
	public String modifierproduit(Model m, @PathVariable("id") int idv ) {
		m.addAttribute("categories", cr.getAllCategorie());
		m.addAttribute("vehicule", vr.getVehicule(idv));
		return "ajouterVehicule";
		
	}
}
