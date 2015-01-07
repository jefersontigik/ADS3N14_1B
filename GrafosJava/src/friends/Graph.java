package friends;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph
{
	ArrayList<Vertex> vertices;
	HashMap<String, Vertex> hashTable;
	ArrayList<String> connectors;
	
	public Graph()
	{
		this.vertices = new ArrayList<Vertex>();
		this.hashTable = new HashMap<String, Vertex>();
		this.connectors = new ArrayList<String>();
	}
	
	public void addVertex(String data)
	{
		Vertex vert = new Vertex(data);
		this.vertices.add(vert);
		hashTable.put(vert.name, vert);
	}
	
	public void addVertex(Vertex addon)
	{
		this.vertices.add(addon);
		hashTable.put(addon.name, addon);
	}
	
	//need a search method for names -> vertex
	public void addEdge(Vertex src, Vertex dest) 
	{
		//error check inputs?
		Vertex srcvertex = this.vertices.get(this.vertices.indexOf(src));
//		System.out.println("SRC" + srcvertex.name);
		Edge newedge = new Edge(dest);
		newedge.next = srcvertex.head;
		srcvertex.head = newedge;
	}
	
	public boolean edgeExists(String src, String dest)
	{
		Vertex srcvertex = vertices.get(vertices.indexOf(src));
		Edge ptr = srcvertex.head;
		while (ptr != null)
		{
			if (ptr.dest.name == dest)
			{
				return true;
			}
			else
			{
				ptr = ptr.next;
			}
		}
		return false;
	}
	
	public void printEdges()
	{
		
		for (int i = 0 ; i < this.vertices.size() ; i++)
		{
			System.out.println();
			Vertex srcvertex = this.vertices.get(i);
			boolean check = false;
			for (Edge ptr = srcvertex.head ; ptr != null ; ptr = ptr.next)
			{
				if(!check) {
				System.out.println("Edges for " + srcvertex.name);
				}
				check = true;
				Vertex destination = this.hashTable.get(ptr.dest.name);
				System.out.print(" " + this.vertices.get(this.vertices.indexOf(destination)).name);
			}
			

			
			if(!check) {
		    	System.out.println(srcvertex.name + " has no friends at " + srcvertex.school + "! what a loser!");
			}
			System.out.println();
		}
	}

    
	
    public void shortest( String name )
    {
    	Iterator i = hashTable.values().iterator();
    	while(i.hasNext()) {
             Vertex r = (Vertex)i.next();
             r.distance = Double.MAX_VALUE;
             r.previous = null;
    	}

        Vertex start = hashTable.get(name);
        
        LinkedList<Vertex> list = new LinkedList<Vertex>( );
        list.addLast(start); start.distance = 0;

        while(!list.isEmpty())
        {
            Vertex v = (Vertex) list.removeFirst();
            Edge runner = v.head;
            while(runner!=null)
            {
                Edge e = (Edge) runner;
                Vertex w = e.dest;
                if( w.distance == Double.MAX_VALUE )
                {
                    w.distance = v.distance + 1;
                    w.previous = v;
                    list.addLast(w);
                }
                runner=runner.next;
            }
        }
    }
	
    public void printEdges (Vertex v) {
    	if(v.head.next==null) {
    		System.out.println(v.name + " has no edges/friends! What a loser!");
    	}
    	
    	for (Edge ptr = v.head ; ptr != null ; ptr = ptr.next) {
    		System.out.print(" " + vertices.get(vertices.indexOf(ptr.dest)).name);
		}
    }
    
    
	public void printDfs(int src)
	{
		boolean[] visited = new boolean[vertices.size()];
		printDfs(src, visited);
	}
	
	private void printDfs(int src, boolean[] visited)
	{
		if (visited[src])
		{
			return;
		}
		
		visited[src] = true;
		
		for (Edge ptr = vertices.get(src).head ; ptr != null ; ptr = ptr.next)
		{
			Vertex destination = this.hashTable.get(ptr.dest.name);
			int index = this.vertices.indexOf(destination);
			printDfs(index, visited);
		}
	}

	public ArrayList<Graph> dfsTraversal()
	{
		boolean[] visited = new boolean[vertices.size()];
		ArrayList<Graph> graphs = new ArrayList<Graph>();
		for (int i = 0 ; i < vertices.size() ; i++)
		{
			printDfs(i, visited);
			Graph subGraph = new Graph();
			Graph compliment = new Graph();
			for(int x = 0; x < visited.length; x++) {
				if(visited[x]) {
					subGraph.vertices.add(vertices.get(x));
					subGraph.hashTable.put(vertices.get(x).name, vertices.get(x));
				} else {
					compliment.vertices.add(vertices.get(x));
					compliment.hashTable.put(vertices.get(x).name, vertices.get(x));
				}
			}
			
			graphs.add(subGraph);
			graphs.addAll(compliment.dfsTraversal());
			return graphs;
		}
		return graphs; //this never actually gets called
	}
	
	
	
	
	private void printConnector(int src, boolean[] visited, int dfsnum, Vertex starter, Vertex w1)
	{
		Vertex start = starter;
	        if (visited[src])
	        {
	        	return;
	        }
	        
	        visited[src] = true;
	        Vertex v = vertices.get(src);
	        v.dfsnum = dfsnum;
	        v.back = dfsnum;
	        
//	        System.out.println("dfs @ " + v.name + " " + v.dfsnum + "/" + v.back);
	        
	        for (Edge ptr = vertices.get(src).head ; ptr != null ; ptr = ptr.next)
	        {
	            Vertex w = vertices.get(vertices.indexOf(ptr.dest)); 
//	            System.out.println(w.name);
	            if(visited[vertices.indexOf(ptr.dest)]) {
	                v.back = Math.min(v.back, w.dfsnum);
//	                System.out.println("Neighbor " + w.name + " is already visited=> " + v.name + " " + v.dfsnum + "/" + v.back);
	                continue;
		            } else {
		            	increment++;
		            	printConnector(vertices.indexOf(ptr.dest), visited, increment, starter, w);
		            }
	            
	            
                if(v.dfsnum  > w.back){
//                	System.out.println("dfsnum(" + v.name + ") > back("+w.name+") =>" + v.dfsnum +"/" + v.back);
                    v.back = Math.min(v.back, w.back);
                    }
                
                if(v.dfsnum  <= w.back){
//                	System.out.println(v.name + " would be connector but it's a starter!");
                    if(!v.equals(start)){
//                        System.out.println(v.name + "is a connector!");
                        if(connectors.indexOf(v.name)==-1) {
                        	connectors.add(v.name);
                        }
                    }
                    
                    if(v.equals(start)) {
                    	start = null;
                    }
                }
	        }
	}
	
	public void dfsConnector()
	{
	        boolean[] visited = new boolean[vertices.size()];
	        for (int i = 0 ; i < vertices.size() ; i++)
	        {
	        	
//	        	System.out.println("ITERATION" + vertices.get(i).name);
	        	increment = 0;
	                printConnector(i, visited, increment, vertices.get(i), null); //runs through every vertex as a start
	        }
	        return;
	}

	static int increment = 0;

}