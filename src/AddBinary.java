import org.junit.Assert;

/**
 * Created by ilumer on 17-4-12.
 */
public class AddBinary {
  //使用ascii码
  public static String addBinary(String a,String b) {
    int flag = 0;
    int i = a.length()-1;
    int j = b.length() -1;
    String s = "";
    while (i>=0|| j>=0){
      int count;
      int m = 0,n = 0;
      if (i>=0) {
        m = a.charAt(i) - '0';
      }
      if (j>=0) {
        n = b.charAt(j) - '0';
      }
      count = m+n +flag;
      s= count%2+s;
      flag = count/2;
      i--;
      j--;
    }
    if (flag > 0) {
      s=flag +s;
    }
    return s;
  }

  public static void main(String[] args) {
    Assert.assertEquals("1111",addBinary("1110","1"));
    Assert.assertEquals("10",addBinary("1","1"));
    Assert.assertEquals("10101",addBinary("1010","1011"));
  }
}
