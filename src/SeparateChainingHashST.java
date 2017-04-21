import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-4-20.
 * 基于拉链法的散列表
 * http://algs4.cs.princeton.edu/34hash/SeparateChainingHashST.java.html
 */
public class SeparateChainingHashST<Key,Value> {

  private static final int MIN_CAPACITY = 4;
  private int N;//键值对总数
  private int M;//散列表的大小 也就是链表的条数
  private SequentialSearchST<Key,Value>[] st;

  public SeparateChainingHashST() {
    this(MIN_CAPACITY);
  }

  @SuppressWarnings({"unchecked","rawtypes"})
  public SeparateChainingHashST(int M) {
    this.M = M;
    this.N = 0;
    st =(SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
    for (int i = 0;i< M;i++)
      st[i] = new SequentialSearchST<>();
  }

  private int hash(Key key){
    return (key.hashCode()&Integer.MAX_VALUE)%M;
  }

  public Value get(Key key){
    return st[hash(key)].get(key);
  }

  public void put(Key key,Value value){
    //忽视null的i情况
    if (N>=10*M){
      resize(2*M);
    }
    int i = hash(key);
    if (get(key)==null)
      N++;
    st[hash(key)].put(key,value);
  }

  public Iterable<Key> keys(){
    Queue<Key> queue = new Queue<Key>();
    for (int i = 0; i<M;i++){
      for (Key key:st[i].keys()){
        queue.enqueue(key);
      }
    }
    return queue;
  }

  public void delete(Key key){
    int i = hash(key);
    if (get(key) != null)
      N--;
    st[hash(key)].delete(key);
    if (M>MIN_CAPACITY && N<=2*M){
      resize(M/2);
    }
  }

  public int size(){
    return N;
  }

  public void resize(int chains){
    SeparateChainingHashST<Key,Value> temp = new SeparateChainingHashST<Key, Value>(chains);
    for (int i = 0;i < M;i++){
      for (Key key:st[i].keys()){
        temp.put(key,get(key));
      }
    }
    this.st = temp.st;
    this.N = temp.N;
    this.M = temp.M;
  }

  public static void main(String[] args) {
    SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }

    // print keys
    for (String s : st.keys())
      StdOut.println(s + " " + st.get(s));

  }
}
