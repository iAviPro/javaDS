// package graphs;

// import java.util.HashMap;
// import java.util.Map;
// import java.util.Set;

// public class WeightedGraph<E> {

//     public class Graph<E> {
//         HashMap<E, Vertex<E>> vertices;
//     }

//     public class Vertex<E> {
//         private E label;
//         private Set<Edge<E>> edges;
//     }

//     public class Edge {
//         public Edge(E dest, double weight2) {
//         }

//         private Vertex<E> destination;
//         private double weight;
//     }

//     public void addEdge(E source, E dest, double weight) {
//         vertices.get(source).add(dest);
//         vertices.get(source).addEdge(new Edge(dest, weight));
//     }

//     public void addVertex(E item) { // don't forget to add already exists checks
//         Set<Vertex<E>> vertSet = new HashSet();
//         vertSet.add(new Vertex(item));
//         vertexMap.put(source, vertSet);
//     }
    
// }