import edu.princeton.cs.algs4.Heap;
import org.junit.Assert;

/**
 * Created by ilumer on 17-4-9.
 * https://leetcode.com/problems/implement-strstr/#/description
 */
public class StrStr {
  //直接通过了。。。。。
  public static int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
  }

  //没有上面的快
  public static int strStr2(String haystack,String needle){
    if (needle.length()==0)
      return 0;
    for (int i = 0; i<haystack.length();i++){
      if (i+needle.length()>haystack.length())
        return -1;
      if (haystack.charAt(i) == needle.charAt(0)){
        int k = 0;
        while (k<needle.length() && haystack.charAt(i+k) == needle.charAt(k))
          k++;
        if (k == needle.length())
          return i;
      }
    }
    return -1;
  }

  //把if的条件作为判断的标准 很有意思而且处理边际条件
  public int strStr3(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == needle.length()) return i;
        if (i + j == haystack.length()) return -1;
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      }
    }
  }

  public static void main(String[] args) {
    Assert.assertEquals(-1,strStr2("asb","efg"));
    Assert.assertEquals(1,strStr2("asd","sd"));
    Assert.assertEquals(4,strStr2("mississippi", "issip"));
  }
}
