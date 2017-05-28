package leetcode.easy;

/**
 * Created by ilumer on 17-5-26.
 */
public class LeetCode203 {

  private class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
      val = x;
    }
  }

  //需要处理的情形太多
  public ListNode removeElements(ListNode head,int val){
    while (head!=null&&head.val == val){
      head = head.next;
    }
    if (head == null){
      return null;
    }
    ListNode pointer = head;
    while (pointer.next!=null){
      if (pointer.next.val == val){
        pointer.next = pointer.next.next;
      }else {
        pointer = pointer.next;
      }
    }
    return head;
  }

  //将全部的情况读入栈中
  public ListNode rescRemoveElements(ListNode head, int val) {
    if(head==null) return head;
    head.next = removeElements(head.next,val);
    return head.val==val ? head.next : head ;
  }
}
