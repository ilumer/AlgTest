package leetcode.easy;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by ilumer on 17-5-31.
 */
public class LeetCode204 {
  //https://discuss.leetcode.com/topic/13654/my-simple-java-solution
  public int countPrimes(int n) {
    boolean[] notPrime = new boolean[n];
    int count = 0;
    //https://www.youtube.com/watch?v=eKp56OLhoQs
    //解释为什么使用这个方法
    for (int i = 2; i < n; i++) {
      if (!notPrime[i]) {
        count++;
        for (int j = 2; i * j < n; j++) {
          //sqrt(x) 是一个优化的
          notPrime[i * j] = true;
        }
      }
    }

    return count;
  }

  //https://zh.wikipedia.org/wiki/%E7%B4%A0%E6%80%A7%E6%B5%8B%E8%AF%95
  public boolean isPrimeNumber(int n) {
    for (int i = 2; i * i <= n; i++) {
      //
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  //https://zh.wikipedia.org/wiki/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95
  //https://discuss.leetcode.com/topic/14387/java-o-n-solution-for-count-primes
  public int countPrimes2(int n) {
    int res = 0;
    boolean[] used = new boolean[n];
    for (int i = 2; i <= Math.sqrt(n); i++) {
      //避免了i*i溢出
      if (!used[i - 1]) {
        int temp = i * i;
        while (temp < n) {
          used[temp - 1] = true;
          temp += i;
          // 等同与每次乘以2*3,3*3,4*3类似
        }
      }
    }
    //没有被访问到的就是素数
    for (int i = 2; i < n; i++) {
      if (!used[i - 1]) {
        res++;
      }
    }
    return res;
  }
}
