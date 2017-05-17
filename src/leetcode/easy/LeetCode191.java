package leetcode.easy;

/**
 * Created by ilumer on 17-5-9.
 */
public class LeetCode191 {
  public int hammingWeight(int n) {
    //非二进制数
    //右移
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >> 1;
    }
    return count;
  }

  //x&(x-1) help remove right most 1 of x
  //https://discuss.leetcode.com/topic/9962/concise-java-solution-x-x-1
  public int hammingWeight2(int n){
    int count = 0;
    while (n!=0){
      n = n&(n-1);
      count++;
    }
    return count;
  }
}
