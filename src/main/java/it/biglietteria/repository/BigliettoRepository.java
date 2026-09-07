package it.biglietteria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import it.biglietteria.entity.Biglietto;

@Repository
public interface BigliettoRepository extends JpaRepository<Biglietto,String> {
	
	//search by clientId and replicaId
	Optional<Biglietto> findByClienteCodClienteAndReplichaCodreplica(Integer codCliente,String codreplica);
	List<Biglietto>findAllByOrderByDataOraAsc();// order nella pagina pronotazioni
	
	@Query("SELECT COALESCE(SUM(b.quantita),0) FROM Biglietto b WHERE b.replicha.codreplica =:codReplica")
	int countTotalBigliettiByReplica(@Param("codReplica")String codReplica);
	
	@Query("SELECT MAX(CAST(b.codOperazione AS integer)) FROM Biglietto b")
	Integer findMaxCodOperazione();

}
