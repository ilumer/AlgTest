package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ilumer on 17-5-6.
 */
public class LeetCode168 {
  //26进制
  public static String convertToTitle(int n) {
    String[] map =
        new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String s = "";
    //ascii码
    while (n>0){
      s= map[(n-1)%26] + s;
      n = (n-1)/26;
    }
    return s;
  }

  @Test
  public static void main(String[] args) {
    Assert.assertEquals("A",convertToTitle(1));
    Assert.assertEquals("B",convertToTitle(2));
    Assert.assertEquals("C",convertToTitle(3));
    Assert.assertEquals("Z",convertToTitle(26));
    Assert.assertEquals("AA",convertToTitle(27));
    Assert.assertEquals("AB",convertToTitle(28));
  }

}
