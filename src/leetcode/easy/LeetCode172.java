package leetcode.easy;

import org.junit.Assert;

/**
 * Created by ilumer on 17-5-6.
 */
public class LeetCode172 {
  public static int trailingZeroes(int n){
    //寻找有多少个5的情况 2一定是多余5的 timeout
    int count = 0;

    //使用* 注意 i 溢出
    int m = 0;
    for (int i = n/5;i >=1;i=i/5){
      m++;
    }
    for (int i = (int) Math.pow(5,m); i >1;i=i/5){
      count+=n/i;
    }
    return count;
  }

  //可以把n变小 避免溢出
  public static int trailingZeroes2(int n){
    int count = 0;
    while (n>0){
      count+=n/5;
      n=n/5;
    }
    return count;
  }

  public static void main(String[] args) {
    Assert.assertEquals(452137076,trailingZeroes2(1808548329));
  }
}
