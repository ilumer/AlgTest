package leetcode.easy;

/**
 * Created by ilumer on 17-6-12.
 */
public class LeetCode235 {
  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //利用BST的性质
    while (root != null) {
      if (root.val < p.val && root.val < q.val) {
        root = root.right;
      } else if (root.val > p.val && root.val > q.val) {
        root = root.left;
      } else {
        return root;
      }
    }
    return null;
  }
}
