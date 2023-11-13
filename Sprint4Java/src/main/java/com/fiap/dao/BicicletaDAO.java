package com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fiap.Conexao.Conexao;
import com.fiap.models.Bicicleta;

public class BicicletaDAO {
	
	public String inserir(Bicicleta b) throws Exception {
		Connection conn = null;
		conn = Conexao.getConnection();
		String sql = "INSERT INTO BICICLETA VALUES(?, ?, ?, ?, ?, ?, ? )";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getNrSerie());
			ps.setString(2, b.getMarca());
			ps.setDouble(3, b.getValor());
			ps.setString(4, b.getModelo());
			ps.setString(5, b.getNotaFiscal());							
			ps.setString(6, b.getCpfCliente());			
			ps.setInt(7, 484);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return "Bicicleta cadastrada com sucesso!";
	}

	public void deleteBicicleta(String nrSerie) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			String sql = "DELETE FROM BICICLETA WHERE NUMERO_SERIE_BIKE = " + "'" + nrSerie + "'";
			Statement st = conn.createStatement();
			st.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public Optional<Bicicleta> selectBicicletaPorNrSerie(String nrSerie) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			Bicicleta b = new Bicicleta();
			String marca = "";
			double valor = 0;
			String numeroSerie = "";
			String notaFiscal = "";
			String modelo = "";
			String cpfCliente = "";
			int codSeguro = 0;
			String sql = "SELECT * FROM BICICLETA WHERE NUMERO_SERIE_BIKE = " + "'" + nrSerie + "'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				marca = rs.getString("MARCA_BIKE");
				valor = rs.getDouble("VALOR_BIKE");
				numeroSerie = rs.getString("NUMERO_SERIE_BIKE");
				notaFiscal = rs.getString("NOTA_FISCAL_BIKE_CODIGO_NF");
				modelo = rs.getString("MODELO_BIKE");
				cpfCliente = rs.getString("CLIENTE_CPF_FK");	 
				codSeguro = rs.getInt("SEGURO_BIKE_COD_SEGURO");
				b = new Bicicleta(marca, valor, numeroSerie, modelo, notaFiscal, cpfCliente, codSeguro);
	            
			}
			return Optional.of(b);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	public List<Bicicleta> selectBicicleta() throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			List<Bicicleta> listaBicicletas = new ArrayList<>();
			String numeroSerie = "";
			String marca = "";
			double valor = 0;
			String modelo = "";
			String codNotaFiscal = "";
			String cpfCliente = "";
			int codSeguro = 0;
			String sql = "SELECT * FROM BICICLETA";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				numeroSerie = rs.getString("NUMERO_SERIE_BIKE");
				marca = rs.getString("MARCA_BIKE");
				valor = rs.getDouble("VALOR_BIKE");
				codNotaFiscal = rs.getString("NOTA_FISCAL_BIKE_CODIGO_NF");
				modelo = rs.getString("MODELO_BIKE");
				cpfCliente = rs.getString("CLIENTE_CPF_FK");
				codSeguro = rs.getInt("SEGURO_BIKE_COD_SEGURO");
	            Bicicleta b = new Bicicleta(marca, valor, numeroSerie, modelo, codNotaFiscal, cpfCliente, codSeguro);
	            listaBicicletas.add(b);
			}
			return listaBicicletas;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizarBicicleta(Bicicleta b) throws SQLException {
		
		Connection conn = null;
		conn = Conexao.getConnection();
		String sql = "UPDATE BICICLETA SET MARCA_BIKE = ?, VALOR_BIKE = ? WHERE NUMERO_SERIE_BIKE = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,	b.getMarca());
			ps.setDouble(2, b.getValor());
			ps.setString(3, b.getNrSerie());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conn.close();
		}

		
	}
	
}
