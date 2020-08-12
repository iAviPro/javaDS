package graphs;

/* Depth First Search (DFS) program using Stack and iterative technique
*/

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;

class DFSIterative
{
	LinkedList<Integer>[] list;
	int V;
	//constructor
	public DFSIterative(int v)
	{
		//initialize adjecency list
		V=v;
		list = new LinkedList[v];
		for(int i=0; i<v; i++){
			list[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int x) {
		// for undirected graph adding nodes
    	list[v].add(x); 
    	list[x].add(v);
    }

	public void DFS(int s)
	{
		Stack<Integer> stack = new Stack<>();
		boolean[] visited =  new boolean[V];
		stack.push(s);
		
		while(!stack.empty())
		{
			int n = stack.pop();
			//if not visited iterate through the node and push all the adjecent connected nodes to the stack
			if(!visited[n])
			{
				visited[n]=true;
				System.out.println(n);
				Iterator<Integer> it = list[n].listIterator();
				while(it.hasNext())
				{
					int x=it.next().intValue();
					stack.push(x);
				}
			}
		}
	}

	public static void main(String[] args)
	{
		DFSIterative dfs = new DFSIterative(8);
		dfs.addEdge(1, 3);
		dfs.addEdge(1, 4);
		dfs.addEdge(1, 2);
		dfs.addEdge(4, 7);
		dfs.addEdge(4, 6);
		dfs.addEdge(4, 5);
		dfs.addEdge(5, 5);
		dfs.addEdge(5, 6);

		System.out.println("Iterative DFS Traversal of graph:");
        //Define the source vertex in the parameter below
        dfs.DFS(1); 
        System.out.print("\n");

	}
}