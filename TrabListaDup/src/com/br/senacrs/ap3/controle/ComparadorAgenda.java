package com.br.senacrs.ap3.controle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.br.senacrs.ap3.modelo.Agenda;


public class ComparadorAgenda implements Comparator<Agenda>{
	
	public int compare(Agenda p1, Agenda p2) { 
		{ 
			int res = 0; 
			if (p1.getNome().compareTo(p2.getNome()) < 0) 
				res = -1; 
			if (p1.getNome().compareTo(p2.getNome()) == 1) 
				res = 1; 
			return res; 
		} 
	} 

	public static Agenda PesquisarPorNome(ArrayList<Agenda> ListaASerPesquisada, String chave){ 		 
		Collections.sort(ListaASerPesquisada , new ComparadorAgenda()); 
		Agenda ag = new Agenda(); 
		ag.setNome(chave);  
		int ResultIndex = Collections.binarySearch(ListaASerPesquisada, ag, new ComparadorAgenda()); 
		if (ResultIndex > -1){ 
			return ag; 
		}else { 
			return null; 
		} 
	} 
}
