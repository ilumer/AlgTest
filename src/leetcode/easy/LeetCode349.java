package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class LeetCode349 {
  public int[] intersection(int[] nums1, int[] nums2) {
    //去重 hash
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> intersection = new HashSet<>();
    for (Integer num:nums1)
      set1.add(num);
    for (int i = 0;i<nums2.length;i++){
      if (set1.contains(nums2[i]))
        intersection.add(nums2[i]);
    }
    int[] a = new int[intersection.size()];
    int i =0;
    for(int num:intersection)
      a[i++] = num;
    return a;
    //https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969
    //二分法用来查找是否存在于数组中
  }
}
