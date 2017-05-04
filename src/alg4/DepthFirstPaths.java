package alg4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-1.
 * 深度优先选找路径
 * 测试数据:http://algs4.cs.princeton.edu/41graph/tinyCG.txt
 * 用数组表示起点和重点
 */
public class DepthFirstPaths {

  private boolean[] marked;//这个顶点是否调用了dfs
  private int[] edgeTo; //从起点到终点的已知路径上的最后一个顶点(将要被访问到的一个顶点)
  private final int s; //起点

  public DepthFirstPaths(Graph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    dfs(G, s);
  }

  private void dfs(Graph G, int s) {
    marked[s] = true;
    for (int i : G.adj(s)) {
      if (!marked[i]) {
        edgeTo[i] = s;//s-i 第一次访问i时经过的边
        //index代表终点 s代表的是起点
        dfs(G, i);
      }
    }
  }

  //起点S是否存在到V的路径
  boolean hasPathTo(int v) {
    return marked[v];
  }

  //s-v的路径
  Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) {
      return null;
    } else {
      Stack<Integer> stack = new Stack<>();
      for (int x = v; x != s; x = edgeTo[x]) {
        //根据终点x 去选找起点 edgeTo[x]
        //是否可以使用hashmap?
        stack.push(x);
      }
      stack.push(s);
      return stack;
    }
  }
}
