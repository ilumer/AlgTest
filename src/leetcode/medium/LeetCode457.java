package leetcode.medium;

/**
 * @author banxuan
 * Date : 2021/8/27
 * Time : 7:59 下午
 */
public class LeetCode457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums[0] > 0) {
            // 整个流程只能向前
            int i = 0;
            int step = 0;
            int count = 0;
            while (nums[i] + step < nums.length) {
                if (nums[i] < 0) {
                    return false;
                }
                int pre = i;
                i = (step + nums[i]) % nums.length;
                step = step + nums[pre];
                count++;
            }
            if (nums[i] < 0) {
                return false;
            }
            if ((nums[i] + step) % nums.length == i) {
                return false;
            }
            count++;
            return count != 1;
        } else if (nums[0] < 0) {
            int i = 0;
            int step = nums.length;
            int count = 0;
            while (step - Math.abs(nums[i]) > 0) {
                if (nums[i] > 0) {
                    return false;
                }
                int pre = i;
                i = (step - Math.abs(nums[i])) % nums.length;
                step = step - Math.abs(nums[pre]);
                count++;
            }
            if (nums[i] > 0) {
                return false;
            }
            // 肯定是一个小数
            int next = nums.length + ((step - Math.abs((nums[i]))) % nums.length);
            if (next == i) {
                return false;
            }
            count++;
            return count != 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode457().circularArrayLoop(new int[]{
                2,2,2,2,2,4,7
        }));
    }
}

