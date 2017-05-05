package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilumer on 17-5-5.
 *
 */
public class LeetCode160 {
  private class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  //速度不够快
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    Set<ListNode> set = new HashSet<>();
    while (headA != null) {
      set.add(headA);
      headA = headA.next;
    }
    while (headB != null && !set.contains(headB)) {
      headB = headB.next;
    }
    return headB;
  }

  //当长度相等的时候就可以同步进行游动 判断相同位置(想对于尾节点)的节点是否相同
  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    int lengthA = getLength(headA);
    int lengthB = getLength(headB);
    while (lengthA > lengthB) {
      headA = headA.next;
      lengthA--;
    }
    while (lengthA < lengthB) {
      headB = headB.next;
      lengthB--;
    }
    //这个时候两者的长度相等
    while (headA != headB) {//equals
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }

  private int getLength(ListNode headA) {
    int count = 0;
    while (headA != null) {
      headA = headA.next;
      count++;
    }
    return count;
  }
}
