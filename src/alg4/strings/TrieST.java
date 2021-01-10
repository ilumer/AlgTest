package alg4.strings;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 每个字符串的char被转换成array的index
 *
 * @param <Value>
 */
public class TrieST<Value> {

    private static int R = 256;

    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    private Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<>();
        Node keyNode = get(root, pre, 0);
        // 查找这个keyNode是否存在于这个树中
        // 然后查看是否这个节点下面还有新的节点 构建成树
        collect(keyNode, pre, q);
        return q;
    }

    /**
     * 查询和pat匹配的键
     *
     * @param pat
     * @return
     */
    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<>();
        collect(root, "", pat, q);
        return q;
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.val != null) {
            q.enqueue(pre);
        }
        if (d == pat.length()) return;
        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(x.next[c], pre + c, pat, q);
            }
        }
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) {
            return;
        }
        if (x.val != null) q.enqueue(pre);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) {
            return length;
        }
        if (x.val != null) {
            length = d;
        }
        // length的长度是没有变化的
        // 如果到了最末端可以退出了
        if (d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }
        if (x.val != null) {
            return x;
        }

        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                // 如果有非空节点 那么这个节点还需要保持 只是这个节点不存在了
                return x;
            }
        }
        // 在 d == key.length() 时
        // 如果下面没有节点 对于上面的节点而言就是一个null 每个node下面的节点都是独立的
        return null;
    }

    public static void main(String[] args) {

        // build symbol table from standard input
        TrieST<Integer> st = new TrieST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // print results

        StdOut.println("keys(\"\"):");
        for (String key : st.keys()) {
            StdOut.println(key + " " + st.get(key));
        }
        StdOut.println();


        StdOut.println("longestPrefixOf(\"shellsort\"):");
        StdOut.println(st.longestPrefixOf("shellsort"));
        StdOut.println();

        StdOut.println("longestPrefixOf(\"quicksort\"):");
        StdOut.println(st.longestPrefixOf("quicksort"));
        StdOut.println();

        StdOut.println("keysWithPrefix(\"shor\"):");
        for (String s : st.keysWithPrefix("shor"))
            StdOut.println(s);
        StdOut.println();

        StdOut.println("keysThatMatch(\".he.l.\"):");
        for (String s : st.keysThatMatch(".he.l."))
            StdOut.println(s);
    }
}
