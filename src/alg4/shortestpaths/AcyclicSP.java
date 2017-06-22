package alg4.shortestpaths;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
* test file:http://algs4.cs.princeton.edu/44sp/tinyEWDAG.txt
*
* */

public class AcyclicSP {

  private DirectedEdge[] edgeTo;
  private double[] distTo;

  public AcyclicSP(EdgeWeightedDigraph g, int s) {
    edgeTo = new DirectedEdge[g.V()];
    distTo = new double[g.V()];
    for (int i = 0; i < g.V(); i++) {
      distTo[i] = Double.POSITIVE_INFINITY;
    }
    distTo[s] = 0;
    EdgeWeightedDigraphTopoLogical topoLogical = new EdgeWeightedDigraphTopoLogical(g);

    for (int v : topoLogical.order) {
      realx(g, v);
    }
  }

  private void realx(EdgeWeightedDigraph g, int v) {
    for (DirectedEdge e : g.adj(v)) {
      int to = e.to();
      if (distTo[to] > distTo[v] + e.weight()) {
        distTo[to] = distTo[v] + e.weight();
        edgeTo[to] = e;//to 代表的是尾点 根据尾点来倒退起点
      }
    }
  }

  public boolean hasPathTo(int v) {
    return distTo[v] != Double.POSITIVE_INFINITY;
  }

  public Double distTo(int v) {
    return distTo[v];
  }

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
    int s = Integer.parseInt(args[1]);
    EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

    // find shortest path from s to each other vertex in DAG
    AcyclicSP sp = new AcyclicSP(G, s);
    for (int v = 0; v < G.V(); v++) {
      if (sp.hasPathTo(v)) {
        StdOut.printf("%d to %d (%.2f)  ", s, v, sp.distTo(v));
        for (DirectedEdge e : sp.pathTo(v)) {
          StdOut.print(e + "   ");
        }
        StdOut.println();
      } else {
        StdOut.printf("%d to %d         no path\n", s, v);
      }
    }
  }
}
