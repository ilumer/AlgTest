package leetcode.easy;

/**
 * Created by ilumer on 17-5-31.
 */
public class LeetCode204 {
  //https://discuss.leetcode.com/topic/13654/my-simple-java-solution
  public int countPrimes(int n){
    boolean[] notPrime = new boolean[n];
    int count = 0;
    //https://www.youtube.com/watch?v=eKp56OLhoQs
    //解释为什么使用这个方法
    for (int i = 2; i < n; i++) {
      if (!notPrime[i]) {
        count++;
        for (int j = 2; i*j < n; j++) {
          //sqrt(x) 是一个优化的
          notPrime[i*j] = true;
        }
      }
    }

    return count;
  }

  //https://zh.wikipedia.org/wiki/%E7%B4%A0%E6%80%A7%E6%B5%8B%E8%AF%95
  public boolean isPrimeNumber(int n){
    for (int i = 2; i < n-1;i++){
      //sqrt(x)如果是非素数 这里一定是小于sqrt(x)
      if (n%i==0){
        return false;
      }
    }
    return true;
  }
}
