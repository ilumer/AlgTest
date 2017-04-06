import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ilumer on 17-4-6.
 * https://leetcode.com/problems/roman-to-integer/#/solutions
 * https://zh.wikipedia.org/wiki/罗马数字
 */
public class RomanToInteger {

  //110ms
  private static int solution(String str) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int result = 0;
    char[] array = str.toCharArray();
    int[] number = new int[array.length];
    int index = 0;
    for (int i = 0; i < array.length; i++) {
      result += map.get(array[i]);
      if (array[i] == 'I' || array[i] == 'X' || array[i] == 'C') {
        number[index++] = i;
      }
    }
    for (int i = 0; i < index; i++) {
      if (number[i] < array.length - 1 && (map.get(array[number[i]]) < map.get(
          array[number[i] + 1]))) {
        result -= 2 * map.get(array[number[i]]);
      }
    }
    return result;
  }

  //https://discuss.leetcode.com/topic/821/my-solution-for-this-question-but-i-don-t-know-is-there-any-easier-way
  public static int romanToInt(String s) {
    int sum = 0;
    if (s.indexOf("IV") != -1) {
      sum -= 2;
    }
    if (s.indexOf("IX") != -1) {
      sum -= 2;
    }
    if (s.indexOf("XL") != -1) {
      sum -= 20;
    }
    if (s.indexOf("XC") != -1) {
      sum -= 20;
    }
    if (s.indexOf("CD") != -1) {
      sum -= 200;
    }
    if (s.indexOf("CM") != -1) {
      sum -= 200;
    }

    char c[] = s.toCharArray();
    int count = 0;

    for (; count <= s.length() - 1; count++) {
      if (c[count] == 'M') sum += 1000;
      if (c[count] == 'D') sum += 500;
      if (c[count] == 'C') sum += 100;
      if (c[count] == 'L') sum += 50;
      if (c[count] == 'X') sum += 10;
      if (c[count] == 'V') sum += 5;
      if (c[count] == 'I') sum += 1;
    }

    return sum;
  }

  //https://discuss.leetcode.com/topic/28471/7ms-solution-in-java-easy-to-understand
  //
  public static int romanToIntFast(String s) {
    int nums[] = new int[s.length()];
    //这里构造了一个一一对应的关系同时也可以用于计算
    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case 'M':
          nums[i] = 1000;
          break;
        case 'D':
          nums[i] = 500;
          break;
        case 'C':
          nums[i] = 100;
          break;
        case 'L':
          nums[i] = 50;
          break;
        case 'X':
          nums[i] = 10;
          break;
        case 'V':
          nums[i] = 5;
          break;
        case 'I':
          nums[i] = 1;
          break;
      }
    }
    int sum = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < nums[i + 1]) {
        sum -= nums[i];
      } else {
        sum += nums[i];
      }
    }
    return sum + nums[nums.length - 1];
  }

  @Test
  public static void main(String[] args) {
    Assert.assertEquals(3, solution("III"));
    Assert.assertEquals(45, solution("XLV"));
    Assert.assertEquals(99, solution("XCIX"));
  }
}
