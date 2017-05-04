package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilumer on 17-5-4.
 * https://discuss.leetcode.com/topic/22068/easy-java-solution-tell-you-why-using-bitwise-xor
 */
public class LeetCode136 {

  public int singleNumber(int[] nums) {
    int res = 0;
    for (int i =0;i<nums.length;i++){
      res^=nums[i];
    }
    return res;
  }

  public int singleNumber2(int[] nums){
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i<nums.length;i++){
      if (!set.contains(nums[i])){
        set.add(nums[i]);
      }
    }
    int count1 = 0,count2 = 0;
    for (int m :set){
      count1+=m;
    }
    for (int n :nums){
      count2+=n;
    }
    return count1*2-count2;
  }
}
