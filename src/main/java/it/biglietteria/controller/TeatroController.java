package it.biglietteria.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.biglietteria.entity.Teatro;
import it.biglietteria.repository.TeatroRepository;

@RestController
@RequestMapping("/api/teatri")
@CrossOrigin(origins = "*") 
public class TeatroController {

    private final TeatroRepository teatroRepository;

    public TeatroController(TeatroRepository teatroRepository) {
        this.teatroRepository = teatroRepository;
    }

    @GetMapping
    public ResponseEntity<List<Teatro>> getAllTeatri() {
        return new ResponseEntity<>(teatroRepository.findAll(), HttpStatus.OK);
    }
}

