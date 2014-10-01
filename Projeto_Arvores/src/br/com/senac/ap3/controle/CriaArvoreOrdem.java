package br.com.senac.ap3.controle;

import br.com.senac.ap3.modelo.Arvore;
import br.com.senac.ap3.modelo.Pessoa;

public class CriaArvoreOrdem {
	
	public void criarArvore(int ordem){
		Arvore<Pessoa> raiz = new Arvore<Pessoa>(ordem);
//		Nodo filhos = new Nodo();
		
		raiz.getRaiz().setAnterior(raiz.getRaiz());
	}
}
