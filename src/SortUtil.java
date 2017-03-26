import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-3-26.
 */
public class SortUtil {

  /**
   *
   * @param v
   * @param w
   * @return v < w return true else return false
   */
  public static boolean less(Comparable v,Comparable w){
    return v.compareTo(w) < 0 ;
  }


  public static void exch(Comparable[] a ,int i,int j){
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++){
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  /**
   *
   * @param a
   * @return 如果是从小到大排列 return true 否则 return false
   */
  public static boolean isSorted(Comparable[] a){
    for (int i = 1; i < a.length;i++){
      if (less(a[i],a[i-1])){
        return false;
      }
    }
    return true;
  }
}
