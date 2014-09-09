package com.senac.estruturas;

import static java.lang.System.out;

public class Nodo {
	
	private int  dado;
	private Nodo next;

	public Nodo()
	{
		dado = 0;
	}
	
	public Nodo(int i)
	{
		dado = i;
		next = null;
	}
	
	public void setData(int i)
	{
		dado = i;
		next = null;
	}
	
	public int getData()
	{
		return dado;
	}

	public void setNext(Nodo next)
	{
		this.next = next;
	}
	
	public Nodo getNext()
	{
		return next;
	}
	
	public static void print(Nodo head)
	{
		Nodo elem = head;
		do {
			out.println(elem.getData());
			elem = elem.getNext();
		} while (elem != null);
	}
	
	public static void insertBefore(Nodo antigo, Nodo novo)
	{
		novo.setNext(antigo);
	}
	
	public static void insertAfter(Nodo novo, Nodo antigo)
	{
		novo.setNext(antigo.getNext());
		antigo.setNext(novo);
	}
	public static void main(String[] args) {
		// criar lista
		Nodo head = new Nodo(), novo;
		head.setData(3);
		
		novo = new Nodo(1);
		insertAfter(novo, head);
		
		novo = new Nodo(2);
		insertBefore(head, novo);
		
		head = novo;
		
		print(head);
	}

}
