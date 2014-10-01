package br.com.ap3.visao;

import static java.lang.System.out;

import java.util.Scanner;

public class Menu {
	
	int i;
	String opcao;

	public String menuInicioUser(){

		out.println("Informe a opção desejada:"
				+ "\n 1 - Digitar Palavras" + "\n 2 - Carregar arquivo de palavras");
		return opcao = new Scanner(System.in).next();
	}

}
