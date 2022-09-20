package leetcode.medium;

/**
 * @author banxuan
 * Date : 2022/9/20
 * Time : 13:13
 */
public class LeetCode29 {
    public int divide(int dividend, int divisor) {
        int judgeSymbol = judgeSymbol(dividend, divisor);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            result++;
        }
        return result * judgeSymbol;
    }

    public int judgeSymbol(int dividend, int divisor) {
        if (dividend < 0 && divisor < 0) {
            return 1;
        }

        if (dividend > 0 && divisor > 0) {
            return 1;
        }
        return -1;
    }
}
