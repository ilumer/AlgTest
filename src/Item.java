/**
 * Created by ilumer on 17-4-5.
 */
public class Item implements Comparable<Item> {

  private int key;

  public Item(int key) {
    this.key = key;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  @Override public int compareTo(Item o) {
    return this.getKey() - o.getKey();
  }
}
