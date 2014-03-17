package com.senac.estrutura.Visao;

import static java.lang.System.out;

import java.io.IOException;
import java.util.Scanner;

import com.senac.estrutura.Controle.ManipulaArquivo;
import com.senac.estrutura.Modelo.ListaGenerica;
import com.senac.estrutura.Modelo.ListaTel;
import com.senac.estrutura.Modelo.NoGen;

public class VisaoRegistro {

	String linha = "";
	char opcao;
	ListaGenerica<ListaTel> lista = new ListaGenerica<ListaTel>();
	ManipulaArquivo<ListaTel> arq = new ManipulaArquivo<ListaTel>();
	ListaTel agenda = new ListaTel();
	NoGen<ListaTel> nodo = new NoGen<ListaTel>(agenda);

	String[] a = new String[3];

	public char MontaMenu() {
		out.println("Informe a opção desejada:"
				+ "\n 1 - Inserir novo registro" + "\n 2 - Apagar registro"
				+ "\n 3 - Listar todos " + "\n 4 - Pesquisar" + "\n 5 - Sair");
		return opcao = new Scanner(System.in).next().toString().charAt(0);
	}

	public void InsereRegistro() {
		out.println("Digite o nome");
		agenda.setNome(new Scanner(System.in).next().toString());

		out.println("Digite o Telefone");
		agenda.setFone(new Scanner(System.in).next().toString());

		nodo.setData(agenda);

		try {
			arq.abreArquivoW("Agenda.txt");
			arq.gravaArquivo(nodo.getData());
			arq.fechaArquivoW();
		} catch (IOException i) {
			out.println(i.getMessage());
		}
	}

	public void ListaTodos() {
		try {
			arq.abreArquivoR("Agenda.txt");
		} catch (IOException i) {
			out.println(i.getMessage());
		}

		while (linha != null) {
			try {
				linha = arq.lerArquivo();
				a = linha.split(";");

				if (lista.ListaVazia()) {
					agenda.setNome(a[0]);
					agenda.setFone(a[1]);
					nodo.setData(agenda);

					lista = new ListaGenerica<ListaTel>();
					lista.insert(nodo);
				} else {

					agenda.setNome(a[0]);
					agenda.setFone(a[1]);
					nodo.setData(agenda);

					lista = new ListaGenerica<ListaTel>();
					lista.append(nodo);
				}
//				out.println(a.toString());
				out.println(agenda.getNome()+" - "+agenda.getFone());
				
				lista.print();

			} catch (IOException i) {
				out.println(i.getMessage());
				break;
			}			
		}
	}
}
