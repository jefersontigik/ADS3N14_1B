package com.senac.estrutura.Visao;

import com.senac.estrutura.Visao.VisaoRegistro;

public class Aplicativo {

	
	public static void main(String[] args) {
		VisaoRegistro visao = new VisaoRegistro();
		char opcao = visao.montaMenu().charAt(0);
		visao.carregaLista();
		
		do {
			opcao = visao.montaMenu().charAt(0);
			switch (opcao) {
				
			case '1':
				
				visao.insereRegistro();
				
				break;

			case '2':

				break;
			case '3':
				
				visao.listaTodos();
				
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
				System.exit(0);
				break;
				
			default:
				System.out.println("Opcao Inexistente");
			}

		} while (opcao != '5');

	}
}
