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

import com.fiap.models.Sinistro;
import com.fiap.services.SinistroService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(value = "/sinistro")
public class SinistroController {
	
	SinistroService ss = new SinistroService();
		
	@GetMapping
	public List<Sinistro> getObjects() throws Exception{
		return ss.selectSinistro();
	}
	
	@PostMapping
	public ResponseEntity<Sinistro> create(@RequestBody @Valid Sinistro s) throws Exception {
		ss.inserir(s);
		return ResponseEntity.status(HttpStatus.CREATED).body(s);
	}
	@GetMapping("{cod}")
	public ResponseEntity<Sinistro> getSinistroPorCod(@PathVariable long cod) throws SQLException{
		return ResponseEntity.of(ss.sinistroPorCod(cod));
	}
	
	@DeleteMapping("{cod}")
	public ResponseEntity<Object> delete(@PathVariable long cod) throws SQLException{
		var optional = ss.sinistroPorCod(cod);
		
		 if(optional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		 
		 ss.deleteSinistro(cod);
		 
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("{cod}")
    public ResponseEntity<Object> atualizar(@PathVariable long cod, @RequestBody @Valid Sinistro s) throws Exception{
        var optional = ss.sinistroPorCod(cod);

        if(optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

    	ss.atualizar(s);
        return ResponseEntity.ok(s);
    }
	

}
