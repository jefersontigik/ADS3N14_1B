package br.com.senacrs.ap3.visao;

import java.util.ArrayList;

import br.com.senacrs.ap3.modelo.Abp;
import br.com.senacrs.ap3.modelo.Nodo;

public class AppABP {

	public static void main(String[] args) {
		Nodo raiz = new Nodo(1);
//		Nodo raiz = new Nodo(8);
//		Nodo raiz = new Nodo(5);
//		Nodo raiz = new Nodo(2);
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	   
	    Abp abp = new Abp(raiz);
	    
	    System.out.println("Construindo árvore com valor Raiz " + raiz.getDados());
	    
	    abp.inserir(abp.getRaiz(), 2);
	    abp.inserir(abp.getRaiz(), 3);
	    abp.inserir(abp.getRaiz(), 4);
	    abp.inserir(abp.getRaiz(), 8);
	    abp.inserir(abp.getRaiz(), 5);
	    abp.inserir(abp.getRaiz(), 7);
	    abp.inserir(abp.getRaiz(), 6);

	    
//	    abp.inserir(abp.getRaiz(), 5);
//	    abp.inserir(abp.getRaiz(), 3);
//	    abp.inserir(abp.getRaiz(), 6);
//	    abp.inserir(abp.getRaiz(), 9);
	    
//	    abp.inserir(abp.getRaiz(), 2);
//	    abp.inserir(abp.getRaiz(), 7);
//	    abp.inserir(abp.getRaiz(), 3);
//	    abp.inserir(abp.getRaiz(), 8);
//	    abp.inserir(abp.getRaiz(), 1);
//	    abp.inserir(abp.getRaiz(), 4);
//	    abp.inserir(abp.getRaiz(), 6);
//	    
//	    abp.inserir(abp.getRaiz(), 2);
//	    abp.inserir(abp.getRaiz(), 3);
//	    abp.inserir(abp.getRaiz(), 5);
//	    abp.inserir(abp.getRaiz(), 4);
	    
	    System.out.println("Imprimindo Árvore final:");
	    abp.imprimeArvore(abp.getRaiz());
	    System.out.println();
	    
	    System.out.println("Imprimindo Árvore em Ordem:");
	    abp.imprimeArvoreEmOrdem(abp.getRaiz());
	    System.out.println();
	    
	    System.out.println("Imprimindo Árvore em PósOrdem:");
	    abp.imprimeArvorePosOrdem(abp.getRaiz());
	    System.out.println();
	    
	    System.out.println("Imprimindo caminhamento em ordem:");
	    arr = raiz.emOrdem(abp.getRaiz());	  
	    for(int i = 0; i < arr.size(); i++){
	    	System.out.print(arr.get(i)+" ");
	    }
	    System.out.println();
	    
	    System.out.println("Imprimindo caminhamento pré-ordem:");
	    raiz.preOrdem(abp.getRaiz());
	    
	    System.out.println("Imprimindo caminhamento pós-ordem:");
	    raiz.posOrdem(abp.getRaiz());
	    
	    System.out.println("Imprimindo todos caminhos da Raiz até a folha:");
	    abp.imprimeTodosCaminhosRaizAteFolha(abp.getRaiz(), new ArrayList<Integer>());
	    
	    System.out.println("Altura da árvore é: ");
	    System.out.println(abp.altura(abp.getRaiz()));
	    
	    System.out.println("FB da árvore é: ");
	    System.out.println(abp.fatorBalanceamento(abp.getRaiz()));
	    
	    System.out.println("Soma máxima de caminhos da raiz à folha");
	    System.out.println( abp.somaMaxRaizAteFolha(abp.getRaiz()) );
	    
	    System.out.println("Diâmetro da árvore é:");
	    System.out.println( abp.diametro(abp.getRaiz()) );
	    
	    System.out.println("Soma máxima de caminhos entre quaisquer dois nodos:");
	    System.out.println( abp.somaMaxCaminho(abp.getRaiz()) );
	}

}
