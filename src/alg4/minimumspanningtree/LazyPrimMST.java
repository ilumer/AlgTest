package alg4.minimumspanningtree;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-6-16.
 */
public class LazyPrimMST {

  private boolean[] marked;
  private MinPQ<Edge> pq;
  private Queue<Edge> mst;

  public LazyPrimMST(EdgeWeightedGraph G) {
    pq = new MinPQ<>();
    marked = new boolean[G.V()];
    mst = new Queue<>();
    visit(G, 0);
    while (!pq.isEmpty()) {
      Edge e = pq.delMin();
      //获取最小的横切边
      int v = e.either();
      int w = e.other(v);
      //根据点是否被访问过判断边是否合格
      if (marked[v] && marked[w]) {
        continue;
      }
      //合格的边添加到树中
      mst.enqueue(e);
      if (!marked[v]) visit(G, v);
      if (!marked[w]) visit(G, w);
    }
  }

  private void visit(EdgeWeightedGraph g, int i) {
    marked[i] = true;
    for (Edge e : g.adj(i)) {
      if (!marked[e.other(i)]) {
        //如果存在一端没有被访问过添加到优先队列
        pq.insert(e);
      }
    }
  }

  public Iterable<Edge> edges() {
    return mst;
  }

  public double weight() {
    double total = 0;
    for (Edge edge : mst) {
      total += edge.getWeight();
    }
    return total;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    EdgeWeightedGraph G = new EdgeWeightedGraph(in);
    LazyPrimMST mst = new LazyPrimMST(G);
    for (Edge e : mst.edges()) {
      StdOut.println(e);
    }
    StdOut.printf("%.5f\n", mst.weight());
  }
}
