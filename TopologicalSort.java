/*Graph: Topological Sort
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
 * such that for every directed edge uv, vertex u comes before v in the ordering.
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
 * Space and time complexity (worst case) is O(n).
 * Algo:
 * 1. Do DFS while maintaining boolean visited array.
 * 2. Put the vertex which are completely explored into a stack.
 * 3. Finally, Pop from stack to get sorted order.
 */
/*
@Author: Aviral Nigam
*/

import java.util.Stack;
import java.util.Iterator;
import java.util.LinkedList;

class TopologicalSort
{
    private int v;
    private LinkedList<Integer>[] adj;  //declaring adjcency list
    //constructor
    public TopologicalSort(int V){
        v=V;
        adj=new LinkedList[v]; //declaring the array of size v of type linkedlist
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList(); //initializing the list within the array of type linkedlist
        }
    }
    //add edges and vertex to define the graph
    void addEdge(int v, int e){
        adj[v].add(e);
    }
    //topologicalsort method
    void topoSort(){
        Stack st = new Stack();
        boolean[] visited = new boolean[v]; //array to maintain visited nodes
        //value of boolean elements of array in java is by default false
        for(int i=0; i<v; i++)
        {
            if (!visited[i]) {
            topoSortUtil(i, visited, st);
        }
    }
        while(!st.empty())
            System.out.print(st.pop() + "  "); //printing the stack as output
    }
    void topoSortUtil(int v, boolean visited[], Stack st) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj[v].iterator(); //iterator to iterate through the linkedlist
        while(it.hasNext()){
            i=it.next();
            if(!visited[i]) // if not visited i.e. value is false
                topoSortUtil(i, visited, st); //recursion
        }
        st.push(new Integer(v)); // once all the adjecent nodes are visited put the vertex in stack
    }
    //driver main method
    public static void main(String args[])
    {
        TopologicalSort graph = new TopologicalSort(6);
        // edit/remove the below values to define the structure of the graph
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        System.out.println("Following is a Topological sort of the given graph:");
        graph.topoSort(); // call to topological sorting method.
        System.out.print("\n"); // to demarcate the output clearly
    }
}
