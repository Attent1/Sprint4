package com.fiap.models;

public class Cliente extends Pessoa {
	// private String nomeCliente;
	// private String sobreNomeCliente;
	// private String cpfCliente;
	private String email;
	private String telefoneCliente;
	private String cepCliente;

	public Cliente() {
		
	}
	
	public Cliente(String nome, String sobreNome, String cpf, String email, String telefoneCliente,
			String cepCliente) {
		super(nome, sobreNome, cpf);
		this.email = email;
		this.telefoneCliente = telefoneCliente;
		this.cepCliente = cepCliente;
	}

	// Getters e setters
	public String getEmailCliente() {
		return email;
	}

	public void setEmailCliente(String email) {
		this.email = email;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}
	
	
}
