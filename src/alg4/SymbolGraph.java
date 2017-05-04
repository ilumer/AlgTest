package alg4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-4.
 * 测试数据:http://algs4.cs.princeton.edu/41graph/movies.txt
 * 测试数据:http://algs4.cs.princeton.edu/41graph/routes.txt
 */
public class SymbolGraph {
  private ST<String, Integer> st;//key -- value
  private String[] keys;//value -- key
  private Graph G;

  public SymbolGraph(String stream, String sp) {
    st = new ST<>();
    In in = new In(stream);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      for (int i = 0; i < a.length; i++)
        if (!st.contains(a[i])) {
          st.put(a[i], st.size());
        }
    }
    keys = new String[st.size()];
    for (String name : st.keys()) {
      keys[st.get(name)] = name;
    }
    //读取第二次
    G = new Graph(st.size());
    in = new In(stream);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      int v = st.get(a[0]);
      //起点
      for (int i = 1; i < a.length; i++)
        G.addEdge(v, st.get(a[i]));
    }
  }

  public boolean contains(String s) {
    return st.contains(s);
  }

  public int index(String s) {
    return st.get(s);
  }

  public String name(int v) {
    return keys[v];
  }

  public Graph G() {
    return G;
  }

  public static void main(String[] args) {
    String filename = args[0];
    String delim = args[1];
    SymbolGraph graph = new SymbolGraph(filename, delim);

    Graph G = graph.G();

    while (StdIn.hasNextLine()) {
      String source = StdIn.readLine();
      //没有做异常处理
      for (int w : G.adj(graph.index(source)))
        StdOut.println(" " + graph.name(w));
    }
  }
}
