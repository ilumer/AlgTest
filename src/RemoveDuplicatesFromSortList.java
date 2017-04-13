/**
 * Created by ilumer on 17-4-13.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/#/description
 */
public class RemoveDuplicatesFromSortList {

  public ListNode deleteDuplicates(ListNode head){
    ListNode first = head;
    while (head!=null&&head.next!=null){
      if (head.val==head.next.val){
        head.next = head.next.next;
      }else {
        head = head.next;
      }
    }
    return first;
  }



  public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
      val = x;
    }
  }
}
