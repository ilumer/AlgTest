package leetcode.easy;

public class LeetCode344 {
  public static String reverseString(String s) {
    char[] str = s.toCharArray();
    for (int i = 0;i<str.length/2;i++){
      char temp = str[i];
      str[i] = str[str.length-i-1];
      str[str.length-i-1] = temp;
    }
    return String.valueOf(str);
  }
  public static void main(String[] args){
    System.out.println(reverseString("hello"));
  }
}
