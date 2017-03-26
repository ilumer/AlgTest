import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import org.junit.Assert;
import org.junit.Test;

/**
 * 使用了junit 代替了 assert，使用了Algs4的API
 * 选择排序
 * Created by ilumer on 17-3-26.
 */
public class Selection {

  public static void sort(Comparable[] a){
    for (int i = 0;i < a.length;i++){
      int minIndex = i;
      for (int j = i; j < a.length;j++) {
        if (!SortUtil.less(a[minIndex], a[j])) {
          minIndex = j;
        }
      }
      SortUtil.exch(a,i,minIndex);
    }
  }

  @Test
  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    sort(a);
    Assert.assertTrue(SortUtil.isSorted(a));
    SortUtil.show(a);
  }
}
