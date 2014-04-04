package controle;

public class FuncoesHeapSort {

	private int n;
	
	public int esquerdo(int i){

		return 2 * i;
	}

	public int direito(int i){

		return 2 * i + 1;
	}

	public void heapSort(int vetor[]){

		criaMaxHeap(vetor);

		n = vetor.length;

		for(int i = n - 1; i > 0; i-- ){

		}
	}

	public void criaMaxHeap(int vetor[]){
		for(int i = vetor.length / 2 - 1; i >= 0; i--)
			maxHeap(vetor, vetor.length);
	}

	public void maxHeap(int vetor[], int i){
		int e = esquerdo(i);
		int d = direito(i);
		
		int max = i;
        if (e <= n && vetor[e] > vetor[i])
            max = e;
        if (d <= n && vetor[d] > vetor[max])        
            max = d;
 
        if (max != i)
        {
        	trocar(vetor, i, max);
            maxHeap(vetor, max);
        }
	}

	public void trocar(int[] vetor, int j, int aposJ){

		int aux = 0;
		aux = vetor[j];
		vetor[j] = vetor[aposJ];
		vetor[aposJ] = aux;
	}

}
