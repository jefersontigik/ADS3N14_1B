package controle;

public class FuncoesSelectionSort {

	private int troca;
	private int compara;
	private int aux1 = 0;
	private int aux2 = 0;
	
	
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


	public void SelectionSort(int[] vetor){
		
		for(int i = 0; i < vetor.length; i++){
			
			for(int j = i + 1; j < vetor.length; j++){
				
				setCompara(aux1++);
				
				if(vetor[i] > vetor[j] ){
					setTroca(aux2++);
					int temp = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = temp;
				}
			}
		}
	}
}

