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
        if (!set.contains(1)) {
            return 1;
        }
        for (int num : nums) {
            if ((!set.contains(num + 1)) && num + 1 > 0) {
                return num + 1;
            }
        }
        return 1;
    }

    public int firstMissingPositive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }

    /**
     * 通过把数据变成负数来保证这个数据是否有被访问过
     * nums[i] = 7 然后 nums[7-1] 是一个负数 那么就是表示 7这个数是被访问过的
     * 与ascii的数组我个人感觉是一致的
     * @param nums
     * @return
     */
    public int firstMissingPositive3(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i]<=0){
                nums[i] = nums.length +1;
                //先把小于等于0的数变成正整数
                //为什么0也要算进来 因为 0-1 会数据越界 0也不是符合条件的数据(正整数)
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            int num = Math.abs(nums[i]);//nums[i] 可能因为被访问过已经变成了负数
            //如果太大就已经超过了表的空间
            if (num<nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < nums.length ; i++) {
            if (nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;
    }

    /**
     * 作交换 1-N(nums.length) 如果 nums[i-1] = i 成立 那么第一个没有出现的数就是最小正整数
     * @param nums
     * @return
     */
    public int firstMissingPositive4(int[] nums) {
        int n = nums.length;
        for (int i= 0;i<n;i++){
            while ((nums[i]>0 && nums[i] < n) && nums[i]!=nums[nums[i]-1]){
                //交换后可能可以继续交换，如果两个一致后可能会出现断栈
                int swap = nums[i];
                nums[i] = nums[swap-1];
                nums[swap-1] = swap;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}
