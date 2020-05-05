package leetcode.hard;

/**
 * @author banxuan
 * Date : 2020/5/4
 * Time : 12:58 上午
 */
public class LeetCode45 {
    public static int jump(int[] nums) {
        int length = nums.length;
        int last = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == last) {
                last = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(2==jump(new int[]{2,3,1,1,4}));
        System.out.println(3==jump(new int[]{1,2,1,1,1}));
        System.out.println(1==jump(new int[]{1,2}));
        System.out.println(0==jump(new int[]{0}));
    }
}
