package leetcode.easy;

/**
 * @author banxuan
 * Date : 2020/5/31
 * Time : 4:47 下午
 */
public class LeetCode101 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return isSame(root.left,root.right);
    }

    public boolean isSame(TreeNode left,TreeNode right) {
        if (left == null && right==null){
            return true;
        }
        if (left==null || right ==null){
            return false;
        }
        return left.val == right.val && isSame(left.left,right.right) && isSame(left.right,right.left);
    }
}
