package it.biglietteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.biglietteria.entity.Replicha;

@Repository
public interface ReplichaRepository extends JpaRepository<Replicha, String> {

}
