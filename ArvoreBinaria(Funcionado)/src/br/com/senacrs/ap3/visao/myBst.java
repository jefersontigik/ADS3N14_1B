package br.com.senacrs.ap3.visao;

import java.util.ArrayList;

import br.com.senacrs.ap3.modelo.Bst;
import br.com.senacrs.ap3.modelo.Node;

public class myBst {

	public static void main(String[] args) {
		Node root = new Node(5);
	    ArrayList<Node> arr = new ArrayList<Node>();
	    
	    Bst bst = new Bst();
	    
	    System.out.println("Building tree with root value " + root.getData());
	    bst.insert(root, 2);
	    bst.insert(root, 7);
	    bst.insert(root, 3);
	    bst.insert(root, 8);
	    bst.insert(root, 1);
	    bst.insert(root, 4);
	    bst.insert(root, 6);
	    
	    System.out.println("Traversing tree inorder");
	    arr=bst.printInOrder(root);	    
	    System.out.println(arr);	
	    
	    System.out.println("printing pre-order traversal with out recursion");
	    bst.preOrderWithoutRecursion(root);
	    
	    System.out.println("printing post-order traversal");
	    bst.postOrder(root);
	    
	    System.out.println("Printing all root to leaf paths:");
	    bst.printAllRootToLeafPaths(root, new ArrayList());
	    
	    System.out.println("Height of the tree is: ");
	    System.out.println(bst.height(root));
	    
	    System.out.println("maximum root to leaf path sum");
	    System.out.println( bst.maxRootToLeafSum(root) );
	    
	    System.out.println("Diametre of the tree is:");
	    System.out.println( bst.diametre(root) );
	    
	    System.out.println("Maximum path sum between any 2 nodes:");
	    System.out.println( bst.maxPathSum(root) );
	}

}
