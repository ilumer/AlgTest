package leetcode.easy;

public class LeetCode367 {
  public static boolean isPerfectSquare(int num) {
    //https://leetcode.com/problems/valid-perfect-square/discuss/83902
    //1. 1+3+5+..... => (2n-1+1)*n/2=n^2
    //2. 二分法实现sqrt 看作一个长为有序num的数组 寻找 sqrt(num)
    //3.牛顿法实现sqrt
    int r = num;
    while (r > num/r) {
      r = (r + (num / r)) / 2;
    }
    return r*r == num;
  }

  public static void main(String[] args){
    System.out.println(isPerfectSquare(808201));
  }
}
