import edu.princeton.cs.algs4.*;
import java.util.List;

/**
 * Created by ilumer on 17-4-23.
 * 类似于拉链法 来相同的点
 */
public class SameKeyBST<Key extends Comparable<Key>,Value>{

  Node root;

  private class Node{
    Key key;
    Value value;
    Node Left;
    Node Right;
    SequentialSearchST<Key,Value> sequentialSearchST;

    public Node(Key key, Value value) {
      this.key = key;
      this.value = value;
      sequentialSearchST = new SequentialSearchST<Key, Value>();
    }
  }

  public void add(Key key,Value value){
    root = add(key,value,root);
  }

  private Node add(Key key, Value value, Node root) {
    if (root == null)
      return new Node(key,value);
    int temp = root.key.compareTo(key);
    if (temp<0){
      root.Right = add(key,value,root.Right);
    }else if (temp>0){
      root.Left = add(key,value,root.Left);
    }else {
      root.sequentialSearchST.put(key,value);
    }
    return root;
  }

  private void delete(Key key){
    //key 不为null的情况
    root = delete(key,root);
  }

  private Node delete(Key key, Node root) {
    if (root == null)
      return null;
    int temp = root.key.compareTo(key);
    if (temp < 0 ){
      root.Right = delete(key,root.Right);
    }else if (temp > 0){
      root.Left = delete(key,root.Left);
    }else {
      //需要去寻找后继节点
      if (root.Right == null)
        root = root.Left;
      else {
        // need do find min node and delete
        Node x = min(root.Right);
        root.Right = deleteMin(root.Right);
        root.sequentialSearchST = null;
        root.key = x.key;
        root.value = x.value;
      }
    }
    return root;
  }

  //deleteMin(node)  node 不可能为null
  private Node deleteMin(Node node) {
    if (node.Left == null)
      return node.Right;
    node.Left = deleteMin(node.Left);
    return node;
  }

  private Node min(Node node) {
    if (node == null || node.Left == null)
      return node;
    return min(node.Left);
  }
}
