package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

public class LeetCode198 {
    // 回溯的方法
    // 最后一个房子选还是不选
    // 假设有n 个房子
    // 最后一个不选 vs 选了最后一个的情况
    // f(n) = max(f(n-2) + nums(n),f(n-1))
    // 回溯的情况太多了超出了限制
    // f(2) =  max(f(0) + nums[2] + f(1))
    public int rob(int[] nums) {
        int i = nums.length;
        int[] cache = new int[i + 2];
        for (int j = 0; j < cache.length; j++) {
            cache[j] = 0;
        }
        for (int m = 0; m < nums.length; m++) {
            cache[m + 2] = Math.max(cache[m + 1], cache[m] + nums[m]);
        }
        return cache[i + 1];
    }

    // 如果我想要正向算应该如何处理
    // 如果我选了第一个 那么我就不能选第二个

}
