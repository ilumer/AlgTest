package leetcode.medium;

/**
 * @author banxuan
 * Date : 2020/5/11
 * Time : 10:38 下午
 * https://leetcode.cn/problems/powx-n/
 */
public class LeetCode50 {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / myPositivePow(x, -n);
        } else {
            return myPositivePow(x, n);
        }
    }

    public double myPositivePow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            double m = myPositivePow(x, n / 2);
            return m * m;
        } else {
            double m = myPositivePow(x, n / 2);
            return m * m * x;
        }
    }

    public double myPow2(double x, int n) {
        if (n < 0) {
            return 1 / myPositivePow(x, -n);
        } else {
            return myPositivePow(x, n);
        }
    }
}
