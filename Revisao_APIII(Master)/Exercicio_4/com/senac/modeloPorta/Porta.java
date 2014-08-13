package com.senac.modeloPorta;

public class Porta {
	
	private boolean porta;
	private boolean tranca;	
	private int fechadura;
	
	public Porta(int codigo){
		this.fechadura = codigo;
	}
	
	public int getFechadura() {
		return this.fechadura;
	}

	public boolean getPorta() {
		return porta;
	}

	public void setPorta(Boolean estado) {
		this.porta = estado;
	}

	public boolean isTranca() {
		return tranca;
	}

	public void setTranca(boolean tranca) {
		this.tranca = tranca;
	}	
	
	public void abrir(){
		if(!isTrancada())
			setPorta(true);
	}
	
	public void fechar(){
		setPorta(false);
	}
	
	public boolean isAberta(){
		return getPorta();
	}
	
	public void trancar(Chave chave){
	
		if(!isTrancada() && this.fechadura == chave.getCodigo())
			setTranca(true);
	}

	public void destrancar(Chave chave){
		
		if(isTrancada() && this.fechadura == chave.getCodigo())
			setTranca(false);
	}
	
	public boolean isTrancada(){
		return isTranca();
	}
}
