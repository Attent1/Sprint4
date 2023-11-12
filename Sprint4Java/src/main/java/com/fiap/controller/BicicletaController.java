package com.fiap.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.models.Bicicleta;
import com.fiap.services.BicicletaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(value = "/bike")
public class BicicletaController {
	
	BicicletaService bs = new BicicletaService();
	
	@GetMapping
	public List<Bicicleta> getObjects() throws Exception{		
		return bs.selectBicicleta();
		
	}
	
	@GetMapping("{nrSerie}")
	public ResponseEntity<Bicicleta> getBicicletaByNrSerie(@PathVariable String nrSerie) throws Exception{		
		   return ResponseEntity.of(bs.bikePorNrSerie(nrSerie));
	}
	
	@PostMapping
	public ResponseEntity<Bicicleta> create(@RequestBody @Valid Bicicleta b) throws Exception {	    
	    bs.inserir(b);	   
	    return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}
	
	@DeleteMapping("{nrSerie}")
	 public ResponseEntity<Object> delete(@PathVariable String nrSerie) throws Exception{
	        var optional = bs.bikePorNrSerie(nrSerie);

	        if(optional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

	    	bs.deleteBicicleta(nrSerie);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }


	@PutMapping("{nrSerie}")
    public ResponseEntity<Object> atualizar(@PathVariable String nrSerie, @RequestBody @Valid Bicicleta b) throws Exception{
        var optional = bs.bikePorNrSerie(nrSerie);

        if(optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

    	bs.atualizar(b);
        return ResponseEntity.ok(b);
    }
	
	
	
}
