package com.miniprojet.vehicule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniprojet.vehicule.entities.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Integer>{

	
	List<Vehicule> findByMarqueContains(String mc);
}
