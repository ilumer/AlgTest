package alg4.directedgraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-19.
 * https://en.wikipedia.org/wiki/Strongly_connected_component
 * 强连通分量指的是 如果每个顶点都是可达的(子图)
 * 如何证明还是有点没有搞懂
 */
public class KosarajuSharirSCC {
  private boolean[] marked;
  private int[] id;
  private int count;

  public KosarajuSharirSCC(Digraph G) {
    marked = new boolean[G.V()];
    id = new int[G.V()];

    DepthFirstOrder order = new DepthFirstOrder(G.reverse());
    for (int i : order.reversePost()) {
      if (!marked[i]) {
        dfs(G, i);
        count++;
      }
    }
  }

  private void dfs(Digraph g, int i) {
    marked[i] = true;
    id[i] = count;

    for (int w : g.adj(i)) {
      if (!marked[w]) {
        dfs(g, w);
      }
    }
  }

  public boolean stronglyConnected(int v, int w) {
    return id[v] == id[w];
  }

  public int id(int v) {
    return id[v];
  }

  public int count() {
    return count;
  }

  @SuppressWarnings({"unchecked","rawtypes"})
  public static void main(String[] args) {
    In in = new In(args[0]);
    Digraph G = new Digraph(in);
    KosarajuSharirSCC scc = new KosarajuSharirSCC(G);

    // number of connected components
    int m = scc.count();
    StdOut.println(m + " strong components");

    // compute list of vertices in each strong component
    Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
    for (int i = 0; i < m; i++) {
      components[i] = new Queue<Integer>();
    }
    for (int v = 0; v < G.V(); v++) {
      components[scc.id(v)].enqueue(v);
    }

    // print results
    for (int i = 0; i < m; i++) {
      for (int v : components[i]) {
        StdOut.print(v + " ");
      }
      StdOut.println();
    }

  }
}
