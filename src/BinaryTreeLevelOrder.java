
import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ilumer on 17-4-15.
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description
 * http://www.cnblogs.com/miloyip/archive/2010/05/12/binary_tree_traversal.html
 */
public class BinaryTreeLevelOrder {

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/solutions
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) {
      return lists;
    }
    //put to last element
    queue.offer(root);
    //put offer http://stackoverflow.com/questions/2703984/what-is-the-difference-between-the-add-and-offer-methods-in-a-queue-in-java
    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        if (queue.peek().left != null) queue.offer(queue.peek().left);
        if (queue.peek().right != null) queue.offer(queue.peek().right);
        list.add(queue.poll().val);
      }
      lists.add(0, list);
    }
    return lists;
  }

}
