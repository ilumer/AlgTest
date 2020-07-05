package leetcode.medium;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class LeetCode718 {
    /**
     * 暴力遍历找到最长的公共子长串
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength1(int[] A, int[] B) {
        int max = 0;
        for (int aIndex = 0; aIndex < A.length; aIndex++) {
            for (int bIndex = 0; bIndex < B.length; bIndex++) {
                int bTempIndex = bIndex;
                int aTempIndex = aIndex;
                while (bTempIndex < B.length && aTempIndex < A.length) {
                    if (A[aTempIndex] != B[bTempIndex]) {
                        break;
                    }
                    bTempIndex++;
                    aTempIndex++;
                }
                max = Math.max(bTempIndex - bIndex, max);
            }
        }
        return max;
    }

    /**
     * 动态规划找到最长的公共子长串
     * if a[i] = b[j]
     *  dp[i+1][j+1] = dp[i][j]+1
     * else
     *  dp[i+1][j+1] = 0
     *  需要倒过来算
     * @param A
     * @param B
     * @return
     */
    public int findLength2(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max= 0;
        for (int aIndex = A.length-1; aIndex >= 0; aIndex--) {
            for (int bIndex = B.length-1; bIndex >= 0; bIndex--) {
                if (A[aIndex]==B[bIndex]){
                    dp[aIndex][bIndex] = dp[aIndex+1][bIndex+1]+1;
                }else {
                    dp[aIndex][bIndex] = 0;
                }
                max = Math.max(max,dp[aIndex][bIndex]);
            }
        }
        return max;
    }

    /**
     * 添加滑动窗口查询的方式
     * 1. A数组不动 B数组移动自己的开头位置
     * 2. B数组不动 A数组移动自己的开头位置
     * @param A
     * @param B
     * @return
     */
    public int findLength3(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

    public int findLength4(int[] A, int[] B) {
        int aLength = A.length;
        int bLength = B.length;
        int len = Math.min(aLength,bLength);
        int ans = 0;
        for (int i = 0; i < len ; i++) {
            int k = 0;
            for (int f = 0; f < len-i; f++) {
                if (A[f]==B[f+i]){
                    k++;
                }else {
                    k=0;
                }
                ans = Math.max(ans,k);
            }
        }
        for (int i = 0; i < len ; i++) {
            int k = 0;
            for (int f = 0; f < len-i; f++) {
                if (B[f+i]==B[f]){
                    k++;
                }else {
                    k=0;
                }
                ans = Math.max(ans,k);
            }
        }
        return ans;
    }

}
