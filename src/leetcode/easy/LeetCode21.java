package leetcode.easy;

/**
 * @author banxuan
 * Date : 2022/6/2
 * Time : 12:39
 */
public class LeetCode21 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode mergeUnsortedTwoLists(ListNode list1, ListNode list2) {
        // 如何合并两个没有序的链表
        list1 = splitListNode(list1);
        list2 = splitListNode(list2);
        return mergeTwoLists(list1, list2);
    }

    private ListNode splitListNode(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode next = list.next;
        list.next = null;
        return mergeTwoLists(list, splitListNode(next));
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode resultPre = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            head.next = list2;
        }
        if (list2 == null) {
            head.next = list1;
        }
        // head1>head2
        // head1=head2
        // head1 < head2
        // head1 is null
        // head2 is null
        return resultPre.next;
    }

    public static void main(String[] args) {
        //[1,2,4]
        //[1,3,4]
        ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(5, new ListNode(4)));
        ListNode result = new LeetCode21().mergeUnsortedTwoLists(listNode, listNode2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
