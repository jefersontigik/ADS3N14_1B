package br.com.senac.ap3.modelo;

public class Nodo<T> {
	private T dado;
	private Nodo<T> anterior;
	private Nodo<T> filhos[];
	private int numeroFilhos;
	
	public Nodo(int ordem){
		dado = null;
		anterior = null;
		numeroFilhos = 0;
		filhos = new Nodo[ordem];
	}

	public Nodo(T chave) {
		this.dado = chave;
		this.filhos = null;
	}

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public Nodo<T>[] getFilhos() {
		return filhos;
	}

	public void setFilhos(Nodo<T>[] filhos) {
		this.filhos = filhos;
	}

	public Nodo<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}
	
	public void addFilho(Nodo<T> filho){
		if(numeroFilhos != filhos.length){
			filhos[numeroFilhos] = filho;
			numeroFilhos++;
		}
		
	}
	
	public void removeFilho(int indice){
		if(indice < numeroFilhos){
			numeroFilhos --;
		}
	}
	
	public Nodo<T> getFilho(int indice){
		
		if(indice < numeroFilhos){
			return filhos[indice];
		}
		
		return null;
	}
}