package controle;

public class FuncoesHeapSort {

	private static int[] a; 
	private static int n;
	private int aux; 
	private static int esquerdo; 
	private static int direito; 
	private static int maior;
	
	public int getAux() {
		return aux;
	}

	public void setAux(int aux) {
		this.aux = aux;
	}

	public  void criaHeap(int[] vetor){ 
		n = vetor.length - 1; 
		for(int i = n/2; i >= 0; i--){
			maxHeap(vetor, i); 
		} 
	} 

	public void maxHeap(int[] vetor, int i){ 
		esquerdo = 2 * i; 
		direito = 2 * i + 1; 
		
//		maior = esquerdo <= n && vetor[esquerdo] > vetor[i] ? esquerdo : i;
		
		if(esquerdo <= n && vetor[esquerdo] > vetor[i]){
			maior = esquerdo;
			setAux(aux++);
		}else{
			maior = i;
			aux++;
		}
		if(direito <= n && vetor[direito] > vetor[maior]){ 
			maior = direito; 
			setAux(aux++);
		} 
		if(maior != i){ 
			troca(i,maior); 
			maxHeap(vetor, maior); 
			setAux(aux++);
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
