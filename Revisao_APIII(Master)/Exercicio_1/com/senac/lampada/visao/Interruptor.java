package com.senac.lampada.visao;

import static java.lang.System.out;

import com.senac.lampada.controle.Modifica;

public class Interruptor {
	
	public void main (String[] args){
		Modifica interruptor = new Modifica();
		interruptor.menu();
		out.println("Lâmpada desligada");
	}

}
