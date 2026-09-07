package it.biglietteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.biglietteria.entity.Spettacolo;

@Repository
public interface SpettacoloRepository extends JpaRepository<Spettacolo,String> {

}
