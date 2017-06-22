package alg4.shortestpaths;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 有向权重图的拓扑排序
 */
public class EdgeWeightedDigraphTopoLogical {

  Iterable<Integer> order;

  public EdgeWeightedDigraphTopoLogical(EdgeWeightedDigraph g) {
    EdgeWeightedCycleFinder finder = new EdgeWeightedCycleFinder(g);
    if (finder.hasCycle()) {
      order = null;
    } else {
      DepthFirstOrder depthFirstOrder = new DepthFirstOrder(g);
      order = depthFirstOrder.getReversePostOrder();
    }
  }

  public Iterable<Integer> getOrder() {
    return order;
  }

  public boolean isDAG() {
    return order == null;
  }

  public static void main(String[] args) {
    EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In(args[0]));
    EdgeWeightedDigraphTopoLogical topoLogical = new EdgeWeightedDigraphTopoLogical(g);
    for (Integer i:topoLogical.order){
      StdOut.printf("from %d to ",i);
    }
  }
}
