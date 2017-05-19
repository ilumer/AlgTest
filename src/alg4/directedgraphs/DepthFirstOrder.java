package alg4.directedgraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-18.
 * 前序：在递归调用之前将顶点加入队列
 * 后序：在递归调用之后将顶点加入队列
 * 逆后序： 在递归调之后将顶点压入在栈
 *     v  pre post
 *  --------------
 *     0    0    8
 *     1    3    2
 *     2    9   10
 *     3   10    9
 *     4    2    0
 *     5    1    1
 *     6    4    7
 *     7   11   11
 *     8   12   12
 *     9    5    6
 *    10    8    5
 *    11    6    4
 *    12    7    3
 *  Preorder:  0 5 4 1 6 9 11 12 10 2 3 7 8
 *  Postorder: 4 5 1 12 11 10 9 6 0 3 2 7 8
 *  Reverse postorder: 8 7 2 3 0 6 9 10 11 12 1 5 4
 */
public class DepthFirstOrder {

  private boolean[] marked;
  private int[] pre;
  private int[] post;
  private Queue<Integer> preOrder;
  private Queue<Integer> postOrder;
  private Stack<Integer> reversePostOrder;
  private int preCounter;   //counter or preorder numbering
  private int postCounter;  //counter or postorder numbering


  public DepthFirstOrder(Digraph G) {
    pre = new int[G.V()];
    post = new int[G.V()];
    preOrder = new Queue<>();
    postOrder = new Queue<>();
    reversePostOrder = new Stack<>();
    marked = new boolean[G.V()];

    for (int i = 0; i < G.V(); i++) {
      if (!marked[i]) {
        dfs(G, i);
      }
    }
  }

  private void dfs(Digraph g, int i) {
    marked[i] = true;
    preOrder.enqueue(i);
    pre[i] = preCounter++;
    for (int m : g.adj(i)) {
      if (!marked[m]) {
        dfs(g, m);
      }
    }
    postOrder.enqueue(i);
    post[i] = postCounter++;
    reversePostOrder.push(i);
  }

  public Iterable<Integer> pre() {
    return preOrder;
  }

  //returns the preOrder number of vertex
  public int pre(int i){
    return pre[i];
  }

  public Iterable<Integer> post() {
    return postOrder;
  }

  //returns the postOrder number of vertex
  public int post(int i){
    return post[i];
  }

  public Iterable<Integer> reversePost() {
    return reversePostOrder;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Digraph G = new Digraph(in);

    DepthFirstOrder dfs = new DepthFirstOrder(G);
    StdOut.println("   v  preOrder postOrder");
    StdOut.println("--------------");
    for (int v = 0; v < G.V(); v++) {
      StdOut.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
    }

    StdOut.print("Preorder:  ");
    for (int v : dfs.pre()) {
      StdOut.print(v + " ");
    }
    StdOut.println();

    StdOut.print("Postorder: ");
    for (int v : dfs.post()) {
      StdOut.print(v + " ");
    }
    StdOut.println();

    StdOut.print("Reverse postorder: ");
    for (int v : dfs.reversePost()) {
      StdOut.print(v + " ");
    }
    StdOut.println();
  }
}
