package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilumer
 * Date : 2018/11/15
 * Time : 8:27 PM
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class LeetCode448 {
    /**
     * 将重复的数定位到相同的index 上,
     * 第二次循环的过程中小于n的数表示的是第一次循环中没有出现的(nums[i] - 1) % n)
     * 也就是我们寻找的没有出现的数
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++)
            nums[(nums[i] - 1) % n] += n;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= n)
                res.add(i + 1);
        return res;
    }
}
