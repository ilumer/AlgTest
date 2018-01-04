package leetcode.easy;

public class LeetCode345 {
  public static String reverseVowels(String s){
    String Vowels = "aeiouAEIOU";
    char[] str = s.toCharArray();
    int left= 0,right=s.length()-1;
    while (left<right){
      while (left<right && Vowels.indexOf(s.charAt(left))==-1)
        left++;
      while (left<right && Vowels.indexOf(s.charAt(right))==-1)
        right--;
      char temp = str[left];
      str[left] = str[right];
      str[right] = temp;

      left++;
      right--;
      //避免出现死循环
    }
    return String.valueOf(str);
  }

  public static void main(String[] args){
    System.out.println(reverseVowels("hello"));
  }
}
