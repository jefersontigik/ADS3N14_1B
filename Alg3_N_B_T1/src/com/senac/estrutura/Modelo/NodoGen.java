package com.senac.estrutura.Modelo;

public class NodoGen <T>{
	
	private T  dado;
	private NodoGen<T> next;

	public NodoGen(T i)
	{
		dado = i;
		next = null;
	}

	public void setData(T i)
	{
		dado = i;
		next = null;
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
