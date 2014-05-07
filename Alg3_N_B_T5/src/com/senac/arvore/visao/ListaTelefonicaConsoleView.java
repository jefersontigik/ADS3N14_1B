package com.senac.arvore.visao;

import com.senac.arvore.visao.ConsoleView;

public class ListaTelefonicaConsoleView
			extends ConsoleView
{

	public void printContato(String nome, String telefone) {
		showMessage("Nome: " + nome);
		showMessage("Telefone: " + telefone);
	}

}
