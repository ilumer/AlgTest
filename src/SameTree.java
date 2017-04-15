/**
 * Created by ilumer on 17-4-15.
 * https://leetcode.com/problems/same-tree/#/description
 */
public class SameTree {
  private class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
      this.val = x;
    }
  }

  boolean result = true;

  public boolean isSameTree(TreeNode p, TreeNode q) {
    isEqual(p,q);
    return result;
  }
  //超级超级慢
  public void isEqual(TreeNode p,TreeNode q){
    if( p == q&&p==null){
      return;
    }
    if(p==null || q == null){
      result = false;
      return ;
    }
    isEqual(p.left,q.left);
    if(p.val != q.val){
      result =false;
      return;
    }
    isEqual(p.right,q.right);
  }

  //相等时候的返回很有意思https://discuss.leetcode.com/topic/4737/five-line-java-solution-with-recursion
  public boolean isSameTree2(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;
    if(p.val == q.val)
      //将根节点的返回值与子节点是否相等绑定在一起
      return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    return false;
  }
}
