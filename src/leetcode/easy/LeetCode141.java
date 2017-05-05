package leetcode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ilumer on 17-5-4.
 */
public class LeetCode141 {
  private class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
      this.val = val;
      next = null;
    }
  }

  public boolean hasCycle(ListNode head){
    Set<ListNode> list = new HashSet<>();
    if (head == null){
      return false;
    }

    while (head!=null && !list.contains(head)){
      list.add(head);
      head = head.next;
    }
    return head != null;
  }

  //使用两个指针如何证明
  //设置快慢指针
  //如果出现环 快慢指针一定会相遇
  public boolean hasCycle2(ListNode head){
    if (head == null||head.next == null){
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next!=null&&fast.next.next!=null){
      slow = slow.next;
      fast = fast.next.next;
      if (slow.equals(fast))
        return true;
    }
    return false;
  }

  public boolean hasCycle3(ListNode head) {
    if(head==null || head.next==null)
      return false;
    ListNode slow=head;
    ListNode fast=head;
    while(true){
      //出现null的情况就是不循环
      slow=slow.next;
      if(fast.next!=null)
        fast=fast.next.next;
      else
        return false;
      if(fast==slow)
        return true;
      if(fast==null || slow==null)
        return false;
    }
  }
}
