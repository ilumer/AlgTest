package leetcode.easy;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ilumer on 17-5-5.
 */
public class LeetCode167 {

  public static int[] twoSum(int[] numbers,int target) {
    int left = 0,right = numbers.length-1;
    while (numbers[left]+numbers[right]!=target){
      //肯定存在相当相等的情况
      if (numbers[left]+numbers[right] < target){
         left++;
      }else if (numbers[left]+numbers[right] > target){
        right--;
      }
    }
    return new int[]{left+1,right+1};
  }

  @Test
  public static void main(String[] args) {
    Assert.assertArrayEquals(new int[]{1,2}, twoSum(new int[]{2,7,11,15},9));
  }

}
