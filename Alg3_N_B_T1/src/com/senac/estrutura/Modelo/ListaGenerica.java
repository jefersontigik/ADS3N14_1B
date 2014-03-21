package com.senac.estrutura.Modelo;

public class ListaGenerica <T>{

	protected NodoGen<T> head;
	protected NodoGen<T> tail;

	public NodoGen<T> getHead() {
		return head;
	}
	
	public NodoGen<T> getTail() {
		return tail;
	}
	
	public ListaGenerica() {
		head = null;
		tail = null;
	}
	
	public boolean listaVazia(){
		return this.head == null ? true : false;
	}
	
	public void insert(NodoGen<T> novo) {
		novo.setNext(head);
		head = novo;
		if (tail == null)
			tail = novo;
	}

	public void insert(NodoGen<T> novo, NodoGen<T> anterior) {
		if (anterior == null) {
			novo.setNext(head);
			head = novo;
			if (tail == null)
				tail = head;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
			if (anterior == tail)
				tail = novo;
		}
	}

	public void append(NodoGen<T> novo) {
		if (tail != null) {
			tail.setNext(novo);
		} else {
			head = novo;
		}
		tail = novo;
	}

//	public void print() {
//		NodoGen<T> elem = head;
//		if(!listaVazia()){
//			do {
//				out.println(elem.getData());
//				elem = elem.getNext();
//			} while (elem != null);
//		}		
//	}
}
