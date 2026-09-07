package it.biglietteria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.biglietteria.entity.Biglietto;
import it.biglietteria.entity.Cliente;
import it.biglietteria.service.BigliettoService;

@RestController
@RequestMapping("/api/biglietti")  // Base URL
public class BigliettoController {
	private final BigliettoService bigliettoService;
	
	public BigliettoController(BigliettoService bigliettoService) {
		this.bigliettoService = bigliettoService;
	}
	// Endpoint per comprare i biglietti
	//POST : http://localhost:8080/api/biglietti/compra
	@PostMapping("/compra")
	public ResponseEntity<?>
	compraBiglietto(@RequestParam Integer codCliente,@RequestParam String codreplica,@RequestParam int quantita,@RequestParam String tipoPagamento ){
		try {	
			Biglietto bigliettoAcquistato = bigliettoService.compraBiglietto(codCliente,codreplica,quantita,tipoPagamento);
			return
					new ResponseEntity<>(bigliettoAcquistato,HttpStatus.CREATED); // Http status è 201
	        }catch (RuntimeException e) {
	        		//Se non c'è il cliente o non c'è la capacity
	        	return
	        			new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST); // Http status è 400
	        							}
	        }
	@GetMapping("/cliente/{id}")
	public ResponseEntity<?>
	getClientById(@PathVariable Integer id){
		try {
	        Cliente cliente = bigliettoService.getClienteById(id);
	        return new ResponseEntity<>(cliente, HttpStatus.OK);
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
		
	
			

}
	@CrossOrigin(origins = "*")
	@GetMapping
		public ResponseEntity<List<Biglietto>> getAllBiglietti() {
		    return new ResponseEntity<>(bigliettoService.getAllBiglietti(), HttpStatus.OK);
		}

}


