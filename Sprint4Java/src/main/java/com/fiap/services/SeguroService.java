package com.fiap.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiap.dao.SeguroDAO;
import com.fiap.models.Seguro;

@Service
public class SeguroService {

	SeguroDAO sd = new SeguroDAO();
	
	public List<Seguro> selectSeguro() throws Exception{
		List<Seguro> listSeguro = new ArrayList<Seguro>();
		listSeguro = sd.selectSeguro();
		return listSeguro;
	}
		
	public void inserir(Seguro s) throws Exception {
		sd.inserir(s);
	}
	
	public Optional<Seguro> seguroPorCod(int cod) throws SQLException{
		Optional<Seguro> s = sd.selectSeguroPorCod(cod);
		return s;
	}
	
	public void deleteSeguro(int cod) throws SQLException {
		sd.deleteSeguro(cod);
	}
	
	public void atualizar(Seguro s) throws SQLException {
		sd.atualizarSeguro(s);
	}

}
