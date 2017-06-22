package alg4.shortestpaths;

import edu.princeton.cs.algs4.Stack;

/**
 * 判断加权有向图是否有环DAG
 */
public class EdgeWeightedCycleFinder {

  private boolean marked[];
  private boolean onStack[];
  private Stack<Integer> stack;

  public EdgeWeightedCycleFinder(EdgeWeightedDigraph g) {
    marked = new boolean[g.V()];
    onStack = new boolean[g.V()];

    for (int i = 0; i < g.V(); i++) {
      if (!marked[i]) {
        dfs(g, i);
      }
    }
  }

  private void dfs(EdgeWeightedDigraph g, int to) {
    marked[to] = true;
    onStack[to] = true;
    for (DirectedEdge e : g.adj(to)) {
      if (!hasCycle()) {
        return;
      } else if (!marked[e.to()]) {
        dfs(g, e.to());
      } else if (onStack[e.to()]) {
        //存在环
        stack = new Stack<>();
        //并没有实现返回环的路径
      }
    }
    onStack[to] = false;
    //在深度优先回退的时候将路径的上的点恢复
  }

  public boolean hasCycle() {
    return stack != null;
  }
}
