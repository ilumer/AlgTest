package leetcode.easy;

public class LeetCode342 {
  public boolean isPowerOfFour(int num) {
    if (num == 0) {
      return false;
    }
    while (num % 4 == 0) {
      num = num / 4;
    }
    return num == 1;
    //return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    // num & (num -1) 处理2的幂的情况
    // (num & 0x55555555) == num排除是2的幂但不是4的幂的情况
    //
  }
}
