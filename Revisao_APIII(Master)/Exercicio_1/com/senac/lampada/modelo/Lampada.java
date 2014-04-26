package com.senac.lampada.modelo;

public class Lampada {
	
	private boolean estado;

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public void ligaLampada(){
		setEstado(true);
	}
	
	public void desligaLampada(){
		setEstado(false);
	}
	
	public boolean isLigada(){
		return isEstado();
	}
}
