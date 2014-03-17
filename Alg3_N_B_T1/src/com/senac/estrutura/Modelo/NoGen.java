package com.senac.estrutura.Modelo;

public class NoGen<T>{
	
	private T  dado;
	private NoGen<T> next;

	public NoGen(T i)
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

	public void setNext(NoGen<T> next)
	{
		this.next = next;
	}
	
	public NoGen<T> getNext()
	{
		return next;
	}
}
