package br.com.senacrs.ap3.modelo;

import java.util.ArrayList;
import java.util.Stack;

public class Nodo {
	private Nodo esquerda; 
	private Nodo direita; 
	private int dados;
	private ArrayList<Integer> arr = new ArrayList<Integer>();
	private Stack<Nodo> pilha = new Stack<Nodo>();

	public Nodo(int novoDado) { 
		this.esquerda = null; 
		this.direita = null; 
		this.dados = novoDado; 
	}

	public Nodo getEsq() {
		return esquerda;
	}

	public void setEsq(Nodo esquerda) {
		this.esquerda = esquerda;
	}

	public Nodo getDir() {
		return direita;
	}

	public void setDir(Nodo direita) {
		this.direita = direita;
	}

	public int getDados() {
		return dados;
	}

	public void setDados(int dados) {
		this.dados = dados;
	} 

	public ArrayList<Integer> emOrdem(Nodo nodo){
		if (nodo != null) {
			emOrdem(nodo.getEsq());
			//Store in an array
			arr.add(nodo.getDados());
			emOrdem(nodo.getDir());
		}
		return arr;
	}	
	
	public void preOrdem(Nodo nodo){
		while(true){
			while(nodo != null){
				System.out.print(nodo.getDados()+" ");
				pilha.push(nodo); 
				nodo = nodo.getEsq();
			}
			if(pilha.empty())
				break;
			
			nodo = ((Nodo)pilha.peek()).getDir();
			pilha.pop();
			
		}
		System.out.println();
	}

	public void posOrdem(Nodo nodo){

		while(true){
			pilha.push(nodo);
			while(!pilha.isEmpty()){
				Nodo proximo = (Nodo) pilha.peek();
				if (proximo.getDir() == nodo || proximo.getEsq() == nodo ||(proximo.getEsq() == null && proximo.getDir() == null)) {
					pilha.pop();
					System.out.print(proximo.getDados()+" ");
					nodo = proximo;
				}else{
					if (proximo.getDir() != null) {
						pilha.push(proximo.getDir());
					}
					if (proximo.getEsq() != null)
						pilha.push(proximo.getEsq());
				}
			}
			if(pilha.empty())
				break;
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "(" + this.getDados();
	}
}
