package alg4.shortestpaths;

public class DirectedEdge {
  private int from;
  private int to;
  private double weight;

  public DirectedEdge(int from, int to, double weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  public double weight() {
    return weight;
  }

  public int from() {
    return from;
  }

  public int to() {
    return to;
  }

  @Override public String toString() {
    return String.format("%d -> %d %.2f", from, to, weight);
  }
}
