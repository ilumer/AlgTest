package alg4.minimumspanningtree;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.GrahamScan;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-6-17.
 */
public class PrimMST {
  private IndexMinPQ<Double> pq;//有效的横切边
  private Edge[] edgeTo;
  private double[] distTo;
  private boolean[] marked;

  public PrimMST(EdgeWeightedGraph G) {
    edgeTo = new Edge[G.V()];
    distTo = new double[G.V()];
    marked = new boolean[G.V()];

    for (int v = 0; v < G.V(); v++) {
      distTo[v] = Double.POSITIVE_INFINITY;
    }

    pq = new IndexMinPQ<>(G.V());
    distTo[0] = 0.0;
    pq.insert(0, 0.0);
    while (!pq.isEmpty()) {
      visit(G, pq.delMin());
    }
  }

  // delete 0
  // delete 7
  // update pq.changeKey

  private void visit(EdgeWeightedGraph g, int i) {
    marked[i] = true;
    //第一次将顶点0的邻接边全部添加到优先队列中
    //这个是所有树中的顶点与非树中的顶点的邻接边
    for (Edge e : g.adj(i)) {
      int w = e.other(i);
      //marked 可以过滤已经在树中的点
      if (marked[w]) continue;//已经在树中
      if (e.getWeight() < distTo[w]) {
        //i->e edge = e
        edgeTo[w] = e;
        distTo[w] = e.getWeight();
        //从树中到达此点权重
        if (pq.contains(w)) {
          pq.changeKey(w, distTo[w]);
        } else {
          pq.insert(w, distTo[w]);
        }
      }
    }
  }

  public Iterable<Edge> edges(){
    //不可能出现edgeTo[0]
    Bag<Edge> mst = new Bag<>();
    for (int i = 1; i<edgeTo.length;i++){
      mst.add(edgeTo[i]);
    }
    return mst;
  }

  public double weight(){
    double weight = 0.0;
    for (Edge e:edges()){
      weight +=e.getWeight();
    }
    return weight;
  }


  public static void main(String[] args) {
    In in = new In(args[0]);
    EdgeWeightedGraph G = new EdgeWeightedGraph(in);
    PrimMST mst = new PrimMST(G);
    for (Edge e : mst.edges()) {
      StdOut.println(e);
    }
    StdOut.printf("%.5f\n", mst.weight());
  }
}
