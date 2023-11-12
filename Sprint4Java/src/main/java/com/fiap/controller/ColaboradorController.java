package com.fiap.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.models.Colaborador;
import com.fiap.services.ColaboradorService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {

	ColaboradorService cs = new ColaboradorService();
	
	@GetMapping
	public List<Colaborador> getObjects() throws Exception{
		return cs.selectColaborador();
	}
	
	@PostMapping
	public ResponseEntity<Colaborador> create(@RequestBody @Valid Colaborador c) throws Exception {	    
	    cs.inserir(c);
	    return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}
	
	@GetMapping("{cpf}")
    public ResponseEntity<Colaborador> getColaboradorByCpf(@PathVariable String cpf) throws Exception{
        return ResponseEntity.of(cs.colaboradorPorCpf(cpf));
    }	
	
	@PutMapping("{cpf}")
    public ResponseEntity<Object> atualizar(@PathVariable String cpf, @RequestBody @Valid Colaborador c) throws Exception{
        var optional = cs.colaboradorPorCpf(cpf);

        if(optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

    	cs.atualizar(c);
        return ResponseEntity.ok(c);
    }
	
	@DeleteMapping("{cpf}")
    public ResponseEntity<Object> delete(@PathVariable String cpf) throws Exception{
        var optional = cs.colaboradorPorCpf(cpf);

        if(optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

    	cs.deleteColaborador(cpf);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
	
}
