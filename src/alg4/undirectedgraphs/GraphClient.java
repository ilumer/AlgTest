package alg4.undirectedgraphs;

/**
 * Created by ilumer on 17-5-1.
 */
public class GraphClient {
  //计算V的度数 度数的定义：某个顶点的度数即为这个顶点的边数
  public static int degree(Graph G, int v) {
    int degree = 0;
    for (int w : G.adj(v)) {
      degree++;
    }
    return degree;
  }

  //计算图中的最大顶点数
  public static int maxDegree(Graph G) {
    int max = 0;
    for (int i = G.V() - 1; i >= 0; i--) {
      if (degree(G, i) > max) {
        max = degree(G, i);
      }
    }
    return max;
  }

  //计算所有顶点的平均度数
  public static double avgDegree(Graph G) {
    return (G.E() * 2.0) / G.V();
    //两个对应的顶点只对应一条边
  }

  //计算自环的个数 自环的定义:兩個端點為同一頂點的邊
  public static int numberOfSelfLoops(Graph G) {
    int count = 0;
    for (int i = G.V() -1;i>=0;i--){
      for (int m:G.adj(i)){
        if (i==m){
          count++;
        }
      }
    }
    return count/2;//因为在添加边的时候会添加两次
    //adj[v].add[v];
    //adj[v].add[v];
    //E++;
  }
}
