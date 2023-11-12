package com.fiap.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiap.dao.ClienteDAO;
import com.fiap.models.Cliente;

@Service
public class ClienteService {
	ClienteDAO cd = new ClienteDAO();
	
	public List<Cliente> selectCliente() throws Exception {
		List<Cliente> cList = new ArrayList<Cliente>();
		cList = cd.selectCliente();
		return cList;
	}

	public void inserir(Cliente c) throws Exception {
		cd.inserir(c);
	}
	
	public Optional<Cliente> clientePorCpf(String cpf) throws Exception {
		Optional<Cliente> c = cd.selectClientePorCpf(cpf);
		return c;
	}

	public void deleteCliente(String cpf)throws Exception {
		cd.deleteCliente(cpf);
	}	
	
	public void atualizarCliente(Cliente c) throws SQLException {
		cd.atualizarCliente(c);
	}
	
}
