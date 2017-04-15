/**
 * Created by ilumer on 17-4-14.
 * https://leetcode.com/problems/merge-sorted-array/#/description
 */
public class Merge {
  /*
  * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
  * The number of elements initialized in nums1 and nums2 are m and n respectively.
  * */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] nums3 = new int[m];
    for (int i = 0; i < m; i++) {
      nums3[i] = nums1[i];
    }

    //归并
    int pointer1 = 0, pointer2 = 0;
    for (int k = 0; k < m + n; k++) {
      if (pointer1 >= m) nums1[k] = nums2[pointer2++];
      if (pointer2 >= n) nums1[k] = nums3[pointer1++];
      if (nums3[pointer1] > nums2[pointer2]) {
        nums1[k] = nums3[pointer1++];
      } else {
        nums1[k] = nums2[pointer2++];
      }
    }
  }

  //从最大的数开始归并
  public void merge2(int[] nums1,int m,int[] nums2,int n){
    int k = m+n-1;
    int pointer1 = m-1;
    int pointer2 = n-1;
    while (pointer1>=0&&pointer2>=0){
      if (nums1[pointer1] > nums2[pointer2]){
        nums1[k--] = nums1[pointer1--];
      }else {
        nums1[k--] = nums2[pointer2--];
      }
    }
    while (pointer2 != 0){
      nums1[k--] = nums2[pointer2--];
    }
  }
}
