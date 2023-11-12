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
import com.fiap.models.Seguro;

public class SeguroDAO {

	public List<Seguro> selectSeguro() throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {			
										
			List<Seguro> listaSeguro = new ArrayList<>();
			int codSeguro = 0;
			double valorSeguro = 0;
			String plano = "";
			String dtAquisicao = "";
			String dtVencimento = "";
			String telefoneSeguro = "";			
			String sql = "SELECT * FROM SEGURO_BIKE";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {	
				codSeguro = rs.getInt("COD_SEGURO");
				valorSeguro = rs.getDouble("VALOR_SEGURO");
				plano = rs.getString("PLANO_SEGURO");
				dtAquisicao = rs.getString("DATA_AQUISICAO_SEGURO");
				dtVencimento = rs.getString("DATA_VENCIMENTO_SEGURO");
				telefoneSeguro = rs.getString("TELEFONE_SEGURO");
				Seguro s = new Seguro(codSeguro, valorSeguro, plano, dtAquisicao, dtVencimento, telefoneSeguro);
	            listaSeguro.add(s);
			}
			return listaSeguro;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String inserir(Seguro s) throws Exception {
		Connection conn = null;
		conn = Conexao.getConnection();
		String sql = "INSERT INTO SEGURO_BIKE VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getCodSeguro());
			ps.setDouble(2, s.getValorSeguro());
			ps.setString(3, s.getPlano());
			ps.setString(4, s.getDtAquisicao());
			ps.setString(5, s.getDtVencimento());
			ps.setString(6, s.getTelefoneSeguro());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return "Seguro cadastrado com sucesso!";
	}

	public Optional<Seguro> selectSeguroPorCod(int cod) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			Seguro s = new Seguro();
			int codSeguro = 0;
			double valorSeguro = 0;
			String plano = "";
			String dtAquisicao = "";
			String dtVencimento = "";
			String telefoneSeguro = "";	
			String sql = "SELECT * FROM SEGURO_BIKE WHERE COD_SEGURO = " + cod;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {	
				codSeguro = rs.getInt("COD_SEGURO");
				valorSeguro = rs.getDouble("VALOR_SEGURO");
				plano = rs.getString("PLANO_SEGURO");
				dtAquisicao = rs.getString("DATA_AQUISICAO_SEGURO");
				dtVencimento = rs.getString("DATA_VENCIMENTO_SEGURO");
				telefoneSeguro = rs.getString("TELEFONE_SEGURO");
				s = new Seguro(codSeguro, valorSeguro, plano, dtAquisicao, dtVencimento, telefoneSeguro);
			}
			return Optional.of(s);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteSeguro(int cod) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			String sql = "DELETE FROM SEGURO_BIKE WHERE COD_SEGURO = " + cod;
			Statement st = conn.createStatement();
			st.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarSeguro(Seguro s) throws SQLException {
		
		Connection conn = null;
		conn = Conexao.getConnection();
		String sql = "UPDATE SEGURO_BIKE SET PLANO_SEGURO = ?, VALOR_SEGURO = ? WHERE COD_SEGURO = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,	s.getPlano());
			ps.setDouble(2, s.getValorSeguro());
			ps.setInt(3, s.getCodSeguro());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conn.close();
		}

		
	}
}
