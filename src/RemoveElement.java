
/**
 * Created by ilumer on 17-4-9.
 * 感觉脑子坏掉了
 * https://leetcode.com/problems/remove-element/#/description
 */
public class RemoveElement {
  //把不等的数重新填充就可以了
  public int removeElement(int[] nums, int val) {
    int m = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[m] = nums[i];
        m++;
      }
    }

    return m;
  }

  //把右边的数发给左边len 还充当了右边的游标
  public static int removeElement2(int[] A, int elem) {
    int len = A.length;
    for (int i = 0 ; i< len; ++i){
      while (A[i]==elem && i< len) {
        A[i]=A[--len];
      }
    }
    return len;
  }

  public static void main(String[] args) {
    int[] A = new int[]{3,2,2,3};
    removeElement2(A,3);
    for (int i:A){
      System.out.print(i);
    }
  }
}
