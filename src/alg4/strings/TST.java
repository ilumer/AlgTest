package alg4.strings;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * @param <Value> 三向单词查找树 没有处理部分空字符串的情况 not null
 */
public class TST<Value> {
    private Node root;

    private class Node {
        /**
         * 这个节点代表的字符
         */
        char c;
        Node left, mid, right;
        Value val;
    }

    public Value get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with null argument");
        }
        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }


    public Node get(Node x, String key, int d) {
        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
        if (x == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        } else {
            return x;
        }
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) {
            x.left = put(x.left, key, val, d);
        } else if (c > x.c) {
            x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1) {
            x.mid = put(x.mid, key, val, d + 1);
        } else {
            //刚好d == key.length() - 1
            x.val = val;
        }
        return x;
    }

    public Iterable<String> keys() {
        Queue<String> queue = new Queue<>();
        collect(root, "", queue);
        return queue;
    }

    private Iterable<String> keysWithPrefix(String pre) {
        if (pre == null) {
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }
        Queue<String> q = new Queue<>();
        Node keyNode = get(root, pre, 0);
        // 需要用的节点是下面的节点
        collect(keyNode.mid, pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) {
            return;
        }

        if (x.left != null) {
            collect(x.left, pre, q);
        }
        if (x.val != null) {
            // 拿到的是上面一个节点的值，对于这个节点的值需要+x.c
            q.enqueue(pre + x.c);
        }
        if (x.mid != null) {
            collect(x.mid, pre + x.c, q);
        }
        if (x.right != null) {
            collect(x.right, pre, q);
        }

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

    /**
     * @param x
     * @param pre 生成的字符串
     * @param pat
     * @param q
     */
    private void collect(Node x, String pre, String pat, Queue<String> q) {
        if (x == null) {
            return;
        }
        int d = pre.length();

        if (d == pat.length()) {
            return;
        }
        char c = pat.charAt(d);
        if (c == '.' || c == x.c) {
            if (pat.length() == (pre + x.c).length() && x.val != null) {
                q.enqueue(pre + x.c);
            }
            collect(x.mid, pre + x.c, pat, q);
        }
        if (c == '.' || c < x.c) {
            collect(x.left, pre, pat, q);
        }
        if (c == '.' || c > x.c) {
            collect(x.right, pre, pat, q);
        }
    }

    /**
     * @param s
     * @return
     */
    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) {
            return length;
        }

        if (d >= s.length()) {
            return length;
        }

        char c = s.charAt(d);
        if (x.val != null && c == x.c) {
            length = d + 1;
        }
        if (c == x.c) {
            length = search(x.mid, s, d + 1, length);
        }

        return length;
    }

    public static void main(String[] args) {
        TST<Integer> st = new TST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            StdOut.println(key + " \\ " + i);
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

        StdOut.println("longestPrefixOf(\"shell\"):");
        StdOut.println(st.longestPrefixOf("shell"));
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
