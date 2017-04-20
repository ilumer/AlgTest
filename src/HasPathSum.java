/**
 * Created by ilumer on 17-4-19.
 * https://leetcode.com/problems/path-sum/#/description
 */
public class HasPathSum {
  private class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public boolean hasPathSum(TreeNode root,int sum){
    if (root == null )
      return false;
    //可能出现负数所以去掉了多余的条件
    if (root.val == sum && root.left == null && root.right == null){
      return true;
    }
    return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
  }
}
