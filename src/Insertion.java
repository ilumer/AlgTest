import edu.princeton.cs.algs4.StdIn;
import org.junit.Assert;
import org.junit.Test;

/**
 * 根据排列纸牌的想法 把抽到的牌与手中的牌往小的方向逐步排序
 * Created by ilumer on 17-3-29.
 */
public class Insertion {
  public static void sort(Comparable[] a){
    for (int i =1;i<a.length;i++)
      for (int j = i;j>0&&!SortUtil.less(a[j-1],a[j]);j--){
        SortUtil.exch(a,j-1,j);
      }
  }

  @Test
  public static void main(String[] args) {
    String[] array = StdIn.readAllStrings();
    sort(array);
    Assert.assertTrue(SortUtil.isSorted(array));
    SortUtil.show(array  );
  }
}
