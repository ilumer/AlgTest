package alg4.directedgraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-18.
 * Data files:   http://algs4.cs.princeton.edu/42digraph/tinyDG.txt
 *
 * 3 to 0:  3-5-4-2-0
 * 3 to 1:  3-5-4-2-0-1
 * 3 to 2:  3-5-4-2
 * 3 to 3:  3
 * 3 to 4:  3-5-4
 * 3 to 5:  3-5
 * 3 to 6:  not connected
 * 3 to 7:  not connected
 * 3 to 8:  not connected
 * 3 to 9:  not connected
 * 3 to 10:  not connected
 * 3 to 11:  not connected
 * 3 to 12:  not connected
 * java-algs4 alg4/directedgraphs/DepthFirstDirectedPaths alg4/directedgraphs/tinyDG.txt 3
 */
public class DepthFirstDirectedPaths {

  private int V;//代表起点
  private boolean[] marked;//此点是否已经被访问
  private int[] edgeTo;//代表着两点间的路径 从被寻找点开始寻找起点
  private int[] edgeFrom;//代表两点间的路径 从起点寻找终点

  public DepthFirstDirectedPaths(Digraph G, int V) {
    this.marked = new boolean[G.V()];
    this.edgeTo = new int[G.V()];
    this.edgeFrom = new int[G.V()];
    this.V = V;
    dfs(G, V);
  }

  /**
   * @param E the head vertex
   * @return the edgeTo from V to E
   */
  public Iterable<Integer> pathTo(int E) {
    if (!hasPathTo(E)) {
      return null;
    }
    Stack<Integer> path = new Stack<>();
    for (int i = E; i != V; i = edgeTo[i]) {
      path.push(i);
    }
    path.push(V);
    return path;
  }

  public Iterable<Integer> pathFrom(int E) {
    if (!hasPathTo(E)) {
      return null;
    }

    Queue<Integer> path = new Queue<>();

    for (int i = V; i != E; i = edgeFrom[i]) {
      path.enqueue(i);
    }
    path.enqueue(E);
    return path;
  }

  private void dfs(Digraph g, int m) {
    marked[m] = true;//m 已经被访问

    //这里是提前遍历 找出与起点连通的点
    for (int n : g.adj(m)) {
      if (!marked[n]) {
        edgeTo[n] = m;//m->n
        edgeFrom[m] = n;
        //由后向前
        dfs(g, n);
      }
    }
  }

  /**
   * @param E the head vertex
   * @return{@code true} if there is a edgeTo ,{@code false} otherwise
   */
  public boolean hasPathTo(int E) {
    return marked[E];
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Digraph G = new Digraph(in);
    // StdOut.println(G);

    int s = Integer.parseInt(args[1]);
    DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(G, s);

    for (int v = 0; v < G.V(); v++) {
      if (dfs.hasPathTo(v)) {
        StdOut.printf("%d to %d:  ", s, v);
        for (int x : dfs.pathTo(v)) {
          if (x == s) {
            StdOut.print(x);
          } else {
            StdOut.print("-" + x);
          }
        }
        StdOut.println();
      } else {
        StdOut.printf("%d to %d:  not connected\n", s, v);
      }
    }
  }
}
