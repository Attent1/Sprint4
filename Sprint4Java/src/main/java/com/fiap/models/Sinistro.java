package com.fiap.models;

public class Sinistro {
	private String dtSinistro;
	private String descricao;
	private long codSinistro;
	private int codSeguro;
	
	public Sinistro() {
		
	}
	
	//Contrutor
	public Sinistro( String dtSinistro, String descricao, long cd, int codSeguro) {
		this.dtSinistro = dtSinistro;
		this.descricao = descricao;
		this.codSinistro = cd;
		this.codSeguro = codSeguro;
		
	}

	//Getters e setters
	public String getDtSinistro() {
		return dtSinistro;
	}
	public void setDtSinistro(String dtSinistro) {
		this.dtSinistro = dtSinistro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getCodSinistro() {
		return codSinistro;
	}
	public void setCodSinistro(long codSinistro) {
		this.codSinistro = codSinistro;
	}

	public int getCodSeguro() {
		return codSeguro;
	}

	public void setCodSeguro(int codSeguro) {
		this.codSeguro = codSeguro;
	}
	
}
