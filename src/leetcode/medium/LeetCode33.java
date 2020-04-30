package leetcode.medium;

/**
 * @author banxuan
 * Date : 2020/4/27
 * Time : 11:03 下午
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        //直接切分判断是否是有序的
        if (nums.length == 0) {
            return -1;
        }
        int mid = (nums.length - 1) / 2;
        int start = 0;
        int end = nums.length - 1;
        if (nums[mid] < nums[end]) {
            //中间数小于右边 右边是有序的
            return Math.max(binarysearch(nums, mid + 1, end, target),
                    searchInNoOrdered(nums, start, mid, target));
        } else {
            return Math.max(searchInNoOrdered(nums, mid + 1, end, target),
                    binarysearch(nums, start, mid, target));
        }
    }

    public int searchInNoOrdered(int[] nums, int start, int end, int target) {
        if (end < start) {
            return -1;
        }
        if (end == start) {
            if (target == nums[start]) {
                return start;
            }
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] < nums[end]) {
            //中间数小于右边 右边是有序的
            return Math.max(binarysearch(nums, mid + 1, end, target),
                    searchInNoOrdered(nums, start, mid, target));
        } else {
            return Math.max(searchInNoOrdered(nums, mid + 1, end, target),
                    binarysearch(nums, start, mid, target));
        }
    }

    public int binarysearch(int[] nums, int start, int end, int target) {
        //直接切分判断是否是有序的
        if (nums[end] < target) {
            return -1;
        }
        if (nums[start] > target) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
