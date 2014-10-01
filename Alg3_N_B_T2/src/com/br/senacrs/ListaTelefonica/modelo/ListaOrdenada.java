package com.br.senacrs.ListaTelefonica.modelo;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T>{	
	
	private int totalNodos = 0;
	
	public int getTotalNodos() {
		return totalNodos;
	}

	public void setTotalNodos(int totalNodos) {
		this.totalNodos = totalNodos;
	}

	public Nodo<T> procuraNodo(Nodo<T> nodo){
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;
		T chaveNodo = nodo.getData();
		
		while (atual != null) {
			T chaveAtual = atual.getData();
			int compara = chaveNodo.compareTo(chaveAtual);
			if (compara == 0)
				return atual; 
			if (compara < 0)
				return anterior;
			anterior = atual;
			atual = atual.getNext();
		}
		return anterior;
	}
	
	@Override
	public void anexa(Nodo<T> novo){
		incluir(novo);
	}
	
	@Override
	public void incluir(Nodo<T> novo, Nodo<T> anterior){
		incluir(novo);
	}
	
	@Override
	public void incluir(Nodo<T> novo){
		Nodo<T> anterior = procuraNodo(novo); 
		
		if (anterior == null) {
			novo.setNext(head);
			if (head != null)
				head.setPrevious(novo);
			head = novo;
			if (tail == null)
				tail = novo;
		} else {
			Nodo<T> prox = anterior.getNext(); 
			novo.setNext(prox);
			novo.setPrevious(anterior);
			anterior.setNext(novo);
			if (tail == anterior)
				tail = novo;
			else
				prox.setPrevious(novo);
		}
		setTotalNodos(totalNodos++);
	}
}
