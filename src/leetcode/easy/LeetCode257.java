package leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ilumer on 17-6-12.
 */
public class LeetCode257 {
  private class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
      val = x;
    }
  }


  //https://discuss.leetcode.com/topic/21474/accepted-java-simple-solution-in-8-lines
  public List<String> binaryTreePaths(TreeNode root){
    List<String> answer = new ArrayList<>();
    if (root != null) searchBT(root, "", answer);
    return answer;
  }

  //将一个树分为左子树和右子树 递归解决问题
  private void searchBT(TreeNode root, String path, List<String> answer) {
    if (root.left == null && root.right == null) answer.add(path + root.val);
    if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
    if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
  }

  //https://discuss.leetcode.com/topic/23047/clean-java-solution-accepted-without-any-helper-recursive-function
 /* public List<String> binaryTreePaths(TreeNode root) {

    List<String> paths = new LinkedList<>();

    if(root == null) return paths;

    if(root.left == null && root.right == null){
      paths.add(root.val+"");
      return paths;
    }

    //分为两个子树
    for (String path : binaryTreePaths(root.left)) {
      paths.add(root.val + "->" + path);
    }

    for (String path : binaryTreePaths(root.right)) {
      paths.add(root.val + "->" + path);
    }

    return paths;

  }*/
}
