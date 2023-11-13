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
import com.fiap.models.Cliente;

public class ClienteDAO {

	public String inserir(Cliente c) throws Exception {
		Connection conn = null;
		conn = Conexao.getConnection();
		String sql = "INSERT INTO CLIENTE VALUES(?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCpf());
			ps.setString(2, c.getNome());			
			ps.setString(3, c.getSobreNome());		
			ps.setString(4, c.getEmailCliente());
			ps.setString(5, c.getTelefoneCliente());	
			ps.setString(6, c.getCepCliente());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conn.close();
		}

		return "Cliente adicionado com sucesso!";
	}
	
	public void atualizarCliente(Cliente c) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		String sql = "UPDATE CLIENTE SET EMAIL_CLIENTE = ?, CEP_CLIENTE = ? WHERE CPF_CLIENTE = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getEmailCliente());
			ps.setString(2, c.getCepCliente());
			ps.setString(3, c.getCpf());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conn.close();
		}
	}
	
	public List<Cliente> selectCliente() throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			List<Cliente> listaClientes = new ArrayList<>();
			String nome = "";
			String sobreNome = "";
			String cpf = "";
			String email = "";
			String telefone = "";
			String cep = "";
			String sql = "SELECT * FROM Cliente";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				cpf = rs.getString("CPF_CLIENTE");
	            nome = rs.getString("NOME_CLIENTE");
	            sobreNome = rs.getString("SOBRENOME_CLIENTE");
	            email = rs.getString("EMAIL_CLIENTE");
	            telefone = rs.getString("TELEFONE_CLIENTE");
	            cep = rs.getString("CEP_CLIENTE");	            
	            Cliente c = new Cliente(nome, sobreNome, cpf, email, telefone, cep);
	            listaClientes.add(c);
			}
			return listaClientes;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	public void deleteCliente(String cpf) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			String sql = "DELETE FROM CLIENTE WHERE CPF_CLIENTE = " + cpf;
			Statement st = conn.createStatement();
			st.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Optional<Cliente> selectClientePorCpf(String cpf) throws SQLException {
		Connection conn = null;
		conn = Conexao.getConnection();
		try {
			Cliente c = new Cliente();
			String nome = "";
			String sobreNome = "";
			String cpfCliente = "";
			String email = "";
			String telefone = "";
			String cep = "";
			String sql = "SELECT * FROM CLIENTE WHERE CPF_CLIENTE = " + cpf;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				cpfCliente = rs.getString("CPF_CLIENTE");
	            nome = rs.getString("NOME_CLIENTE");
	            sobreNome = rs.getString("SOBRENOME_CLIENTE");
	            email = rs.getString("EMAIL_CLIENTE");
	            telefone = rs.getString("TELEFONE_CLIENTE");
	            cep = rs.getString("CEP_CLIENTE");	            
	            c = new Cliente(nome, sobreNome, cpfCliente, email, telefone, cep);
	            
			}
			return Optional.of(c);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
