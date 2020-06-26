package leetcode.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 * 没有考虑时间复杂度
 */
public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (!set.contains(1)){
            return 1;
        }
        for (int num : nums) {
            if ((!set.contains(num + 1)) && num + 1 > 0) {
                return num + 1;
            }
        }
        return 1;
    }
}
