package com.fiap.models;

public class Colaborador extends Pessoa {	
	private String cargo;
	private double salario;
	private int codSeguro;

	public Colaborador() {
		
	}
	
	public Colaborador(String nome, String sobreNome, String cpf, String cargo, double salario, int codSeguro) {
		super(nome, sobreNome, cpf);
		this.cargo = cargo;
		this.salario = salario;
		this.codSeguro = codSeguro;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getCodSeguro() {
		return codSeguro;
	}

	public void setCodSeguro(int codSeguro) {
		this.codSeguro = codSeguro;
	}

}
