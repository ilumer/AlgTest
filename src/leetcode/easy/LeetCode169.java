package leetcode.easy;

import java.util.Arrays;
import org.junit.Assert;

/**
 * Created by ilumer on 17-5-6.
 */
public class LeetCode169 {
  public int majorityElement(int[] nums){
    Arrays.sort(nums);
    return nums[nums.length/2];
  }

  //有一半的相同的数时 count一定为正数
  public int marjorityElement(int[] nums){
    int marjor = nums[0],count = 1;
    for (int i = 0 ;i < nums.length;i++){
      if (count == 0){
        marjor = nums[i];
        count++;
      }else if (marjor == nums[i]){
        count++;
      }else {
        count--;
      }
    }
    return marjor;
  }
}
