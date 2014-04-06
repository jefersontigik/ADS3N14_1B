package visao;

import static java.lang.System.out;
import java.util.Scanner;
import controle.FuncoesHeapSort;
import controle.FuncoesSelectionSort;

public class OrdenacaoTela {
	private int n, i;
	private String imprime;
	
	public String imprime(){
		
		FuncoesHeapSort heap = new FuncoesHeapSort();
		FuncoesSelectionSort select = new FuncoesSelectionSort();
		Scanner ler = new Scanner(System.in);
		out.println("Informe o tamanho do vetor: ");
		
		out.println("Entre o numero de elementos inteiros:");
        n = ler.nextInt();
        
        /**
         * Cria o vetor com n elementos 
         */
        int vetor1[] = new int[ n ];
        int vetor2[] = new int[ n ];
        /**
         * Recebe os elementos
         */
        out.println("\nEntre com "+ n +" elementos inteiros: ");
        for (i = 0; i < n; i++)
        	vetor2[i] = vetor1[i] = ler.nextInt();
        	
        /**
         * Acessa os elementos.
         */
        heap.sort(vetor1);
        select.SelectionSort(vetor2);
        /**
         * Imprime o vetor ordenado
         */
        out.println("\nElementos após a ordenação: ");        
        for (i = 0; i < n; i++){
        	if(i < n -1)
        		out.print(vetor1[i]+" - ");
        	else
        		out.print(vetor1[i]);
        }
        	
        
        imprime = "\nTotal de trocas Heap Sort: "+heap.getTroca()+"\n" +
        "Total de comparações Heap Sort: "+heap.getCompara()+"\n" +
        "Total de trocas Selection Sort: " + select.getTroca()+"\n" +
        "Total de comparações Selection Sort: " + select.getCompara()+"\n"; 
        
		return imprime;
	}
}
