package com.fiap.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiap.dao.ColaboradorDAO;
import com.fiap.models.Colaborador;
@Service
public class ColaboradorService {
	ColaboradorDAO cd = new ColaboradorDAO();
		
	public List<Colaborador> selectColaborador() throws Exception {
		List<Colaborador> cList = new ArrayList<Colaborador>();
		cList = cd.selectColaborador();
		return cList;
	}

	public void inserir (Colaborador c) throws Exception {
		cd.inserir(c);
	}
	
	public void atualizar(Colaborador c) throws SQLException {
		cd.atualizarColaborador(c);
	}
	
	public Optional<Colaborador> colaboradorPorCpf(String cpf) throws Exception {
		Optional<Colaborador> c = cd.selectColaboradorPorCpf(cpf);
		return c;
	}
	
	public void deleteColaborador(String cpf)throws Exception {
		cd.deleteColaborador(cpf);
	}	
	
}
