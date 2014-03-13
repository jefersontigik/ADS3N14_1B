package com.senac.estruturas;

public class ListaEncadeada {
	
	private Nodo head;
	private Nodo tail;
	
	public void insert(Nodo novo, Nodo anterior){
		novo.setNext(anterior.getNext());
		anterior.setNext(novo);
	}
	
	public void insert(Nodo novo){
		novo.setNext(head);
		head = novo;
	}
	
	public static void main(String[] args) {
		// criar lista
		ListaEncadeada lista = new ListaEncadeada();
		
		Nodo novo = new Nodo(1);
		lista.insert(novo);
		
		lista.insert(new Nodo(2), novo);
	}

}
