package com.salma.don_Donnateur.repositories;

import com.salma.don_Donnateur.entities.Campagne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampagneRepository extends CrudRepository<Campagne, Long> {
}