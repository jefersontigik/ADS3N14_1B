package controle;

import modelo.Matriz;

public class FuncoesJogador {

	public Matriz tiro(Matriz matrizNaval, int x, int y){
		if(matrizNaval.getMatriz()[x][y] == 2){
			matrizNaval.getMatriz()[x][y] = 1;
		}else{
			matrizNaval.getMatriz()[x][y] = 0;
		}
		return matrizNaval;
	}

	public int  atualizaContagem(boolean acertou, int i){
		return i += acertou ? 1 : -1; 
	}
}
//out.println("Tiros restantes: "+ i+"\n\n");
