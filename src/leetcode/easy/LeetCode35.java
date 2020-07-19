package leetcode.easy;

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i]>=target){
                return ans;
            }
            ans++;
        }
        return ans;
    }

    public int binarySearchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length; // 可能target >  all nums
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            //不能直接把ans 代替 mid可能
            if (target <= nums[mid]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int binarySearchInsert2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;// 可能target >  all nums
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low ;
    }
}
