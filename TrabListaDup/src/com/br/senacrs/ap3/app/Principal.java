package com.br.senacrs.ap3.app;

import com.br.senacrs.ap3.controle.ListaOrdenada;
import com.br.senacrs.ap3.modelo.Agenda;
import com.br.senacrs.ap3.modelo.Lista;

public class Principal {
	
	public static void main(String[] args){
		Lista<Agenda> lista = new Lista<Agenda>();
		ListaOrdenada<Agenda> listaOrdem = new ListaOrdenada<Agenda>();
				
//		lista = listaOrdem.ordenaLista();
		lista = listaOrdem.listaIndexada();
		System.out.println(lista.toString());
	}

}
