package leetcode.easy;

import java.util.Arrays;
import org.junit.Assert;

/**
 * Created by ilumer on 17-5-8.
 */
public class LeetCode189 {
  public void rotate(int[] nums, int k) {
    //O(n) extra space time out
    int[] copy = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      copy[i] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[(i + k) % nums.length] = copy[i];
    }
  }

  public static void rotate2(int[] nums, int k) {
    if (nums.length <= 1) {
      return;
    }

    k %= nums.length;

    //为什么选择nums.length - k -1
    //编程珠玑p15 右移k位代表的就是左移nums.length - k(对长度取模)
    //长度的决定依靠的是还有多少元素会留在原来的数组中(i+k<nums.length)
    //将整个字符串数组分为两个部分
    revesre(nums, 0, nums.length - k-1);
    revesre(nums, nums.length-k, nums.length - 1);
    revesre(nums, 0, nums.length - 1);
  }

  private static void revesre(int[] nums, int left, int right) {
    int temp;
    while (left < right) {
      temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++;
      right--;
    }
  }

  public static void main(String[] args) {
    int[] array = new int[]{1,2,3};
    rotate2(array,1);
    System.out.println(Arrays.toString(array));
  }
}
