package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ilumer
 * Date : 2018/10/16
 * Time : 11:25 PM
 *  https://leetcode.com/problems/add-two-numbers/
 *  用一个队列保存存入的节点  然后依次poll出所有的节点 生成需要的listNode
 *  与两个数相加是相同的思路
 */
public class LeetCode2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<ListNode> queue = new ArrayDeque<>();
        int temp = 0;
        while (l1 != null && l2 != null) {
            int t1 = (l1.val + l2.val + temp) % 10;
            temp = l1.val + l2.val + temp >= 10 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
            queue.add(new ListNode(t1));
        }
        if (l1 !=null){
            while (l1 != null) {
                int t1 = (l1.val + temp) % 10;
                temp = l1.val + temp >= 10 ? 1 : 0;
                l1 = l1.next;
                queue.add(new ListNode(t1));
            }
        }else if (l2 !=null){
            while (l2 != null) {
                int t1 = (l2.val + temp) % 10;
                temp = l2.val + temp >= 10 ? 1 : 0;
                l2 = l2.next;
                queue.add(new ListNode(t1));
            }
        }
        if (temp != 0) {
            queue.add(new ListNode(temp));
        }
        ListNode node = queue.poll();
        ListNode result = node;
        while (!queue.isEmpty()) {
            node.next = queue.poll();
            node = node.next;
        }
        return result;
    }
}
