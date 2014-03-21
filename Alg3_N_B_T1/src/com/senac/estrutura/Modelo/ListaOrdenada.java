package com.senac.estrutura.Modelo;

public class ListaOrdenada<T extends Comparable<T>> extends ListaGenerica<T>
{	
	public NodoGen<T> procuraNodo(NodoGen<T> needle)
	{
		NodoGen<T> atual = getHead();
		NodoGen<T> anterior = null;
		T chaveNeedle = needle.getData();
		
		while (atual != null) {
			T chaveAtual = atual.getData();
			int cmp = chaveNeedle.compareTo(chaveAtual);
			if (cmp == 0)
				return atual; 
			if (cmp < 0)
				return anterior;
			anterior = atual;
			atual = atual.getNext();
		}
		return anterior;
	}
	
	@Override
	public void append(NodoGen<T> novo)
	{
		insert(novo);
	}
	
	@Override
	public void insert(NodoGen<T> novo, NodoGen<T> anterior)
	{
		insert(novo);
	}
	
	@Override
	public void insert(NodoGen<T> novo)
	{
		NodoGen<T> anterior = procuraNodo(novo);
		
		if (anterior == null) {
			novo.setNext(head);
			head = novo;
			if (tail == null)
				tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
			if (tail == anterior)
				tail = novo;
		}
		
	}
}
