package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225 {

  private class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
      queue.add(x);
    }

    public int pop() {
      //将原来的队列全部弹出 添加到新的队列
      Queue<Integer> removeQueue = new LinkedList<>();
      int i = queue.size();
      //处理异常queue.isEmpty
      if (i >= 1) {
        for (int j = 0; j < i - 1; j++) {
          removeQueue.add(queue.poll());
        }
        int x = queue.poll();
        queue = removeQueue;
        return x;
      } else {
        return queue.poll();
      }
    }

    public int top() {
      Queue<Integer> removeQueue = new LinkedList<>();
      int i = queue.size();
      int x = 0;
      //处理异常
      if (i >= 1) {
        for (int j = 0; j < i; j++) {
          if (j == i - 1) {
            x = queue.poll();
            removeQueue.add(x);
          } else {
            removeQueue.add(queue.poll());
          }
        }
        queue = removeQueue;
        return x;
      } else {
        return queue.peek();
      }
    }

    public boolean empty() {
      return queue.isEmpty();
    }
  }
}

//https://discuss.leetcode.com/topic/16141/only-push-is-o-n-others-are-o-1-using-one-queue-combination-of-two-shared-solutions
/*class MyStack
{
  Queue<Integer> queue;

  public MyStack()
  {
    this.queue=new LinkedList<Integer>();
  }

  // Push element x onto stack.
  public void push(int x)
  {
    queue.add(x);
    for(int i=0;i<queue.size()-1;i++)
    {
      queue.add(queue.poll());
    }
    //将最后添加的数放到队列的最前方
  }

  // Removes the element on top of the stack.
  public void pop()
  {
    queue.poll();
  }

  // Get the top element.
  public int top()
  {
    return queue.peek();
  }

  // Return whether the stack is empty.
  public boolean empty()
  {
    return queue.isEmpty();
  }
}*/
