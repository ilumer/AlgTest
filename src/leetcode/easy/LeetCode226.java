package leetcode.easy;

//https://leetcode.com/problems/invert-binary-tree/#/solutions
public class LeetCode226 {
  private class TreeNode {
    int val;
    TreeNode Left;
    TreeNode Right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  //DFS
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = root.Left, right = root.Right;
    root.Left = invertTree(right);
    root.Right = invertTree(left);
    //每一个树反转
    return root;
  }

  //BFS
  /*public TreeNode invertTree(TreeNode root) {

    if (root == null) {
      return null;
    }

    final Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()) {
      final TreeNode node = queue.poll();
      final TreeNode left = node.left;
      node.left = node.right;
      node.right = left;

      if(node.left != null) {
        queue.offer(node.left);
      }
      if(node.right != null) {
        queue.offer(node.right);
      }
    }
    return root;
  }*/
}
