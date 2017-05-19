package alg4.directedgraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-18.
 * java-algs4 alg4/directedgraphs/DirectedCycle alg4/directedgraphs/tinyDG.txt
 * output: 3 5 4 3
 */
public class DirectedCycle {
  private boolean[] marked;
  private boolean[] onStack;//递归调用栈上所有顶点
  private int[] edgeTo; // edgeTo[v] = previous vertex on path to v
  private Stack<Integer> cycle;

  public DirectedCycle(Digraph G) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    onStack = new boolean[G.V()];
    for (int i = 0; i < G.V(); i++) {
      if (!marked[i]) {
        dfs(G, i);
      }
    }
  }

  private void dfs(Digraph g, int i) {
    marked[i] = true;
    onStack[i] = true;
    for (int m : g.adj(i)) {
      if (this.hasCycle()) {
        return;
      } else if (!marked[m]) {
        edgeTo[m] = i;
        dfs(g, m);
      } else if (onStack[m]) {
        //出现了环
        cycle = new Stack<>();
        //从
        for (int x = i; x != m; x = edgeTo[x]) {
          cycle.push(x);
        }
        cycle.push(m);
        //i - m 的路径
        cycle.push(i);
        //添加起点 形成环
        // 假设 3,4,5形成了环
        //    3
        //   /  \
        //  4 -->5
        // 可以表达为 3,4,5,3
        //            4,5,3,4
        //            5 3 4 5
      }
      onStack[i] = false;
      //表示递归的栈pop
    }
  }

  public boolean hasCycle() {
    return cycle != null;
  }

  public Iterable<Integer> cycle() {
    return cycle;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Digraph G = new Digraph(in);

    DirectedCycle finder = new DirectedCycle(G);
    if (finder.hasCycle()) {
      StdOut.print("Directed cycle: ");
      for (int v : finder.cycle()) {
        StdOut.print(v + " ");
      }
      StdOut.println();
    } else {
      StdOut.println("No directed cycle");
    }
    StdOut.println();
  }
}
