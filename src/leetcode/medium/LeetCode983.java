package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author banxuan
 * Date : 2020/5/6
 * Time : 10:45 下午
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/zui-di-piao-jie-by-leetcode-solution/
 */
public class LeetCode983 {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet<>();
        for (int d : days) {
            dayset.add(d);
        }
        return dp(1);
    }

    public int dp(int i) {
        if (i > 365) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        if (dayset.contains(i)) {
            memo[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
        } else {
            memo[i] = dp(i + 1);
        }
        return memo[i];
    }
}
