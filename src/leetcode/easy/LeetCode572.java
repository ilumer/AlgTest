package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author banxuan
 * Date : 2020/5/7
 * Time : 4:28 下午
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * https://leetcode-cn.com/problems/subtree-of-another-tree/solution/ling-yi-ge-shu-de-zi-shu-by-leetcode-solution/
 */
public class LeetCode572 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public boolean isSubtree(TreeNode s, TreeNode t) {
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(s);
            while (!deque.isEmpty()) {
                TreeNode p = deque.poll();
                if (isSameTree(p, t)) {
                    return true;
                }
                if (p.left != null) {
                    deque.add(p.left);
                }
                if (p.right != null) {
                    deque.add(p.right);
                }
            }
            return false;
        }

        public boolean isSameTree(TreeNode s, TreeNode t) {
            if ((s == null && t != null) || (s != null && t == null)) {
                return false;
            }
            if (s == null && t == null) {
                return true;
            }
            if (s.val != t.val) {
                return false;
            }
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }
}
