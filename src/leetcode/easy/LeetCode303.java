package leetcode.easy;

public class LeetCode303 {
  private int[] nums;
  private int[] total;

  public LeetCode303(int[] nums) {
    this.nums = nums;
    this.total = new int[nums.length];
    int num = 0;
    for (int i = 0; i < nums.length; i++) {
      num += nums[i];
      total[i] = num;
    }
  }

  //需要将之前的结果保留
  public int sumRange(int i, int j) {
    return total[j] - total[i] + nums[i];
  }
}
