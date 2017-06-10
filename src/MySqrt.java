import org.junit.Assert;

/**
 * Created by ilumer on 17-4-13.
 * https://leetcode.com/problems/sqrtx/#/description
 */
public class MySqrt {
  public static int mySqrt(int x) {
    int lo = 0, hi = x;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      //用乘法会出现溢出的情况
      if (mid == 0) {
        return x;
      }
      if (mid == x / mid || (mid < x / mid && mid + 1 > x / (mid + 1))) {
        return mid;
      } else if (mid > x / mid) {
        hi = mid - 1;
      } else if (mid < x / mid) {
        lo = mid + 1;
      }
    }
    return lo;
  }

  //http://www.guokr.com/question/461510/
  public static int sqrt(int x) {
    int r = x;
    while (r * r > x) {
      r = (r + (x / r)) / 2;
    }
    return r;
  }

  public static void main(String[] args) {
    Assert.assertEquals((int) Math.sqrt(9), sqrt(9));
    Assert.assertEquals((int) Math.sqrt(1), sqrt(1));
    Assert.assertEquals((int) Math.sqrt(0), sqrt(0));
    Assert.assertEquals((int) Math.sqrt(3), sqrt(3));
    Assert.assertEquals((int) Math.sqrt(2), sqrt(2));
    Assert.assertEquals((int) Math.sqrt(2147395600), mySqrt(2147395600));
  }
}
