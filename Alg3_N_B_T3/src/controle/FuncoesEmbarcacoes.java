package controle;

import java.util.Random;

import modelo.Embarcacao;
import modelo.Matriz;

public class FuncoesEmbarcacoes {

	Embarcacao barcos = new Embarcacao();
	Random vert, hor;
	int x, y;
	
	public void posicionaEmbarcacao(Matriz matrizNaval, int tam){
		barcos.setBarco(tam);
		boolean res = false;
		do{
			vert = new Random();
			hor = new Random();
			
			x = vert.nextInt(10);
			y = hor.nextInt(10);
			
			if((y + barcos.getBarco() <= matrizNaval.getMatriz().length) || matrizNaval.getMatriz()[x][y] == 2){
				for(int i = 0; i < barcos.getBarco(); i++){
					matrizNaval.getMatriz()[x][y+i] = 2;
					res = true;
				}
			}
		}while(!res);

	}
}
