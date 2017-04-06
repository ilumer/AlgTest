import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ilumer on 17-4-6.
 * -1不算真的挺奇怪的
 */
public class PalindromeNumber {
  //245 ms
  public static boolean isPalindrome(int x){
    List<Integer> list = new ArrayList<>();
    if (x<0){
      return false;
    }
    while (x!=0){
      list.add(x%10);
      x = x/10;
    }
    int N = list.size();
    for (int i = 0 ; i <N/2;i++){
      if (list.get(i)!=list.get(N-1-i)){
        return false;
      }
    }
    return true;
  }

  //197ms
  public static boolean isPalindromeNew(int x){
    if ((x%10 == 0 && x!=0) || x <0 ){
      return false;
    }
    int rev = 0 ;
    while (x > rev){
      rev = rev * 10 + x%10;
      x = x/10;
    }
    return x==rev || x/10 == rev;
    //左边等于右边
  }

  @Test
  public static void main(String[] args) {
    Assert.assertTrue(isPalindromeNew(0));
    Assert.assertTrue(isPalindromeNew(1001));
    Assert.assertFalse(isPalindromeNew(-9));
    Assert.assertFalse(isPalindromeNew(-101));
    Assert.assertFalse(isPalindromeNew(-1111111111));
    Assert.assertFalse(isPalindromeNew(-1234));
  }
}
