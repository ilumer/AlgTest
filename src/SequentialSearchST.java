import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-4-10.
 * http://algs4.cs.princeton.edu/31elementary/SequentialSearchST.java
 */
public class SequentialSearchST<Key, Value> {

  Node first = null;
  int size = 0;

  public SequentialSearchST() {
  }

  public Node get(Key key) {
    Node temp = first;
    while (temp != null) {
      if (temp.key.equals(key)) {
        return temp;
      }
      temp = temp.next;
    }
    return null;
  }

  public void put(Key key, Value value) {
    if (first == null) {
      first = new Node(key, value, null);
      size++;
      return;
    }
    Node temp = first;
    while (temp.next != null) {
      if (temp.key.equals(key)) {
        temp.value = value;
        return;
      }
      temp = temp.next;
    }
    temp.next = new Node(key, value, null);
    size++;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void showKeys() {
    Node temp = first;
    while (temp != null) {
      StdOut.println(temp.key + " " + temp.value);
      temp = temp.next;
    }
  }

  /*public Iterable<Key> keys(){

  }*/

  /**
   * @return 如果没有命中时返回false, 删除成功后返回true
   */
  public boolean delete(Key key) {
    if (first==null){
      throw new IllegalArgumentException("argument to delete is null");
    }
    if(first.key.equals(key)){
      first = first.next;
      size--;
      return true;
    }
    Node temp = first;
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
    st.showKeys();
    System.out.println(st.size());
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
