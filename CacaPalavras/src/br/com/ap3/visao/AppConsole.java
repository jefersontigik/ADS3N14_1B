package br.com.ap3.visao;

import java.util.ArrayList;
import br.com.ap3.controle.ManipulaTabua;

public class AppConsole {
	
	static int x = 15;
	static int y = 15;
	static ManipulaTabua tabuleiro;
	static ArrayList<String> palavras;
	
	public static void main(String[] args){
		
		palavras = new funcoesApp().funcoes(x, y);
		tabuleiro = new ManipulaTabua(palavras,x,y);
		tabuleiro.geraMatriz(palavras,x,y);
	}		
}
