package com.fiap.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiap.dao.BicicletaDAO;
import com.fiap.models.Bicicleta;

@Service
public class BicicletaService {

	BicicletaDAO bd = new BicicletaDAO();
	public List<Bicicleta> selectBicicleta() throws Exception {
		List<Bicicleta> bicicletaList = new ArrayList<Bicicleta>();
		bicicletaList = bd.selectBicicleta();
		return bicicletaList;

	}

	public void inserir(Bicicleta b) throws Exception {
		bd.inserir(b);
	}
	
	public void deleteBicicleta(String nrSerie) throws Exception {
		bd.deleteBicicleta(nrSerie);
	}
	
	public Optional<Bicicleta>bikePorNrSerie(String nrSerie) throws Exception{
		Optional<Bicicleta> b = bd.selectBicicletaPorNrSerie(nrSerie);
		return b;	
	}
	
	public void atualizar(Bicicleta b) throws SQLException {
		bd.atualizarBicicleta(b);
	}
}
