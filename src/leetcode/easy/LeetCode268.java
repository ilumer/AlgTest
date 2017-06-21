package leetcode.easy;

/**
 * Created by ilumer on 17-6-21.
 */
public class LeetCode268 {
  public int missingNumber(int[] nums){
    int xor =0;
    int i;
    for (i = 0;i<nums.length;i++){
      xor = xor^i^nums[i];
    }
    return xor^i;
    // a ^ b ^ c = a ^ c ^b
  }

  //https://discuss.leetcode.com/topic/23427/3-different-ideas-xor-sum-binary-search-java-code
  //二分寻找的方法 要求有序
}
