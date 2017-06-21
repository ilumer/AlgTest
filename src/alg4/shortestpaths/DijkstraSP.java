package alg4.shortestpaths;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-6-21.
 */
public class DijkstraSP {
  private DirectedEdge[] edgeTo;
  private double[] distTo;
  private IndexMinPQ<Double> pq;

  /**
   * @param G 有向权重图
   * @param s 起点
   */
  public DijkstraSP(EdgeWeightedDigraph G, int s) {
    edgeTo = new DirectedEdge[G.E()];
    distTo = new double[G.E()];
    pq = new IndexMinPQ<>(G.V());
    for (int v = 0; v < G.V(); v++) {
      distTo[v] = Double.POSITIVE_INFINITY;
    }
    distTo[0] = 0.0;
    //初始化初始条件
    pq.insert(s, 0.0);
    while (!pq.isEmpty()) {
      relax(G, pq.delMin());
      //根据距离的大小来判断是否del
    }
  }

  private void relax(EdgeWeightedDigraph g, int i) {
    for (DirectedEdge e : g.adj(i)) {
      int w = e.to();
      //是否存在更小的路径
      if (distTo[w] > distTo[i] + e.weight()) {
        distTo[w] = distTo[i] + e.weight();
        edgeTo[w] = e;

        if (pq.contains(w)) {
          pq.changeKey(w, distTo[w]);
        } else {
          pq.insert(w, distTo[w]);
        }
      }
    }
  }

  public double distTo(int v) {
    return distTo[v];
  }

  public boolean hasPathTo(int v) {
    return distTo[v] != Double.POSITIVE_INFINITY;
  }

  /**
   * @param v 终点
   * @return s到v的最短路径
   */
  public Iterable<DirectedEdge> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    Stack<DirectedEdge> path = new Stack<>();
    //from -> to 根据终点寻找起点
    for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
      path.push(e);
    }
    return path;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
    int s = Integer.parseInt(args[1]);

    // compute shortest paths
    DijkstraSP sp = new DijkstraSP(G, s);

    // print shortest path
    for (int t = 0; t < G.V(); t++) {
      if (sp.hasPathTo(t)) {
        StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
        for (DirectedEdge e : sp.pathTo(t)) {
          StdOut.print(e + "   ");
        }
        StdOut.println();
      } else {
        StdOut.printf("%d to %d         no path\n", s, t);
      }
    }
  }
}
