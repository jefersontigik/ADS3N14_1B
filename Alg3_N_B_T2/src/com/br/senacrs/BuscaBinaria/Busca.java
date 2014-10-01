package com.br.senacrs.BuscaBinaria;

import java.util.Scanner;

public class Busca {	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int db[] = new int[10];
		int numero, i, inicio = 0, meio, fim = 9;
		boolean localizador = false;

		for (i = 0; i < 10; i++) {
			System.out.print("Digite o " + (i + 1) + " número: ");
			db[i] = in.nextInt();
		}
		System.out.println("Digite o número a ser localizado: ");
		numero = in.nextInt();
		i = 0;
		meio = (inicio + fim) / 2;
		while (inicio <= fim && localizador == false) {
			if (db[meio] == numero) {
				localizador = true;
			} else {
				if (numero < db[meio]) {
					fim = meio - 1;
				} else {
					inicio = meio + 1;
				}
				meio = (inicio + fim) / 2;
			}
		}
		if (localizador) {
			System.out.println("Número encontrado na posição [" + meio + "]");
		} else {
			System.out.println("Número não encontrado");
		}
	}
}

