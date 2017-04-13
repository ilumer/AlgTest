import org.junit.Assert;

/**
 * Created by ilumer on 17-4-13.
 * 动态规划
 */
public class ClimbingStairs {


  //类似Basically it's a fibonacci.
  //https://discuss.leetcode.com/topic/5371/basically-it-s-a-fibonacci
  public static int climbStairs(int n){
    if (n <= 0){
      return 0;
    }
    if (n ==1)
      return 1;
    if (n==2)
      return 2;
    int start = 1;
    int end =2;
    for (int i =2;i<n;i++){
      int temp = start;
      start = end;
      end = start+temp;
    }
    return end;
  }

  public static void main(String[] args) {
    Assert.assertEquals(610,climbStairs(14));
  }
}
