package com.senac.estrutura.Visao;

import com.senac.estrutura.Visao.VisaoRegistro;

public class Aplicativo {

	public static void main(String[] args) {

		VisaoRegistro visao = new VisaoRegistro();

		do {

			switch (visao.MontaMenu()) {
				
			case '1':
				
				visao.InsereRegistro();
				
				break;

			case '2':

				break;
			case '3':
				
				visao.ListaTodos();
				
				break;

			case '4':
//				Para procurar registros
//				for (ListaTel ag : nodo) {
//					if (ag.getNome().equalsIgnoreCase(nome)) {
//						out.println("Nome: " + ag.getNome() + "\n Fone: "
//										+ ag.getFone());
//					}
//				}
				break;

			case '5':
				System.out.println("Fim programa");
			}

		} while (visao.MontaMenu() != '5');

	}
}
