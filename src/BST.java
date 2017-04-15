import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-4-14.
 * http://algs4.cs.princeton.edu/32bst/BST.java.html
 * 忽视了很多key为null的情况
 */
public class BST<Key extends Comparable<Key> ,Value> {

  private Node root;
  //内部类 树的节点
  private class Node{
    private Key key;
    private Value value;
    private Node left,right;
    private int N;//以该点为树的根的子树的节点数

    public Node(Key key,Value value,int N){
      this.key = key;
      this.value = value;
      this.N = N;
    }
  }

  private int size(){
    return size(root);
  }

  private int size(Node root) {
    return root == null ? 0 : root.N;
  }

  //如何使用递归的方式实现
  public Value get(Key key){
    if (key == null){
      throw new IllegalArgumentException("unsupport key == null");
    }
    return get(key,root);
  }

  //判断key所处的位置 左右树
  private Value get(Key key,Node node){
    if (node == null){
      return null;
    }
    int temp = node.key.compareTo(key);
    if (temp == 0){
      return node.value;
    }else if (temp < 0){
      return get(key,node.right);
    }else {
      return get(key,node.left);
    }
  }

  public void put(Key key,Value value){
    //if key == null
    root = put(key,value,root);
  }

  private Node put(Key key,Value value,Node node){
    if (node == null){
      //值传递还是引用
      return new Node(key,value,1);
      //这里的1指代的是根节点
    }
    int temp = node.key.compareTo(key);
    if (temp<0){
      node.right = put(key,value,node.right);
    }else if (temp>0){
      node.left = put(key,value,node.left);
    }else if (temp == 0){
      node.value = value;
    }
    node.N = size(node.left)+size(node.right) +1;
    //判断子树有多少个节点
    return node;
  }

  //中序遍历
  public void print(){
    Node x = root;
    print(x);
  }

  private void print(Node x) {
    if (x == null)
      return;
    print(x.left);
    StdOut.print(x.key);
    print(x.right);
  }

  public Key min(){
    if (root == null)
      return null;
    return min(root).key;
  }

  private Node min(Node node){
    if (node.left!=null)
      return min(node.left);
    else
      return node;
  }

  public Key max(){
    if (root == null)
      return null;
    return max(root).key;
  }

  private Node max(Node node){
    if (node.right!=null)
      return max(node.right);
    else
      return node;
  }

  //向下取整
  public Key floor(Key key){
    Node x = floor(key,root);
    if (x == null) return null;
    return x.key;
  }

  //如何在get的基础上面修改 不能返回null

  private Node floor(Key key,Node node){
    if (node == null) {
      return null;
    }
    int temp = node.key.compareTo(key);
    if (temp == 0)
      return node;
    if (temp > 0 )
      return floor(key,node.left);
    //temp < 0 的情况如何处理
    Node t = floor(key,node.right);
    //以右节点为一个新的根节点
    if (t!=null)
      return t;
    else
      return node;
  }
  //想上取整
  public Key ceiling(Key key){
    Node node = ceiling(key,root);
    if (node == null)
      return null;
    return node.key;
  }

  private Node ceiling(Key key, Node node) {
    if (node == null)
      return null;
    int temp = node.key.compareTo(key);
    if (temp == 0)
      return node;
    if (temp < 0)
      return ceiling(key,node.right);
    //temp > 0 时 在未命中的情况下想要想上取整的最大数就是 node
    Node t = ceiling(key,node.left);
    if (t != null)
      return t;
    else
      return node;
  }

  public Key select(int k){
    return select(k,root);
  }

  //可以使用size() 这个函数 k从0 开始计数
  private Key select(int k, Node node) {
    if (node == null)
      return null;
    int t = size(node.left);
    if (k == t)
      return node.key;
    if (k < t)
      return select(k,node.left);
    else // k > size(node.left);
      return select(k-t -1,node.right);
  }

  public int rank(Key key){
    return rank(key,root);
  }

