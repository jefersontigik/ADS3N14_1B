package com.senac.estrutura.Modelo;

public class NodoGenerico<T> {
	
	private T  dado;
	private NodoGenerico<T> next;

	public NodoGenerico(T i)
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

	public void setNext(NodoGenerico<T> next)
	{
		this.next = next;
	}
	
	public NodoGenerico<T> getNext()
	{
		return next;
	}
}
