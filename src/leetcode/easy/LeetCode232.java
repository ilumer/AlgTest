package leetcode.easy;

import java.util.Stack;

public class LeetCode232 {
  private class MyQueue {

    private Stack<Integer> stack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
      if (stack.isEmpty()) {
        stack.add(x);
      } else {
        int[] array = new int[stack.size()];
        for (int i = array.length - 1; i >= 0; i--) {
          array[i] = stack.pop();
        }
        //添加的元素在栈底 Leetcode225
        stack.add(x);
        for (int i : array) {
          stack.add(i);
        }
      }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
      return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return stack.empty();
    }
  }
}
