package br.com.ap3.visao;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ap3.controle.ManipulaTabua;

public class funcoesApp {
	static ArrayList<String> palavra;
	
	public ArrayList<String> funcoes(int x, int y){
		String linha = "";
		Scanner ler = new Scanner(System.in);
		Menu tela = new Menu();
		
		if(tela.menuInicioUser().equalsIgnoreCase("1")){
			palavra = new ArrayList<String>();
			
			do{
				System.out.println("Informe uma palavra (Digite 'Gerar' para criar a Matriz)");
				linha = ler.next();
				
				if(!linha.equalsIgnoreCase("Gerar"))
					palavra.add(linha);
				
			}while(!linha.equalsIgnoreCase("Gerar"));
		}else{
			palavra = new ArrayList<String>();
			ManipulaTabua lista = new ManipulaTabua(palavra,x,y);
			
			for (String plv : lista.carregaLista()) {
				palavra.add(plv);
			}
		}
		return palavra;
	}
}
