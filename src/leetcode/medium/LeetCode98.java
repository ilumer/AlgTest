package leetcode.medium;


/**
 * @author banxuan
 * Date : 2020/4/27
 * Time : 11:03 下午
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 将一个二插树不断切分为单个节点
 */
public class LeetCode98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
