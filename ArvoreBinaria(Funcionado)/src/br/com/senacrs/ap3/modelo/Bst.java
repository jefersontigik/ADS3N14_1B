package br.com.senacrs.ap3.modelo;

import java.util.ArrayList;
import java.util.Stack;

public class Bst {
	Node root;
	ArrayList arr = new ArrayList();
	ArrayList<Node> path = new ArrayList<Node>();
	Stack<Node> stk = new Stack<Node>();
	int lh = 0, rh = 0;
	
	public Bst(){
		root = null;
	}
	
	public int findMax(int a, int b){
		if(a > b) 
			return a;
		else 
			return b;
	}
	
	public void insert(Node node, int value){
	    if (value < node.getData()){
	      if (node.getLeft()!= null){
	        insert(node.getLeft(), value);
	      }else{
	        System.out.println("  Inserted " + value + " to left of "
	            + node.getData());
	        node.setLeft(new Node(value));
	      }
	    }else if (value > node.getData()){
	      if (node.getRight() != null){
	        insert(node.getRight(), value);
	      }else{
	        System.out.println("  Inserted " + value + " to right of "
	            + node.getData());
	        node.setRight(new Node(value));
	      }
	    }
	    
	  }
	
	public ArrayList<Node> printInOrder(Node node){
	    if (node != null) {
	      printInOrder(node.getLeft());
	      System.out.println("  Traversed " + node.getData());
	      //Store in an array
	      arr.add(node.getData());
	      printInOrder(node.getRight());
	    }
	    return arr;
	}	
	
	public void preOrderWithoutRecursion(Node node){
		while(true){
			while(node != null){
				System.out.print(node.getData()+" ");
				stk.push(node); 
				node = node.getLeft();
			}
			
			if(stk.empty())
				break;
			
			node = ((Node)stk.peek()).getRight();
			stk.pop();
		}
		System.out.println();
	}
	
	public void postOrder(Node node){
	
		while(true){
			stk.push(node);
			while(!stk.isEmpty()){
				Node next = (Node) stk.peek();
				if (next.getRight() == node || next.getLeft() == node ||(next.getLeft() == null && next.getRight() == null)) {
					stk.pop();
					System.out.print(next.getData()+" ");
					node = next;
				}else{
					if (next.getRight() != null) {
				        stk.push(next.getRight());
				      }
				      if (next.getLeft() != null)
				        stk.push(next.getLeft());
				}
			}
			if(stk.empty())
				break;
		}
		System.out.println();
	}
	
	public void printAllRootToLeafPaths(Node node,ArrayList path){
		if(node == null){
			return;
		}
		path.add(node.getData());
		
		if(node.getLeft() == null && node.getRight() == null){
			System.out.println(path);
			return;
		}else{
			printAllRootToLeafPaths(node.getLeft(), new ArrayList(path));
			printAllRootToLeafPaths(node.getRight(), new ArrayList(path));
		}	   
	}
	
	public int height (Node node){
	    if (node == null) 
	    	return 0;
	    return 1 + Math.max(height (node.getLeft()), height (node.getRight()));
	}
	
	public int maxRootToLeafSum(Node node){
		if(node == null)
			return 0;
		return findMax( maxRootToLeafSum(node.getLeft()) , maxRootToLeafSum(node.getRight()) ) + node.getData() ;
	}
	
//	public int diametre(Node node, int d)
//	{
//		if(node==null)
//			return 0;
//		
//		lh=diametre(node.left, d);
//		rh=diametre(node.right, d);
//		
//		if(lh+rh+1>d)
//			d=lh+rh+1;
//		
//		return findMax(lh, rh)+1;
//	}
	
	public int diametre(Node node){
		if(node == null)
			return 0;
		else{
			return Math.max( (height(node.getLeft())+height(node.getRight())+1), Math.max( diametre(node.getLeft()), diametre(node.getRight()) ) );
		}		
	}
	
	public int maxPathSum(Node node){
		if(node == null)
			return 0;
		else{
			return Math.max( (maxRootToLeafSum(node.getLeft())+maxRootToLeafSum(node.getRight())+node.getData()), Math.max( maxPathSum(node.getLeft()), maxPathSum(node.getRight()) ) );
		}
	}
}
