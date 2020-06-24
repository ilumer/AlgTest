package leetcode.medium;

import java.util.Arrays;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        int diffCount = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        //a + b +c 最接近于target，min(Math.abs(target-sum))
        // 优化思路就是有序以后 向左走整体的值变小，向右边走整体的值变大
        for (int i = 1;i<nums.length-1;i++){
            int index_b = i-1;
            int index_c = i+1;
            while (index_b>=0 && index_c<nums.length){
                int sum = nums[index_b] + nums[i] + nums[index_c];
                if (sum==target){
                    return target;
                }else if (sum<target){
                    if (diffCount>Math.abs(sum-target)){
                        result = sum;
                        diffCount = Math.abs(sum-target);
                    }
                    index_c++;
                }else {
                    if (diffCount>Math.abs(sum-target)){
                        result = sum;
                        diffCount = Math.abs(sum-target);
                    }
                    index_b--;
                }
            }
        }
        return result;
    }
}
