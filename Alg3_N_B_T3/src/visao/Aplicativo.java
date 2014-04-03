package visao;

import modelo.Matriz;
import controle.FuncoesEmbarcacoes;
import controle.FuncoesMatriz;

public class Aplicativo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Matriz matrizNaval = new Matriz();
		FuncoesMatriz funcMatriz = new FuncoesMatriz();
		FuncoesEmbarcacoes funcEmbarc = new FuncoesEmbarcacoes();
		
		funcMatriz.preencheMatriz(matrizNaval);
		System.out.println(funcMatriz.imprimeMatriz(matrizNaval));
		funcEmbarc.posicionaPortaAviao(matrizNaval);
		System.out.println(funcMatriz.imprimeMatriz(matrizNaval));

	}
}
