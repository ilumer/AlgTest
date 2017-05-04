package leetcode.easy;

/**
 * Created by ilumer on 17-5-4.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
 * https://leetcode.com/articles/best-time-buy-and-sell-stock/
 */
public class LeetCode121 {

  //依次推导， 当新访问的点比前一个点大的时候可以把最大的点移到当前点
  public int maxProfit(int[] prices) {
    int maxCur = 0,maxFar = 0;
    for (int i = 1; i <prices.length;i++){
      maxCur = Math.max(0,maxCur+=prices[i]-prices[i-1]);
      maxFar = Math.max(maxCur,maxFar);
    }
    return maxFar;
  }

  public int maxProfit2(int[] prices){
    if (prices.length ==0)
      return 0;
    int profit = 0;
    int min = prices[0];
    for (int i = 1; i<prices.length;i++){
      if (prices[i]<min)
        min = prices[i];
      else if (profit<prices[i] - min)
        profit = prices[i] - min;
    }
    return profit;
  }
}
