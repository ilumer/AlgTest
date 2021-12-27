package leetcode.easy;

import java.util.Arrays;

/**
 * @author banxuan
 * Date : 2021/12/27
 * Time : 9:00 上午
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        int[][] stairs = new int[3][n + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n + 1; j++) {
                stairs[i][j] = 0;
            }
        }
        if (n<=2){
            return n;
        }
        stairs[1][1] = 1;
        stairs[1][2] = 1;
        stairs[2][1] = 0;
        stairs[2][2] = 1;
        //f(n) = f(n-1)+f(n-2)
        for (int j = 3; j < n + 1; j++) {
            for (int i = 1; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    stairs[i][j] += stairs[k][j - i];
                }
            }
        }
        System.out.println(Arrays.deepToString(stairs));
        return stairs[1][n]+stairs[2][n];
    }

    public static void main(String[] args) {
        new LeetCode70().climbStairs(1);
    }
}
