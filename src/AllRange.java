import java.util.Map;

public class AllRange {
  public static void main(String[] args) {
    String a = "abb";
    String result = "";
    AllRange(result, a);
  }

  public static void AllRange(String reslut, String str) {
    if (reslut.length() == str.length()) {
      System.out.println(reslut);
    } else {
      for (int i = 0; i < str.length(); i++) {
        if (reslut.indexOf(str.charAt(i)) < 0)
          AllRange(reslut + str.charAt(i), str);
      }
    }
  }
}
// n*n-1*n-2...1 O(n!)
//在出现相同的字符的情况下失败
// 去重的实现 http://wuchong.me/blog/2014/07/28/permutation-and-combination-realize/