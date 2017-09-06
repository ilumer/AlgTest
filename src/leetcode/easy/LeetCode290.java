package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode290 {

  public boolean wordPattern(String pattern, String str) {
    String[] array = str.split(" ");
    if (array.length != pattern.length()) {
      return false;
    }
    Map<Character, String> map = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      if (map.get(pattern.charAt(i)) == null) {
        if (map.values().contains(array[i])) {
          return false;
        }
        map.put(pattern.charAt(i), array[i]);
      } else if (!map.get(pattern.charAt(i)).equals(array[i])) {
        return false;
      }
    }
    return true;
  }
}
