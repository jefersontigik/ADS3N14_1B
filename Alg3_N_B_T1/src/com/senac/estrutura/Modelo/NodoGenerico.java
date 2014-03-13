package com.senac.estrutura.Modelo;
/**
 * Criando Nodo genérico.
 */

public class NodoGenerico <T> {
	
	private T elemento;
	private NodoGenerico <T> proximo;
	
	public NodoGenerico(T elemento){
		this.elemento = elemento;
	}
	public NodoGenerico(T elemento, NodoGenerico <T> b){
		this.elemento = elemento;
		this.proximo = b;
	}
	
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public NodoGenerico<T> getProximo() {
		return proximo;
	}
	public void setProximo(NodoGenerico<T> proximo) {
		this.proximo = proximo;
	}
	
	

}
