package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author banxuan
 * Date : 2020/5/2
 * Time : 3:39 上午
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        Map<Character, Integer> travel = new HashMap<>();
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        int high;
        for (high = 0; high < s.length(); high++) {
            Integer integer = travel.get(s.charAt(high));
            if (integer != null && integer >= low) {
                max = Math.max(max, high - low);
                low = integer + 1;
            }
            travel.put(s.charAt(high), high);

        }
        max = Math.max(max, high - low);
        return max;
    }
}
