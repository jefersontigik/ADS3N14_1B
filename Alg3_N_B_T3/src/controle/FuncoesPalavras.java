package controle;

import java.util.Random;

import modelo.Palavra;
import modelo.Matriz;

public class FuncoesPalavras {

	Palavra palavra = new Palavra();
	Random vert, hor;
	int x, y;
	
	public void posicionaPalavra(Matriz matrizPalavras, int tam){
		palavra.setPalavra(tam);
		boolean res = false;
		do{
			vert = new Random();
			hor = new Random();
			
			x = vert.nextInt(10);
			y = hor.nextInt(10);
			
			if((y + palavra.getPalavra() <= matrizPalavras.getMatriz().length) || matrizPalavras.getMatriz()[x][y] == 2){
				for(int i = 0; i < palavra.getPalavra(); i++){
					matrizPalavras.getMatriz()[x][y+i] = 2;
					res = true;
				}
			}
		}while(!res);

	}
}
