package com.br.senacrs.ap3.aplicacao;

import com.br.senacrs.ap3.ES.Teclado;
import com.br.senacrs.ap3.estruturas.Grafo;
import com.br.senacrs.ap3.estruturas.Vertice;

public class AplicacaoDijkstra {
	
	public static void main(String arg[]) {

		Grafo inicial = new Grafo();
		Grafo resultado = new Grafo();		
		Vertice verticeAux1, verticeAux2;
		int opcao = 5;
		
		
		while(opcao!=0){
			System.out.println("1 - Adiciona vertices e arestas");
			System.out.println("2 - Obter menor caminho de Dijkstra");
			System.out.println("0 - Encerra");
			
			opcao = Teclado.lerInteiro();
			resultado.limpaListas();
			inicial.limparArestaVisitada();
			inicial.limparVerticeVisitado();
			
			switch (opcao){
			case 1:
				inicial.criarGrafo();
				
				inicial.imprimeArvore();
				break;
			
			case 2:
				System.out.println("Informe origem:");
				verticeAux1 = inicial.acharVertice(Teclado.readString());
				System.out.println("Informe destino:");
				verticeAux2 = inicial.acharVertice(Teclado.readString());
				resultado.setVertices(inicial.encontrarMenorCaminhoDijkstra(verticeAux1, verticeAux2));
				System.out.println("Menor Caminho:");
				System.out.println(resultado.getVertices());
				
				System.out.println("Custo total do caminho:");
				System.out.println(inicial.exibirCustoTotal()+" metros.");
				break;
				
			case 0:
				break;
			default:
				System.out.println("Opcao Invalida");
				break;
			}
			
		}
	}
}
