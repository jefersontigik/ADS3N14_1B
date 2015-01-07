package br.com.senacrs.ap3.visao;

import br.com.senacrs.ap3.modelo.AVLTree;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.insert(new Integer(1));
		tree.insert(new Integer(2));
		tree.insert(new Integer(3));
		tree.insert(new Integer(4));
		tree.insert(new Integer(5));
		tree.insert(new Integer(6));
		tree.insert(new Integer(7));
		tree.insert(new Integer(8));
//		for (int i = 1; i <= 20; i++)
//			tree.insert(new Integer(i));
 
		tree.PrintTree();
	}

}
