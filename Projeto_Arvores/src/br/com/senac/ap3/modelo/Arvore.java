package br.com.senac.ap3.modelo;

public class Arvore <T>{
	private Nodo<T> raiz;
	private int ordem;
	
	public Arvore(int ordem){
		this.ordem = ordem;
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}
	
	public Nodo<T> criaNodo(){
		return new Nodo<T>(this.ordem);
	}
}
