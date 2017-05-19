package alg4.directedgraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-18.
 * 单点最短的有向路径
 * http://algs4.cs.princeton.edu/42digraph/BreadthFirstDirectedPaths.java.html
 */
public class BreadthFirstDirectedPaths {

  private int[] edgeTo;//edgeTo[v] = previous vertex on path to v
  public boolean[] marked;//是否被访问过
  private int s;//起点
  private int[] dist;

  public BreadthFirstDirectedPaths(Digraph G, int s) {
    this.marked = new boolean[G.V()];
    this.edgeTo = new int[G.V()];
    this.dist = new int[G.V()];
    this.s = s;
    bfs(G, s);
  }

  private void bfs(Digraph g, int m) {
    Queue<Integer> queue = new Queue<>();
    dist[m] =0;
    queue.enqueue(m);
    marked[m] = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int n = queue.dequeue();
        for (int j : g.adj(n)) {
          if (!marked[j]) {
            edgeTo[j] = n;
            dist[j] = dist[n]+1;
            marked[j] = true;
            queue.enqueue(j);
          }
        }
      }
    }
  }

  public boolean hasPathTo(int E) {
    return marked[E];
  }

  public Iterable<Integer> pathTo(int E) {
    if (!hasPathTo(E)) {
      return null;
    }
    Stack<Integer> path = new Stack<>();

    for (int i = E; i != s; i = edgeTo[i]) {
      path.push(i);
    }
    path.push(s);
    return path;
  }

  public int distTo(int E){
    return dist[E];
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Digraph G = new Digraph(in);
    // StdOut.println(G);

    int s = Integer.parseInt(args[1]);
    BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(G, s);

    for (int v = 0; v < G.V(); v++) {
      if (bfs.hasPathTo(v)) {
        StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
        for (int x : bfs.pathTo(v)) {
          if (x == s) StdOut.print(x);
          else        StdOut.print("->" + x);
        }
        StdOut.println();
      }

      else {
        StdOut.printf("%d to %d (-):  not connected\n", s, v);
      }

    }
  }
}
