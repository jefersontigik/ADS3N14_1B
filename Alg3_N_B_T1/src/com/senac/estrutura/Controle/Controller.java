package com.senac.estrutura.Controle;

import com.senac.estrutura.Visao.ConsoleView;
import com.senac.estrutura.Modelo.ListaOrdenada;
import com.senac.estrutura.Modelo.NodoGen;

public class Controller {
	
	private ListaOrdenada<Integer>
			lista = new ListaOrdenada<Integer>();
	private ConsoleView view = new ConsoleView();
	
	public void iniciaLista() {
		for (int i = 0; i < 50; ++i) {
			NodoGen<Integer> novo = new NodoGen<Integer>();
			novo.setData((int)(Math.random() * 10000));
			lista.insert(novo);
		}
	}
	
	public void imprimeLista() {
		NodoGen<Integer> nodo = lista.getHead();
		while (nodo != null) {
			view.imprimeInteiro(nodo.getData());
			nodo = nodo.getNext();
		}
	}
	
}









