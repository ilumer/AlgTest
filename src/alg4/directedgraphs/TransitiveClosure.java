package alg4.directedgraphs;

/**
 * Created by ilumer on 17-5-19.
 * 如何判断图中任意两点是否是可达的
 */
public class TransitiveClosure {

  DirectedDFS[] directedDfs;

  public TransitiveClosure(Digraph G) {
    directedDfs = new DirectedDFS[G.V()];

    for (int i = 0 ; i < G.V();i++){
      directedDfs[i] = new DirectedDFS(G,i);
    }
  }

  public boolean reachable(int v,int w){
    return directedDfs[v].marked(w);
  }
}
