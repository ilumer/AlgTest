package leetcode.easy;

/**
 * 如何生成反向链表
 * http://blog.csdn.net/guyuealian/article/details/51119499
 * Created by ilumer on 17-3-25.
 */
public class LeetCode206 {

  /**
   * @param first 首节点
   * @return 反转后的首节点
   */
  public static Node solution(Node first) {
    Node pre;
    if (first == null) {
      return null;
    } else {
      pre = new Node(first.getId(), null);
      if (first.getNext() == null) {
        return first;
      } else {
        while (first.getNext() != null) {
          first = first.getNext();
          Node temp = new Node(first.getId(), null);
          temp.next = pre;
          pre = temp;
          //生成新的节点将原来的节点向后移动需要生成新的N个节点
        }
      }
    }
    return pre;
  }

  public static Node solution2(Node first) {
    if (first == null) {
      return null;
    }
    Node pre = first;
    Node cur = first.getNext();
    Node temp;
    while (cur != null) {
      temp = cur.getNext();
      cur.setNext(pre);
      pre = cur;
      cur = temp;
      /*
        通过的修改指向域 形成反向 每次下移一位把cur的指向域指向pre
        pre a [1,b]
        cur b [2,c]
            c [3,d]
            d [4,null]
         在实现反转时 cur变量会将b的next域指向 a,然后下移cur pre 变量引用b，c实例
             a[1,b]
         pre b[2,a]
         cur c[3,d]
             d[4,null]
             最后将a的next域 置为null
      */
    }
    first.setNext(null);
    return pre;
  }

  public static Node solution3(Node first){
    if (first == null || first.getNext() == null){
      return first;
    }
    //不对返回的变量更改会丢失开头的节点(原来的尾节点)
    Node next = solution3(first.getNext());
    first.getNext().setNext(first);
    first.setNext(null);
    return next;//一直是尾节点 可以设置为全局变量更好理解
  }

  public static void main(String[] args) {
    Node head = new Node(11, null);
    Node first = new Node(12, null);
    Node second = new Node(13, null);
    Node third = new Node(14, null);
    head.setNext(first);
    first.setNext(second);
    second.setNext(third);
    Node last = solution3(head);
    while (last != null) {
      System.out.println(last.getId());
      last = last.getNext();
    }
  }

  private static class Node {
    int id;
    Node next;

    public Node(int id, Node next) {
      this.id = id;
      this.next = next;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }
}
