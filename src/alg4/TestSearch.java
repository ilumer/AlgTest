package alg4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-3.
 */
public class TestSearch {

  public static void main(String[] args) {
    Graph G = new Graph(new In(args[0]));
    int s = Integer.parseInt(args[1]);
    Search search = new DepthFirstSearch(G,s);

    for (int v = 0; v<G.V();v++){
      if (search.marked(v))
        StdOut.print(v+" ");
    }
    StdOut.println();

    if (search.count()!=G.V()){
      //当起点可以与所有点连通时 可以证明图是连通的
      StdOut.print("Not ");
    }
    StdOut.println("connected");
  }
}
