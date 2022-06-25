package com.miniprojet.vehicule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.miniprojet.vehicule.repository.CategorieRepository;
import com.miniprojet.vehicule.service.VehiculeService;

@SpringBootApplication
public class VehiculeApplication implements CommandLineRunner {
	
	@Autowired VehiculeService vs;
	@Autowired CategorieRepository cr;


	public static void main(String[] args) {
		SpringApplication.run(VehiculeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Categorie c1 = new Categorie(1,"camion");
//		Categorie c2 = new Categorie(2,"moto");
//		cr.save(c1);
//		cr.save(c2);
//		vs.ajouterVehicule(new Vehicule(1,"ferari",2020,02555455,c1));
//		vs.ajouterVehicule(new Vehicule(2,"ferari",2020,02555455,c2));
//		
	}

}

