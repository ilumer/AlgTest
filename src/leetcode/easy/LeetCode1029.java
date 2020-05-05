package leetcode.easy;

import java.util.Arrays;

/**
 * @author banxuan
 * Date : 2020/5/4
 * Time : 5:31 下午
 */
public class LeetCode1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));

        int total = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; ++i) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }
}
