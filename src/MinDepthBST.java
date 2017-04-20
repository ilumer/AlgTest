/**
 * Created by ilumer on 17-4-19.
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/#/description
 */
public class MinDepthBST {

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public int minDepth(TreeNode root){
    //找到叶子节点:定义为没有子节点的节点
    if (root == null )
      return 0;
    else if (root.left == null)
      return 1+minDepth(root.right);
    else if (root.right == null)
      return 1+minDepth(root.left);
    else
      return 1+Math.min(minDepth(root.left),minDepth(root.right));
  }


}
