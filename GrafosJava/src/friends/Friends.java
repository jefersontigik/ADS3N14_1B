//Abe Stanway and Sean Yeager
//word?
package friends;
import java.io.*;
import java.util.*;


public class Friends
{
    static ArrayList<Vertex> verts = new ArrayList<Vertex>();
    static ArrayList<Edge> edges = new ArrayList<Edge>();
    static Graph friendGraph = new Graph();

    // public Friends(){
    //     ArrayList<Vertex> verts = new ArrayList<Vertex>();
    //     // ArrayList<Edge> edges = new ArrayList<Edge>();
    // }
    
    public static void readVertices(BufferedReader br) throws IOException  {
        
		int totalVerts = Integer.parseInt(br.readLine());
		for(int i = 0; i < totalVerts; i++){
			String word = br.readLine();
//			System.out.println(word);
			friendGraph.addVertex(word);
//			Vertex vertizzle = new Vertex(word);
//			verts.add(vertizzle);
		}
		printVerts(verts);
		
		
		///Have a hash table where NAMES are keys and VALUES are vertices
		String line;
		while((line = br.readLine ()) != null){
		    String home = line.substring(0, line.indexOf('|'));
		    String dest = line.substring(line.indexOf('|')+1);
		    Vertex homeVert = friendGraph.hashTable.get(home);
		    Vertex destVert = friendGraph.hashTable.get(dest);
		    friendGraph.addEdge(homeVert, destVert);
		    friendGraph.addEdge(destVert, homeVert);
		}
		
//		friendGraph.printEdges();
		return;
	}
    
