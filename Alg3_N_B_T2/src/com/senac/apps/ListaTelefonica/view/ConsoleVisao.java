package com.senac.apps.ListaTelefonica.view;

import static java.lang.System.out;

import java.util.Scanner;

public class ConsoleVisao {

	private Scanner teclado = new Scanner(System.in);

	public void mensagem(String message) {
		out.println(message);
	}

	public String ler(String tela) {
		out.print(tela+": ");
		return teclado .nextLine();
	}
	
	public void imprimeContato(String nome, String telefone) {
		mensagem("Nome: " + nome);
		mensagem("Telefone: " + telefone);
	}

	public void erroLog(String mensagem) {
		mensagem("Erro: " + mensagem);
	}

}
