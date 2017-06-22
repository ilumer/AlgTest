package alg4.shortestpaths;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-6-22.
 *  这里的stack是使用了alg4下的stack 在 迭代的情况下是与util下的stack相反
 */
public class DepthFirstOrder {

  private boolean[] marked;
  private Queue<Integer> preOrder;
  private Queue<Integer> postOrder;
  private Stack<Integer> reversePostOrder;

  public DepthFirstOrder(EdgeWeightedDigraph g) {

    marked = new boolean[g.V()];
    preOrder = new Queue<>();
    postOrder = new Queue<>();
    reversePostOrder = new Stack<>();

    for (int i = 0; i < g.V(); i++) {
      if (!marked[i]) {
        dfs(g, i);
      }
    }
  }

  private void dfs(EdgeWeightedDigraph g, int i) {
    marked[i] = true;
    preOrder.enqueue(i);
    for (DirectedEdge e : g.adj(i)) {
      if (!marked[e.to()]) {
        dfs(g, e.to());
      }
    }

    postOrder.enqueue(i);
    reversePostOrder.push(i);
  }

  public Queue<Integer> getPreOrder() {
    return preOrder;
  }

  public Queue<Integer> getPostOrder() {
    return postOrder;
  }

  public Iterable<Integer> getReversePostOrder() {
    return reversePostOrder;
  }

  public static void main(String[] args) {
    DepthFirstOrder depthFirstOrder = new DepthFirstOrder(new EdgeWeightedDigraph(new In(args[0])));
    for (int i:depthFirstOrder.getPostOrder()){
      StdOut.print(i+" ");
    }
    StdOut.println();
    for (int i:depthFirstOrder.getReversePostOrder()){
      StdOut.print(i+" ");
    }
  }
}
