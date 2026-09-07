package it.biglietteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.biglietteria.entity.Teatro;

@Repository
public interface TeatroRepository extends JpaRepository<Teatro, String> {

}
