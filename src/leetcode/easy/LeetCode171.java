package leetcode.easy;

/**
 * Created by ilumer on 17-5-6.
 */
public class LeetCode171 {
  public int titleToNumber(String s){
    int sum = 0;
    for (int i = 0 ; i<s.length();i++){
      sum = sum + (s.charAt(i) - 'A' + 1)*(int) Math.pow(26,(s.length()-i));
      //result = result * 26 + (s.charAt(i) - 'A' + 1);
      //如何升位 乘以x进制
    }
    return sum;
  }
}
