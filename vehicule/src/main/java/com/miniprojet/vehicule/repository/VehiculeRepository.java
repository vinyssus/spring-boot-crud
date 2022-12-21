package com.miniprojet.vehicule.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miniprojet.vehicule.entities.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Integer>{

	@Query(value="select v from Vehicule v where v.marque like %:mc%")
	public List<Vehicule> findByMarqueContains(@Param("mc") String mc);
	//List<Vehicule> findByMarqueContains(String mc);
}
