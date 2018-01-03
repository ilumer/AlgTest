package leetcode.easy;

public class LeetCode326 {
  public boolean isPowerOfThree(int n) {
    if (n==0)
      return false;
    while (n%3==0)
      n = n / 3;
    return n==1;
    //return ( n>0 &&  1162261467%n==0);
    //用在Integer.MAX下的最大的3的幂数来计算
  }
}
