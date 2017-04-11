/**
 * Created by ilumer on 17-4-11.
 */
public class CountAndSay {
  //https://discuss.leetcode.com/topic/2309/show-an-answer-in-java
  public static String countAndSay(int n) {
    StringBuilder curr = new StringBuilder("1");
    StringBuilder prev;
    int count;
    char say;
    for (int i = 1; i < n; i++) {
      prev = curr;
      curr = new StringBuilder();
      count = 1;
      say = prev.charAt(0);

      for (int j = 1, len = prev.length(); j < len; j++) {
        if (prev.charAt(j) != say) {
          curr.append(count).append(say);
          count = 1;
          say = prev.charAt(j);
        } else {
          count++;
        }
      }
      curr.append(count).append(say);
    }
    return curr.toString();
  }

  public static String count(int n) {
    String init = "1";
    if (n == 0) {
      return "";
    }
    if (n == 1) {
      return init;
    }
    for (int i = 1; i < n; i++) {
      init = say(init);
    }
    return init;
  }

  public static String say(String last) {
    StringBuilder builder = new StringBuilder();
    int i = 0;
    while (i < last.length()) {
      int count = 1;
      while (i + 1 < last.length() && last.charAt(i) == last.charAt(i + 1)) {
        i++;
        count++;
      }
      builder.append(count).append(last.charAt(i));
      i++;
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(count(2));
  }
}
