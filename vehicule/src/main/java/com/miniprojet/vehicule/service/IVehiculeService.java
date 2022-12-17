package com.miniprojet.vehicule.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.miniprojet.vehicule.entities.Vehicule;

public interface IVehiculeService {

	public void ajouterVehicule(String v,MultipartFile mf)throws IOException;
	public void ajouterVehicules(Vehicule v,MultipartFile mf)throws IOException;
	public void supprimerVehicule(int id)throws IOException;
	public String saveImage(MultipartFile mf)throws IOException;
	public void supprimerImage(Integer IdVehicule)throws IOException;
	public void modifierVehicule(Vehicule v);
	public List<Vehicule> getAllVehicule();
	public List<Vehicule> getVehiculeByMc(String mc);
	public Vehicule getVehicule(int id);
	public byte[] getImage(int id)throws IOException;
}
