package leetcode.easy;

/**
 * Created by ilumer on 17-5-4.
 * https://leetcode.com/problems/valid-palindrome/#/description
 * https://discuss.leetcode.com/topic/17240/two-lines-in-java/2 很有意思的一个方法
 */
public class LeetCode125 {
  public boolean isPalindrome(String s) {
    s = s.trim().toLowerCase();
    if (s.length() == 0) {
      return true;
    }
    int left = 0, right = s.length() - 1;
    while (left < right) {
      //完全没有想到这个api
      while (!Character.isLetterOrDigit(s.charAt(left)) && left<right){
        left++;
      }
      while (!Character.isLetterOrDigit(s.charAt(right)) && left<right){
        right--;
      }
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        return false;
      }
    }
    return true;
  }
}
