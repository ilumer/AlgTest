import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ilumer on 17-3-31.
 */
public class MergeSort {

  public static Comparable[] aux;

  public static void merge(Comparable[] a,Comparable[] aux,int lo,int mid,int hi){
    //a[lo] -> a[mid]已经是有序的
    //a[mid] -> a[hi]
    for (int i = 0;i<a.length;i++){
      aux[i] = a[i];
    }

    int i = lo,j= mid+1;
    for (int k = lo;k<a.length;k++){
      if (i<=mid&&j<a.length){
        if (SortUtil.less(aux[i],aux[j])){
          a[k] = aux[i++];
        }else {
          a[k] = aux[j++];
        }
      }else if (i>mid){
        a[k] = aux[j++];
      }else if (j==a.length){
        a[k] = aux[i++];
      }
    }
  }

  public static void sort(Comparable[] a){
    aux = new Comparable[a.length];
    sort(a,aux,0,a.length-1);
  }

  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    if (hi <=lo){
      //处理a.length == 0 时 hi<lo;
      return;
    }

    int mid = lo + (hi-lo)/2;
    sort(a,aux,lo,mid);
    sort(a,aux,mid+1,hi);
    merge(a,aux,lo,mid,hi);
  }

  @Test
  public static void main(String[] args) {
    Integer[] array = new Integer[]{1,2,3,4,6,5,7,1,10,4,7};
    sort(array);
    Assert.assertTrue(SortUtil.isSorted(array));
    SortUtil.show(array);
  }
}
