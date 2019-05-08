package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ilumer
 * Date : 2019-05-08
 * Time : 18:42
 * https://leetcode.com/problems/all-possible-full-binary-trees/submissions/
 */
public class LeetCode894 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, List<TreeNode>> integerTreeNodeMap = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();
        if (N % 2 == 0) {
            return result;
        }
        if (N == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        int leftSize = 1;
        int rightSize = N - 1 - leftSize;
        while (leftSize < N) {
            List<TreeNode> leftTreeNode = integerTreeNodeMap.get(leftSize);
            if (leftTreeNode == null){
                leftTreeNode = allPossibleFBT(leftSize);
            }
            List<TreeNode> rightTreeNode = integerTreeNodeMap.get(rightSize);
            if (rightTreeNode == null){
                rightTreeNode = allPossibleFBT(rightSize);
            }
            for (TreeNode i : leftTreeNode) {
                for (TreeNode j : rightTreeNode) {
                    TreeNode node = new TreeNode(0);
                    node.left = i;
                    node.right = j;
                    result.add(node);
                }
            }
            leftSize++;
            rightSize = N - 1 - leftSize;
        }
        integerTreeNodeMap.put(N,result);
        return result;
    }

    public static void main(String[] args) {
        LeetCode894 test = new LeetCode894();
        test.allPossibleFBT(7);
    }
}
