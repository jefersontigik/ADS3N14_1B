package com.br.senacrs.ap3.controle;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import com.br.senacrs.ap3.modelo.Agenda;
import com.br.senacrs.ap3.modelo.Lista;
import com.br.senacrs.ap3.modelo.Nodo;


public class ListaOrdenada<T> extends Lista<T>{	
	public Lista<Agenda> ordenaLista(){

		Lista<Agenda> lista = new Lista<Agenda>();
		for (Agenda age:  carregaLista()) {
			//lista.adicionaHead(age);
			lista.adicionaTail(age);
		}
		return lista;
	}

	public Set<Agenda> carregaLista(){
		String linha = "";
		String[] a = new String[6];
		ManipulaArquivo<Agenda> arq = new ManipulaArquivo<Agenda>();
		Set<Agenda> lista = new TreeSet<Agenda>(new Ordenador());

		try {
			arq.abreArquivoR("dados.txt");
			linha = arq.lerArquivo();

			while (linha != null) {

				Agenda ag = new Agenda();
				a = linha.split("#");
				ag.setNome(a[0]);
				ag.setEndereco(a[1]);

				if(a.length == 2){
					ag.setTelefone1("*");
					ag.setTelefone2("*");
					ag.setTelefone3("*");
					ag.setTelefone4("*");
				}else if(a.length == 3){
					ag.setTelefone1(a[2]);
					ag.setTelefone2("*");
					ag.setTelefone3("*");
					ag.setTelefone4("*");

				}else if(a.length == 4){
					ag.setTelefone1(a[2]);
					ag.setTelefone2(a[3]);
					ag.setTelefone3("*");
					ag.setTelefone4("*");

				}else if(a.length == 5){
					ag.setTelefone1(a[2]);
					ag.setTelefone2(a[3]);
					ag.setTelefone3(a[4]);
					ag.setTelefone4("*");

				}else if(a.length == 6){
					ag.setTelefone1(a[2]);
					ag.setTelefone2(a[3]);
					ag.setTelefone3(a[4]);
					ag.setTelefone4(a[5]);
				}
				lista.add(ag);
				linha = arq.lerArquivo();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Lista<Agenda> listaIndexada(){
		Lista<Agenda> listaAux = ordenaLista();
		Nodo<Agenda> atual = listaAux.getHead();
		Lista<Agenda> listaIndex = new Lista<Agenda>();
		double tam = listaAux.getTotElem();
		
		for(Agenda ag: carregaLista()){
			if(tam%8 == 0){
				ag.setNome(((Agenda)atual.getDados()).getNome());
				ag.setEndereco(((Agenda)atual.getDados()).getEndereco());
				ag.setTelefone1(((Agenda)atual.getDados()).getTelefone1());
				ag.setTelefone2(((Agenda)atual.getDados()).getTelefone2());
				ag.setTelefone3(((Agenda)atual.getDados()).getTelefone3());
				ag.setTelefone4(((Agenda)atual.getDados()).getTelefone4());
				listaIndex.adicionaTail(ag);
			}
			atual = atual.getProx();
			tam--;
		}

		return listaIndex;
	} 

	public Nodo<T> procuraNodo(Nodo<T> alvo){
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;
		T chaveAlvo = alvo.getDados();

		while (atual != null) {
			System.out.println("Entrou While");
			T chaveAtual = atual.getDados();
			boolean cmp = chaveAlvo.equals(chaveAtual);
			if (cmp)
				return atual; 
			if (!cmp)
				return anterior;
			anterior = atual;
			atual = atual.getProx();
		}
		return anterior;
	}

	public static int buscaBinaria( int[] tabela, int valor ) {

		boolean achou = false;
		int alto = tabela.length - 1;
		int baixo = 0;
		int meio = alto / 2;

		while (!achou && alto >= baixo) {
			if (valor == tabela[meio]) {
				achou = true;
			} else if (valor < tabela[meio]) {
				alto = meio -1;
			} else {
				baixo = meio + 1;
			}
			meio = (alto + baixo) / 2;
		}
		return ( (achou) ? meio : -1);
	}
	
	@Override
	public void append(Nodo<T> novo){
		insert(novo);
	}
}
