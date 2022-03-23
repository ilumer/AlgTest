package alg4.context;

public class Page<Key extends Comparable<Key>> {
    //创建并打开一个页
    Page(boolean bottom) {

    }

    //关闭页
    void close() {

    }

    //将键插入（外部的）页中
    void add(Key key) {

    }

    //打开 p，向这个（内部）页中插入一个条目
    //    并将 p
    //    和 p
    //    中的最小键相关联
    void add(Page p) {

    }

    //这是一个外部页吗
    boolean isExternal() {

        return false;
    }

    //键 key 在页中吗
    boolean contains(Key key) {

        return false;
    }

    //可能含有键 key 的子树
    Page next(Key key) {

        return null;
    }

    //页是否已经溢出
    boolean isFull() {

        return false;
    }

    //将较大的中间键移动到一个新页中
    Page split() {

        return null;
    }

    //页中所有键的迭代器
    Iterable<Key> keys() {

        return null;
    }
}
