package alg4.directedgraphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-5-17.
 * 可达的点就是被标记的点
 * Data files:   http://algs4.cs.princeton.edu/42digraph/tinyDG.txt
 *  % java-algs4 DirectedDFS tinyDG.txt 1
 *  1
 *
 *  % java-algs4 DirectedDFS tinyDG.txt 2
 *  0 1 2 3 4 5
 *
 *  % java-algs4 DirectedDFS tinyDG.txt 1 2 6
 *  0 1 2 3 4 5 6 8 9 10 11 12
 */
public class DirectedDFS {

  private boolean[] marked;

  public DirectedDFS(Digraph G, int s) {
    marked = new boolean[G.V()];
    dfs(G, s);
  }

  public DirectedDFS(Digraph G, Iterable<Integer> sources) {
    marked = new boolean[G.V()];
    for (int w : sources) {
      if (!marked(w)) dfs(G, w);
    }
  }

  private void dfs(Digraph g, int s) {
    marked[s] = true;
    for (int w : g.adj(s)) {
      if (!marked[w]) {
        dfs(g, w);
      }
    }
  }

  public boolean marked(int v) {
    return marked[v];
  }

  public static void main(String[] args){
    Digraph G = new Digraph(new In(args[0]));
    Bag<Integer> sources = new Bag<>();

    for (int i = 1; i <args.length;i++){
      sources.add(Integer.parseInt(args[i]));
    }

    DirectedDFS directedDFS = new DirectedDFS(G,sources);

    for (int i =0 ; i <G.V();i++){
      if (directedDFS.marked(i)){
        StdOut.print(i + " ");
      }
    }
    StdOut.println();
  }
}
