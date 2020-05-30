package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author banxuan
 * Date : 2020/5/13
 * Time : 11:29 下午
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            result.add(queue.stream().map(i -> i.val).collect(Collectors.toList()));
            queue = traverse(queue);
        }
        return result;
    }

    public Queue<TreeNode> traverse(Queue<TreeNode> queue) {
        Queue<TreeNode> nextLevelNodeQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                nextLevelNodeQueue.add(node.left);
            }
            if (node.right != null) {
                nextLevelNodeQueue.add(node.right);
            }
        }
        return nextLevelNodeQueue;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
