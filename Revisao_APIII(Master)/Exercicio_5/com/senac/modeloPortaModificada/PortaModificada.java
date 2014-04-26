package com.senac.modeloPortaModificada;

import com.senac.modeloPorta.Chave;
import com.senac.modeloPorta.Porta;
import com.senac.modeloComodo.Comodo;
import com.senac.modeloNovoComodo.*;


public class PortaModificada {
	
	private boolean porta;
	private boolean tranca;	
	private int fechadura;
	private Comodo direita;
	private Comodo esquerda;
	
	public PortaModificada(int codigo){
		this.fechadura = codigo;
		this.direita = null;
		this.esquerda = null;
	}
	
	public void associaComodos(Comodo dir, Comodo esq){
		this.direita = dir;
		this.esquerda = esq;
	}
	
	public Comodo getComodoDireito(){
		return direita;
	}
	
	public Comodo getComodoEsquerdo(){
		return esquerda;
	}
	
	public void addPorta(Porta porta){
		
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
