/**
 * Created by ilumer on 17-3-25.
 */
public class LongestPalindrome {
  public static String solution(String s){
    //暴力查找
    String maxString = null;
    for (int i = 0 ;i<s.length();i++){
      for (int j = i+1;j<s.length();j++){
        if(isPalindrome(i,j,s)) {
          if (maxString == null) {
            maxString = s.substring(i, j+1);
          } else if (maxString.length() < j - i) {
            maxString = s.substring(i, j+1);
          }
        }
      }
    }
    return maxString;
  }

  public static boolean isPalindrome(int i,int j,String s){
    while (i<j){
      if (s.charAt(i++) != s.charAt(j--)){
        return false;
      }
    }
    return true;
  }

  public static int max = 1;
  public static int left;
  public static int right;

  /*
  * http://zhangmengrou.github.io/2017/03/15/p5/#more=
  * 还是一个穷举的方法，但是用的迭代和判断条件做的很好
  * 根据回文的对称的性质来实现的
  * */
  public static String solution2(String s){
    if (s == null || s.length() ==1){
      return s;
    }
    for (int i =0;i<s.length();i++){
      dp(i-1,i+1,s,1);
      dp(i,i+1,s,0);
    }
    return s.substring(left,right+1);
  }

  public static void dp(int i,int j,String s,int count){
    if (i < 0 || j == s.length() || s.charAt(i) != s.charAt(j)){
      if (count >= max){
        left = i +1;
        right = j -1;
        max = count;
      }
      return;
    }
    dp(i-1,j+1,s,count+2);
  }


  public static void main(String[] args) {
    String s = "cbjf";
    System.out.println(solution2(s));
  }
}
