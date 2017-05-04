package alg4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-3.
 */
public class CC {

  private boolean[] marked;
  private int[] id;
  private int count;
  //预处理构造函数
  public CC(Graph G){
    marked = new boolean[G.V()];
    id = new int[G.V()];
    //起点为0
    for (int i = 0;i <G.V();i++){
      if (!marked[i]){
        dfs(G,i);
        count++;
      }
    }
  }

  private void dfs(Graph g, int i) {
    marked[i] = true;
    id[i] = count;
    //用来标记同一连通分量
    for (int m:g.adj(i)){
      if (!marked[m])
        dfs(g,m);
    }
  }

  //连通分量数
  int count(){
    return count;
  }

  //V和W是否连通
  boolean connected(int V,int W){
    return id[V] == id[W];
  }

  //V所在的连通分量的标识符(0 -- count() -1 )
  int id(int V){
    return id[V];
  }

  @SuppressWarnings({"unchecked","rawtypes"})
  public static void main(String[] args) {
    Graph G = new Graph(new In(args[0]));
    CC cc = new CC(G);

    int M = cc.count();
    StdOut.println(M + "components");

    Bag<Integer>[] components = (Bag<Integer>[]) new Bag[M];
    for (int i = 0; i<M;i++){
      components[i] = new Bag<>();
    }

    for (int V=0;V<G.V();V++){
      components[cc.id(V)].add(V);
      //将同一连通分量的顶点联合到一起
    }

    for (int i =0;i<M;i++){
      for (int v:components[i]){
        StdOut.print(v+" ");
      }
      StdOut.println();
    }
  }
}
