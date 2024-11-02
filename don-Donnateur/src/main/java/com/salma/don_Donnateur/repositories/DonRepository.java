package com.salma.don_Donnateur.repositories;

import com.salma.don_Donnateur.entities.Don;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonRepository extends CrudRepository<Don, Long> {
}