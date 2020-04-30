package leetcode.hard;


/**
 * Created by ilumer
 * Date : 2020/4/27
 * Time : 11:25 AM
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 分治
 */
public class LeetCode23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0){
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (end - start == 1) {
            return mergeKLists(lists[start], lists[end]);
        }
        if (end == start) {
            return lists[start];
        }
        return mergeKLists(mergeKLists(lists, start, start + (end - start) / 2), mergeKLists(lists, start + (end - start) / 2 + 1, end));
    }

    public ListNode mergeKLists(ListNode a, ListNode b) {
        ListNode head;
        if (a==null){
            return b;
        }
        if (b ==null){
            return a;
        }
        if (a.val <= b.val) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }
        ListNode temp = head;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                temp.next = a;
                temp = temp.next;
                a = a.next;
            } else {
                temp.next = b;
                temp = temp.next;
                b = b.next;
            }
        }
        if (a == null) {
            temp.next = b;
        }
        if (b == null) {
            temp.next = a;
        }
        return head;
    }
}
