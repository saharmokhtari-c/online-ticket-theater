package it.biglietteria.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import java.util.List;

import it.biglietteria.entity.Biglietto;
import it.biglietteria.entity.Cliente;
import it.biglietteria.entity.Replicha;
import it.biglietteria.repository.BigliettoRepository;
import it.biglietteria.repository.ClienteRepository;
import it.biglietteria.repository.ReplichaRepository;

@Service
public class BigliettoService {

	private final BigliettoRepository bigliettoRepository;
	private final ClienteRepository clienteRepository;
	private final ReplichaRepository replichaRepository;
	
	public BigliettoService(BigliettoRepository bigliettoRepository, ClienteRepository clienteRepository,
			ReplichaRepository replichaRepository) {
		
		this.bigliettoRepository = bigliettoRepository;
		this.clienteRepository = clienteRepository;
		this.replichaRepository = replichaRepository;
	}
	
	public Biglietto compraBiglietto(Integer codCliente,String codreplica,int quantita,String tipoPagamento) {
		
		//Trovare il ciliente
		Cliente cliente = clienteRepository.findById(codCliente).orElseThrow(() -> new RuntimeException("Cliente non trovato con codice :" + codCliente)) ;
		
		//Trovare la replicha
		Replicha replicha = replichaRepository.findById(codreplica).orElseThrow(() -> new RuntimeException("Replica non trovato con codice :" + codreplica)) ;
		
		//Capacity del salone
		
		int capacity = replicha.getSpettacolo().getTeatro().getPosti();
		int compratatoBiglieeti = bigliettoRepository.countTotalBigliettiByReplica(codreplica);
		
		//Controlla capacity
		if (compratatoBiglieeti + quantita > capacity ) {
			throw new RuntimeException("capienza massima superata! Posti disponibili :" + (capacity - compratatoBiglieeti));}
			
		// Controlla che il cliente ha gia il biglietto per quello replicha
		
		Biglietto biglietto = bigliettoRepository.findByClienteCodClienteAndReplichaCodreplica(codCliente , codreplica).orElse(null);
		if (biglietto != null) {
			biglietto.setQuantita(biglietto.getQuantita() + quantita);
			biglietto.setDataOra(LocalDateTime.now());
			biglietto.setTipoPagamento(tipoPagamento);
		}  else {
			// se il biglietto è nouvo
			//maxCod is a random value for cod_operazion
			Integer maxCod = bigliettoRepository.findMaxCodOperazione();
			int nextCod = (maxCod == null)? 1 : maxCod +1;
			String generateCode = String.valueOf(nextCod);
			
			biglietto = new Biglietto();
			biglietto.setCodOperazione(generateCode);
			
			biglietto.setCliente(cliente);
			biglietto.setReplicha(replicha);
			biglietto.setQuantita(quantita);
			biglietto.setDataOra(LocalDateTime.now());
			biglietto.setTipoPagamento(tipoPagamento);
		}
		
		// Salvare in DataBase
		return 
				bigliettoRepository.save(biglietto);
		
	}
	
    public Cliente getClienteById(Integer codCliente) {
        return clienteRepository.findById(codCliente)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + codCliente));
    }
    
    public List<Biglietto> getAllBiglietti(){
    	return bigliettoRepository.findAllByOrderByDataOraAsc();
    }
   

}
