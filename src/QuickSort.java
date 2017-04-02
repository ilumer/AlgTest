import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ilumer on 17-4-1.
 */
public class QuickSort {

  public static void sort(Comparable[] a) {
    int n = a.length;
    sort(a, 0, n - 1);
  }

  public static void sort(Comparable[] a, int lo, int hi) {
    if (lo == hi) {
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j);
    sort(a, lo + 1, hi);
  }

  /*
  *
  * 需要考虑过界的问题
  * */
  public static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    //这里+1主要是配合下面--j
    while (true) {
      while (SortUtil.less(a[++i], a[lo])) {
        if (i == hi) break;
      }
      while (SortUtil.less(a[lo], a[--j])) {
        if (j == lo) break;
      }
      //处理边界溢出的情况
      //i与j相遇的情况
      // 1. i刚好等于j 因为 a[i] < a[lo] 为false a[j] > a[lo] 为false 这个时候说明 a[lo] 等于 a[j]
      // 2. i 大于 j 时
      //      [ 5, 1, 3, 4, 6, 7, 8, 9, 10]
      //index   0, 1, 2, 3, 4, 5, 6, 7, 8
      //lo = 0 时  i = 4 j = 3
      if (i >= j) {
        break;
      }
      SortUtil.exch(a, i, j);
    }
    //交换j，lo的数组
    SortUtil.exch(a, lo, j);
    //这里是把被排序的数放在j的位置
    return j;
  }

  @Test
  public static void main(String[] args) {
    Integer[] array = new Integer[] {5, 1, 3, 4, 6, 7, 8, 9, 10};
    sort(array);
    Assert.assertTrue(SortUtil.isSorted(array));
    SortUtil.show(array);
  }
}
