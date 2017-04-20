/**
 * Created by ilumer on 17-4-19.
 * https://leetcode.com/problems/balanced-binary-tree/#/description
 */
public class JudgeAVL {

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public boolean isBalanced(TreeNode root){
    if (root == null)
      return true;
    if (balanceFactor(root) <=1&& balanceFactor(root)>=-1){
      return isBalanced(root.left) && isBalanced(root.right);
    }else {
      return false;
    }

  }

  private int balanceFactor(TreeNode root){
    return height(root.left) - height(root.right);
  }

  //空节点的高度急为-1
  public int height(TreeNode node) {
    if (node == null) {
      return -1;
    } else {
      return 1 + Math.max(height(node.left), height(node.right));
    }
  }
}
