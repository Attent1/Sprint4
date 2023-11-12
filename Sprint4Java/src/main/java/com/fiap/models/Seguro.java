package com.fiap.models;

public class Seguro {
	private int codSeguro;
	private double valorSeguro;
	private String plano;
	private String dtAquisicao;
	private String dtVencimento;
	private String telefoneSeguro;


	public Seguro() {
		
	}
	
	// Construtor
	public Seguro(int codSeguro, double valorSeguro, String plano, String dtAquisicao, String dtVencimento, String telefoneSeguro) {
		this.codSeguro = codSeguro;
		this.valorSeguro = valorSeguro;
		this.plano = plano;
		this.dtAquisicao = dtAquisicao;
		this.dtVencimento = dtVencimento;
		this.telefoneSeguro = telefoneSeguro;

	}
	
	public int getCodSeguro() {
		return codSeguro;
	}
	
	public void setCodSeguro(int codSeguro) {
		this.codSeguro = codSeguro;
	}

	// Getters e setters
	public double getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getDtAquisicao() {
		return dtAquisicao;
	}

	public void setDtAquisicao(String dtAquisicao) {
		this.dtAquisicao = dtAquisicao;
	}

	public String getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(String dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public String getTelefoneSeguro() {
		return telefoneSeguro;
	}

	public void setTelefoneSeguro(String telefoneSeguro) {
		this.telefoneSeguro = telefoneSeguro;
	}

}
