package visao;

import static java.lang.System.out;

import java.util.Scanner;

import controle.FuncoesPalavras;
import controle.FuncoesJogador;
import controle.FuncoesMatriz;
import modelo.Matriz;

public class Tela {
	int i;
	String opcao;
	Matriz matrizPalavras = new Matriz();
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

	public void posicionaPalavras(){

		FuncoesPalavras funcPal = new FuncoesPalavras();

		funcMatriz.preencheMatriz(matrizPalavras);
		//		System.out.println(funcMatriz.imprimeMatriz(matrizNaval));

		/**
		 * Porta-Avioes
		 */
		funcPal.posicionaPalavra(matrizPalavras, 5);

		/**
		 * Destroyer
		 */
		i = 0;
		do{
			funcPal.posicionaPalavra(matrizPalavras, 4);
			i++;
		}while(i < 2);

		/**
		 * Fragata
		 */
		i = 0;
		do{
			funcPal.posicionaPalavra(matrizPalavras, 3);
			i++;
		}while(i < 2);

		/**
		 * Torpedeiro
		 */
		i = 0;
		do{
			funcPal.posicionaPalavra(matrizPalavras, 2);
			i++;
		}while(i < 3);

		/**
		 * Submarino
		 */
		i = 0;
		do{
			funcPal.posicionaPalavra(matrizPalavras, 1);
			i++;
		}while(i < 5);

		out.println(funcMatriz.imprimeMatriz(matrizPalavras));
	}

	public void jogo(int a, int b){
		int i = 5;
		do{
			out.println(funcMatriz.imprimeMatriz(jogador.tiro(matrizPalavras, a, b)));
			i--;
		}while(i > 0);
	}
	
	public void mostraContagem(int a, int b){
//		jogador.atualizaContagem(a, b);
	}
}
