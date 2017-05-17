package alg4.undirectedgraphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-1.
 * 图的基本API
 * 测试数据:http://algs4.cs.princeton.edu/41graph/tinyG.txt
 */
public class Graph {

  private final int V;//顶点数

  private int E;

  private Bag<Integer>[] adj;//邻接表

  //创建一个含有V个顶点但是不含有边的图
  @SuppressWarnings({"unchecked","rawtypes"})
  public Graph(int V) {
    this.V = V;
    this.E = 0;
    adj = (Bag<Integer>[]) new Bag[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new Bag<>();//类型推导
    }
  }

  //从标准输入流中读入一副图
  public Graph(In in) {
    this(in.readInt());
    int E = in.readInt();
    //没有直接读取E 是为了用addEdge来更新Edge
    for (int i = 0; i < E; i++) {
      //v,w属于 [0,E-1]
      int v = in.readInt();
      int w = in.readInt();
      addEdge(v, w);
    }
  }

  //顶点数
  int V() {
    return V;
  }

  //边数
  int E() {
    return E;
  }

  //想图中添加一条边V-W
  void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
    E++;
  }

  //和V相邻的所有顶点
  //当两个顶点通过一条边相连的时，两个顶点是相邻的
  Iterable<Integer> adj(int v) {
    return adj[v];
  }

  //tostring方法直接重写 可以使用StringBuilder
  @Override public String toString() {
    String s = V + "vertices," + E +" edges\n";
    //输出顶点数和边数
    for (int i = 0; i<V;i++){
      s+=i+" : ";
      for (int m:adj(i)){
        //自动拆箱
        s+=m+" ";
      }
      s+="\n";
    }
    return s;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    Graph G = new Graph(in);
    StdOut.println(G);
  }
}
