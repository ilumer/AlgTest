import org.junit.Assert;

/**
 * Created by ilumer on 17-4-11.
 * https://leetcode.com/problems/maximum-subarray/#/description
 * https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%AD%90%E6%95%B0%E5%88%97%E9%97%AE%E9%A2%98
 */
public class MaximumSubarray {

  //从0开始增加 当和为负数时 重新寻找子序列的起点，同时记录原本的最大值
  public static int maxSubArray(int[] A) {
    int max = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < A.length; i++) {
      if (sum < 0) {
        sum = A[i];
      } else {
        sum += A[i];
      }
      if (sum > max) {
        max = sum;
      }
    }
    return max;
  }

  //根据第i个节点时 是否应该开始新的节点 判断的标准是原来的和加上新的节点大还是 新的节点大
  //判断是否比以往的最大值大 来确定最大值
  public static int maxSubArray2(int[] A) {
    int maxEnding, maxFar;
    maxEnding = maxFar = A[0];
    for (int i = 1; i < A.length; i++) {
      maxEnding = Math.max(A[i], maxEnding + A[i]);
      maxFar = Math.max(maxEnding, maxFar);
    }
    return maxFar;
  }

  public static void main(String[] args) {
    Assert.assertEquals(15, maxSubArray2(new int[] {15, -100, 10}));
  }
}
