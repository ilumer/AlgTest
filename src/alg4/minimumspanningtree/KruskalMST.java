package alg4.minimumspanningtree;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

//将带权的边进行排序
//在不形成环的情况下添加到树中
public class KruskalMST {
  private Queue<Edge> mst;
  //private boolean[] marked;
  //当两个点都被被访问过后 两者之间的边可能还还没有被添加到最小生成树中

  public KruskalMST(EdgeWeightedGraph G) {
    mst = new Queue<>();
    MinPQ<Edge> pq = new MinPQ<>(G.E());
    for (Edge e : G.edges()) {
      pq.insert(e);
    }
    //marked = new boolean[G.V()];
    UF uf = new UF(G.V());
    while (!pq.isEmpty() && mst.size() < G.V() - 1) {
      Edge e = pq.delMin();
      int v = e.either(), w = e.other(v);
      if (uf.connected(v, w)) continue;
      //marked[v] marked[w] 是否同时在树中
      uf.union(v, w);
      mst.enqueue(e);
    }
  }

  public Iterable<Edge> edges() {
    return mst;
  }

  public double weight() {
    double total = 0;
    for (Edge e : mst) {
      total += e.getWeight();
    }
    return total;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    EdgeWeightedGraph G = new EdgeWeightedGraph(in);
    KruskalMST mst = new KruskalMST(G);
    for (Edge e : mst.edges()) {
      StdOut.println(e);
    }
    StdOut.printf("%.5f\n", mst.weight());
  }
}
