package controle;

import modelo.Matriz;

public class FuncoesMatriz {

	Matriz matriz = new Matriz();

	public void imprimeMatriz(){
		int i = 0;
				
		for (int x = 0; x < matriz.getMatriz().length; x++)
			for (int y = 0; y < matriz.getMatriz()[x].length; y++){
				matriz.getMatriz()[x][y] = '.';
			}

		for (int x = 0; x < matriz.getMatriz().length; x++){
			
			String imprime = x > 0 ? x+"\t" : "\t";
			System.out.print(imprime);
			
			for (int y = 0; y < matriz.getMatriz()[x].length; y++){
				
				imprime = i < 10 ? (char)(65+y)+"\t" : matriz.getMatriz()[x][y]+"\t";
				System.out.print(imprime);
				i++;
			}
			System.out.println("");
		}

	}

}
