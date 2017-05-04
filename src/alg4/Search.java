package alg4;

/**
 * Created by ilumer on 17-5-1.
 */
public abstract class Search {

  //找到与起点S连通的所有顶点 连通:两点间存在路径
  public Search(Graph G,int s){

  }

  //V和起点S是否连通
  abstract boolean marked(int V);

  //与起点S连通的点的数量
  abstract int count();
}
