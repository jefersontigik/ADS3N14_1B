package controle;

import java.util.Random;

import modelo.Matriz;

public class FuncoesMatriz {

	Matriz matrizVisual = new Matriz();
	Matriz matrizNaval = new Matriz();

	public void preencheMatriz(Matriz matriz){

		for (int x = 0; x < matriz.getMatriz().length; x++)
			for (int y = 0; y < matriz.getMatriz()[x].length; y++){
				matriz.getMatriz()[x][y] = ".";
			}
	}

	public void imprimeMatrizVisual(){
		preencheMatriz(matrizVisual);
		int i = 0;

		for (int x = 0; x < matrizVisual.getMatriz().length; x++){

			String imprime = x > 0 ? x+"\t" : "\t";
			System.out.print(imprime);

			for (int y = 0; y < matrizVisual.getMatriz()[x].length; y++){

				imprime = i < 10 ? (char)(65+y)+"\t" : matrizVisual.getMatriz()[x][y]+"\t";
				System.out.print(imprime);
				i++;
			}
			System.out.println("");
		}

	}

	public void imprimeMatrizNaval(){

		int i = 0;

		for (int x = 0; x < matrizNaval.getMatriz().length; x++){

			String imprime = x > 0 ? x+"\t" : "\t";
			System.out.print(imprime);

			for (int y = 0; y < matrizNaval.getMatriz()[x].length; y++){

				imprime = i < 10 ? (char)(65+y)+"\t" : matrizNaval.getMatriz()[x][y]+"\t";
				System.out.print(imprime);
				i++;
			}
			System.out.println("");
		}

	}

	public void alteraMatriz(){

		preencheMatriz(matrizNaval);

		Random hor = new Random();
		Random vert = new Random();

		for (int x = 0; x < matrizVisual.getMatriz().length; x++){

			for (int y = 0; y < matrizVisual.getMatriz()[x].length; y++){
				
				if(y%2 == 0 && matrizNaval.getMatriz()[x][y].equals("."))
					matrizNaval.getMatriz()[vert.nextInt(10)][hor.nextInt(10)] = "O";
				else
					matrizNaval.getMatriz()[vert.nextInt(10)][hor.nextInt(10)] = "-";
			}
		}
	}
}
