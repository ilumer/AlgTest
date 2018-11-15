package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilumer
 * Date : 2018/11/15
 * Time : 10:38 PM
 * https://leetcode.com/problems/find-all-duplicates-in-an-array
 */
public class LeetCode442 {
    /**
     * 重复出现两次的就是正数 把 nums[i] 作为索引
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums){
        int i , size = nums.length;
        List<Integer> result = new ArrayList<>();
        for (i = 0; i < size; i++) {
            int index = Math.abs(nums[i]) - 1;
            // 避免数组越界
            if (nums[index] >= 0)
                nums[index] = -nums[index];
            else
                result.add(index+1);
        }
        return result;
    }
}
