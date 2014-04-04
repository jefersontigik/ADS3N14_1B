package visao;

import static java.lang.System.out;

import java.util.Scanner;

import controle.FuncoesEmbarcacoes;
import controle.FuncoesJogador;
import controle.FuncoesMatriz;
import modelo.Matriz;

public class Tela {
	int i;
	String opcao;
	Matriz matrizNaval = new Matriz();
	FuncoesMatriz funcMatriz = new FuncoesMatriz();
	FuncoesJogador jogador = new FuncoesJogador();

	public String menuInicioUser(){

		out.println("Informe a opção desejada:"
				+ "\n 1 - Iniciar" + "\n 2 - Encerrar");
		return opcao = new Scanner(System.in).next();
	}

	public String menuJogoUser(){

		out.println("Informe a opção desejada:"
				+ "\n 1 - Atirar" + "\n 2 - Encerrar");
		return opcao = new Scanner(System.in).next();
	}

	public String coordX(){

		out.println("Informe a coordenada X:");
		return opcao = new Scanner(System.in).next();
	}
	
	public String coordY(){

		out.println("Informe a coordenada Y:");
		return opcao = new Scanner(System.in).next();
	}

	public void posicionaBarcos(){

		FuncoesEmbarcacoes funcEmbarc = new FuncoesEmbarcacoes();

		funcMatriz.preencheMatriz(matrizNaval);
		//		System.out.println(funcMatriz.imprimeMatriz(matrizNaval));

		/**
		 * Porta-Avioes
		 */
		funcEmbarc.posicionaEmbarcacao(matrizNaval, 5);

		/**
		 * Destroyer
		 */
		i = 0;
		do{
			funcEmbarc.posicionaEmbarcacao(matrizNaval, 4);
			i++;
		}while(i < 2);

		/**
		 * Fragata
		 */
		i = 0;
		do{
			funcEmbarc.posicionaEmbarcacao(matrizNaval, 3);
			i++;
		}while(i < 2);

		/**
		 * Torpedeiro
		 */
		i = 0;
		do{
			funcEmbarc.posicionaEmbarcacao(matrizNaval, 2);
			i++;
		}while(i < 3);

		/**
		 * Submarino
		 */
		i = 0;
		do{
			funcEmbarc.posicionaEmbarcacao(matrizNaval, 1);
			i++;
		}while(i < 5);

		out.println(funcMatriz.imprimeMatriz(matrizNaval));
	}

	public void jogo(int a, int b){
		int i = 5;
		do{
			out.println(funcMatriz.imprimeMatriz(jogador.tiro(matrizNaval, a, b)));
			i--;
		}while(i > 0);
	}
	
	public void mostraContagem(int a, int b){
//		jogador.atualizaContagem(a, b);
	}
}
