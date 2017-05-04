package alg4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by ilumer on 17-5-2.
 */
public class BreadthFirstPaths {

  private boolean[] marked;
  private int[] edgeTo;
  private final int s;//起点

  public BreadthFirstPaths(Graph G, int s) {
    this.s = s;
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    bfs(G, s);
  }

  private void bfs(Graph G, int n) {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(n);
    marked[n] = true;
    while (!queue.isEmpty()) {
      //队列的先进先出性质保证了最短路径的性质
      int from = queue.dequeue();
      for (int m : G.adj(from))
        if (!marked[m]) {
          marked[m] = true;
          edgeTo[m] = from;
          queue.enqueue(m);
        }
    }
  }

  //是否存在起点S 到 V的路径
  public boolean hasPathTo(int V) {
    return marked[V];
  }

  //输出S到V的路径
  public Iterable<Integer> pathTo(int V) {
    if (!hasPathTo(V)) {
      return null;
    } else {
      Stack<Integer> stack = new Stack<>();
      for (int x = V; x != s; x = edgeTo[x]) {
        stack.push(x);
      }
      stack.push(s);
      return stack;
    }
  }
}
