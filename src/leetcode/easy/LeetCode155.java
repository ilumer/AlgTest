package leetcode.easy;


/**
 * Created by ilumer on 17-5-5.
 * https://leetcode.com/problems/min-stack/#/description
 * https://discuss.leetcode.com/topic/7020/java-accepted-solution-using-one-stack
 * 这个方法把最小值添加两次到栈中,然后遇到最小值时弹出两次
 */
public class LeetCode155 {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }

  static class MinStack {
    //为什么使用数组无法有一些情况无法通过出现错误的情况(不是超时)
    Node head;

    public MinStack() {
      head = null;
    }

    public void push(int x) {
      if (head == null) {
        head = new Node(x, x, null);
      }else {
        //当前节点下最小的值
        head = new Node(x,Math.min(x,head.min),head);
      }
    }

    public void pop() {
      head = head.next;
      //null处理
    }

    public int top() {
      //null处理
      return head.x;
    }

    public int getMin() {
      return head.min;
    }
  }

  private static class Node {
    int x;
    int min;
    //在当前栈中的最小值
    Node next;

    public Node(int x, int min, Node next) {
      this.x = x;
      this.min = min;
      this.next = next;
    }
  }
}
