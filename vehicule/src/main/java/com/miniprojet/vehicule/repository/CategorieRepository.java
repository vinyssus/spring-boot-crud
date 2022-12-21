package com.miniprojet.vehicule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniprojet.vehicule.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer>{

}
