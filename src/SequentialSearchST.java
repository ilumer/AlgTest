import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-4-10.
 * http://algs4.cs.princeton.edu/31elementary/SequentialSearchST.java
 */
public class SequentialSearchST<Key, Value> {

  Node root = null;
  int size = 0;

  public SequentialSearchST() {
  }

  public boolean contains(Key key){
    return get(key) != null;
  }

  public Value get(Key key) {
    Node temp = root;
    while (temp != null) {
      if (temp.key.equals(key)) {
        return temp.value;
      }
      temp = temp.next;
    }
    return null;
  }

  public void put(Key key, Value value) {
    Node temp = root;
    while (temp!= null) {
      if (temp.key.equals(key)) {
        temp.value = value;
        return;
      }
      temp = temp.next;
    }
    root = new Node(key, value, root);
    size++;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Iterable<Key> keys(){
    return keys(root);
  }

  private Queue<Key> keys(Node root) {
    Queue<Key> queue = new Queue<Key>();
    for (Node x = root; x != null; x = x.next)
      queue.enqueue(x.key);
    return queue;
  }

  /**
   * @return 如果没有命中时返回false, 删除成功后返回true
   */
  public boolean delete(Key key) {
    if (root ==null){
      throw new IllegalArgumentException("argument to delete is null");
    }
    if(root.key.equals(key)){
      root = root.next;
      size--;
      return true;
    }
    Node temp = root;
    if (temp.next != null) {
      if (temp.next.key.equals(key)){
        Node delete = temp.next;
        temp.next = delete.next;
        size--;
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }
    for (String s:st.keys())
      StdOut.println(s+" "+st.get(s));
  }

  private class Node {
    Key key;
    Value value;
    Node next;

    public Node(Key key, Value value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }
}
