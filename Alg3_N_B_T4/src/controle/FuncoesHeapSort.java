package controle;

public class FuncoesHeapSort {

	private int[] a; 
	private int n;
	private int esquerdo; 
	private int direito; 
	private int maior;
	private int aux1 = 0;
	private int aux2 = 0;
	private int troca;
	private int compara;
	
	
	public int getTroca() {
		return troca;
	}

	public void setTroca(int troca) {
		this.troca = troca;
	}

	public int getCompara() {
		return compara;
	}

	public void setCompara(int compara) {
		this.compara = compara;
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
		setCompara(aux1++);
		if(esquerdo <= n && vetor[esquerdo] > vetor[i]){
			setTroca(aux2++);
			maior = esquerdo;
		}else{
			setTroca(aux2++);
			maior = i;
		}
		setCompara(aux1++);
		if(direito <= n && vetor[direito] > vetor[maior]){ 
			setTroca(aux2++);
			maior = direito; 
		} 
		setCompara(aux1++);
		if(maior != i){ 
			setTroca(aux2++);
			troca(i,maior); 
			maxHeap(vetor, maior); 
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
