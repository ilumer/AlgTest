/**
 * Created by ilumer on 17-4-15.
 * https://leetcode.com/problems/symmetric-tree/#/description
 */
public class SymmetricTree {
  private class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
      this.val = x;
    }
  }

  public boolean isSymmetric(TreeNode root){
    return root == null ||isSameTree(root.left,root.right);
  }

  //从100 这道题上想到的
  public boolean isSameTree(TreeNode left,TreeNode right){
    if (left == right && left == null){
      return true;
    }
    if (left == null || right == null){
      return false;
    }
    if (left.val == right.val){
      return isSameTree(left.left,right.right) && isSameTree(left.right,right.left);
    }
    return false;
  }
}
