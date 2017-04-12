import org.junit.Assert;

/**
 * Created by ilumer on 17-4-12.
 * https://leetcode.com/problems/length-of-last-word/#/description
 */
public class LengthOfLastWord {
  //如果最后一个字符为空字符則把前面的一个作为最后的字符

  public static int lengthOfLastWord(String s){
    int right = s.length() -1;
    while (right >= 0 && s.charAt(right) ==' '){
      right--;
    }
    int i = right;
    while (i >=0 && s.charAt(i) !=' '){
      i --;
    }
    return right - i;
  }

  public static void main(String[] args) {
    Assert.assertEquals(5,lengthOfLastWord("Hello world"));
    Assert.assertEquals(5,lengthOfLastWord("Hello"));
    Assert.assertEquals(5,lengthOfLastWord("Hello "));
    Assert.assertEquals(0,lengthOfLastWord(" "));

  }
}