    static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String[] args) throws IOException
	{
        System.out.print("Enter vertex file name => ");
        String infile = keyboard.readLine();
        BufferedReader br = new BufferedReader(new FileReader(infile));	
		readVertices(br);
        
		while (true)
		{
			int choice = getMenuChoice();
			
			if (choice == 1)
			{
				System.out.println("Enter school: ");
				String school = keyboard.readLine();
				Graph subGraph = subGraph(friendGraph, school);
				for(int i = 0 ; i < subGraph.vertices.size() ; i++)
				{
					System.out.println(subGraph.vertices.get(i).name);
				}
				subGraph.printEdges();
		    }
			
			else if (choice == 2)
			{
				System.out.println("Enter first person (who wants to get introduced):");
				String name = keyboard.readLine();
				friendGraph.shortest(name);
				System.out.println("Enter the person who he wants to get introduced to:");
				name = keyboard.readLine();
				Vertex v = friendGraph.hashTable.get(name);
			    printPath(v, true);
			    
			}
			
			else if (choice == 3)
			{
				System.out.println("Enter school:");
				String school = keyboard.readLine();
				Graph subGraph = subGraph(friendGraph, school);
				ArrayList<Graph> graphs = subGraph.dfsTraversal();
				for (int i = 0; i < graphs.size(); i++) {
					int number = i + 1;
					System.out.println();
					System.out.println("Clique " + number);
					for (Vertex v : graphs.get(i).vertices) {
						v.printName();
					}
				}
			}
			else if (choice == 4)
			{
					friendGraph.dfsConnector();
					for(String name : friendGraph.connectors) {
						System.out.println(name);
					}
		    }
		    
		    else if (choice == 5)
			{
                return;
		    }
	    }
    }


	public static int getMenuChoice() throws IOException 
	{
		System.out.println();
		System.out.println("Menu:");
		System.out.println("1. Students at School");
		System.out.println("2. Shortest Intro Chain");
		System.out.println("3. Cliques");
		System.out.println("4. Connectors");
		System.out.println("5. Quit");
		System.out.println();
		System.out.print("Choose an option: ");
	
		try {
		int choice = Integer.parseInt(keyboard.readLine());
		
		while (choice < 1 || choice > 5) 
		{
			System.out.print("That is not a valid menu option. Pick 1-5. ");
			try {
			choice = Integer.parseInt(keyboard.readLine());
			} catch (NumberFormatException nfe) {
				
			}
		}
		
			return choice;
		} catch (NumberFormatException nfe) {
			return getMenuChoice();
		}
	}
	
	private static void printPath( Vertex dest, boolean first )
    {
        if( dest.previous != null )
        {
            printPath( dest.previous, false );
            System.out.print( " to " );
        }
        
        if(dest.previous == null && first) {
        	System.out.print("There is no path to ");
        }
        
        System.out.print( dest.name );
    }
	
    private static void printVerts(ArrayList<Vertex> list) {
            for(int i = 0; i < list.size(); i++) {
                list.get(i).printAll();
            }
        }
    
    
   public static Graph subGraph(Graph input, String newschool){
        
        Graph output = new Graph();
                
        for(int i = 0 ; i < input.vertices.size() ; i++)
        {
                if(input.vertices.get(i).student)
                {
                        if(input.vertices.get(i).school.equals(newschool))
                        {
                    		Vertex addon = new Vertex(input.vertices.get(i)); 
                        	output.addVertex(addon);
                        }
                }    
        }
        
        //////////////////////////////////////// probable error spot begin 
        
        for(int i = 0 ; i < output.vertices.size() ; i++)
        {
//        	System.out.println("NAME" + output.vertices.get(i).name);
            if(output.vertices.get(i).student)
            {
                    if(output.vertices.get(i).school.equals(newschool))
                    {
                    	Vertex newone = output.vertices.get(i);
                    	
                        for(Edge ptr = input.hashTable.get(newone.name).head ; ptr != null ; ptr = ptr.next)
                        {
                        	
                        	
                        	if(ptr.dest.student)
                        	{
                        		if(ptr.dest.school.equals(newschool))
                        		{
//                        	System.out.println(ptr.dest.name);
                        			Edge newEdge = new Edge(ptr.dest);
                        			newEdge.next = newone.head;
                        			newone.head = newEdge;
                        		}
                        	}
                        }
                        
                    }
                    
            }
        }
        
        
//        for(int i = 0 ; i< output.vertices.size() ; i++)
//          {
//          	for(Edge ptr = output.vertices.get(i).head ; ptr != null ; ptr = ptr.next)
//          	{
//          		System.out.println(output.vertices.get(i).name + " knows " + ptr.dest.name);
//          	}
//          }
        
        
//        System.out.println("END OF METHOD");
        //////////////////////////////probable error spot end
       
/*        obsolete stuff
    	for(int i = 0 ; i < output.vertices.size(); i++)
    	{
    		System.out.println(output.vertices.get(i).name + " goes to " + newschool);
    	}
    	
    	for(int i = 0 ; i < output.vertices.size(); i++)
    	{

    		
    		for(Edge ptr = output.vertices.get(i).head ; ptr != null ; ptr = ptr.next)
    		{
    			System.out.println(output.vertices.get(i).name + " knows " + ptr.dest.name);
    		}
    	}


        
        Edge curr = null;
        Edge prev = null;
        
        for(int i = 0 ; i < output.vertices.size() ; i++)
        {
                curr = output.vertices.get(i).head;
                prev = null;
                
                while(curr != null)
                {       
                        if(!(curr.dest.student) || !(curr.dest.school.equals(newschool)))
                        {
                                if(prev == null)
                                {
                                        if(curr.next == null)
                                        {
                                                output.vertices.get(i).head = null;
                                                curr = null;
                                        }
                                        
                                        else if(curr.next != null)
                                        {
                                                output.vertices.get(i).head = output.vertices.get(i).head.next;
                                                curr = curr.next;
                                        }        
                                }
                                
                                else if(curr.next == null)
                                {
                                        prev.next = null;
                                        curr = null;
                                }
                                
                                else
                                {
                                        prev.next = curr.next;
                                curr = curr.next;
                                }  
                        }
                        else
                        {
                            prev = curr;
                            curr = curr.next;                                
                        }
                }
        }
        */
        return output;
    }

    

    
}