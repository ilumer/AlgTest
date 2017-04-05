import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-4-5.
 * 测试用例 http://algs4.cs.princeton.edu/24pq/tiny.txt
 * 代码来源 http://algs4.cs.princeton.edu/24pq/Heap.java.html
 */
public class HeapSort {

  public static void sort(Comparable[] a) {
    //先建立一个堆 并不需要生成一个优先队列 用下沉
    int N = a.length;
    //从1开始建立有什么问题  以下沉的方式建立堆会出现建堆错误
    //无法保证子节点的问题(根节点大于两个子节点不能保证大于全部的节点)
    for (int i = N / 2; i >= 1; i--) {
      sink(a, i, N);
    }
    //这个时候需要去丢弃已经排列好的最大数

    while (N > 1) {
      exch(a, 1, N);
      sink(a, 1, --N);
    }

    //然后在下沉排序
  }

  public static void sink(Comparable[] a, int i, int hi) {
    while (2 * i < hi) {
      int j = 2 * i;
      if (less(a, j, j + 1)) j++;
      if (less(a, j, i)) break;
      exch(a, i, j);
      i = j;
    }
  }

  public static boolean less(Comparable[] a, int i, int j) {
    return a[i - 1].compareTo(a[j - 1]) < 0;
  }

  public static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i - 1];
    a[i - 1] = a[j - 1];
    a[j - 1] = temp;
  }

  public static void show(Comparable[] a) {
    for (Comparable temp : a) {
      StdOut.println(temp);
    }
  }

  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    sort(a);
    show(a);
  }
}
