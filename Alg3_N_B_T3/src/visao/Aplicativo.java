package visao;

import controle.FuncoesMatriz;

public class Aplicativo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FuncoesMatriz funcMatriz = new FuncoesMatriz();
		
//		funcMatriz.preencheMatriz();
//		funcMatriz.imprimeMatrizVisual();
		funcMatriz.alteraMatriz();
		funcMatriz.imprimeMatrizNaval();

	}
}
