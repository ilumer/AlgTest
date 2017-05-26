package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilumer on 17-5-26.
 */
public class LeetCode202 {
  public boolean isHappy(int n){
    if (n == 1) return true;
    List<Integer> container = new ArrayList<>();
    while (!container.contains(n)){
      container.add(n);
      n = calculate(n);
    }
    return n==1;
  }

  public int calculate(int n){
    int result = 0;
    while (n!=0){
      result+=(n%10)*(n%10);
      n = n/10;
    }
    return result;
  }
}
