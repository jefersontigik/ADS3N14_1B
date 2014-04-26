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
		setPorta(true);
	}
	
	public boolean isAberta(){
		return getPorta();
	}
	
	public void trancar(Chave chave){
		if(this.fechadura == chave.getCodigo())
			setTranca(true);
//		throw new ChaveInvalida();
	}

	public void destrancar(Chave chave){
		if(this.fechadura == chave.getCodigo())
			setTranca(false);
//		throw new ChaveInvalida();
	}
	
	public boolean isTrancada(){
		return isTranca();
	}
}
