package leetcode.medium;

/**
 * @author banxuan
 * Date : 2020/4/29
 * Time : 3:42 上午
 */
public class LeetCode56 {
    public int[] singleNumbers(int[] nums) {
        //先异或再分组
        if (nums.length == 0) {
            return nums;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            i = i ^ nums[j];
        }
        //计算i的二进制中第一个不为1的位数
        int bitIndex = bitIndex(i);
        int a = 0, b = 0;
        for (int j = 0; j < nums.length; j++) {
            if (bitIndexTrue(nums[j], bitIndex)) {
                a = a ^ nums[j];
            } else {
                b = b ^ nums[j];
            }
        }
        return new int[]{a, b};
    }

    private int bitIndex(int i) {
        int index = 0;
        while ((i & 1) == 0) {
            i = i >> 1;
            index++;
        }
        return index;
    }

    private boolean bitIndexTrue(int num, int bitIndex) {
        num = num >> bitIndex;
        return (num & 1) == 1;
    }
}

