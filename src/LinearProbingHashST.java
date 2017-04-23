import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-4-20.
 * http://algs4.cs.princeton.edu/34hash/LinearProbingHashST.java.html
 * Data files:   http://algs4.cs.princeton.edu/34hash/tinyST.txt
 */
public class LinearProbingHashST<Key,Value> {
  private static final int INIT_CAPACITY = 4;
  private int num;//键值对的个数
  private int size;//散列表的大小
  private Key[] keys;
  private Value[] values;

  public LinearProbingHashST() {
    this(INIT_CAPACITY);
  }

  @SuppressWarnings("unchecked")
  public LinearProbingHashST(int chain) {
    this.num = 0;
    this.size = chain;
    this.keys = (Key[]) new Object[chain];
    this.values = (Value[]) new Object[chain];
  }

  public int size(){
    return num;
  }

  public boolean isEmpty(){
    return size() == 0;
  }

  public boolean contains(Key key){
    return get(key)!=null;
  }

  public int hash(Key key){
    return (key.hashCode() & Integer.MAX_VALUE)% size;
  }

  private void resize(int capacity){
    LinearProbingHashST<Key,Value> st = new LinearProbingHashST<>(capacity);
    for (int i = 0;i< size;i++){
      if (keys[i]!=null)
        st.put(keys[i],values[i]);
    }
    this.values = st.values;
    this.keys = st.keys;
    this.size = st.size;
    //this.num = st.num; 不需要更新
  }

  public void put(Key key,Value value){
    if (num >= size /2) resize(size *2);
    int i;
    for (i = hash(key);keys[i]!=null;i=(i+1)% size){
      if (keys[i].equals(key)){
        values[i] = value;
        //update
        return;
      }
    }
    //StdOut.print(key+ " " + value);
    keys[i] = key;
    values[i]= value;
    num++;
  }

  //需要考虑的情况是
  //1：对应的index 还没有添加 应该返回null
  //2：找到对应的index 但是添加时出现了碰撞
  public Value get(Key key){
    for (int i = hash(key);keys[i] !=null;i = (i+1)% size)
      if (keys[i].equals(key)){
        return values[i];
      }
      return null;
  }

  @SuppressWarnings("unchecked")
  public void delete(Key key){
    //将对应的值置为空后并将后面的值重新添加
    if (!contains(key))
      return;
    // 1.先找到对应的index
    int i = hash(key);
    while (!keys[i].equals(key)){
      i = (i + 1)% size;
    }
    //肯定找到后

    keys[i++] = null;
    values[i++] = null;
    this.num--;
    int j = (i+1)%size;//取模很重要
    while (keys[j]!=null){
      Key tempKey = keys[j];
      Value tempValue = values[j];
      keys[j] = null;
      values[j] = null;
      //需要注意减低N
      num--;
      put(tempKey,tempValue);
      j = (j +1)% size;
    }
    //找到键簇
    if (num > 0 && num < 8/ size)
      resize(size /2);
    assert check();
  }

  public Iterable<Key> keys(){
    Queue<Key> queue = new Queue<>();
    for (int i = 0 ; i <size;i++){
      if (keys[i]!=null)
        queue.enqueue(keys[i]);
    }
    return queue;
  }

  private boolean check() {

    // check that hash table is at most 50% full
    if (size < 2*num) {
      System.err.println("Hash table size m = " + size + "; array size n = " + num);
      return false;
    }

    // check that each key in table can be found by get()
    for (int i = 0; i < size; i++) {
      if (keys[i] == null) continue;
      else if (get(keys[i]) != values[i]) {
        System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + values[i]);
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }

    // print keys
    StdOut.println();
    for (String s : st.keys())
      StdOut.println(s + " " + st.get(s));
    //
    StdOut.println();
    st.delete("C");
    for (String s:st.keys()){
      StdOut.println(s+" " +st.get(s));
    }
  }
}
