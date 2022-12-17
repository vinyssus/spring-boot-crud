package com.miniprojet.vehicule.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniprojet.vehicule.entities.Vehicule;
import com.miniprojet.vehicule.repository.VehiculeRepository;

@Service
public class VehiculeService implements IVehiculeService{

	@Autowired VehiculeRepository vr;

	@Override
	public void supprimerVehicule(int id)throws IOException {
		// TODO Auto-generated method stub
		if(!vr.getById(id).getImage().equals("")) {
			supprimerImage(id);
		}
		vr.deleteById(id);
	}

	@Override
	public void modifierVehicule(Vehicule v) {
		// TODO Auto-generated method stub
		vr.save(v);
	}

	@Override
	public List<Vehicule> getAllVehicule() {
		// TODO Auto-generated method stub
		return vr.findAll();
	}

	@Override
	public List<Vehicule> getVehiculeByMc(String mc) {
		// TODO Auto-generated method stub
		return vr.findByMarqueContains(mc);
	}

	@Override
	public Vehicule getVehicule(int id) {
		// TODO Auto-generated method stub
		return vr.findById(id).get();
	}


	@Override
	public void ajouterVehicule(String v, MultipartFile mf) throws IOException {
		// TODO Auto-generated method stub
            Vehicule ve=new ObjectMapper().readValue(v, 
				Vehicule.class);

		String image;
		if(!mf.getOriginalFilename().equals("")) {
			image = saveImage(mf);
			ve.setImage(image);
		}
		vr.save(ve);
	}

	@Override
	public String saveImage(MultipartFile mf) throws IOException {
		String nameFile = mf.getOriginalFilename();
		String tab[] = nameFile.split("\\.");
		String fileModif = tab[0] + "_" + System.currentTimeMillis() + "." + tab[1];
		String chemin = System.getProperty("user.dir") + "/src/main/webapp/images/";
		//String chemin = System.getProperty("user.home") + "/imagesSpring/";
		Path p = Paths.get(chemin,fileModif);
		Files.write(p, mf.getBytes());
		return fileModif;
	}
	

	@Override
	public void supprimerImage(Integer IdVehicule) throws IOException {
		// TODO Auto-generated method stub
		Vehicule vehicule = vr.getById(IdVehicule);
		String chemin =  System.getProperty("user.dir") + "/src/main/webapp/images/";
		Path p = Paths.get(chemin,vehicule.getImage());
		Files.delete(p);
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		String image=vr.findById(id).get().getImage();
		String chemin = System.getProperty("user.dir") + "/src/main/webapp/images/";
		//String chemin = System.getProperty("user.home") + "/imagesSpring/";
		Path p = Paths.get(chemin,image);
		return Files.readAllBytes(p);
	}

	@Override
	public void ajouterVehicules(Vehicule v, MultipartFile mf) throws IOException {
		String image;
		if(!mf.getOriginalFilename().equals("")) {
			image = saveImage(mf);
			v.setImage(image);
		}
		vr.save(v);
		
	}
}
