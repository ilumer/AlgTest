package leetcode.easy;



//https://discuss.leetcode.com/topic/30746/share-some-analysis-and-explanations

import java.util.Arrays;

public class LeetCode312 {
  //1 使用分治的方法 从上而下 分割的点[K]是最后被击破的气球
  //2 在子问题的两个边界[left,right]一定是晚于k点的
  public int maxCoins(int[] nums) {
    int[] lnums = new int[nums.length+2];//添加left 和right
    int n = 1;
    for(int i:nums)
      lnums[n++] = i;
    lnums[0] = 1;
    lnums[n++] = 1;//复制好数组
    int[][] maxCoins = new int[n][n];
    //6x6
    return maxCoins(maxCoins,lnums,0,n-1);
  }

  private int maxCoins(int[][] maxCoins, int[] lnums, int left, int right) {
    if (left==right-1)
      return 0;
    if (maxCoins[left][right]>0)
      return maxCoins[left][right];//说明已经访问过
    int sum = 0;
    for (int i = left+1;i<right;i++){
      sum = Math.max(sum,lnums[left]*lnums[i]*lnums[right]+
          maxCoins(maxCoins,lnums,left,i)+maxCoins(maxCoins,lnums,i,right));
    }
    maxCoins[left][right] = sum;
    return sum;
  }

  public static void main(String[] args) {
    int[] ballons = new int[]{
      3,1,5,8
    };
    new LeetCode312().maxCoins2(ballons);
  }

  public int maxCoins2(int[] iNums) {
    int[] nums = new int[iNums.length + 2];
    int n = 1;
    for (int x : iNums) if (x > 0) nums[n++] = x;
    nums[0] = nums[n++] = 1;


    int[][] dp = new int[n][n];
    for (int k = 2; k < n; ++k)
      for (int left = 0; left < n - k; ++left) {
        int right = left + k;
        for (int i = left + 1; i < right; ++i)
          dp[left][right] = Math.max(dp[left][right],
              nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
      }
    for (int i = 0;i<dp.length;i++){
      System.out.println(Arrays.toString(dp[i]));
    }
    return dp[0][n - 1];
  }
}
