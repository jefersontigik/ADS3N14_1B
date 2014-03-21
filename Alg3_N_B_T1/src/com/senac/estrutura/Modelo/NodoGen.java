package com.senac.estrutura.Modelo;

public class NodoGen <T>{
	
	private T  dado;
	private NodoGen<T> next;

	public NodoGen()
	{
		dado = null;
		next = null;
	}

	public void setData(T dado)
	{
		
		this.dado = dado;
	}

	public T getData()
	{
		return dado;
	}

	public void setNext(NodoGen<T> next)
	{
		this.next = next;
	}

	public NodoGen<T> getNext()
	{
		return next;
	}
}
