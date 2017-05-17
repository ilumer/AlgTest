package alg4.undirectedgraphs;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-4.
 * 测试数据:http://algs4.cs.princeton.edu/41graph/routes.txt
 */
public class DegreesOfSeparation {
  public static void main(String[] args) {
    SymbolGraph sg = new SymbolGraph(args[0],args[1]);
    Graph g = sg.G();
    String source = args[2];
    if (!sg.contains(source)){
      StdOut.println(source + "not in database.");
      return;
    }

    int s = sg.index(source);
    BreadthFirstPaths bfs = new BreadthFirstPaths(g,s);

    while (!StdIn.isEmpty()){
      String sink = StdIn.readLine();
      if (sg.contains(sink)){
        int end = sg.index(sink);
        if (bfs.hasPathTo(end))
          for (int m : bfs.pathTo(end))
            StdOut.println(" "+sg.name(m));
        else
          StdOut.println("not connected");
      }else {
        StdOut.println(sink+" not in database");
      }
    }
  }
}
