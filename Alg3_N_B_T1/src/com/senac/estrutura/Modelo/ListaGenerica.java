package com.senac.estrutura.Modelo;

import static java.lang.System.out;

public class ListaGenerica<T> {

	protected NodoGenerico<T> head;
	protected NodoGenerico<T> tail;

	public void insert(NodoGenerico<T> novo) {
		novo.setNext(head);
		head = novo;
		if (tail == null)
			tail = novo;
	}

	public void insert(NodoGenerico<T> novo, NodoGenerico<T> anterior) {
		novo.setNext(anterior.getNext());
		anterior.setNext(novo);
		if (anterior == tail)
			tail = novo;
	}

	public void append(NodoGenerico<T> novo) {
		if (tail != null)
			tail.setNext(novo);
		else
			head = novo;
		tail = novo;
	}

	public void print() {
		NodoGenerico<T> elem = head;
		do {
			out.println(elem.getData());
			elem = elem.getNext();
		} while (elem != null);
	}
}
