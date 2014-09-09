package com.br.senacrs.ap3.controle;

import java.util.Comparator;
import com.br.senacrs.ap3.modelo.Agenda;

public class Ordenador implements Comparator<Agenda>{

	@Override
	public int compare(Agenda ag1, Agenda ag2) {
		
		return ag1.getNome().compareTo(ag2.getNome());
	}
	
	public int comparaObj(Agenda atual, Agenda alvo){
		if(alvo.getNome().equals(atual))
			return 1;
		else
			return -1;
	}

}
