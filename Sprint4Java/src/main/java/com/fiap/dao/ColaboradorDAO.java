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
import com.fiap.models.Colaborador;

public class ColaboradorDAO {

	public String inserir(Colaborador c) throws Exception {
		Connection conn = null;
		conn = Conexao.getConnection();
		String sql = "INSERT INTO COLABORADOR VALUES(?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCpf());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getSobreNome());
			ps.setString(4, c.getCargo());
			ps.setDouble(5, c.getSalario());
			ps.setInt(6, 723);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return "Colaborador adicionado com sucesso!";
	}

	public void atualizarColaborador(Colaborador c) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		String sql = "UPDATE COLABORADOR SET CARGO_COLABORADOR = ?, SALARIO_COLABORADOR = ? WHERE CPF_COLABORADOR = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,	c.getCargo());
			ps.setDouble(2, c.getSalario());
			ps.setString(3, c.getCpf());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conn.close();
		}
	}

	public void deleteColaborador(String cpf) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			String sql = "DELETE FROM COLABORADOR WHERE CPF_COLABORADOR = " + cpf;
			Statement st = conn.createStatement();
			st.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Colaborador> selectColaborador() throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			List<Colaborador> listaColaboradores = new ArrayList<>();
			String nome = "";
			String sobreNome = "";
			String cpf = "";
			String cargo = "";
			double salario = 0;
			int codSeguro = 0;
			String sql = "SELECT * FROM COLABORADOR";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				cpf = rs.getString("CPF_COLABORADOR");
	            nome = rs.getString("NOME_COLABORADOR");
	            sobreNome = rs.getString("SOBRENOME_COLABORADOR");
	            cargo = rs.getString("CARGO_COLABORADOR");
	            salario = rs.getDouble("SALARIO_COLABORADOR");
	            codSeguro = rs.getInt("SEGURO_BIKE_COD_SEGURO");	 
	            Colaborador c = new Colaborador(nome, sobreNome, cpf, cargo, salario, codSeguro);
	            listaColaboradores.add(c);
			}
			return listaColaboradores;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Optional<Colaborador> selectColaboradorPorCpf(String cpf) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			Colaborador c = new Colaborador();
			String nome = "";
			String sobreNome = "";
			String cpfColaborador = "";
			String cargo = "";
			double salario = 0;
			int codSeguro = 0;
			String sql = "SELECT * FROM COLABORADOR WHERE CPF_COLABORADOR = " + cpf;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				cpfColaborador = rs.getString("CPF_COLABORADOR");
	            nome = rs.getString("NOME_COLABORADOR");
	            sobreNome = rs.getString("SOBRENOME_COLABORADOR");
	            cargo = rs.getString("CARGO_COLABORADOR");
	            salario = rs.getDouble("SALARIO_COLABORADOR");
	            codSeguro = rs.getInt("SEGURO_BIKE_COD_SEGURO");	            
	            c = new Colaborador(nome, sobreNome, cpfColaborador, cargo, salario, codSeguro);
	            
			}
			return Optional.of(c);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
