package com.senac.estrutura.Modelo;

import static java.lang.System.out;

public class ListaGenerica <T>{

	protected NodoGen<T> head;
	protected NodoGen<T> tail;

	public boolean ListaVazia(){
		return this.head == null ? true : false;
	}
	
	public void insert(NodoGen<T> novo) {
		novo.setNext(head);
		head = novo;
		if (tail == null)
			tail = novo;
	}

	public void insert(NodoGen<T> novo, NodoGen<T> anterior) {
		novo.setNext(anterior.getNext());
		anterior.setNext(novo);
		if (anterior == tail)
			tail = novo;
	}

	public void append(NodoGen<T> novo) {
		if (tail != null)
			tail.setNext(novo);
		else
			head = novo;
		tail = novo;
	}
	
//	@Override
//	public String toString() {
//		return "ListaGenerica [head=" + head.getData().toString() + ", tail=" + tail.getData().toString() + "]";
//	}

	public void print() {
		NodoGen<T> elem = head;
		if(!ListaVazia()){
			do {
				out.println(elem.getData());
				elem = elem.getNext();
			} while (elem != null);
		}		
	}
}
