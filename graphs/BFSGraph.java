package graphs;
/* Graph traversal: BFS traversal using queue (iterative).
 * Time Complexity(Worst Case): O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
 * In this algorithm, we traverse each node and enqueue all the adjecent nodes in a queue; continue this process till queue becomes null. 
 * A visited array is maintained to track all the nodes that are visited.  
 * Note that the below code traverses only the vertices reachable from a given source vertex. 
 * All the vertices may not be reachable from a given vertex (example Disconnected graph).
*/
/*
@Author: Aviral Nigam
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class BFSGraph {
	int v;
	LinkedList<Integer>[] list;
	//constructor
	public BFSGraph(int V) {
		v=V;
		//initializing adjacency list
		list = new LinkedList[v];
		for(int i=0;i<v;i++)
			list[i] = new LinkedList<Integer>();//initializing list within list
	}
	public void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[v]; // by default in java boolean array elements are initialized as false
		visited[s] = true;
		q.add(s); // adds the source value to queue
		while(q.size()!=0) {
			s=q.poll();
			System.out.print(s+"  ");
			Iterator<Integer> it = list[s].listIterator(); // iterates through adjacency list
			while(it.hasNext()) {
				int i = it.next();
				if(!visited[i]) {
					q.add(i); //enqueue if not visited
					visited[i] = true; //mark visited
				}
			}
		}	
	}
	// Method to add an edge into the graph
    void addEdge(int v,int w)
    {
        list[v].add(w);
    }

    // Driver main method
    public static void main(String args[])
    {
        BFSGraph g = new BFSGraph(4);
        // edit/remove below statements to define structure of the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal (starting from vertex 2): ");
        g.bfs(2); //call to bfs with source value;
        System.out.println("\n"); //for demarcating output clearly
}
}