  //节点数temp与排名为K的关系 temp = k+1//k从0开始计算
  private int rank(Key key, Node node) {
    //key == null 暂时没有处理
    if (node == null)
      return -1;
    int temp = node.key.compareTo(key);
    if (temp == 0)
      return size(node.left);
    else if (temp <0 )
      return rank(key,node.left);
    else //temp > 0
      return rank(key,node.right) + 1 +size(node.left);
  }

  public void deleteMin(){
    root = deleteMin(root);
  }

  private Node deleteMin(Node node) {
    if (node.left == null)
      return node.right;
    node.left =  deleteMin(node.left);
    node.N = size(node.left) + size(node.right) +1;
    return node;
  }

  public void deleteMax(){
    root = deleteMax(root);
  }

  private Node deleteMax(Node node) {
    if (node.right == null)
      return node.left;
    node.right = deleteMax(node.right);
    node.N = size(node.left) + size(node.right) +1;
    return node;
  }

  public void delete(Key key){
    root = delete(key,root);
  }

  private Node delete(Key key, Node node) {
    //先找到那个节点
    if (node == null)
      return null;
    int temp = node.key.compareTo(key);
    if (temp < 0){
      node.right = delete(key,node.right);
    }else if (temp > 0){
      node.left = delete(key,node.left);
    }else {
      //temp == 0 时找到了要删除的节点
      if (node.left == null)
        return node.right;
      if (node.right == null)
        return node.left;
      //如何删除 先找到 后继节点
      //值传递
      Node x = node;
      node = min(node.right);
      node.right = deleteMin(x.right);
      //先删除后继节点
      //然后把要删除的节点的左右链接 连接到后继节点上
      node.left = x.left;
    }
    node.N = size(node.left) + size(node.right) + 1;
    return node;
  }


  //使用了alg4中的Queue这个API
  public Iterable<Key> keys(){
    return Keys(min(),max());
  }


  public Iterable<Key> Keys(Key lo,Key hi){
    Queue<Key> queue = new Queue<>();
    keys(root,queue,lo,hi);
    return queue;
  }

  //如何判断这个节点是否在lo和hi之间
  private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
    /*if (node == null)
      return;
    int templo = node.key.compareTo(lo);
    int temphi = node.key.compareTo(hi);
    if (templo>=0 && temphi<=0){
      queue.enqueue(node.key);
    }
    if (templo>0){
      //直到找到不满足这个条件的左节点
      keys(node.left,queue,lo,hi);
    }
    if (temphi <0){
      //直到找到不满足这个条件的右节点
      keys(node.right,queue,lo,hi);
    }*/
    //遍历的时候忽视了递归返回后的情况
    //                18   lo:5 hi: 25
    //                /\   先递归找到最小的节点 然后压入 再把根节点的右节点作为根节点进行相同的操作
    //               9 20  本质类似与中序遍历 
    //              /\
    //             7 10
    if (node == null) return;
    int cmplo = lo.compareTo(node.key);
    int cmphi = hi.compareTo(node.key);
    if (cmplo < 0) keys(node.left, queue, lo, hi);
    if (cmplo <= 0 && cmphi >= 0) queue.enqueue(node.key);
    if (cmphi > 0) keys(node.right, queue, lo, hi);
  }

  private Iterable<Key> levelOrder() {
    Queue<Key> keys = new Queue<Key>();
    Queue<Node> queue = new Queue<Node>();
    queue.enqueue(root);
    while (!queue.isEmpty()) {
      Node x = queue.dequeue();
      if (x == null) continue;
      keys.enqueue(x.key);
      queue.enqueue(x.left);
      queue.enqueue(x.right);
    }
    return keys;
  }

  public static void main(String[] args) {
    BST<String, Integer> st = new BST<String, Integer>();
    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }
    for (String s : st.levelOrder())
      StdOut.println(s + " " + st.get(s));

    StdOut.println();

    for (String s : st.keys())
      StdOut.println(s + " " + st.get(s));
  }

}
