package com.fiap.models;

public class Bicicleta {
	private String marca;
	private double valor;
	private String nrSerie;
	private String notaFiscal;
	private String modelo;
	private String cpfCliente ;
	private int codSeguro;

	public Bicicleta() {
		
	}
	
	public Bicicleta(String marca, double valor, String nrSerie, String modelo, String notaFiscal, String cpfCliente, int codSeguro) {
		this.marca = marca;
		this.valor = valor;
		this.nrSerie = nrSerie;
		this.notaFiscal = notaFiscal;
		this.modelo = modelo;
		this.cpfCliente = cpfCliente;
		this.codSeguro = codSeguro;
	}

	// Getters e setters
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNrSerie() {
		return nrSerie;
	}

	public void setNrSerie(String nrSerie) {
		this.nrSerie = nrSerie;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public int getCodSeguro() {
		return codSeguro;
	}

	public void setCodSeguro(int codSeguro) {
		this.codSeguro = codSeguro;
	}


}
