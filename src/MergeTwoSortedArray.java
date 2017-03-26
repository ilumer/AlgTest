/**
 * 如何实现将两个有序数组合并
 * 归并算法中的一个环节
 * Created by ilumer on 17-3-25.
 */
public class MergeTwoSortedArray {
  public static void solution(int a[], int b[]) {
    int c[] = new int[a.length + b.length];
    for (int i = 0, j = 0, k = 0; i < c.length; i++) {
      if (j < a.length && k < b.length) {
        if (a[j] < b[k]) {
          c[i] = a[j++];
        } else {
          c[i] = b[k++];
        }
      } else if (j == a.length && k < b.length) {
        c[i] = b[k++];
      } else if (j < a.length && k == b.length) {
        c[i] = a[j++];
      }
    }

    for (int i = 0; i < c.length; i++) {
      System.out.println(c[i]);
    }
  }

  public static void main(String[] args) {
    int a[] = {1, 3, 5, 7, 9};
    int b[] = {2, 4, 5, 7, 10};
    solution(a, b);
  }
}
