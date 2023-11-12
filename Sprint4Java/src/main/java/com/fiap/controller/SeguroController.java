package com.fiap.controller;

import java.sql.SQLException;
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

import com.fiap.models.Seguro;
import com.fiap.services.SeguroService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(value = "/seguro")
public class SeguroController {
	SeguroService ss = new SeguroService();
	
	@GetMapping
	public List<Seguro> getObjects() throws Exception{
		return ss.selectSeguro();
	}
	
	@PostMapping
	public ResponseEntity<Seguro> create(@RequestBody @Valid Seguro s) throws Exception {
		ss.inserir(s);
		return ResponseEntity.status(HttpStatus.CREATED).body(s);
	}
	
	@GetMapping("{cod}")
	public ResponseEntity<Seguro> getSeguroPorCod(@PathVariable int cod) throws SQLException{
		return ResponseEntity.of(ss.seguroPorCod(cod));
	}
	
	@DeleteMapping("{cod}")
	public ResponseEntity<Object> delete(@PathVariable int cod) throws SQLException{
		var optional = ss.seguroPorCod(cod);
		
		 if(optional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		 
		 ss.deleteSeguro(cod);
		 
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("{cod}")
    public ResponseEntity<Object> atualizar(@PathVariable int cod, @RequestBody @Valid Seguro s) throws Exception{
        var optional = ss.seguroPorCod(cod);

        if(optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

    	ss.atualizar(s);
        return ResponseEntity.ok(s);
    }
	
	
}
