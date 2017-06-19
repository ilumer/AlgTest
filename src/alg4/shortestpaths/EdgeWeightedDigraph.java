package alg4.shortestpaths;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class EdgeWeightedDigraph {
  private int V;//边的数量
  private int E;//E的数量
  private Bag<DirectedEdge>[] adj;//邻接表

  @SuppressWarnings({"rawtypes", "unchecked"})
  public EdgeWeightedDigraph(int v) {
    this.V = v;
    this.E = 0;
    adj = (Bag<DirectedEdge>[]) new Bag[V];
    for (int i = 0; i < adj.length; i++) {
      adj[i] = new Bag<>();
    }
  }

  public EdgeWeightedDigraph(In in) {
    this(in.readInt());
    int E = in.readInt();
    for (int i = 0; i < E; i++) {
      DirectedEdge e = new DirectedEdge(in.readInt(), in.readInt(), in.readDouble());
      addEdge(e);
    }
  }

  public int V() {
    return V;
  }

  public int E() {
    return E;
  }

  public void addEdge(DirectedEdge edge) {
    adj[edge.from()].add(edge);
    this.E++;
  }

  public Iterable<DirectedEdge> adj(int v) {
    return adj[v];
  }

  public Iterable<DirectedEdge> edges() {
    Bag<DirectedEdge> list = new Bag<>();
    for (int i = 0; i < V; i++) {
      for (DirectedEdge e : adj[i]) {
        list.add(e);
      }
    }
    return list;
  }

  @Override public String toString() {
    String str = "";
    for (int i = 0; i < adj.length; i++) {
      str += i + "\t";
      for (DirectedEdge e : adj[i]) {
        str = str + e.toString() + "\t";
      }
      str += "\n";
    }

    return str;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(in);
    StdOut.println(edgeWeightedDigraph);
  }
}
