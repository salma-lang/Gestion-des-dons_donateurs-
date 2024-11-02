package com.salma.don_Donnateur.repositories;

import com.salma.don_Donnateur.entities.Donateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonateurRepository extends CrudRepository<Donateur, Long> {
}