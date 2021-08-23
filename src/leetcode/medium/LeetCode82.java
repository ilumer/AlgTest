package leetcode.medium;

/**
 * @author banxuan
 * Date : 2021/8/21
 * Time : 6:48 下午
 */
public class LeetCode82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        return deleteDuplicates(head, head.next);
    }

    private ListNode deleteDuplicates(ListNode first, ListNode second) {
        boolean a = true;
        while (first != null && second != null && first.val == second.val) {
            first = second;
            second = second.next;
            a = false;
        }
        if (first == null) {
            return first;
        }
        if (second == null) {
            if (a) {
                return first;
            } else {
                return null;
            }
        }
        if (a) {
            first.next = deleteDuplicates(second, second.next);
            return first;
        } else {
            return deleteDuplicates(second, second.next);
        }
    }

    public class ListNode {
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
}
