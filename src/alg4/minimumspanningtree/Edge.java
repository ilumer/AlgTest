package alg4.minimumspanningtree;

public class  Edge implements Comparable<Edge> {
  private int V;//顶点V
  private int W;//顶点W
  private double Weight;//权重

  public Edge(int v, int w, double weight) {
    V = v;
    W = w;
    Weight = weight;
  }

  public double getWeight() {
    return Weight;
  }

  public int other(int vertex) {
    if (vertex == V) {
      return W;
    } else if (vertex == W) {
      return V;
    } else {
      throw new IllegalArgumentException("Illegal endpoint");
    }
  }

  public int either() {
    return V;
  }

  @Override public int compareTo(Edge o) {
    if (this.Weight < o.Weight) {
      return -1;
    } else if (this.Weight > o.Weight) {
      return 1;
    } else {
      return 0;
    }
  }

  @Override public String toString() {
    return String.format("%d - %d %.5f", V, W, Weight);
  }
}
