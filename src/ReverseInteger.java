import edu.princeton.cs.algs4.In;

/**
 * Created by ilumer on 17-4-2.
 * https://leetcode.com/problems/reverse-integer/#/description
 */
public class ReverseInteger {

  public static void main(String[] args) {
    System.out.println(reverse(Integer.MIN_VALUE));
  }

  /*
  * 反转之后的0如何处理
  * 反转之后的溢出如何出来
  * 48ms
  * */
  private static int reverse(int i) {
    int flag = i < 0 ? -1 : 1;
    StringBuilder builder = new StringBuilder();
    while (i != 0) {
      builder.append(Math.abs(i % 10));
      i = i / 10;
    }
    while (builder.length() != 0 && builder.charAt(0) == '0') {
      builder.deleteCharAt(0);
    }
    if (builder.length() == 0) {
      return 0;
    }
    long result = Long.parseLong(builder.toString());
    if (flag * result > Integer.MAX_VALUE || flag * result < Integer.MIN_VALUE) {
      return 0;
    }
    return (int) result * flag;
  }

  /*
  * 38ms*/
  private static int reverseFast(int i) {
    long answer = 0;
    while (i != 0) {
      answer = answer * 10 + i % 10;
      i = i / 10;
      //直接规避了0001这样的情况
    }
    return (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) ? 0 : (int) answer;
  }
}
