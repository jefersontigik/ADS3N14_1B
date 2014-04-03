package controle;

import modelo.Matriz;

public class FuncoesJogador {

	public void tiro(Matriz matrizNaval, int x, int y){
		if(matrizNaval.getMatriz()[x][y] == 2){
			matrizNaval.getMatriz()[x][y] = 1;
		}else{
			matrizNaval.getMatriz()[x][y] = 0;
		}
	}
}

