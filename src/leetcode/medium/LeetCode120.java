package leetcode.medium;

import java.util.List;

public class LeetCode120 {
    //递归超出时间限制
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> integers = triangle.get(0);
        return Math.min(minimumTotal(triangle, 1, 0) + integers.get(0), minimumTotal(triangle, 1, 1) + integers.get(0));
    }

    public int minimumTotal(List<List<Integer>> triangle, int high, int index) {
        if (high > triangle.size()) {
            return 0;
        }
        if (index >= triangle.get(high).size()) {
            return 0;
        }
        return Math.min(minimumTotal(triangle, high + 1, index) + triangle.get(high).get(index),
                minimumTotal(triangle, high + 1, index + 1) + triangle.get(high).get(index));
    }

    //动态规划
    //f[i][j] 表示第i行第j列的最小值(同时也是此层的最小值)
    //f[i][0] = f[i-1][0]+C[i][0] 最左列只能由上层的最左列访问到
    //f[i][i] = f[i-1][i-1]+C[i][i] 最右列只能由上层的最右列访问到
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        //最后的最小值就是最后一层访问结果中的最小值
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
