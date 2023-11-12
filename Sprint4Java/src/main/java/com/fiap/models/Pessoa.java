package com.fiap.models;

public abstract class Pessoa {
	protected String nome;
	protected String sobreNome;
	protected String cpf;
	
	
	public Pessoa(String nome, String sobreNome, String cpf) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
	}

	public Pessoa() {
		
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
		
}
