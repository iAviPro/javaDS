package graphs;
/** 
 * Generic Graph implementation.
 * Adjacency List based directional / bidirectional graph implementation using Java Generics
 * Note: In Parameter type, we cannot use primitives like 'int','char' or 'double'.
*/

/**
 * @author: Aviral Nigam
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

 public class Graph<T> {
     // Implementing Adjacency List using Map to store vertices & List to store edges.
     private Map<T,List<T>> adjMap = new HashMap<>();

     public void addVertex(T vertex) {
         adjMap.put(vertex, new LinkedList<T>());
     }

     public void addEdge(T source, T destination, boolean bidirectional) {
         if (!adjMap.containsKey(source)) {
             addVertex(source);
         }
         if (!adjMap.containsKey(destination)) {
             addVertex(destination);
         }
         adjMap.get(source).add(destination);
         if(bidirectional) {
             adjMap.get(destination).add(source);
         }
     }

     // This function gives the count of vertices
     public void getVertexCount() {
         System.out.println("The graph has " + adjMap.keySet().size() + " vertex");
     }

     // This function gives the count of edges
     public void getEdgesCount(boolean bidirectional) {
         int count = 0;
         for (T v : adjMap.keySet()) {
             count += adjMap.get(v).size();
         }
         if (bidirectional == true) {
             count = count / 2;
         }
         System.out.println("The graph has " + count + " edges.");
     }

     // This function gives whether a vertex is present or not.
     public void hasVertex(T s) {
         if (adjMap.containsKey(s)) {
             System.out.println("The graph contains " + s + " as a vertex.");
         } else {
             System.out.println("The graph does not contain " + s + " as a vertex.");
         }
     }

     // This function gives whether an edge is present or not.
     public void hasEdge(T s, T d) {
         if (adjMap.get(s).contains(d)) {
             System.out.println("The graph has an edge between " + s + " and " + d + ".");
         } else {
             System.out.println("The graph has no edge between " + s + " and " + d + ".");
         }
     }
     
     // Prints the adjacency list of each vertex.
     @Override
     public String toString() {
         StringBuilder builder = new StringBuilder();

         for (T v : adjMap.keySet()) {
             builder.append(v.toString() + ": ");
             for (T w : adjMap.get(v)) {
                 builder.append(w.toString() + " ");
             }
             builder.append("\n");
         }

         return (builder.toString());
     }

 // Driver Code
     public static void main(String args[]) {

         // Object of graph is created.
         Graph<Integer> g = new Graph<Integer>();

         // edges are added.
         // Since the graph is bidirectional,
         // so boolean bidirectional is passed as true.
         g.addEdge(0, 1, true);
         g.addEdge(0, 4, true);
         g.addEdge(1, 2, true);
         g.addEdge(1, 3, true);
         g.addEdge(1, 4, true);
         g.addEdge(2, 3, true);
         g.addEdge(3, 4, true);

         // print the graph.
         System.out.println("Graph:\n" + g.toString());

         // gives the no of vertices in the graph.
         g.getVertexCount();

         // gives the no of edges in the graph.
         g.getEdgesCount(true);

         // tells whether the edge is present or not.
         g.hasEdge(3, 4);

         // tells whether vertex is present or not
         g.hasVertex(5);
     }
     
 }