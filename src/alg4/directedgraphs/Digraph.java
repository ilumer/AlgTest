package alg4.directedgraphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-17.
 *
 * Data files:http://algs4.cs.princeton.edu/42digraph/tinyDG.txt
 *  % java Digraph tinyDG.txt
 *  13 vertices, 22 edges
 *  0: 5 1
 *  1:
 *  2: 0 3
 *  3: 5 2
 *  4: 3 2
 *  5: 4
 *  6: 9 4 8 0
 *  7: 6 9
 *  8: 6
 *  9: 11 10
 *  10: 12
 *  11: 4 1
 *  12: 9
 *
 *
 *  javac-algs4 alg4/directedgraphs/Digraph.java
 *  java-algs4 alg4/directedgraphs/Digraph alg4/directedgraphs/tinyDG.txt
 */
public class Digraph {

  private final int V;
  private int E;
  private Bag<Integer>[] adj;

  @SuppressWarnings({"unchecked","rawtypes"})
  public Digraph(int V) {
    //create a v-vertex digraph with no edges
    this.V = V;
    this.E = 0;
    adj = (Bag<Integer>[]) new Bag[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new Bag<>();
    }
  }

  public Digraph(In in) {
    this(in.readInt());
    int tempE = in.readInt();
    //这里需要一个临时变量 将此处的变量赋值给图的边数时
    //会出现edge数重复添加
    //add edge

    for (int i = 0; i < tempE; i++) {
      int v = in.readInt();
      int w = in.readInt();
      addEdge(v, w);
    }

  }

  /**
   * @return the number of vertex
   */
  int V() {
    return V;
  }

  /**
   * @return the number of edge
   */
  int E() {
    return E;
  }

  /**
   * add edge (v point to w) to this digraph
   *
   * @param v the tail vertex
   * @param w the head vertex
   */
  void addEdge(int v, int w) {
    adj[v].add(w);
    E++;
  }

  /**
   * @param v the tail vertex
   * @return vertices connected to v by edges pointing from v
   */
  Iterable<Integer> adj(int v) {
    return adj[v];
  }

  /**
   * reverse digraph
   *
   * @return reverse digraph
   */
  Digraph reverse() {
    Digraph reDigraph = new Digraph(this.V);
    for (int i = 0; i < V; i++) {
      for (int m : adj[i]) {
        reDigraph.addEdge(m, i);
      }
    }
    return reDigraph;
  }


  @Override public String toString() {
    String s = V + "vertices" + E + "edges\n";
    for (int v = 0; v < V; v++) {
      s = s + v + " : ";
      for (int m : adj[v]) {
        s = s + " " + m;
      }
      s = s + "\n";
    }
    return s;
  }

  public static void main(String[] args){
    In in = new In(args[0]);
    Digraph G = new Digraph(in);
    StdOut.println(G);
  }
}
