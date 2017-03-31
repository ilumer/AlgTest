import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;

/**
 * 希尔排序 插入的排序的优化版  h = h*3+1 为算法书中提出的一个效率很高的 sequence
 * Created by ilumer on 17-3-31.
 */
public class Shell {

  public static void sort(Comparable[] a) {
    int N = a.length;
    int h = 1;
    while (h < N / 3) {
      h = h * 3 + 1;
    }
    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && SortUtil.less(a[j], a[j - h]); j -= h) {
          SortUtil.exch(a, j, j - h);
        }
      }
      h = h / 3;
    }
  }

  @Test
  public static void main(String[] args) {
    Integer[] array = new Integer[] {3, 4, 7, 1, 3, 55, 77, 88, 11, 22, 4, 33, 123, 45};
    sort(array);
    Assert.assertTrue(SortUtil.isSorted(array));
    SortUtil.show(array);
  }
}
