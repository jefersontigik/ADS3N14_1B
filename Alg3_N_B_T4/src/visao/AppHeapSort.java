package visao;

import java.util.Scanner;

import controle.FuncoesHeapSort;
import static java.lang.System.out;

public class AppHeapSort {
	
	
	
	public static void main(String[] args) 
	{
		FuncoesHeapSort heap = new FuncoesHeapSort();
		Scanner ler = new Scanner(System.in);
		out.println("Informe o tamanho do vetor: ");
		
		int n, i;    
        /**
         *  Número de elementos 
         */
        out.println("Entre o numero de elementos inteiros:");
        n = ler.nextInt();    
        /**
         * Cria o vetor com n elementos 
         */
        int vetor[] = new int[ n ];
        /**
         * Recebe os elementos
         */
        out.println("\nEntre elementos "+ n +" de inteiros: ");
        for (i = 0; i < n; i++)
        	vetor[i] = ler.nextInt();
        /**
         * Acessa os elementos.
         */
        heap.sort(vetor);
        /**
         * Imprime o vetor ordenado
         */
        out.println("\nElementos após a ordenação: ");        
        for (i = 0; i < n; i++)
        	out.print(vetor[i]+" ");
        
        out.print("Total de trocas e comparações: "+heap.getAux());  
        out.println();
	}
}
