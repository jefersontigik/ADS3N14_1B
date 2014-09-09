package com.br.senacrs.ap3.modelo;
public class Nodo <T> {
	
	private T dados;
	private Nodo <T> prox;
	private Nodo <T> ant;
	
	public Nodo(){
		this.dados = null;
		this.prox = null;
		this.ant = null;
	}
	
	public Nodo(T p){
	      this.prox = null;
	      this.ant = null;
	      this.dados = p;
	}

	public T getDados() {
		return dados;
	}

	public void setDados(T dados) {
		this.dados = dados;
	}

	public Nodo<T> getProx() {
		return prox;
	}

	public void setProx(Nodo<T> prox) {
		this.prox = prox;
	}

	public Nodo<T> getAnt() {
		return ant;
	}

	public void setAnt(Nodo<T> ant) {
		this.ant = ant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dados == null) ? 0 : dados.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo<T> other = (Nodo<T>) obj;
		if (dados == null) {
			if (other.dados != null)
				return false;
		} else if (!dados.equals(other.dados))
			return false;
		return true;
	}
}
