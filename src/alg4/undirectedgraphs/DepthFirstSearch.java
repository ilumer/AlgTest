package alg4.undirectedgraphs;

/**
 * Created by ilumer on 17-5-1.
 * 深度优先查找
 */
public class DepthFirstSearch extends Search {

  private boolean[] marked;
  private int count = 0;

  public DepthFirstSearch(Graph G, int s) {
    super(G, s);
    marked = new boolean[G.V()];
    dfs(G, s);
  }

  private void dfs(Graph g, int s) {
    marked[s] = true;
    //已经遍历了这个点
    count++;
    for (int i : g.adj(s)) {
      if (!marked[i]) {
        dfs(g, i);
      }
    }
  }

  @Override boolean marked(int V) {
    return marked[V];
  }

  //返回与起点S的连通的数量
  @Override int count() {
    return count;
  }
}
