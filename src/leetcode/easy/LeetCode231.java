package leetcode.easy;

public class LeetCode231 {

  //排除负数的情况
  public boolean isPowerOfTwo(int n) {
    int count = 0;
    if (n < 0) {
      return false;
    }
    for (int i = 0; i <= 31; i++) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >>> 1;
    }
    //多做了运算
    //当出现不等于1的情况时 应该判断此时的数是否为1
    return count == 1;
  }
}
