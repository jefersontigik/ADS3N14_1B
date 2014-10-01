package controle;

import modelo.Matriz;

public class FuncoesJogador {

	public Matriz tiro(Matriz matrizPalavras, int x, int y){
		if(matrizPalavras.getMatriz()[x][y] == 2){
			matrizPalavras.getMatriz()[x][y] = 1;
		}else{
			matrizPalavras.getMatriz()[x][y] = 0;
		}
		return matrizPalavras;
	}

	public int  atualizaContagem(boolean acertou, int i){
		return i += acertou ? 1 : -1; 
	}
}
//out.println("Tiros restantes: "+ i+"\n\n");
