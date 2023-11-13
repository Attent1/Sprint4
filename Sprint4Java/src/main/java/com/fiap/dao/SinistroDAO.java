package com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.fiap.Conexao.Conexao;
import com.fiap.models.Sinistro;

public class SinistroDAO {
	
	
	public List<Sinistro> selectSinistro() throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {			
										
			List<Sinistro> listaSinistros = new ArrayList<>();
			String dtSinistro = "";
			String descricao = "";
			long cd = 0;
			int cdSeguro = 0;
			String sql = "SELECT * FROM Sinistro";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				dtSinistro = rs.getString("DATA_SINISTRO");
				descricao = rs.getString("DESCRICAO_SINISTRO");
				cd = rs.getLong("CODIGO_SINISTRO");
				cdSeguro = rs.getInt("SEGURO_BIKE_COD_SEGURO");
	            Sinistro s = new Sinistro(dtSinistro, descricao, cd, cdSeguro);
	            listaSinistros.add(s);
			}
			return listaSinistros;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String inserir(Sinistro s) throws Exception {
		Connection conn = null;
		conn = Conexao.getConnection();
		String sql = "INSERT INTO SINISTRO VALUES(?, ?, ?, ?)";
		Random r = new Random();
		int cd = r.nextInt(10000000);
		cd += +r.nextInt(100000);
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, cd);
			ps.setString(2, s.getDtSinistro());
			ps.setString(3, s.getDescricao());
			if(s.getCodSeguro() == 0) {
				ps.setInt(4, 484);
			}
			else {
				ps.setInt(4, s.getCodSeguro());	
			}						
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return "Seguro cadastrado com sucesso!";
	}
		
	public Optional<Sinistro> selectSinistroPorCod(long cod) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			Sinistro s = new Sinistro();
			String dtSinistro = "";
			String descricao = "";
			long codigo = 0;
			int cdSeguro = 0;
			String sql = "SELECT * FROM SINISTRO WHERE CODIGO_SINISTRO = " + cod;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				dtSinistro = rs.getString("DATA_SINISTRO");
				descricao = rs.getString("DESCRICAO_SINISTRO");
				codigo = rs.getLong("CODIGO_SINISTRO");
				cdSeguro = rs.getInt("SEGURO_BIKE_COD_SEGURO");
	            s = new Sinistro(dtSinistro, descricao, codigo, cdSeguro);
	            
			}
			return Optional.of(s);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteSinistro(long cod) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			String sql = "DELETE FROM SINISTRO WHERE CODIGO_SINISTRO = " + cod;
			Statement st = conn.createStatement();
			st.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void atualizarSinistro(Sinistro s) throws SQLException {
		
		Connection conn = null;
		conn = Conexao.getConnection();
		String sql = "UPDATE SINISTRO SET DESCRICAO_SINISTRO = ? WHERE CODIGO_SINISTRO = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,	s.getDescricao());
			ps.setLong(2, s.getCodSinistro());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conn.close();
		}

		
	}
	
}
