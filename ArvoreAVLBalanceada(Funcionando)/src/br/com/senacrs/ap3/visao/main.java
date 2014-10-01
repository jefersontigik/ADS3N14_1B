package br.com.senacrs.ap3.visao;

import br.com.senacrs.ap3.modelo.AVLTree;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AVLTree<Integer> tree = new AVLTree<Integer>();
		for (int i = 1; i <= 20; i++)
			tree.insert(new Integer(i));
 
		tree.PrintTree();
	}

}
