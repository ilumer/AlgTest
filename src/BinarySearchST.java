import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ilumer on 17-4-10.
 */

public class BinarySearchST<Key extends Comparable<Key>, Value> {

  private Key[] keys;
  private Value[] values;
  private int N = 0;

  @SuppressWarnings("unchecked")
  public BinarySearchST(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    values = (Value[]) new Object[capacity];
  }

  public int size() {
    return N;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public Value get(Key key) {
    int index = rank(key);
    if (index >= keys.length) {
      return null;
    }//没有找到的情况
    return values[index];
  }

  public int rank(Key key) {
    int lo = 0, hi = N - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (keys[mid].compareTo(key) < 0) {
        lo = mid + 1;
      }

      if (keys[mid].compareTo(key) > 0) {
        hi = mid - 1;
      }
      if (keys[mid].compareTo(key) == 0) {
        return mid;
      }
    }
    return lo;
  }

  public void put(Key key, Value value) {
    if (key == null) {
      throw new IllegalArgumentException("can not put null");
    }
    int index = rank(key);
    //如何插入实现
    if (index < N && keys[index].compareTo(key) == 0) {
      values[index] = value;
      return;
    }

    if (N == keys.length) {
      resize(keys.length * 2);
    }
    for (int j = N; j > index; j--) {
      keys[j] = keys[j - 1];
      values[j] = values[j - 1];
    }
    N++;
    keys[index] = key;
    values[index] = value;
    assert isSorted();
  }

  @SuppressWarnings("unchecked")
  private void resize(int capacity) {
    Value[] resizeValues = (Value[]) new Object[capacity];
    Key[] resizeKeys = (Key[]) new Comparable[capacity];
    for (int i = 0; i < values.length; i++) {
      resizeValues[i] = values[i];
      resizeKeys[i] = keys[i];
    }
    values = resizeValues;
    keys = resizeKeys;
  }

  public Value delete(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("can not delete key ==  null");
    }
    if (isEmpty()) {
      throw new IllegalArgumentException("this table size is 0 can not delete");
    }
    int index = rank(key);
    if (index == size() || keys[index].compareTo(key) != 0) {
      return null;
    } else {
      //如何从新排序
      Value temp = values[index];
      int i = index;
      for (; i < N - 1; i++) {
        values[i] = values[i + 1];
        keys[i] = keys[i + 1];
      }
      values[N] = null;
      keys[N] = null;
      N--;
      if (N > 0 && N < values.length / 4) {
        resize(values.length / 2);
      }
      return temp;
    }
  }

  public boolean isSorted() {
    for (int i = 1; i < keys.length; i++) {
      if (keys[i].compareTo(keys[i - 1]) < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    BinarySearchST<String, Integer> st = new BinarySearchST<>(150);
    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }
  }
}


