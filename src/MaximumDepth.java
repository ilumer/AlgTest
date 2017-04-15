/**
 * Created by ilumer on 17-4-15.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/#/description
 */
public class MaximumDepth {
  private class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
      val = x;
    }
  }

  //BST 中的size()计算
  public int maxDepth(TreeNode root){
    if (root == null){
      return 0;
    }
    return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
  }
}
