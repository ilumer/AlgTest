import java.util.HashSet;
import java.util.Set;

public class Date0626 {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> duplicateNodes = new HashSet<>();
        if (head == null) {
            return head;
        }
        ListNode resultHead = new ListNode(0);
        ListNode traceHead = resultHead;
        while (head != null) {
            if (!duplicateNodes.contains(head.val)) {
                resultHead.next = head;
                resultHead = resultHead.next;
            }
            duplicateNodes.add(head.val);
            head = head.next;
        }
        // 并在后面的节点需要free 掉
        resultHead.next = null;
        return traceHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
