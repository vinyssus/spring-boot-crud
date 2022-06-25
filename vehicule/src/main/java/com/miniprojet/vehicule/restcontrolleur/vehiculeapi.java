package com.miniprojet.vehicule.restcontrolleur;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniprojet.vehicule.entities.Vehicule;
import com.miniprojet.vehicule.service.IVehiculeService;

@RestController
@RequestMapping("/restapivehicule")
public class vehiculeapi {

	@Autowired IVehiculeService vs;
	
	@RequestMapping("/all")
	public List<Vehicule> getAllVehicule(){
		return vs.getAllVehicule();
	}
	@GetMapping("/search/{mc}")
	public List<Vehicule> getVehiculeBMC(@PathVariable("mc") String mot){
		return vs.getVehiculeByMc(mot);
	}
	
	@GetMapping(path="/getimage/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable("id")int id) throws IOException {
		return vs.getImage(id);
		
	}
	
//	@PostMapping("save")
//	public void ajoutervehicule(@RequestParam("vehicule")String v,@RequestParam("file")MultipartFile m) throws IOException{
//	  // Vehicule v = new ObjectMapper().readValue(v, Vehicule.class);
//		Vehicule v = new ObjectMapper().readValue(v, Vehicule.class);
//	   vs.ajouterVehicule(v,m);
//	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteVehicule(@PathVariable("id") int id) throws IOException{
		vs.supprimerVehicule(id);
	}
	
//	@PutMapping("/update")
//	public void updateVehicule(@RequestParam("vehicule")String v,@RequestParam("file")MultipartFile m) {
//		ajoutervehicule(v, m);
//	}
}
