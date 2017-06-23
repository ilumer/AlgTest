package alg4.shortestpaths;

import edu.princeton.cs.algs4.AcyclicLP;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;

/**
 * Created by ilumer on 17-6-23.
 * test file:http://algs4.cs.princeton.edu/44sp/jobsPC.txt
 */
public class CPM {

  public static void main(String[] args) {
    int n = StdIn.readInt();

    // source and sink
    int source = 2 * n;
    int sink = 2 * n + 1;

    // build network
    EdgeWeightedDigraph G = new EdgeWeightedDigraph(2 * n + 2);
    for (int i = 0; i < n; i++) {
      double duration = StdIn.readDouble();
      //读取权重
      G.addEdge(new DirectedEdge(source, i, 0.0));
      G.addEdge(new DirectedEdge(i + n, sink, 0.0));
      //为每个任务添加一条从起点指向每个任务的的起始顶点的边
      //为每个任务添加一条从每个任务的结束顶点的边指向终点的边

      G.addEdge(new DirectedEdge(i, i + n, duration));
      // precedence constraints
      int m = StdIn.readInt();
      //任务依赖的其他任务的数量
      for (int j = 0; j < m; j++) {
        int precedent = StdIn.readInt();
        G.addEdge(new DirectedEdge(n + i, precedent, 0.0));
        //添加 v-w的权重为0的边
      }
    }
    //如何构造这个图

    // compute longest path
    AcyclicLP lp = new AcyclicLP(G, source);
    // //AcyclicLP
    //将 AcyclicSP中的 distTo距离改为最小值 同时将relax 改变寻找最长路径
    //  distto[to] < distTo[from] + e.weight()

    // print results
    StdOut.println(" job   start  finish");
    StdOut.println("--------------------");
    for (int i = 0; i < n; i++) {
      StdOut.printf("%4d %7.1f %7.1f\n", i, lp.distTo(i), lp.distTo(i + n));
    }
    StdOut.printf("Finish time: %7.1f\n", lp.distTo(sink));
  }
}
