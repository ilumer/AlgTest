import edu.princeton.cs.algs4.Queue;

/**
 * Created by ilumer on 17-4-19.
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/#/description
 * 如何将有序数组h转换为AVL
 */
public class ConvertArrayBST {
  private class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public TreeNode sortedArrayToBST(int[] nums){
    if (nums == null || nums.length == 0)
      return null;
    return putNodeAVL(nums,0,nums.length-1);
  }

  //https://discuss.leetcode.com/topic/20983/java-recursive-solution
  private TreeNode putNodeAVL(int[] nums, int lo, int hi) {
    if (lo >= hi) {
      return null;
    }
    int mid = lo + (hi - lo) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = putNodeAVL(nums,lo,mid-1);
    node.right = putNodeAVL(nums,mid+1,hi);
    return node;
  }
}
