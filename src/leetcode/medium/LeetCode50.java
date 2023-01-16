package leetcode.medium;

/**
 * @author banxuan
 * Date : 2020/5/11
 * Time : 10:38 下午
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


    public double myNonRecursivePositivePow(double x, int n) {
        double res = 1;
        while (n > 0) {
            // 代表的是一个不能被2整除的情况
            if (n % 2 != 0) {
                res = res * x;
            }
            x = x * x;
            n >>= 1;
        }
        return res;
    }
}
