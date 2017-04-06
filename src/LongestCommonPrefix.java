import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ilumer on 17-4-6.
 */
public class LongestCommonPrefix {
  //9ms
  private static String solution(String[] str) {
    if (str.length == 0) {
      return "";
    }
    String longestCommonPrefix = str[0];
    for (int i = 0; i < str.length; i++) {
      int j = str[i].length()>longestCommonPrefix.length()?longestCommonPrefix.length():str[i].length();
      longestCommonPrefix = longestCommonPrefix.substring(0,j);
      while (!str[i].substring(0,j).equals(longestCommonPrefix)){
        longestCommonPrefix = longestCommonPrefix.substring(0,--j);
      }
      if (longestCommonPrefix.length() == 0){
        return longestCommonPrefix;
      }
    }
    return longestCommonPrefix;
  }

  @Test
  public static void main(String[] args) {
    Assert.assertEquals("a", solution(new String[] {"aa", "a"}));
    Assert.assertEquals("", solution(new String[] {"", "b"}));
    Assert.assertEquals("aa", solution(new String[] {"aaa", "aa", "aaa"}));
    Assert.assertEquals("", solution(new String[] {"a", "b"}));
    Assert.assertEquals("a", solution(new String[] {"aa", "ab"}));
    Assert.assertEquals("",solution(new String[]{"ca","a"}));
  }
}
