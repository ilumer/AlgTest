package alg4.minimumspanningtree;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class EdgeWeightedGraph {

  private static final String NEWLINE = System.getProperty("line.separator");
  private int V;//顶点的个数
  private int E;//边的个数
  private Bag<Edge>[] adj;

  @SuppressWarnings({"unchecked", "rawtypes"})
  public EdgeWeightedGraph(int v) {
    //create a empty V-vertex graph
    this.V = v;
    this.E = 0;
    adj = (Bag<Edge>[]) new Bag[V];

    for (int i = 0; i < V; i++) {
      adj[i] = new Bag<>();
    }
  }

  public EdgeWeightedGraph(In in) {
    //read graph from inputStream
    this(in.readInt());
    int E = in.readInt();
    //添加Edge
    for (int i = 0; i < E; i++) {
      int a = in.readInt();
      int b = in.readInt();
      double w = in.readDouble();
      Edge e = new Edge(a, b, w);
      addEdge(e);
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(Edge e) {
    int v = e.either();
    int w = e.other(v);
    adj[v].add(e);
    adj[w].add(e);
    E++;
  }

  public Iterable<Edge> adj(int v) {
    return adj[v];
  }

  public Iterable<Edge> edges() {
    Bag<Edge> list = new Bag<>();
    for (int v = 0; v < V; v++) {
      //边 0 ： 6 weight 0.58
      //adj[0].add(E)
      //adj[6].add(E)
      //但是额e.other(v)可以避免出现重复
      //不包括自环
      for (Edge e : adj(v)) {
        if (e.other(v) > v) {
          list.add(e);
        }
      }
    }
    return list;
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(V + " " + E + NEWLINE);
    for (int v = 0; v < V; v++) {
      s.append(v + ": ");
      for (Edge e : adj[v]) {
        s.append(e + "  ");
      }
      s.append(NEWLINE);
    }
    return s.toString();
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    EdgeWeightedGraph G = new EdgeWeightedGraph(in);
    StdOut.println(G);
    for (Edge edge:G.edges()){
      StdOut.println("v :"+edge.either()+"w:"+edge.other(edge.either())+" weight:"+edge.getWeight());
    }
  }
}
