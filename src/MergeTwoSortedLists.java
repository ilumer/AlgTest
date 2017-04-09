/**
 * Created by ilumer on 17-4-9.
 * https://leetcode.com/problems/merge-two-sorted-lists/#/description
 */
public class MergeTwoSortedLists {

  //处理头部 然后用一个指针指向起点另一个滑动链接不同的节点 16ms
  static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode head, first;
    if (l1.val < l2.val) {
      head = first = l1;
      l1 = l1.next;
    } else {
      head = first = l2;
      l2 = l2.next;
    }
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        first.next = l1;
        first = first.next;
        l1 = l1.next;
      } else {
        first.next = l2;
        first = first.next;
        l2 = l2.next;
      }
    }
    if (l1 != null) {
      first.next = l1;
    } else {
      first.next = l2;
    }
    return head;
  }

  //将大的链表分割为小的链表
  public static ListNode solution(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = solution(l1.next, l2);
      return l1;
    } else {
      l2.next = solution(l2.next, l1);
      return l2;
    }
  }

  static class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
      this.val = x;
    }
  }
}
