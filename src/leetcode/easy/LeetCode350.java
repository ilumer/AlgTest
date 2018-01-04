package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode350 {
  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> list = new ArrayList<>();
    int i = 0, j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else {
        list.add(nums1[i]);
        i++;
        j++;
      }
    }
    int[] a = new int[list.size()];
    int k = 0;
    for (int num : list) {
      a[k++] = num;
    }
    return a;
  }
  //如果数组是有序的可以省去排序的步骤
}
