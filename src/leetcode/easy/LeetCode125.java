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

    /**
     *  需要考虑到number 和 letter
     *  这个时候不能只考虑到大小写之间相差32
     * @param s
     * @return
     */
  public boolean addWayIsPalindrome(String s){
    int i = 0,j = s.length()-1;
    while (i<j){
        char a = s.charAt(i);
        char b = s.charAt(j);
        while (!Character.isLetterOrDigit(a) && i<j){
            i++;
            a  = s.charAt(i);
        }
        while (!Character.isLetterOrDigit(b) && i<j){
            j --;
            b = s.charAt(j);
        }
        if (!(a == b ||(Character.isLetter(a) && Character.isLetter(b) && Math.abs(a - b)==32))){
            return false;
        }
        i++;
        j--;
    }
    return true;
  }
}
