package controle;

import java.util.Random;

import modelo.Embarcacao;
import modelo.Matriz;

public class FuncoesEmbarcacoes {

	Embarcacao barcos = new Embarcacao();
	private int posicaoIni;
	Random vert, hor;
	int x, y;
	
	public int getPosicaoIni() {
		return posicaoIni;
	}

	public void setPosicaoIni(int posicaoIni) {
		this.posicaoIni = posicaoIni;
	}
	
	public void posicionaPortaAviao(Matriz matrizNaval){
		boolean res = false;
		do{
			vert = new Random();
			hor = new Random();
			
			x = vert.nextInt(10);
			y = hor.nextInt(10);
			
			if((y + Embarcacao.getPorta_aviao() <= matrizNaval.getMatriz().length) || matrizNaval.getMatriz()[x][y] == 2){
				for(int i = 0; i < Embarcacao.getPorta_aviao(); i++){
					matrizNaval.getMatriz()[x][y+i] = 2;
//					matrizNaval.setMatriz(x, i, 2);
					res = true;
				}
			}
		}while(!res);

	}
	
	public void posicionaDestroyer(Matriz matrizNaval){
		matrizNaval.getMatriz()[vert.nextInt(10)][y] = 0;
	}
	
	public void posicionaFragata(Matriz matrizNaval){
		matrizNaval.getMatriz()[vert.nextInt(10)][y] = 0;
	}
	
	public void posicionaTorpedeiro(Matriz matrizNaval){
		matrizNaval.getMatriz()[vert.nextInt(10)][y] = 0;
	}
	
	public void posicionaSubmarino(Matriz matrizNaval){
		matrizNaval.getMatriz()[vert.nextInt(10)][y] = 0;
	}
	
}
