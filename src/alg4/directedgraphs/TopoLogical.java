package alg4.directedgraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolDigraph;

/**
 * Created by ilumer on 17-5-18.
 * 拓扑排序： https://zh.wikipedia.org/wiki/%E6%8B%93%E6%92%B2%E6%8E%92%E5%BA%8F
 * 拓扑排序：对于给定的一幅有向图，就是找一个节点的顺序，在这个顺序里排在后面的节点在图中不指向前面的节点
 * test file:http://algs4.cs.princeton.edu/42digraph/jobs.txt
 */
public class TopoLogical {
  private Iterable<Integer> order;

  public TopoLogical(Digraph digraph) {
    DirectedCycle cycle = new DirectedCycle(digraph);
    if (!cycle.hasCycle()){
      DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
      order = depthFirstOrder.reversePost();
    }
  }

  public Iterable<Integer> getOrder(){
    return order;
  }

  public boolean isDAG(){
    //是否是有向无环图
    return order !=null;
  }


}
