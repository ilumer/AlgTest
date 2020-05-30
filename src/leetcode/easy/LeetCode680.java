package leetcode.easy;

/**
 * @author banxuan
 * Date : 2020/5/19
 * Time : 12:55 下午
 */
public class LeetCode680 {
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                // 左边向前进一位
                boolean flag1 = true, flag2 = true;
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
    //递归实现 可以生成新的字符串(同时生成两个 判断是否去除过一次字符串)判断这个字符串是否是一个回文字符串
}
