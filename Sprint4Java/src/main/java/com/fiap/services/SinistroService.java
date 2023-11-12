package com.fiap.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiap.dao.SinistroDAO;
import com.fiap.models.Sinistro;

@Service
public class SinistroService {
	
	SinistroDAO sd = new SinistroDAO();
	public void inserir(Sinistro s) throws Exception {
		sd.inserir(s);		
	}
	
	public List<Sinistro> selectSinistro() throws Exception{
		List<Sinistro> listSinistro = new ArrayList<Sinistro>();
		listSinistro = sd.selectSinistro();
		return listSinistro;
	}
	
	public Optional<Sinistro> sinistroPorCod(long cod) throws SQLException{
		Optional<Sinistro> s = sd.selectSinistroPorCod(cod);
		return s;
	}
	
	public void deleteSinistro(long cod) throws SQLException {
		sd.deleteSinistro(cod);
	}
	
	public void atualizar(Sinistro s) throws SQLException {
		sd.atualizarSinistro(s);
	}
}
