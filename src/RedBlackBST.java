/**
 * Created by ilumer on 17-4-17.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;
  private Node root;

  private class Node {
    Key key;
    Value val;
    Node left, right;
    int N;
    boolean color;//代表的是父节点指向他链接的颜色

    public Node(Key key, Value val, int n, boolean color) {
      this.key = key;
      this.val = val;
      N = n;
      this.color = color;
    }
  }

  private boolean isRed(Node x) {
    if (x == null) return false;
    return x.color == RED;
  }

  //将右红色链接旋转左红色链接
  //       E(h)
  //      /     \\(红色链接)
  //     < E     S(x)
  //           /  \
  //     <S && >E  >S
  public Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);
    return x;
  }

  //将左红色链接旋转为右红色链接
  //         S(h)
  //(左红) //   \
  //      E     > S
  //    /   \
  //   < E   >E && < S
  public Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);
    return x;
  }

  private void flipColors(Node h) {
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
  }

  private int size(Node node) {
    if (node == null) {
      return 0;
    }
    return node.N;
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
    root.color = BLACK;
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) {
      return new Node(key, value, 1, RED);
    }
    int cmp = key.compareTo(node.key);
    if (cmp < 0) {
      node.left = put(node.left, key, value);
    } else if (cmp > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.val = value;
    }
    //查找Key 然后添加Node
    //然后对出现的情况进行处理
    if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
    if (isRed(node.right) && isRed(node.left.left)) node = rotateRight(node);
    if (isRed(node.left) && isRed(node.right)) flipColors(node);
    node.N = size(node.left) + size(node.right) + 1;
    return node;
  }


  //TODO:如何删除(智商有限)
}
