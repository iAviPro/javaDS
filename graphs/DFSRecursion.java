package graphs;

/** Graph Traversal: Depth First Search (DFS) on a graph using recursion 
 * The diffrence between DFS on a tree and a graph is that in graph there is a possibility of cycle 
 * hence we maintain a boolean array called visited[], which maintains all previously visited vertex.
 * So if the vertex is not visited, we recursively traverse through it and mark it as visited.
 * In DFS once we have recursively traversed all non-visited connected compononets of a vertex through its depth
 * the recursion backtracks to the starting vertex to traverse its other connected-components(in its width).
 **/

/**
 * @author: Aviral Nigam
 */
import java.util.*;

public class DFSRecursion
{
	private int V;
	private LinkedList<Integer>[] list;
	
	DFSRecursion(int v) { //constructor to initialize adj. list and the no. of vertex
		V=v;
		list = new LinkedList[V];
		for(int i=0; i<V; i++){
			list[i] = new LinkedList();
		}
	}
	public void DFS(int v) { 
		boolean[] visited = new boolean[V]; //initializing visited[] array
		/* in java all the boolean array elements are by default initialized as false(i.e. not visited)*/
			DFSutil(v,visited);
	    }

    public void DFSutil(int v,boolean[] visited) {
	    visited[v]=true;
	    System.out.print(v+ " "); // print vertex
	    Iterator<Integer> it = list[v].listIterator(); //listIterator to traverse the adj.list's linkedlist
	    while(it.hasNext()) {
		    int n=it.next();//next vertex no.
		    if(!visited[n])
			   DFSutil(n,visited); // if visited is false recurse
	        }
        }
    public void addEdge(int v, int x) {
    	list[v].add(x); //adding to the adj.list of vertex v
    }

    //Driver 
    public static void main(String[] args) {
    	//Give the no. of vertex to the constructor of Graph class
    	DFSRecursion g =  new DFSRecursion(5);
    	//use the copy of below command to add edges and build the graph
    	g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 4);
        g.addEdge(3, 3);
        g.addEdge(4, 4);
        g.addEdge(4, 3);

        System.out.println("DFS Traversal of graph using Recursion:");
        //Define the source vertex in the parameter below
        g.DFS(2); 
        System.out.print("\n");
    }
}