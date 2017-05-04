package leetcode.easy;

/**
 * Created by ilumer on 17-5-4.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/#/description
 * https://leetcode.com/articles/best-time-buy-and-sell-stock-ii/
 */
public class LeetCode122 {

  //当右边大于左边时一直增加 出现右边小于左边时 直接跳过llyn
  public int maxProfit(int[] prices) {
    int max = 0;
    int left = 0, right = left + 1;
    while (left < prices.length && right < prices.length) {
      if (prices[right]>prices[left]){
        max += prices[right] - prices[left];
      }
      left++;
      right++;
    }
    return max;
  }
}
