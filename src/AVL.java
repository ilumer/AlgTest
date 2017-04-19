import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-4-18.
 */
public class AVL<Key extends Comparable<Key>, Value> {

  private Node root;

  public AVL() {
  }

  private class Node {
    Key key;
    Value value;
    int N;//node numbers in subtree
    int height;//the height of subtree
    Node left;
    Node right;

    public Node(Key key, Value value, int n, int height) {
      this.key = key;
      this.value = value;
      N = n;
      this.height = height;
    }
  }

  public void put(Key key, Value value) {
    root = put(key, value, root);
  }

  private Node put(Key key, Value value, Node node) {
    if (node == null) {
      return new Node(key, value, 1, 0);
    }
    int temp = node.key.compareTo(key);
    if (temp == 0) {
      //update
      node.value = value;
      return node;
    } else if (temp < 0) {
      //添加到右子树上
      node.right = put(key, value, node.right);
    } else if (temp > 0) {
      //添加到左子树上
      node.left = put(key, value, node.left);
    }
    //更新size和深度
    node.N = 1 + size(node.left) + size(node.right);
    node.height = 1 + Math.max(height(node.left), height(node.right));
    //如果不平衡需要将左右子树设置为平衡
    return balance(node);
  }

  //https://zh.wikipedia.org/wiki/AVL%E6%A0%91
  //什么情况下需要旋转
  //1 左 左
  //2.右 右
  //3.左 右
  //4右 左
  private Node balance(Node node) {
    if (balanceFactor(node) > 1) {
      if (balanceFactor(node.left) < 0) {
        node.left = leftRotate(node.left);
      }
      node = rightRotate(node);
    } else if (balanceFactor(node) < -1) {
      if (balanceFactor(node.right) > 0) {
        node.right = rightRotate(node.right);
      }
      node = leftRotate(node);
    }
    return node;
  }

  private int balanceFactor(Node node) {
    //return node.left.height - node.right.height;
    //会出现空指针的情况
    return height(node.left) - height(node.right);
  }

  //将原来的右链接 旋转成 左链接
  private Node leftRotate(Node x) {
    Node h = x.right;
    x.right = h.left;
    h.left = x;
    h.N = 1 + size(h.left) + size(h.right);
    //x节点的深度也改变了
    x.height = 1 + Math.max(height(x.left), height(x.right));
    h.height = 1 + Math.max(height(h.left), height(h.right));
    return h;
  }

  //将原来的左链接 旋转成右链接
  private Node rightRotate(Node x) {
    Node h = x.left;
    x.left = h.right;
    h.right = x;
    //需要更新深度和节点数
    x.height = 1 + Math.max(height(x.left), height(x.right));
    h.height = 1 + Math.max(height(h.left), height(h.right));
    h.N = 1 + size(h.left) + size(h.right);
    return h;
  }

  private int size(Node node) {
    if (node == null) return 0;
    return node.N;
  }

  public void delete(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("key can not set null");
    }
    root = delete(key, root);
  }

  private Node delete(Key key, Node root) {
    if (root == null) {
      return null;
    }
    int temp = root.key.compareTo(key);
    if (temp > 0) {
      root.left = delete(key, root.left);
    } else if (temp < 0) {
      root.right = delete(key, root.right);
    } else {
      if (root.right == null) {
        root = root.left;
      } else if (root.left == null) {
        root = root.right;
      } else {
        Node x = root;
        root = min(root.right);
        root.left = x.left;
        root.right = deleteMin(x);
      }
    }
    root.N = 1 + size(root.left) + size(root.right);
    root.height = 1 + Math.max(height(root.left), size(root.right));
    return balance(root);
  }

  private Node deleteMin(Node node) {
    if (node.left == null) {
      return node.right;
    }
    node.left = deleteMin(node.left);
    node.N = 1 + size(node.left) + size(node.right);
    node.height = 1 + Math.max(height(node.left), size(node.right));
    return balance(node);
  }

  private Node min(Node root) {
    if (root.left != null) {
      return min(root.left);
    }
    return root;
  }

  //假设空节点的深度为-1
  private int height(Node node) {
    if (node == null) return -1;
    return node.height;
  }

  public Value get(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("key can not set null");
    }
    return get(key, root).value;
  }

  public boolean contains(Key key) {
    return get(key) != null;
  }

  private Node get(Key key, Node root) {
    if (root == null) {
      return null;
    }
    int temp = root.key.compareTo(key);
    if (temp < 0) {
      return get(key, root.right);
    } else if (temp > 0) {
      return get(key, root.left);
    } else {
      return root;
    }
  }

  private Iterable<Key> keys() {
    return keysInOrder();
  }

  private Iterable<Key> keysInOrder() {
    Queue<Key> queue = new Queue<Key>();
    keysInOrder(root, queue);
    return queue;
  }

  private void keysInOrder(Node root, Queue<Key> queue) {
    if (root == null) {
      return;
    }
    keysInOrder(root.left, queue);
    queue.enqueue(root.key);
    keysInOrder(root.right, queue);
  }

  public static void main(String[] args) {
    AVL<String, Integer> st = new AVL<String, Integer>();
    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }
    for (String s : st.keys())
      StdOut.println(s + " " + st.get(s));
    StdOut.println();
  }
}
