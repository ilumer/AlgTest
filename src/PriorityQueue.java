import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ilumer on 17-4-5.
 */
public class PriorityQueue<Key extends Comparable<Key>> {

  private Key[] pq;
  private int N = 0;

  public PriorityQueue(int capacity) {
    pq = (Key[]) new Comparable[capacity + 1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void insert(Key key) {
    pq[++N] = key;
    swim(N);
  }

  public Key delMax() {
    Key temp = pq[1];
    exch(1, N);
    pq[N--] = null;
    //需要下沉
    sink(1);
    return temp;
  }

  public void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exch(k, k / 2);
      k = k / 2;
    }
  }

  /*
  * 这里下沉的时候 需要判断停止的时候 设置有一个临时变量 比直接使用 2×k的情况要好很多
  * */
  public void sink(int k) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(j, j + 1)) j++;
      if (less(j, k)) break;
      exch(k, j);
      k = j;
    }
  }

  public boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  public void exch(int i, int j) {
    Key temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  @Test
  public static void main(String[] args) {
    PriorityQueue<Item> priorityQueue = new PriorityQueue<>(10);
    priorityQueue.insert(new Item(10));
    priorityQueue.insert(new Item(19));
    priorityQueue.insert(new Item(44));
    priorityQueue.insert(new Item(99));
    priorityQueue.insert(new Item(25));
    Assert.assertEquals(99, priorityQueue.delMax().getKey());
    Assert.assertEquals(44, priorityQueue.delMax().getKey());
    Assert.assertEquals(25, priorityQueue.delMax().getKey());
    Assert.assertEquals(19, priorityQueue.delMax().getKey());
    Assert.assertEquals(10, priorityQueue.delMax().getKey());
  }
}
