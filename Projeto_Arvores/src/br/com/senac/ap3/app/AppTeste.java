package br.com.senac.ap3.app;

import br.com.senac.ap3.modelo.Arvore;
import br.com.senac.ap3.modelo.Nodo;
import br.com.senac.ap3.modelo.Pessoa;

public class AppTeste {

	public static void main(String[] args) {
		
		Arvore<Pessoa> arvore = new Arvore<Pessoa>(3);
		Nodo<Pessoa> raiz = new Nodo<Pessoa>(3);
		Pessoa pes = new Pessoa();
		
		
		
		raiz = arvore.criaNodo();
		pes.setNome("Andrea");
		pes.setTelefone("6343463");
		raiz.setDado(pes);
		arvore.setRaiz(raiz);
		
		Nodo<Pessoa> interno = arvore.criaNodo();
		pes.setNome("Maria");
		pes.setTelefone("4912764512");
		interno.setDado(pes);
		interno.setAnterior(raiz);
		raiz.addFilho(interno);
		
		pes = new Pessoa();
		interno = arvore.criaNodo();
		pes.setNome("Jose");
		pes.setTelefone("987643-98");
		interno.setDado(pes);
		interno.setAnterior(raiz);
		raiz.addFilho(interno);
		
		pes = new Pessoa();
		interno = arvore.criaNodo();
		pes.setNome("Marcos");
		pes.setTelefone("976650943");
		interno.setDado(pes);
		interno.setAnterior(raiz);
		raiz.addFilho(interno);
		
		Nodo<Pessoa> folha = arvore.criaNodo();
		pes = new Pessoa();
		pes.setNome("Jonas");
		pes.setTelefone("976650943");
		folha.setDado(pes);
		folha.setAnterior(interno);
		interno.addFilho(folha);	
		
		System.out.println("Feito!"+ interno.getAnterior().getDado().getNome());
		System.out.println(raiz.getFilho(0).getDado().getNome());
		
	}

}
