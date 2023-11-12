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

import com.fiap.models.Cliente;
import com.fiap.services.ClienteService;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	ClienteService cs = new ClienteService();
	
	@GetMapping
	public List<Cliente> getObjects() throws Exception{
		return cs.selectCliente();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente c) throws Exception {	    
	    cs.inserir(c);
	    return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}	

	@GetMapping("{cpf}")
    public ResponseEntity<Cliente> getClienteByCpf(@PathVariable String cpf) throws Exception{
        return ResponseEntity.of(cs.clientePorCpf(cpf));
    }
		
	@DeleteMapping("{cpf}")
    public ResponseEntity<Object> delete(@PathVariable String cpf) throws Exception{
        var optional = cs.clientePorCpf(cpf);

        if(optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

    	cs.deleteCliente(cpf);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
	
	@PutMapping("{cpf}")
    public ResponseEntity<Object> atualizar(@PathVariable String cpf, @RequestBody @Valid Cliente c) throws Exception{
        var optional = cs.clientePorCpf(cpf);

        if(optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

    	cs.atualizarCliente(c);
        return ResponseEntity.ok(c);
    }
	
}
