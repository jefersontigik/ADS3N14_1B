package controle;

public class FuncoesHeapSort {

	private static int[] a; 
	private static int n; 
	private static int esquerdo; 
	private static int direito; 
	private static int largura;

	public  void criaHeap(int[] vetor){ 
		n = vetor.length - 1; 
		for(int i = n/2; i >= 0; i--){
			maxHeap(vetor, i); 
		} 
	} 

	public void maxHeap(int[] vetor, int i){ 
		esquerdo = 2 * i; 
		direito = 2 * i + 1; 
		
		largura = esquerdo <= n && vetor[esquerdo] > vetor[i] ? esquerdo : i;

		if(direito <= n && vetor[direito] > vetor[largura]){ 
			largura = direito; 
		} 
		if(largura != i){ 
			troca(i,largura); 
			maxHeap(vetor, largura); 
		} 
	} 

	public void troca(int i, int j){ 
		int t = a[i]; 
		a[i] = a[j]; 
		a[j] = t; 
	} 

	public void sort(int[] vetor){ 
		a = vetor; 
		criaHeap(a); 
		for(int i = n; i > 0; i--){
			troca(0, i); 
			n--;
			maxHeap(a, 0); 
		} 
	}
}
