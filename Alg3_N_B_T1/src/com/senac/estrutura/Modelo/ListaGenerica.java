package com.senac.estrutura.Modelo;


public class ListaGenerica <T> {
	
	private NodoGenerico <T> head;
	
	public NodoGenerico<T> getHead() {
		return head;
	}

	public void setHead(NodoGenerico<T> head) {
		this.head = head;
	}

	public ListaGenerica(){
		head = null;
	}
	
	public void insere(T elemento){
		NodoGenerico <T> novo = new NodoGenerico <T>(elemento);
		novo.setProximo(this.head);
		this.head = novo;
	}
	
	public NodoGenerico <T> apagar(NodoGenerico <T> nodo){
		NodoGenerico <T> atual = head;
		
		while(atual.getElemento() != nodo){
			if(atual.getProximo() == null)
				return null;
			else{
				atual = atual.getProximo();
			}
			if(atual == head)
				head = head.getProximo();
		}
		return atual;
	}

}
