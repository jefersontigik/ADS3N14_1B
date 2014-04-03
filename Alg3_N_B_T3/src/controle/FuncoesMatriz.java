package controle;

import java.util.Random;
import modelo.Matriz;

public class FuncoesMatriz {

	public void preencheMatriz(Matriz matrizNaval){

		for (int x = 0; x < matrizNaval.getMatriz().length; x++)
			for (int y = 0; y < matrizNaval.getMatriz()[x].length; y++){
				matrizNaval.getMatriz()[x][y] = -1;
			}
	}
	
	public String imprimeMatriz(Matriz matrizNaval){

		String imprime = "\tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ \n";
		
		for (int x = 0; x < matrizNaval.getMatriz().length; x++){
			
			imprime += x >= 0 ? x+"\t" : "\t";
			
			for (int y = 0; y < matrizNaval.getMatriz()[x].length; y++){
				
				if(matrizNaval.getMatriz()[x][y] == -1 /*|| matrizNaval.getMatriz()[x][y] == -2*/)
					imprime += ".\t";
				else if(matrizNaval.getMatriz()[x][y] == 0)
					imprime += "-\t";
				else if(matrizNaval.getMatriz()[x][y] == 1)
					imprime += "O\t";
				else if(matrizNaval.getMatriz()[x][y] == 2)
					imprime += "#\t";
			}
			imprime += "\n";
		}
		return imprime;
	}

	public void alteraMatriz(Matriz matrizNaval){

		Random hor = new Random();
		Random vert = new Random();

		for (int x = 0; x < matrizNaval.getMatriz().length; x++){

			for (int y = 0; y < matrizNaval.getMatriz()[x].length; y++){
				
				if(y%2 == 0 && matrizNaval.getMatriz()[x][y] == -1)
					matrizNaval.getMatriz()[vert.nextInt(10)][hor.nextInt(10)] = 0;
				else
					matrizNaval.getMatriz()[vert.nextInt(10)][hor.nextInt(10)] = 1;
			}
		}
	}
}
