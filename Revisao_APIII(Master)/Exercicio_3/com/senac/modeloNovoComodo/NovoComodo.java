package com.senac.modeloNovoComodo;

import com.senac.lampada.modelo.Lampada;

public class NovoComodo {
	
	private double tamanho;
	private String tipo;
	private String cor;
	private Lampada lampada;
	
	public NovoComodo(){
		this.lampada = new Lampada();
	}
	
	public void iluminar(){
		this.lampada.ligaLampada();
	}
	
	public void escurecer(){
		this.lampada.desligaLampada();
	}
	
	public boolean isIluminado(){
		return this.lampada.isLigada();
	}
	
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

}
