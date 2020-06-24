import java.io.*;
import java.util.LinkedList;

class EdgeWeightedGraph
{
    static class Edge implements Comparable<Edge> {
        private int v, w;
        private double weight;

        //constructor to inner class Edge
        public Edge(int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        // return currrent endpoint
        public int thisEndPoint(){
            return v;
        }

        // return other endpoint
        public int otherEndPoint(int vertex){
            if(vertex == v)
                return w;
            else
            return v;
        }

        // compare edges using overridden Comparable
        public int compareTo(Edge that) {
            if (this.weight > that.weight) return +1;
            if (this.weight < that.weight) return -1;
            else return 0;
        }
    }
    private int v;
    private LinkedList<Edge>[] adj;

    //constructor for EdgeWeightedGraph to initialize values
    public EdgeWeightedGraph(int V) {
        v=V;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++){
            adj[i] = new LinkedList<Edge>();
        }
    }

    //add weighted Edge to the graph
    public void addEdge (Edge e) {
        int v = e.thisEndPoint();
        int w = e.otherEndPoint(v);
        adj[v].add(e);
        adj[w].add(e);
    }
}
