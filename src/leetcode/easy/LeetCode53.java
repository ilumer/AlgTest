package leetcode.easy;

/**
 * @author banxuan
 * Date : 2020/5/3
 * Time : 1:47 上午
 * https://leetcode-cn.com/problems/maximum-subarray/
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/ 题解介绍
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int max = 0x80000000;
        int sum = 0;
        if (nums.length == 1) {
            return nums[0];
        }
        int right = 0;
        while (right < nums.length) {
            sum = sum + nums[right];
            right++;
            max = Math.max(sum, max);
            //如果小于就抛弃之前的内容
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
